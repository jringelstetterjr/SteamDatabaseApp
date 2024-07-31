<script setup>
import AppTopbar from '@/components/layout/AppTopbar.vue';
import AppSidebar from '@/components/layout/AppSidebar.vue';
</script>

<template>
  <div class="layout-wrapper">
    <AppTopbar />
    <div class="layout-body">
      <AppSidebar />
      <div class="layout-main">
        <router-view />
      </div>
    </div>
  </div>
</template>

<style scoped>
.layout-wrapper {
  display: flex;
  flex-direction: column;
  height: 100vh;
}

.layout-body {
  display: flex;
  flex: 1;
}

.layout-sidebar {
  width: 200px;
  background-color: #f2f2f2;
  padding: 20px;
  display: flex;
  flex-direction: column;
  height: 100%;
}

.layout-main {
  flex-grow: 1;
  padding: 20px;
  overflow-y: auto;
}
</style>
