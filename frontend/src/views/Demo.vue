<template>
  <div>
    <ul>
      <li v-for="(item,index) in lists" v-bind:key="index"
          v-on:click="select(index)" v-bind:class="{active: currentValue == index && currentValue !== ''}">
        {{item}}
      </li>
    </ul>
    <button type="button" v-on:click="add()">
      Select
    </button>
    <ul>
      <li v-for="(item, index) in selectLists" :key="index">
        {{item}}
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: 'Demo',
    data () {
      return {
        lists: [1, 2, 3, 4, 5],
        currentValue: '',
        selectLists: []
      }
    },
    methods: {
      select (index) {
        this.currentValue = index
      },
      add () {
        if (this.currentValue === '') {
          return
        }
        this.selectLists.push(this.lists[this.currentValue])
        this.currentValue = ''
      }
    }
  }
</script>

<style scoped>
  li.active {
    background: green;
  }
</style>
