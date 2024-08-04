<template>
    <div class="sidebar">
      <ul>
        <li @click="navigateTo('userSearchView')">Friends</li>
        <li @click="navigateTo('gameSearchView')">Games</li>
        <li @click="navigateTo('recommendationsSearchView')">Recommendations</li>
        <li @click="navigateTo('creatorSearchView')">Creators</li>
        <li @click="navigateTo('scoreSearchView')">Scores</li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      navigateTo(page) {
        this.$router.push({ name: page });
      }
    }
  }
  </script>
  
  <style scoped>
  .sidebar {
    width: 200px;
    background-color: #f2f2f2;
    padding: 20px;
    display: flex;
    flex-direction: column;
    height: 100%;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
    flex-grow: 1;
  }
  
  li {
    cursor: pointer;
    margin-bottom: 10px;
  }
  
  li:hover {
    color: blue;
  }
  </style>
  