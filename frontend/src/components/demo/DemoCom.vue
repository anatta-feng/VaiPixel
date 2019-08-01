<template>
  <div>
    <h4 @click="cc">{{post.title}}</h4>
  </div>
</template>

<script>
export default {
  name: 'DemoCom',
  props: {
    post: Object,
    testClick: Function
  },
  data: function () {
    return {

    }
  },
  methods: {
    cc: function () {
      this.testClick()
    }
  }
}
</script>

<style scoped>

</style>
