<script setup>
//import { computed, watch, ref } from 'vue';
import AppTopbar from '@/components/layout/AppTopbar.vue';
import AppSidebar from '@/components/layout/AppSidebar.vue';
</script>
<template>
  <div class="layout-wrapper" :class="containerClass">
    <app-topbar></app-topbar>
    <div class="layout-sidebar">
      <app-sidebar></app-sidebar>
    </div>
    <div class="layout-main-container">
      <div class="layout-main">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>