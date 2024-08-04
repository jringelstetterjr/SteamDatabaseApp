<template>
    <div class="creatorSearchView">
      <h1 class="header">Creator Search</h1>
      <div class="search-results">
        <div class="search-window">
          <button @click="getTopRatedCreators" class="search-button">Search Top Creators</button>
        </div>
        <div class="results-window">
          <vue-good-table
          :columns="columns"
          :rows="creators"
          :search-options="{ enabled: true }"
          :pagination-options="{ enabled: true, perPage: 10 }"
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
        publishers: '',
        positiveReviews: '',
        creators: [],
        columns: [
          { label: 'Publishers', field: 'publishers' },
          { label: 'Positive Reviews', field: 'reviews', type:"number"  }
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
  }
  
  .search-button:hover {
    background-color: #0056b3;
  }
  
  .dropdown {
    margin-bottom: 20px;
  }
  </style>
  