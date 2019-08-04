<template>
  <div>
    <DemoCom :post="post" :test-click="click" :token="token"/>
    <UploadBtn/>
  </div>

</template>

<script>
import DemoCom from '../../components/demo/DemoCom'
import UploadBtn from '../../components/upload/UploadBtn'

export default {
  name: 'DemoPage',
  components: { UploadBtn, DemoCom },
  data: function () {
    return {
      post: {
        title: '测试'
      },
      token: 'brk4iEsr7VV17iirO4ls2fd4aRJh7viW-kHCCYVO:WE2FFrZkwRQ1bkZAo0-GZZbhcWw=:eyJjYWxsYmFja0JvZHlUeXBlIjoiYXBwbGljYXRpb24vanNvbiIsInNjb3BlIjoidmFpcGl4ZWwiLCJyZXR1cm5Cb2R5Ijoie1wia2V5XCI6XCIkKGtleSlcIixcImhhc2hcIjpcIiQoZXRhZylcIixcImJ1Y2tldFwiOlwiJChidWNrZXQpXCIsXCJmc2l6ZVwiOiQoZnNpemUpLFwiZXhpZlwiOiR7ZXhpZn19IiwiY2FsbGJhY2tVcmwiOiJodHRwOi8vcmVxdWVzdGJpbi5mdWxsY29udGFjdC5jb20vMWd3ZTY0NDEiLCJkZWFkbGluZSI6MTU2NDkyMzE3MiwiY2FsbGJhY2tCb2R5Ijoie1wia2V5XCI6XCIkKGtleSlcIixcImhhc2hcIjpcIiQoZXRhZylcIixcImJ1Y2tldFwiOlwiJChidWNrZXQpXCIsXCJmc2l6ZVwiOiQoZnNpemUpLFwiZXhpZlwiOiR7ZXhpZn19In0='
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
