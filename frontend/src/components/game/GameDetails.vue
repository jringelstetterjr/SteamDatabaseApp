<template>
  <div class="tab-details">
    <div class="detail-item" v-for="(value, key) in gameDetails" :key="key">
      <span class="detail-name">{{ key }}:</span>
      <span class="detail-value">{{ value }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GameDetails',
  data() {
    return {
      gameDetails: {
        Description: '',
        'Genre(s)': '',
        Tags: '',
        'Number of DLC': '',
        'Release Date': ''
      }
    };
  }
};
</script>

<style scoped>
.game-details {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.detail-item {
  display: flex;
  justify-content: flex-start;
  width: 100%;
  max-width: 600px;
  margin-bottom: 10px;
}

.detail-name {
  flex: 1;
  font-weight: bold;
  text-align: left;
}

.detail-value {
  flex: 2;
  text-align: left;
  padding-left: 10px;
}
</style>
