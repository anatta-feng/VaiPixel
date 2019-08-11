<template>
  <div class="upload upload_border" @click="clickSelectFile">
    <div>
      <img src="../../assets/img/upload/ic_upload_new_pic.png" alt="Upload"/>
      <div>
        Drop your image here or
        <span>Browser</span>
      </div>
    </div>
    <img class="prevImage" :src="prevImageSrc" alt="PrevImage" v-bind:class="{visibly: isSelect, invisibly: !isSelect}">
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
      isSelect: false,
      prevImageSrc: ''
    }
  },
  methods: {
    fileChange: function ({ target: { files } }) {
      let _this = this
      if (files.length === 0) {
        return
      }
      _this.isSelect = true
      const uploadFile = files[0]
      var reader = new FileReader()
      reader.onload = function (result) {
        _this.prevImageSrc = result.target.result
      }
      reader.readAsDataURL(uploadFile)
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
  .upload {
    position: relative;
  }

  .upload_border {
    border: 2px dashed #e3e3e3;
    pointer-events: auto;
    transition: border-color .15s ease-in-out,background-color .15s ease-in-out
  }

  .upload_border:hover {
    border-color: #cfdbe3;
    background-color: #f0f5f7
  }

  .prevImage {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .visibly {
    display: block;
  }

  .invisibly {
    display: none;
  }
</style>
