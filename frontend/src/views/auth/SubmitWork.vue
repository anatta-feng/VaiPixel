<template>
  <div class="submit-root">
    <div class="submit-title">
      <h1>
        <span>发布图片🎉</span>
      </h1>
    </div>
    <div class="submit-group">
      <div class="submit-select-group">
        <UploadBtn></UploadBtn>
      </div>
      <div class="submit-info-group">
        <form>
          <div>
            <label class="pic-info-label" for="title">
              <span>标题</span>
              <input class="pic-info-input" type="text" id="title">
            </label>
            <label class="pic-info-label" for="description">
              <span>描述</span>
              <input class="pic-info-input" type="text" id="description">
            </label>
            <label class="pic-info-label" for="tags">
              <span>标签（按"回车"键添加标签）</span>
              <input class="pic-info-input" type="text" id="tags">
            </label>
            <label class="pic-info-label" for="equipment">
              <span>拍摄设备</span>
              <input class="pic-info-input" type="text" id="equipment">
            </label>
            <button class="btn-submit" type="submit">发布</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>

import UploadBtn from '../../components/upload/UploadBtn'

export default {
  name: 'SubmitWork',
  components: { UploadBtn },
  data () {
    return {}
  }
}
</script>

<style lang="scss">
  .submit-root {
    text-align: left
  }
  .submit-group {
    display: flex;
    justify-content: space-between;
  }

  .submit-select-group {
    flex: 7;
    background-color: white;
    border-radius: .2rem;
    box-shadow: 0 0.1rem 0.25rem 0 rgba(0, 0, 0, .1);;
  }

  .submit-info-group {
    flex: 3;
    margin-left: .8rem;
    background-color: white;
    border-radius: .2rem;
    padding: .8rem;
    box-shadow: 0 0.1rem 0.25rem 0 rgba(0, 0, 0, .1);
  }

  .pic-info-label {
    width: 100%;
    margin-top: .8rem;
  }

  .pic-info-label span {
    color: #4b4b4b;
    font-size: .6rem;
    line-height: .8rem;
    font-weight: 600;
  }

  .pic-info-label input {
    margin-top: .5rem;
  }

  .pic-info-input {
    width: 100%;
    background: #fff;
    box-sizing: border-box;
    border-radius: .2rem;
    border: .5px solid #dfdfdf;
    padding: .6rem;
    margin: 0;
    color: #4b4b4b;
    font-weight: 400;
    font-size: .6rem;
    line-height: .8rem;
  }

  .btn-submit {
    background-color: #1088f2;
    color: #fff;
    padding: 0 1rem;
    cursor: pointer;
    font-weight: 600;
    font-size: .6rem;
    border-radius: .3rem;
    width: 100%;
    height: 2.5rem;
    margin-top: .8rem;
  }
</style>
