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
    token: {
      type: String,
      default: 'asd'
    }
  },
  data: function () {
    return {
      uploadToken: this.token
    }
  },
  methods: {
    fileChange: function ({ target: { files } }) {
      console.log(files)
      if (files.length === 0) {
        return
      }
      const uploadFile = files[0]
      this.uploadImg2Qiniu(uploadFile, this.uploadToken)
    },
    clickSelectFile: function () {
      this.$refs.selectFile.dispatchEvent(new MouseEvent('click'))
    },
    onProgress (percent) {
      console.log('onProgress ' + percent)
    },
    onSuccess () {
      console.log('onSuccess')
    },
    onFail () {
      console.log('onFail')
    },
    uploadImg2Qiniu: function (file, token) {
      let key = file.name
      let config = {
        useCdnDomain: true
      }
      let putExtra = {
        fname: file,
        params: {},
        mimeType: ['image/png', 'image/jpeg', 'image/jpg']
      }
      let observe = {
        next (res) {
          this.onProgress(res.total.percent)
        },
        error (err) {
          this.onFailed(err.code, err.message)
        },
        complete (res) {
          this.onSuccess(res)
        }
      }
      let observable = qiniu.upload(file, key, token, putExtra, config)
      observable.subscribe(observe)
    }
  }
}
</script>

<style scoped>

</style>
