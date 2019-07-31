<template>
  <div class @click="upload">
    <img src="../../assets/img/upload/icon_upload.png" alt="Upload"/>
    <div>
      Drop your image here or
      <span>Browser</span>
    </div>
    <qiniu-img-upload ref="qiniuImgUpload" :token="qiniuToken"></qiniu-img-upload>
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
    }
  }
}
</script>

<style scoped>
</style>
