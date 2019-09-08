<template>
  <div class="submit-root">
    <div class="submit-title">
      <h4>
        <span>发布图片🎉</span>
      </h4>
    </div>
    <div class="submit-group">
      <div class="submit-select-group">
        <UploadBtn class="submit-select"
                   :token="uploadToken"
                   :on-success="onSuccess"
                   :on-failed="onFailed"></UploadBtn>
      </div>
      <div class="submit-info-group">
        <form>
          <div>
            <label class="pic-info-label" for="title">
              <span>标题</span>
              <input class="pic-info-input" type="text" id="title" v-model="submitParams.title"/>
            </label>
            <label class="pic-info-label" for="description">
              <span>描述</span>
              <input class="pic-info-input" type="text" id="description" v-model="submitParams.description"/>
            </label>
            <label class="pic-info-label" for="classify">
              <span>分类</span>
              <input class="pic-info-input" type="text" id="classify" v-model="submitParams.classify"/>
            </label>
            <label class="pic-info-label" for="tags">
              <span>标签（按"回车"键添加标签）</span>
              <input class="pic-info-input" type="text" id="tags" />
            </label>
            <label class="pic-info-label" for="equipment">
              <span>拍摄设备</span>
              <input class="pic-info-input" type="text" id="equipment" />
            </label>
          </div>
        </form>
        <button class="btn-submit" type="submit" @click="submit">发布</button>
      </div>
    </div>
  </div>
</template>

<script>
import UploadBtn from '../../components/upload/UploadBtn'
import { submitWork } from '../../api/works'

export default {
  name: 'SubmitWork',
  components: { UploadBtn },
  data () {
    return {
      uploadToken: '',
      submitParams: {
        title: '',
        description: '',
        tags: [],
        classify: '',
        equipment: {
          make: '',
          model: '',
          lens: '',
          focalLength: '',
          aperture: '',
          iso: '',
          shutter: ''
        },
        type: 'photo'
      }
    }
  },
  created () {
    let _this = this
    this.$axios.post('/work/upload/auth').then(function (response) {
      _this.uploadToken = response.data.data.token
    })
  },
  methods: {
    submit () {
      console.log('submit work')
      submitWork(this.submitParams)
    },
    onSuccess (res) {
      // TODO turn to page for next upload or finish load
      console.log(res)
    },
    onFailed (code, message) {
      // TODO alert error
      console.log('submit')
      console.log(message)
    }
  }
}
</script>

<style lang="scss">
.submit-root {
  text-align: left;
}
.submit-group {
  display: flex;
  justify-content: space-between;
}

.submit-title {
  margin: 2rem 0 0 1rem;
}

.submit-title h4 {
  font-size: 1rem;
}

.submit-select-group {
  flex: 7;
  background-color: white;
  border-radius: 0.2rem;
  box-shadow: 0 0.15rem 0.3rem 0 rgba(0, 0, 0, 0.2);
  padding: 1rem;
}

.submit-select {
  width: 100%;
  height: 100%;
}

.submit-info-group {
  flex: 3;
  margin-left: 0.8rem;
  background-color: white;
  border-radius: 0.2rem;
  padding: 0.8rem;
  box-shadow: 0 0.15rem 0.3rem 0 rgba(0, 0, 0, 0.2);
}

.pic-info-label {
  width: 100%;
  margin-top: 0.8rem;
}

.pic-info-label span {
  color: #4b4b4b;
  font-size: 0.6rem;
  line-height: 0.8rem;
  font-weight: 600;
}

.pic-info-label input {
  margin-top: 0.5rem;
}

.pic-info-input {
  width: 100%;
  background: #fff;
  box-sizing: border-box;
  border-radius: 0.2rem;
  border: 0.5px solid #dfdfdf;
  padding: 0.6rem;
  margin: 0;
  color: #4b4b4b;
  font-weight: 400;
  font-size: 0.6rem;
  line-height: 0.8rem;
}

.btn-submit {
  background-color: #1088f2;
  color: #fff;
  padding: 0 1rem;
  cursor: pointer;
  font-weight: 600;
  font-size: .9rem;
  border-radius: 0.3rem;
  width: 100%;
  height: 2.5rem;
  margin-top: 0.8rem;
}
</style>
