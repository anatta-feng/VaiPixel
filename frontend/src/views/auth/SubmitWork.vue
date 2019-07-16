<template>
  <div class="submit group">
    <div class="submit header">
      <h4 class="submit title">Publish your first photos 🎉</h4>
    </div>
    <div class="submit content">
      <form action="" class="submit form">
        <div class="submit upload-group">
          <div class="submit upload">
            <label for="" class="submit-label">
              <img src="../../assets/img/upload/icon_upload.png" alt="">
              <div>
                Drop your images here or
                <span class="underline-text">Browse</span>
              </div>
            </label>
            <div class="submit-works-group" v-for="(item, index) in workList" :key="index">
              <div class="submit-work-card">
                <div class="submit-work-card-info">
                  <img v-bind:src="item.filePath" v-bind:alt="item.fileName" class="submit-work-card-img">
                  <div class="submit-work-card-hover"></div>
                  <div class="submit-work-card-progressbar"></div>
                </div>
                <textarea class="submit-work-card-desc" placeholder="Write a description (optional)"
                          maxlength="600"></textarea>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'SubmitWork',
    components: {},
    data () {
      return {
        workList: [{
          fileName: '',
          filePath: ''
        }]
      }
    }
  }
</script>

<style lang="scss">
  .submit .header {
    padding: 8px 12px 10px 16px;
    background: #42b983;
    min-height: 48px;
    display: flex;
    align-items: center;
  }

  .submit .title {
    font-weight: 500;
    font-size: 15px;
  }

  .submit .content {
    display: flex;
    flex-direction: column;
    margin-bottom: 0;
    min-height: 0;
    flex-grow: 1;
  }

  .submit .upload-group {

  }

  .submit-label {
    display: block;
    padding: 16px;
    justify-content: center;
    cursor: pointer;
    border: 2px dashed #e3e3e3;
    border-radius: 2px;
    color: #999999;
  }

  .submit-works-group {

  }

  .submit-work-card {
    width: 33.33%;
  }

  .submit-work-card-info {
    padding-bottom: 66.6667%;
    position: relative;
  }

  .submit-work-card-img {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    background-color: rgba(0, 0, 0, .4);
  }

  .submit-work-card-desc {
    width: 100%;
  }
</style>
