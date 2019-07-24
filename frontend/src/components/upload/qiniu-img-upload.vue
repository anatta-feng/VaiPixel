<template>
  <input
    type="file"
    @change="addFile"
    accept="image/png, image/jpg, image/jpeg"
    autocomplete="off"
    :multiple="multiple"
    style="display: none"
    name="qiniu-img-upload"
    id="qiniuImgUpload"
  />
</template>

<script>
import * as qiniu from "qiniu-js";

export default {
  name: "qiniu-img-upload",
  props: {
    multiple: Boolean,
    token: String,
    file: File,
    onChange: Function,
    onBefore: Function,
    onProgress: Function,
    onSuccess: Function,
    onFailed: Function,
  },
  methods: {
    addFile({ target: { files } }) {
      console.log(this.token)
      let tempFile = files[0];
      tempFile.url = URL.createObjectURL(tempFile);
      this.file = tempFile;
      this.onChange(tempFile)
      this.submit();
    },
    remove() {
      this.file = null;
      this.onChange(null)
    },
    submit() {
      if (this.checkIfCanUpload()) {
        this.upload2Qiniu(this.file, this.token);
      }
    },
    checkIfCanUpload() {
      return this.file === null
        ? false
        : (this.onBefore && this.onBefore(this.file)) || !this.onBefore;
    },
    upload2Qiniu(file, token) {
      let key = file.name;
      let config = {
        useCdnDomain: true
      };
      let putExtra = {
        fname: file,
        params: {},
        mimeType: ["image/png", "image/jpeg", "image/jpg"]
      };
      let observe = {
        next(res) {
          this.onProgress(res.total.percent)
        },
        error(err) {
          this.onFailed(err.code, err.message)
        },
        complete(res) {
          this.onSuccess(res)
        }
      };
      let observable = qiniu.upload(file, key, token, putExtra, config);
      let subscription = observable.subscribe(observe);
    }
  }
};
</script>

<style scoped>
</style>
