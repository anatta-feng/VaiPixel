<template>
  <div @click="clickSelectFile">
    <img src="../../assets/img/upload/icon_upload.png" alt="Upload"/>
    <div>
      Drop your image here or
      <span>Browser</span>
    </div>
    <input accept="image/png, image/jpg, image/jpeg"
           type="file"
           style="display: none"
           ref="selectFile"
           @change="fileChange">
  </div>
</template>

<script>
import * as qiniu from 'qiniu-js'
export default {
  name: 'UploadBtn',
  props: {
    token: String
  },
  data: function () {
    return {
    }
  },
  methods: {
    fileChange: function ({ target: { files } }) {
      if (files.length === 0) {
        return
      }
      const uploadFile = files[0]
      this.uploadImg2Qiniu(uploadFile, this.token)
    },
    clickSelectFile: function () {
      this.$refs.selectFile.dispatchEvent(new MouseEvent('click'))
    },
    onProgress: function (percent) {
      console.log('onProgress ' + percent)
    },
    onSuccess: function () {
      console.log('onSuccess')
    },
    onFailed: function (code, message) {
      console.log('onFail ' + code + '  ' + message)
    },
    uploadImg2Qiniu: function (file, token) {
      let _this = this
      let key = file.name
      let config = {
        useCdnDomain: true,
        region: qiniu.region.z2
      }
      let putExtra = {
        fname: file,
        params: {},
        mimeType: ['image/png', 'image/jpeg', 'image/jpg']
      }
      console.log(token)
      let observable = qiniu.upload(file, key, token, putExtra, config)
      observable.subscribe({
        next (res) {
          _this.onProgress(res.total.percent)
        },
        error (err) {
          _this.onFailed(err.code, err.message)
        },
        complete (res) {
          _this.onSuccess(res)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
