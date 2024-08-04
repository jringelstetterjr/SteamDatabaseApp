<template>
    <div class="home">
        <h1>Welcome to our website!</h1>
        <p>Feel free to explore and discover amazing content.</p>
        <div class="table-container">
            <div class="table-wrapper">
                <h2>Top Creators</h2>
                <vue-good-table
                :columns="columnsCreators"
                :rows="creators"
                :search-options="{ enabled: true }"
                :pagination-options="{ enabled: true, perPage: 10 }"
                class="vgt-table"
                />
            </div>
            <div class="table-wrapper">
                <h2> Top Rated Games By Our Users</h2>
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
        creators: [],
        columnsCreators: [
          { label: 'Publishers', field: 'publishers' },
          { label: 'Positive Reviews', field: 'reviews', type:"number"  }
        ],
        games: [],
        columnsTopGames: [
          { label: 'App ID', field: 'appID' },
          { label: 'Name', field: 'name' },
          { label: 'Genre', field: 'genres' },
          { label: 'DLC', field: 'dlcCount', type:"number" },
          { label: 'Release Date', field: 'releaseDate' },
          { label: 'Windows', field: 'windows', type:"boolean" },
          { label: 'Linux', field: 'linux', type:"boolean" },
          { label: 'Mac', field: 'mac', type:"boolean" },
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
      getTopRatedCreators() {
        var apiUrl = 'http://localhost:8081/api/creator/top-creators';
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("Creator found");
            this.creators = response.data;
          } else {
            this.creators = [];
            console.log("Game not found");
          }
        })
      },
      getMostFavorited() {
        console.log("Getting most favorited games");
        var apiUrl = 'http://localhost:8081/api/games/get-most-favorited';
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("Games found");
            response.data.forEach(game => {
              game.releaseDate = new Date(game.releaseDate).toLocaleDateString();
            });
            this.games = response.data;
          } else {
            this.games = [];
            console.log("Games not found");
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
        this.getTopRatedCreators();
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