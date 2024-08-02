<template>
  <div class="tab-score">
    <div class="score-item" v-for="(value, key) in gameScore" :key="key">
      <span class="score-name">{{ key }}:</span>
      <span class="score-value">{{ value }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GameScore',
  data() {
    return {
      gameScore: {
        Rank: '',
        'Number of Positive Reviews': '',
        'Number of Negative Reviews': '',
        'Metacritic Score': '',
        'Metacritic URL': '',
        'User Score': ''
      }
    };
  }
};
</script>

<style scoped>
.game-score {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.score-item {
  display: flex;
  justify-content: flex-start;
  width: 100%;
  max-width: 600px;
  margin-bottom: 10px;
}

.score-name {
  flex: 1;
  font-weight: bold;
  text-align: left;
}

.score-value {
  flex: 2;
  text-align: left;
  padding-left: 10px;
}
</style>
