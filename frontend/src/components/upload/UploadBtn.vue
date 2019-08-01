<template>
  <div class @click="upload">
    <img src="../../assets/img/upload/icon_upload.png" alt="Upload"/>
    <div>
      Drop your image here or
      <span>Browser</span>
    </div>
    <qiniu-img-upload ref="qiniuImgUpload" :token="qiniuToken" :on-change="onChange()"
                      :on-before="onBefore()"
                      :on-progress="onProgress()"
                      :on-success="onSuccess()"
    :on-failed="onFailed()"></qiniu-img-upload>
  </div>
</template>

<script>
  import QiniuImgUpload from './qiniu-img-upload'

  export default {
    name: 'UploadBtn',
    props: {
      token: {
        type: String,
        default: 'adada'
      }
    },
    components: { QiniuImgUpload },
    data () {
      return {
        qiniuToken: this.token
      }
    },
    methods: {
      upload () {
        this.$refs.qiniuImgUpload.$el.dispatchEvent(new MouseEvent('click'))
      },
      addFile ({ target: { files } }) {
        console.log(files)
      },
      onChange (tempFile) {
        console.log('onChange ' + tempFile)
      },
      onBefore (tempFile) {
        console.log('onBefore ' + tempFile)
        return true
      },
      onProgress (percent) {
        console.log('onProgress ' + percent)
      },
      onSuccess (res) {
        console.log('onSuccess ' + res)
      },
      onFailed (res) {
        console.log('onFailed ' + res)
      }
    }
  }
</script>

<style scoped>
</style>
