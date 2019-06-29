import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home/Home'
import Join from '@/components/user/Join'
import Login from '@/components/user/Login'
import Admin from '@/components/board/Admin'
import Board from '@/components/board/Board'

Vue.use(Router)

export default new Router({
  mode : 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/join',
      name: 'join',
      component: Join
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin
    },
    {
      path: '/board',
      name: 'board',
      component: Board
    }
  ]
})
