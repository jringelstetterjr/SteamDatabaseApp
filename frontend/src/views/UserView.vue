<template>
  <div class="user-view">
    <h1 class="profile-header">User's Profile: <span class="username" v-if="username">{{ username }}</span></h1>
    <div class="profile-columns">
      <div class="column">
        <h2>Favorites</h2>
        <vue-good-table
          :columns="favColumns"
          :rows="favGames"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 5 }"
          class="vgt-table"
        >
          <template #table-row="{ column, row }">
            <span v-if="column.field === 'unfavoriteActions'">
              <button @click="removeFavorite(row.appID)">Unfavorite</button>
            </span>
            <span v-else>{{ row[column.field] }}</span>
          </template>
        </vue-good-table>
      </div>
      <div class="column">
        <h2>Following</h2>
        <vue-good-table
          :columns="followColumns"
          :rows="following"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 5 }"
          class="vgt-table"
        />
      </div>
      <div class="column">
        <h2>Followers</h2>
        <vue-good-table
          :columns="followColumns"
          :rows="followers"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 5 }"
          class="vgt-table"
        />
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { computed } from 'vue';
import { useUserStore } from '@/store';
import { useToast } from 'vue-toastification';
import "vue-good-table/dist/vue-good-table.css";

export default {
  name: 'UserView',
  data() {
    return {
      favGames: [],
      followers: [],
      following: [],
      favColumns: [
        { label: 'App ID', field: 'appID' },
        { label: 'Name', field: 'name' },
        { label: 'Actions', field: 'unfavoriteActions', sortable: false, filterable: false }
      ],
      followColumns: [
        { label: 'Username', field: 'username' },
        { label: 'Display Name', field: 'displayName' }
      ]
    }
  },
  setup() {
    const userStore = useUserStore();
    const username = computed(() => userStore.username);
    const toast = useToast();

    return {
      username,
      toast
    };
  },
  methods: {
    getUserFavorites() {
      const apiUrl = `http://localhost:8081/api/user/get-user-favorites/${this.username}`;
      axios.get(apiUrl)
        .then(response => {
          if (response.data) {
            this.favGames = response.data;
          } else {
            this.favGames = [];
          }
        })
        .catch(error => {
          console.error("There was an error fetching the favorites:", error);
        });
    },
    getUserFollowers() {
      const apiUrl = `http://localhost:8081/api/user/get-user-followers/${this.username}`;
      axios.get(apiUrl)
        .then(response => {
          if (response.data) {
            this.followers = response.data;
          } else {
            this.followers = [];
          }
        })
        .catch(error => {
          console.error("There was an error fetching the followers:", error);
        });
    },
    getUserFollowing() {
      const apiUrl = `http://localhost:8081/api/user/get-user-following/${this.username}`;
      axios.get(apiUrl)
        .then(response => {
          if (response.data) {
            this.following = response.data;
          } else {
            this.following = [];
          }
        })
        .catch(error => {
          console.error("There was an error fetching the following:", error);
        });
    },
    removeFavorite(appId) {
      console.log(`Attempting to remove favorite app: ${appId}`);
      const apiUrl = `http://localhost:8081/api/user/remove-favorite/${this.username}/${appId}`;
      axios.delete(apiUrl)
        .then(response => {
          console.log("Favorite removed:", response.data);
          this.toast.success("Favorite removed!", { timeout: 3000 });
          this.getUserFavorites(); // Refresh the favorites list
        })
        .catch(error => {
          console.error("Error removing favorite:", error);
          this.toast.error("Failed to remove favorite.", { timeout: 3000 });
        });
    }
  },
  mounted() {
    this.getUserFavorites();
    this.getUserFollowers();
    this.getUserFollowing();
  }
}
</script>

<style scoped>
.user-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.profile-header {
  font-size: 2em;
  margin-bottom: 20px;
}

.username {
  font-size: 1em; /* Smaller font size */
  color: #007bff;
}

.profile-columns {
  display: flex;
  width: 100%;
  justify-content: space-around;
  margin-bottom: 20px;
}

.column {
  flex: 1;
  padding: 10px;
  text-align: center;
}

h2 {
  margin-bottom: 10px;
}

button {
  padding: 5px 10px;
  border: none;
  background-color: #007bff;
  color: white;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
