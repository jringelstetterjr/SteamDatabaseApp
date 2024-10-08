// store.js
import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
  state: () => ({
    username: ''
  }),
  actions: {
    setUsername(username) {
      this.username = username;
    }
  },
  getters: {
    getUsername: (state) => state.username
  }
});
