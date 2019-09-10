import Vue from 'vue'
import Submit from './Submit.vue'
import router from './router'
import store from './store'
import '@/assets/css/main.scss'

new Vue({
  router,
  store,
  render: h => h(Submit)
}).$mount('#app')
