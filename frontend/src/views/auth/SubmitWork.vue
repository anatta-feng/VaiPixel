<template>
  <div class="submit group">
    <UploadBtn></UploadBtn>

    <div class="submit header">
      <h4 class="submit title">Publish your first photos 🎉</h4>
    </div>
  </div>
</template>

<script>
import NewComponent from './NewComponent'
import UploadBtn from '../../components/upload/UploadBtn'

export default {
  name: 'SubmitWork',
  components: { UploadBtn, NewComponent },
  data () {
    return {
      workList: [{
        fileName: '',
        filePath: 'blob:https://unsplash.com/98fd683f-19b7-475e-8bf7-b86b12bd459f'
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

</style>
