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
          <h1 v:if v-if="username">{{ username }}</h1>
          <p v-else>No user</p>
        </router-link>
        <img src="@/assets/userLogo.png" alt="User Logo" class="user-logo">
      </div>
    </div>
  </template>
  
  <script>
  import { computed } from 'vue';
  import { useUserStore } from '@/store';
  export default {
    name: 'AppTopbar',
    props: {
      title: {
        type: String,
        required: true
      }
    },
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
  </style>
  