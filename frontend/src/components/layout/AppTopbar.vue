<template>
  <div class="topbar">
    <!-- Router link for logo -->
    <router-link to="/" class="app-logo-link">
      <img src="@/assets/steamLogo.png" alt="App Logo" class="app-logo">
    </router-link>
    <h1>{{ title }}</h1>
    <div class="app-name">Steam Database Application</div>
    <div class="user-info">
      <router-link :to="{ name: 'userView' }" class="user-link">
        <h1 v-if="username">{{ username }}</h1>
        <p v-else>No user</p>
      </router-link>
      <img src="@/assets/userLogo.png" alt="User Logo" class="user-logo">
      <button @click="goToLogin" class="login-button">Log Out</button>
    </div>
  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/store';

const userStore = useUserStore();
const username = computed(() => userStore.username);

const router = useRouter();
const goToLogin = () => {
  router.push('/');
};
</script>

<style scoped>
.topbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
  background-color: #f0f0f0;
}

.app-logo {
  height: 40px;
  margin-right: 16px;
}

.user-info {
  display: flex;
  align-items: center;
}

.user-link {
  margin-right: 8px;
  font-weight: bold;
  text-decoration: none;
  color: inherit;
}

.user-link:hover {
  text-decoration: underline;
}

.user-logo {
  height: 25px;
  margin-left: 8px; /* Adding buffer to the left of the button */
}

.app-logo-link {
  display: flex;
  align-items: center;
}

.app-name {
  font-size: 1.5em;
  margin-right: auto;
  margin-left: 16px;
}

.login-button {
  padding: 8px 16px; /* Making the button smaller */
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: white;
  font-size: 1em;
  cursor: pointer;
  margin-left: 8px; /* Adding buffer to the left of the button */
  margin-right: 8px; /* Adding buffer to the right of the button */
}

.login-button:hover {
  background-color: #0056b3;
}
</style>
