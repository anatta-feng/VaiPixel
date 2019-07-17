<template>
  <input type="file" @change="addFile" accept="image/png, image/jpg, image/jpeg" autocomplete="off"
         :multiple="multiple"
         style="display: none" name="qiniu-img-upload" id="qiniuImgUpload">
</template>

<script>
import * as qiniu from 'qiniu-js'

export default {
  name: 'qiniu-img-upload',
  props: {
    multiple: Boolean,
    token: String,
    file: File,
    onChange: Function,
    onBefore: Function,
    onProgress: Function,
    onSuccess: Function,
    onFailed: Function,
    onFinished: Function
  },
  methods: {
    addFile ({ target: { files } }) {
      let tempFile = files[0]
      tempFile.url = URL.createObjectURL(tempFile)
      this.file = tempFile
      this.onChange(tempFile)
    },
    remove () {
      this.file = null
      this.onChange(null)
    },
    submit () {
      console.log('asda')
      if (this.checkIfCanUpload()) {
        var config = {
          useCdnDomain: true,
          disableStatisticsReport: false,
          retryCount: 6,
          region: qiniu.region.z2
        }
        var putExtra = {
          fname: '',
          params: {
            'x:name': 'asda'
          },
          mimeType: null
        }
        let token = 'brk4iEsr7VV17iirO4ls2fd4aRJh7viW-kHCCYVO:lAP1IZRoF9WFB0O-z8gdJjYW_5Y=:eyJjYWxsYmFja0JvZHlUeXBlIjoiYXBwbGljYXRpb24vanNvbiIsInNjb3BlIjoidmFpcGl4ZWwiLCJyZXR1cm5Cb2R5Ijoie1wia2V5XCI6XCIkKGtleSlcIixcImhhc2hcIjpcIiQoZXRhZylcIixcImJ1Y2tldFwiOlwiJChidWNrZXQpXCIsXCJmc2l6ZVwiOiQoZnNpemUpLFwiZXhpZlwiOiR7ZXhpZn19IiwiY2FsbGJhY2tVcmwiOiJodHRwOi8vcmVxdWVzdGJpbi5mdWxsY29udGFjdC5jb20vMWd3ZTY0NDEiLCJkZWFkbGluZSI6MTU2MzM3OTQ1MCwiY2FsbGJhY2tCb2R5Ijoie1wia2V5XCI6XCIkKGtleSlcIixcImhhc2hcIjpcIiQoZXRhZylcIixcImJ1Y2tldFwiOlwiJChidWNrZXQpXCIsXCJmc2l6ZVwiOiQoZnNpemUpLFwiZXhpZlwiOiR7ZXhpZn19In0='
        let ob = qiniu.upload(this.file, '', token, putExtra, config)
        ob.subscribe({
          next (res) {
            console.log('next')
          },
          error (res) {
            console.log('error')
          },
          complete (res) {
            console.log('complete')
          }
        })
      }
    },
    checkIfCanUpload () {
      return this.file === null ? false : (this.onBefore && this.onBefore() || !this.onBefore)
    }

  }
}
</script>

<style scoped>

</style>
