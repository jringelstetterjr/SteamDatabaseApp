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
          <label for="displayName" class="search-label">Display User:</label>
          <input
            id="displayUser"
            v-model="displayUser"
            type="text"
            class="search-input"
            placeholder="Enter display user"
          />
          <button @click="search" class="search-button">Search</button>
        </div>
        <div class="results-window">
          <!-- Future data table for results will be here -->
          <vue-good-table
          :columns="columns"
          :rows="users"
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
import "vue-good-table/dist/vue-good-table.css";

  export default {
    name: 'UserSearch',
    data() {
      return {
        username: '',
        displayName: '',
        users: [],
        columns: [
          { label: 'Username', field: 'username' },
          { label: 'Dislay Name', field: 'displayName' },
        ]
      }
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
      }

    }
  }
  </script>
  
  <style scoped>
  .user-search {
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
  