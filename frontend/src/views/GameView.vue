<template>
    <div class="game-page">
      <h1 class="game-header">Game Name: </h1>
      <div class="tabs">
        <button
          v-for="tab in tabs"
          :key="tab"
          :class="{ active: activeTab === tab }"
          @click="activeTab = tab"
          class="tab-button"
        >
          {{ tab }}
        </button>
      </div>
      <div class="tab-content">
        <component :is="currentTabComponent"></component>
      </div>
      <button class="favorite-button">Favorite</button>
    </div>
  </template>
  
  <script>
  import GameDetails from '@/components/game/GameDetails.vue';
  import GameScore from '@/components/game/GameScore.vue';
  import GameCreator from '@/components/game/GameCreator.vue';
  
  export default {
    name: 'GameView',
    components: {
      GameDetails,
      GameScore,
      GameCreator,
    },
    data() {
      return {
        tabs: ['Details', 'Score', 'Creator'],
        activeTab: 'Details',
      };
    },
    computed: {
      currentTabComponent() {
        return `Game${this.activeTab}`;
      },
    },
  };
  </script>
  
  <style scoped>
  .game-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    position: relative;
    height: 100vh;
    /* padding-bottom: 60px; */ /* Remove this padding */
  }
  
  .game-header {
    font-size: 2em;
    margin-bottom: 20px;
  }
  
  .game-name {
    color: blue;
  }
  
  .tabs {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
  }
  
  .tab-button {
    padding: 10px 20px;
    margin: 0 5px;
    border: none;
    cursor: pointer;
  }
  
  .tab-button.active {
    background-color: blue;
    color: white;
  }
  
  .tab-content {
    width: 100%;
    max-width: 800px;
  }
  
  .favorite-button {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 1em;
    cursor: pointer;
    position: absolute;
    bottom: 10px; /* Adjust this to move button closer to the bottom */
    right: 10px;  /* Adjust this to move button closer to the right */
  }
  
  .favorite-button:hover {
    background-color: #0056b3;
  }
  </style>
  