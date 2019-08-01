<template>
  <DemoCom :post="post" :test-click="click"/>
</template>

<script>
import DemoCom from '../../components/demo/DemoCom'

export default {
  name: 'DemoPage',
  components: { DemoCom },
  data: function () {
    return {
      post: {
        title: '测试'
      }
    }
  },
  methods: {
    click: function () {
      console.log('click')
    }
  }
}
</script>

<style scoped>

</style>
