<template>
  <div class="upload upload_border" @click="clickSelectFile">
    <div class="upload_guide">
      <img src="../../assets/img/upload/ic_upload_new_pic.png" alt="Upload"/>
      <div>
        Drop your image here or
        <span>Browser</span>
      </div>
    </div>
    <div>
      <img class="prevImage" :src="prevImageSrc" alt="PrevImage"
           v-bind:class="{visibly: isSelect, invisibly: !isSelect}">
      <div class="upload_progress_bar"
           aria-valuemin="0"
           aria-valuemax="100"
           role="progressbar"
           :style="{width: getUploadProgress}"></div>
      <div class="upload_img_mask_parent" v-bind:class="{visibly: isSelect, invisibly: !isSelect}">
        <div class="upload_img_mask" :style="{transform: getUploadProgressTransform}"></div>
      </div>
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
    token: String,
    onSuccessFun: {
      type: Function,
      default: function () {
      }
    },
    onFailedFun: {
      type: Function,
      default: function () {
      }
    }
  },
  data: function () {
    return {
      isSelect: false,
      prevImageSrc: '',
      uploadProgress: 0.0
    }
  },
  computed: {
    getUploadProgress: function () {
      return this.uploadProgress + '%'
    },
    getUploadProgressTransform: function () {
      return 'translate(' + this.getUploadProgress + ')'
    }
  },
  methods: {
    fileChange: function ({ target: { files } }) {
      let _this = this
      if (files.length === 0) {
        return
      }
      const uploadFile = files[0]
      var reader = new FileReader()
      reader.onload = function (result) {
        _this.prevImageSrc = result.target.result
        _this.isSelect = true
      }
      reader.readAsDataURL(uploadFile)
      this.uploadImg2Qiniu(uploadFile, this.token)
    },
    clickSelectFile: function () {
      this.$refs.selectFile.dispatchEvent(new MouseEvent('click'))
    },
    onProgress: function (percent) {
      this.uploadProgress = percent
    },
    onSuccess: function () {
      this.onSuccessFun()
    },
    onFailed: function (code, message) {
      console.log('onFail ' + code + '  ' + message)
      this.onFailedFun()
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
    text-align: center;
    align-items: center;
  }

  .upload_guide {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center
  }

  .upload_border {
    border: 2px dashed #e3e3e3;
    pointer-events: auto;
    transition: border-color .15s ease-in-out, background-color .15s ease-in-out
  }

  .upload_border:hover {
    border-color: #cfdbe3;
    background-color: #f0f5f7
  }

  .upload_progress_bar {
    height: 3px;
    background-color: #007fff;
    position: relative;
    transition: width .3s, background-color .3s
  }

  .upload_img_mask_parent {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    overflow: hidden;
  }

  .upload_img_mask {
    height: 100%;
    background-color: hsla(0, 0%, 100%, .5);
    will-change: transform;
    transition: transform .3s;
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
