<template>
  <div>
    <router-view></router-view>
    <router-link :to="{name:'add'}">添加</router-link>
  </div>
</template>

<script>
export default {
  name: 'User'
}
</script>

<style scoped>

</style>
