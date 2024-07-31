<template>
  <div class="tab-creator">
    <div class="creator-item" v-for="(value, key) in gameCreator" :key="key">
      <span class="creator-name">{{ key }}:</span>
      <span class="creator-value">{{ value }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GameCreator',
  data() {
    return {
      gameCreator: {
        Developer: '',
        Publisher: '',
        'Support Email': '',
        'Support URL': ''
      }
    };
  }
};
</script>

<style scoped>
.game-creator {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.creator-item {
  display: flex;
  justify-content: flex-start;
  width: 100%;
  max-width: 600px;
  margin-bottom: 10px;
}

.creator-name {
  flex: 1;
  font-weight: bold;
  text-align: left;
}

.creator-value {
  flex: 2;
  text-align: left;
  padding-left: 10px;
}
</style>
