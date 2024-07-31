<template>
    <div class="error-toast">
        <div class="error-toast__message">{{ errorMessage }}</div>
        <button class="error-toast__close-button" @click="closeToast">X</button>
    </div>
</template>

<script>
export default {
    name: 'ErrorToast',
    props: {
        errorMessage: {
            type: String,
            required: true
        }
    },
    methods: {
        closeToast() {
            // Implement your logic to close the toast here
        }
    }
}
</script>

<style scoped>
.error-toast {
    position: fixed;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    background-color: #ff0000;
    color: #ffffff;
    padding: 10px;
    border-radius: 5px;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.error-toast__message {
    flex-grow: 1;
}

.error-toast__close-button {
    background-color: transparent;
    border: none;
    color: #ffffff;
    cursor: pointer;
}
</style>