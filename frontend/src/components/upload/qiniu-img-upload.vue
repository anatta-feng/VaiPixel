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
    onFinished: Function
  },
  methods: {
    addFile({ target: { files } }) {
      let tempFile = files[0];
      tempFile.url = URL.createObjectURL(tempFile);
      this.file = tempFile;
      // this.onChange(tempFile)
      this.submit()
    },
    remove() {
      this.file = null;
      // this.onChange(null)
    },
    submit() {
      console.log("asda");
      if (this.checkIfCanUpload()) {
      
        let token =
          "brk4iEsr7VV17iirO4ls2fd4aRJh7viW-kHCCYVO:mNBfZUSWw2Y8INts7JmhB3pHEzc=:eyJjYWxsYmFja0JvZHlUeXBlIjoiYXBwbGljYXRpb24vanNvbiIsInNjb3BlIjoidmFpcGl4ZWwiLCJyZXR1cm5Cb2R5Ijoie1wia2V5XCI6XCIkKGtleSlcIixcImhhc2hcIjpcIiQoZXRhZylcIixcImJ1Y2tldFwiOlwiJChidWNrZXQpXCIsXCJmc2l6ZVwiOiQoZnNpemUpLFwiZXhpZlwiOiR7ZXhpZn19IiwiY2FsbGJhY2tVcmwiOiJodHRwOi8vcmVxdWVzdGJpbi5mdWxsY29udGFjdC5jb20vMWd3ZTY0NDEiLCJkZWFkbGluZSI6MTU2Mzg5NzU0MywiY2FsbGJhY2tCb2R5Ijoie1wia2V5XCI6XCIkKGtleSlcIixcImhhc2hcIjpcIiQoZXRhZylcIixcImJ1Y2tldFwiOlwiJChidWNrZXQpXCIsXCJmc2l6ZVwiOiQoZnNpemUpLFwiZXhpZlwiOiR7ZXhpZn19In0=";
        this.upload2Qiniu(this.file, token)
      }
    },
    checkIfCanUpload() {
      return this.file === null
        ? false
        : (this.onBefore && this.onBefore()) || !this.onBefore;
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
          console.log("已上传大小，单位为字节：" + res.total.loaded);
          console.log("本次上传的总量控制信息，单位为字节：" + res.total.size);
          console.log("当前上传进度，范围：0～100：" + res.total.percent);
        },
        error(err) {
          console.log(err.code);
          console.log(err.message);
          console.log(err.isRequestError);
          console.log(err.reqId);
        },
        complete(res) {
          //完成后的操作
          //上传成功以后会返回key 和 hash  key就是文件名了！
          console.log(res);
        }
      };
      //开始上传  token 需要找后端获取(单独的方法)
      let observable = qiniu.upload(file, key, token, putExtra, config);
      let subscription = observable.subscribe(observe);
    }
  }
};
</script>

<style scoped>
</style>
