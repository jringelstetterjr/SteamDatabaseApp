<template>
    <div class="home">
        <div class="table-container">
            <div class="table-wrapper">
                <h3> Game Leaderboard</h3>
                <vue-good-table
                :columns="columnsTopGames"
                :rows="games"
                :search-options="{ enabled: true }"
                :pagination-options="{ enabled: true, perPage: 10 }"
                class="vgt-table"
                >
                <template #table-row="{ column, row }">
                    <span v-if="column.field === 'actions' && username ">
                      <button @click="addToFavorites(row.appID)">Favorite</button>
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
    name: 'HomieView',
    data() {
      return {
        games: [],
        columnsTopGames: [
          { label: 'Name', field: 'name' },
          { label: 'Favorite Count', field: 'favoritedCount', type: "number" },
          {
            label: 'Favorites',
            field: 'actions',
            sortable: false,
            filterable: false,
            html: true
          }
        ]
      }
    },
    methods: {
      getMostFavorited() {
        var apiUrl = 'http://localhost:8081/api/games/get-leaderboard';
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("Creator found");
            this.games = response.data;
          } else {
            this.games = [];
            console.log("Game not found");
          }
        })
      },
      addToFavorites(gameId) {
        console.log(`Adding game ${gameId} to favorites`);
        console.log(`Username: ${this.username}`);
        var apiUrl = `http://localhost:8081/api/user/add-favorite/${this.username}/${gameId}`;
        axios
          .post(apiUrl)
          .then((response) => {
            console.log("Game added to favorites", response.data);
            alert("Game added to favorites!");
          })
          .catch((error) => {
            console.error("Error adding game to favorites", error);
            alert("Failed to add game to favorites.");
          });
      }
    },
    mounted() {
        this.getMostFavorited();
    },
    setup() {
        const userStore = useUserStore();
        const username = computed(() => userStore.username);
        return {
            username
        };
    }
}
</script>

<style scoped>
.home {
    text-align: center;
    margin-top: 100px;
}
.table-container {
  display: flex;
  justify-content: center; /* Center the tables horizontally */
  gap: 20px; /* Add space between the tables */
  flex-wrap: wrap; /* Allow wrapping if space is limited */
}

.table-wrapper {
  flex: 1; /* Allow tables to take equal space */
  max-width: 45%; /* Limit the width of each table */
  box-sizing: border-box;
}

.vgt-table {
  margin: 0 auto; /* Center tables inside the wrapper */
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