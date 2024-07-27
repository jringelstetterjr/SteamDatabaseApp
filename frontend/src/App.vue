<script setup> 
import ErrorToast from "@/components/ErrorToast.vue";
</script>

<template>
 <div style="position: relative;">
  <LoadingOverlay :loading="loading" />
    <router-view/>
    <ErrorToast/>
  </div>
</template>


