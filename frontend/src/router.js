import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/Login'
import Home from './views/Home'
import SubmitWork from './views/auth/SubmitWork'
import DemoPage from './views/demo/DemoPage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      children: [
        {
          path: 'list',
          name: 'list',
          component: () => import(/* webpackChunkName: "list" */ './views/List.vue')
        },
        {
          path: 'user',
          name: 'user',
          component: () => import(/* webpackChunkName: "list" */ './views/User.vue')
        }
      ]
    },
    {
      path: '/add',
      name: 'add',
      component: () => import(/* webpackChunkName: "list" */ './views/Add.vue')
    },
    {
      path: '/submit',
      name: 'submit',
      component: SubmitWork
    },
    {
      path: '/demo',
      name: 'demo',
      component: DemoPage
    }
  ]
})
