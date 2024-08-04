<template>
  <div class="userSearchView">
    <h1 class="header">User Search</h1>
    <div class="search-section">
      <div class="search-window">
        <label for="username" class="search-label">Username:</label>
        <input
          id="username"
          v-model="username"
          type="text"
          class="search-input"
          placeholder="Enter username"
        />
        <button @click="search" class="search-button">Search</button>
      </div>
      <div class="results-window">
        <vue-good-table
          :columns="columns"
          :rows="users"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 5 }"
          class="vgt-table"
        >
          <template #table-row="{ column, row }">
            <span v-if="column.field === 'friendActions'">
              <button @click="addFriend(row.username)">Friend</button>
            </span>
            <span v-if="column.field === 'followActions'">
              <button @click="followUser(row.username)">Follow</button>
            </span>
            <span v-else>{{ row[column.field] }}</span>
          </template>
        </vue-good-table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import "vue-good-table/dist/vue-good-table.css";
import { computed } from 'vue';
import { useUserStore } from '@/store';

export default {
  name: 'UserSearch',
  data() {
    return {
      username: '',
      displayName: '',
      users: [],
      columns: [
        { label: 'Username', field: 'username' },
        { label: 'Display Name', field: 'displayName' },
        {
          label: 'Friend',
          field: 'friendActions',
          sortable: false,
          filterable: false,
          html: true
        },
        {
          label: 'Follow',
          field: 'followActions',
          sortable: false,
          filterable: false,
          html: true
        }
      ]
    };
  },
  methods: {
    search() {
      console.log(`Username: ${this.username}, Display Name: ${this.displayName}`);
      let apiUrl = 'http://localhost:8081/api/user/get-users';

      axios.get(apiUrl, {
        params: {
          username: this.username,
          displayName: this.displayName
        }
      })
      .then(response => {
        console.log("Response.data:", response.data);
        if (response.data) {
          console.log("User(s) found");
          this.users = response.data; // Assuming response.data is an array
        } else {
          this.users = [];
          console.log("User(s) not found");
        }
      })
      .catch(error => {
        console.error("There was an error fetching the users:", error);
      });
    },
    addFriend(otherUsername) {
      const apiUrl = `http://localhost:8081/api/user/add-friend/${this.currentUsername}/${otherUsername}`;
      axios.post(apiUrl)
        .then(response => {
          console.log("Friend added:", response.data);
          alert("Friend added!");
        })
        .catch(error => {
          console.error("Error adding friend:", error);
          alert("Failed to add friend.");
        });
    },
    followUser(otherUsername) {
      const apiUrl = `http://localhost:8081/api/user/follow/${this.currentUsername}/${otherUsername}`;
      axios.post(apiUrl)
        .then(response => {
          console.log("Followed user:", response.data);
          alert("User followed!");
        })
        .catch(error => {
          console.error("Error following user:", error);
          alert("Failed to follow user.");
        });
    }
  },
  setup() {
    const userStore = useUserStore();
    const currentUsername = computed(() => userStore.username);

    return {
      currentUsername
    };
  }
}
</script>

<style scoped>
.userSearchView {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.header {
  font-size: 2em;
  margin-bottom: 20px;
}

.search-section {
  display: flex;
  width: 100%;
}

.search-window {
  display: flex;
  flex-direction: column;
  width: 25%;
  padding: 20px;
  margin-right: 20px; /* Add buffer between search and results window */
}

.search-label {
  align-self: flex-start;
  margin-bottom: 5px;
  font-weight: bold;
}

.search-input {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: white;
  font-size: 1em;
  cursor: pointer;
}

.search-button:hover {
  background-color: #0056b3;
}

.results-window {
  width: 75%;
  padding: 20px;
  border-left: 1px solid #ccc;
}
</style>
