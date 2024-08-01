<template>
    <div class="gameSearchView">
      <h1 class="header">Game Search</h1>
      <div class="search-results">
        <div class="search-window">
          <label for="game" class="form-label">Name:</label>
          <input id="game" v-model="game" type="text" class="form-input" placeholder="Search by game name" />
          
          <details class="dropdown">
            <summary>Details</summary>
            <label for="description" class="form-label">Description:</label>
            <input id="description" v-model="description" type="text" class="form-input" placeholder="Enter description" />
            <label for="genre" class="form-label">Genre:</label>
            <input id="genre" v-model="genre" type="text" class="form-input" placeholder="Enter genre" />
            <label for="tags" class="form-label">Tags:</label>
            <input id="tags" v-model="tags" type="text" class="form-input" placeholder="Enter tags" />
            <label for="dlc" class="form-label">Number of DLC:</label>
            <input id="dlc" v-model="dlc" type="text" class="form-input" placeholder="Enter number of DLC" />
            <label for="release-date" class="form-label">Release Date:</label>
            <input id="release-date" v-model="releaseDate" type="date" class="form-input" />
          </details>
          
          <details class="dropdown">
            <summary>Creator</summary>
            <label for="developer" class="form-label">Developer:</label>
            <input id="developer" v-model="developer" type="text" class="form-input" placeholder="Enter developer" />
            <label for="publisher" class="form-label">Publisher:</label>
            <input id="publisher" v-model="publisher" type="text" class="form-input" placeholder="Enter publisher" />
          </details>
          
          <details class="dropdown">
            <summary>Score</summary>
            <label for="score" class="form-label">Sort by:</label>
            <select id="score" v-model="score" class="form-input">
              <option value="highest">Highest</option>
              <option value="lowest">Lowest</option>
            </select>
          </details>
          
          <button @click="search" class="search-button">Search</button>
        </div>
        <div class="results-window">
          <!-- Results will go here -->
        </div>
      </div>
    </div>
  </template>
  
  <script>
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
      }
    },
    methods: {
      search() {
        console.log(`Game: ${this.game}`);
        console.log(`Description: ${this.description}`);
        console.log(`Genre: ${this.genre}`);
        console.log(`Tags: ${this.tags}`);
        console.log(`Number of DLC: ${this.dlc}`);
        console.log(`Release Date: ${this.releaseDate}`);
        console.log(`Developer: ${this.developer}`);
        console.log(`Publisher: ${this.publisher}`);
        console.log(`Score: ${this.score}`);
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
  