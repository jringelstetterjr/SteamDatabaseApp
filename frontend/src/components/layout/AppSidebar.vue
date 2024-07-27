<template>
    <div class="sidebar">
        <ul>
            <li @click="navigateTo('friends')">Friends</li>
            <li @click="navigateTo('games')">Games</li>
        </ul>
    </div>
</template>

<script>
export default {
    methods: {
        navigateTo(page) {
            // Logic to navigate to the selected page
            // You can use Vue Router or any other navigation method here
            console.log(`Navigating to ${page}`);
        }
    }
}
</script>

<style>
.sidebar {
    width: 200px;
    background-color: #f2f2f2;
    padding: 20px;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    cursor: pointer;
    margin-bottom: 10px;
}

li:hover {
    color: blue;
}
</style>