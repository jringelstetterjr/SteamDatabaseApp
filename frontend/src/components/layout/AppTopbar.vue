<template>
    <div class="topbar">
        <h1>{{ title }}</h1>
        <div class="username">{{ username }}</div>
    </div>
</template>

<script>
export default {
    name: 'AppTopbar',
    props: {
        title: {
            type: String,
            required: true
        },
        username: {
            type: String,
            default: ''
        }
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

.username {
    font-weight: bold;
}
</style>