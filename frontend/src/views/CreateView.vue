<template>
    <div class="create">
      <h1 class="main-title">Steam Database Application</h1>
      <p class="sub-title">Create a new account.</p>
      <div class="form">
        <label for="display-name" class="form-label">Display Name:</label>
        <input
          id="display-name"
          v-model="displayName"
          type="text"
          class="form-input"
          placeholder="Enter your display name"
        />
        <label for="username" class="form-label">Username:</label>
        <input
          id="username"
          v-model="username"
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
        <button @click="createAccount" class="create-button">Create Account</button>
        <router-link to="/" class="login-link">Log in</router-link>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'CreateView',
    data() {
      return {
        displayName: '',
        username: '',
        password: ''
      }
    },
    methods: {
      createAccount() {
        console.log(`Display Name: ${this.displayName}, Username: ${this.username}, Password: ${this.password}`);
        var apiUrl = 'http://localhost:8081/api/user/create-user/';
        apiUrl = apiUrl.concat(this.username);
        apiUrl = apiUrl.concat('/');
        apiUrl = apiUrl.concat(this.password);
        apiUrl = apiUrl.concat('/');
        apiUrl = apiUrl.concat(this.displayName);
        axios.post(apiUrl)
        .then(response => {
          console.log("Response.data:" + response.data);
          if (response.data == "User created successfully") {
            console.log("Account creation successful");
            this.$router.push({ name: 'login' });
          } else {
            console.log("Account creation failed");
          }
        })
        // Simulate account creation and redirect to home
        this.$router.push({ name: 'home-view' });
      }
    }
  }
  </script>
  
  <style scoped>
  .create {
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
  
  .create-button {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 1em;
    cursor: pointer;
  }
  
  .create-button:hover {
    background-color: #0056b3;
  }
  
  .login-link {
    margin-top: 10px;
    font-size: 1em;
    color: #007bff;
    text-decoration: none;
  }
  
  .login-link:hover {
    text-decoration: underline;
  }
  </style>
  