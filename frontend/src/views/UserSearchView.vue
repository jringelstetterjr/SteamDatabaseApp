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
          <label for="displayUser" class="search-label">Display User:</label>
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
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'UserSearch',
    data() {
      return {
        username: '',
        displayUser: ''
      }
    },
    methods: {
      search() {
        console.log(`Username: ${this.username}, Display User: ${this.displayUser}`);
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
  