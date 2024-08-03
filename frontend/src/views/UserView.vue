<template>
  <div class="user-view">
    <h1 class="profile-header">User's Profile: <span class="username" v:if v-if="username">{{ username }}</span></h1>
    <div class="profile-columns">
      <div class="column">
        <h2>Favorites</h2>
        <!-- Data will go here -->
      </div>
      <div class="column">
        <h2>Follows</h2>
        <!-- Data will go here -->
      </div>
      <div class="column">
        <h2>Followers</h2>
        <!-- Data will go here -->
      </div>
    </div>
    <div class="button-container">
      <button class="follow-button">Follow</button>
    </div>
  </div>
</template>

<script>
import { computed } from 'vue';
import { useUserStore } from '@/store';
export default {
  name: 'UserView',
  setup() {
    const userStore = useUserStore();
    const username = computed(() => userStore.username);
    return {
      username
    };
  }
}
</script>

<style scoped>
.user-profile {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.profile-header {
  font-size: 2em;
  margin-bottom: 20px;
}

.username {
  font-size: 1em; /* Smaller font size */
  color: #007bff;
}

.profile-columns {
  display: flex;
  width: 100%;
  justify-content: space-around;
  margin-bottom: 20px;
}

.column {
  flex: 1;
  padding: 10px;
  text-align: center;
}

h2 {
  margin-bottom: 10px;
}

.button-container {
  display: flex;
  justify-content: flex-end;
  width: 100%;
  padding-right: 20px;
}

.follow-button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: white;
  font-size: 1em;
  cursor: pointer;
}

.follow-button:hover {
  background-color: #0056b3;
}
</style>
