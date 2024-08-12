<template>
    <div class="creatorSearchView">
      <h1 class="header">Score Search</h1>
      <div class="search-results">
        <div class="search-window">
          <label for="appId" class="form-label">App ID's:</label>
          <input id="appId" v-model="appId" type="text" class="form-input" placeholder="Search by App ID's" />
          <button @click="searchScores" class="search-button">Search All Scores</button>
        </div>
        <div class="results-window">
          <vue-good-table
          :columns="columns"
          :rows="scores"
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
import { useToast } from 'vue-toastification';

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
        scores: [],
        columns: [
          { label: "App ID", field: "appID", type: "number" },
          { label: "Name", field: "name", },
          { label: "Genres", field: "genres", },
          { label: "DLC Count", field: "dlcCount", type: "number" },
          { label: "Score Rank", field: "scoreRank", type: "number" },
          { label: "Positive Reviews", field: "positive", type: "number" },
          { label: "Release Date", field: "releaseDate" },
        ]
      }
    },
    setup() {
      const toast = useToast();
      return { toast };
    },
    methods: {
      searchScores() {
        if (this.appId === '') {
          this.toast.error('Please enter an App ID', { timeout: 3000 });
          return;
        }
        var apiUrl = 'http://localhost:8081/api/games/get-game-scores/';
        apiUrl = apiUrl.concat(this.appId);
        axios.get(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data) {
            console.log("scores found");
            response.data.releaseDate = new Date(response.data.releaseDate).toLocaleDateString();
            this.scores = response.data;
          } else {
            this.scores = [];
            console.log("scores not found");
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
  }
  
  .search-button:hover {
    background-color: #0056b3;
  }
  
  .dropdown {
    margin-bottom: 20px;
  }
  </style>
  