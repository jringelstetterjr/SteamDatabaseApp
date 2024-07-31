<template>
    <div class="login">
      <h1>Login Page</h1>
      <button @click="login">Log In</button>
    </div>
</template>
  
  
  <script>
  export default {
    name: 'LoginView',
    methods: {
      login() {
        // Simulate login and redirect to home
        this.$router.push({ name: 'home-view' });
        console.log("pushed log in");
      }
    }
  }
  </script>
  
  <style scoped>
  .login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    text-align: center;
  }
  </style>
  