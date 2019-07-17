<template>
  <div>
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
</template>
<script>
  export default {
    name: 'NewComponent',
    props: {
      workList: {}
    }
  }
</script>
<style lang="scss">

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
