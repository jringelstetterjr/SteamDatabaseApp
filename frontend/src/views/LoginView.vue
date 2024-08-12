<template>
    <div class="login">
      <h1 class="main-title">Steam Database Application</h1>
      <p class="sub-title">Please log in, or create a new account.</p>
      <div class="form">
        <label for="username" class="form-label">Username:</label>
        <input
          id="username"
          v-model="usernameInput"
          type="text"
          class="form-input"
          placeholder="Enter your username"
        />
        <label for="password" class="form-label">Password:</label>
        <input
          id="password"
          v-model="password"
          type="password"
          class="form-input"
          placeholder="Enter your password"
        />
        <button @click="login" class="login-button">Log In</button>
        <router-link to="/create" class="create-account-link">Create account</router-link>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import { useUserStore } from '../store';
  import { useToast } from 'vue-toastification';

  export default {
    name: 'LoginView',
    data() {
      return {
        usernameInput: '',
        password: ''
      }
    },
    setup() {
      const userStore = useUserStore();
      const toast = useToast();

      return {
        userStore,
        toast
      };
    },
    methods: {
      login() {
        if (this.usernameInput == '' || this.password == '') {
          this.toast.error('Please enter a username and password', { timeout: 3000 });
          return;
        }
        
        var apiUrl = 'http://localhost:8081/api/user/validate-user/';
        apiUrl = apiUrl.concat(this.usernameInput);
        apiUrl = apiUrl.concat('/');
        apiUrl = apiUrl.concat(this.password);
        console.log(apiUrl);
        axios.get(apiUrl)
        .then(response => {
          if (response.data == true) {
            this.userStore.setUsername(this.usernameInput);
            this.toast.success('Logged in successfully', { timeout: 3000 });
            this.$router.push({ name: 'home-view' });        
          } else {
            this.toast.error('Invalid username or password', { timeout: 3000 });
          }
        })
      }
    }
  }
  </script>
  
  <style scoped>
  .login {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    text-align: center;
  }
  
  .main-title {
    font-size: 2.5em;
    margin-bottom: 10px;
  }
  
  .sub-title {
    font-size: 1.2em;
    margin-bottom: 30px;
  }
  
  .form {
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 400px;
    width: 100%;
  }
  
  .form-label {
    align-self: flex-start;
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  .form-input {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .login-button {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 1em;
    cursor: pointer;
  }
  
  .login-button:hover {
    background-color: #0056b3;
  }
  
  .create-account-link {
    margin-top: 10px;
    font-size: 1em;
    color: #007bff;
    text-decoration: none;
  }
  
  .create-account-link:hover {
    text-decoration: underline;
  }
  </style>
  