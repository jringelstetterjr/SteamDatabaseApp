<template>
    <div class="gameSearchView">
      <h1 class="header">Game Search</h1>
      <div class="search-results">
        <div class="search-window">
          <label for="game" class="form-label">Name:</label>
          <input id="game" v-model="game" type="text" class="form-input" placeholder="Search by game name" />
          <button @click="searchSingleGame" class="search-button">Search Games</button>
        </div>
        <div class="results-window">
          <vue-good-table
          :columns="columns"
          :rows="games"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 5 }"
          class="vgt-table"
        />
          <!-- Results will go here -->
        </div>
      </div>
    </div>
  </template>
  
  <script>
import axios from 'axios';
import "vue-good-table/dist/vue-good-table.css";

  export default {
    name: 'GameSearchView',
    data() {
      return {
        game: '',
        description: '',
        genre: '',
        tags: '',
        dlc: '',
        releaseDate: '',
        developer: '',
        publisher: '',
        score: 'highest',
        games: [],
        columns: [
          { label: 'appID', field: 'appID', type:"number" },
          { label: 'Name', field: 'name' },
          { label: 'Description', field: 'description' },
          { label: 'Genre', field: 'genres' },
          { label: 'Tags', field: 'tags' },
          { label: 'DLC', field: 'dlcCount', type:"number" },
          { label: 'Release Date', field: 'releaseDate' },
          { label: 'Categories', field: 'categories' },
          { label: 'Windows', field: 'windows', type:"boolean" },
          { label: 'Linux', field: 'linux', type:"boolean" },
          { label: 'Mac', field: 'mac', type:"boolean" }
        ]
      }
    },
    methods: {
      searchSingleGame() {
        console.log(`Game: ${this.game}`);
        var apiUrl = 'http://localhost:8081/api/games/game-info/';
        apiUrl = apiUrl.concat(this.game);
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("Game found");
            response.data.releaseDate = new Date(response.data.releaseDate).toLocaleDateString();
            this.games = [response.data];
          } else {
            this.games = [];
            console.log("Game not found");
          }
        })
      }
    }
  }
  </script>
  
  <style scoped>
  .game-search {
    padding: 20px;
  }
  
  .header {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .search-results {
    display: flex;
  }
  
  .search-window {
    width: 25%;
    padding-right: 20px;
    border-right: 1px solid #ccc;
  }
  
  .results-window {
    width: 75%;
    padding-left: 20px;
  }
  
  .form-label {
    display: block;
    margin-top: 10px;
    margin-bottom: 5px;
  }
  
  .form-input {
    width: calc(100% - 20px); /* Adjust width to leave space for padding */
    padding: 10px;
    margin-bottom: 10px;
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
    margin-top: 20px;
    align-self: center; /* Center the button horizontally */
    display: flex;
  }
  
  .search-button:hover {
    background-color: #0056b3;
  }
  
  .dropdown {
    margin-bottom: 20px;
  }
  </style>
  