<script setup> 
</script>

<template>
 <div style="position: relative;">
  <LoadingOverlay :loading="loading" />
    <router-view/>
    <ErrorToast/>
  </div>
</template>


