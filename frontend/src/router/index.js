import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home/Home'
import Join from '@/components/user/Join'
import Login from '@/components/user/Login'
import Admin from '@/components/board/Admin'
import Board from '@/components/board/Board'
import Write from '@/components/board/Write'
import BoardView from '@/components/board/BoardView'
import Technology from '@/components/common/Technology'
import Test from '@/components/common/Test'

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
    ,
    {
      path: '/write',
      name: 'write',
      component: Write
    },
    {
      path: '/boardview',
      name: 'boardview',
      component: BoardView
    },
    {
      path: '/technology',
      name: 'technology',
      component: Technology
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    }
  ]
})
