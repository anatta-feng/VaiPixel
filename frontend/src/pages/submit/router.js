import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/submit',
    name: 'submit',
    component: () => import('./views/SubmitWork')
  }
]

export default new VueRouter({
  mode: 'history',
  routes: routes
})
