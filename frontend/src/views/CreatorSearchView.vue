<template>
    <div class="gameSearchView">
      <h1 class="header">Creator Search</h1>
      <div class="search-results">
        <div class="search-window">
          <label for="game" class="form-label">Name:</label>
          <input id="game" v-model="game" type="text" class="form-input" placeholder="Search by game name" />
          <button @click="searchCreator" class="search-button">Search Creators</button>
        </div>
        <div class="results-window">
          <vue-good-table
          :columns="creatorsColumns"
          :rows="creators"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 5 }"
          class="vgt-table"
        />
          <!-- Results will go here -->
        </div>
      </div>
    </div>
    <div class="creatorRecentGamesSearchView">
      <h1 class="header">Search Recent Games By Creator</h1>
      <div class="search-results">
        <div class="search-window">
          <label for="game" class="form-label">Creator ID:</label>
          <input id="creatorId" v-model="creatorId" type="text" class="form-input" placeholder="Search by Creator ID" />
          <button @click="searchRecentGames" class="search-button">Search Creators</button>
        </div>
        <div class="results-window">
          <vue-good-table
          :columns="gamesColumns"
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
        creators: [],
        creatorsColumns: [
          { label: 'Creator ID', field: 'creatorID', type:"number" },
          { label: 'Support Email', field: 'supportEmail' },
          { label: 'Publishers', field: 'publishers' },
          { label: 'Developers', field: 'developers' },
          { label: 'Support URL', field: 'supportUrl' },
          { label: 'App ID', field: 'appId' },
        ],
        games: [],
        gamesColumns: [
          { label: 'appID', field: 'appID', type:"number" },
          { label: 'Name', field: 'name' },
          { label: 'Genre', field: 'genres' },
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
      searchCreator() {
        console.log(`Game: ${this.game}`);
        var apiUrl = 'http://localhost:8081/api/creator/get-creator/';
        apiUrl = apiUrl.concat(this.game);
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("Game found");
            this.creators = [response.data];
          } else {
            this.creators = [];
            console.log("Game not found");
          }
        })
      },
      searchRecentGames() {
        console.log(`ID: ${this.creatorId}`);
        var apiUrl = 'http://localhost:8081/api/games/recent-games/';
        apiUrl = apiUrl.concat(this.creatorId);
        console.log(apiUrl);
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("Game found");
            this.games = response.data;
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
  