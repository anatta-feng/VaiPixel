<template>
  <div>
    <DemoCom :post="post" :test-click="click"/>
    <UploadBtn/>
  </div>

</template>

<script>
import DemoCom from '../../components/demo/DemoCom'
import UploadBtn from '../../components/upload1/UploadBtn'

export default {
  name: 'DemoPage',
  components: { UploadBtn, DemoCom },
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
