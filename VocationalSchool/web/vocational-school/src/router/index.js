import Vue from 'vue'
import Router from 'vue-router'
import AppStudentIndex from '@/pages/app/student/Index'
import AppStudentMain from '@/pages/app/student/Main'
import AppStudentHome from '@/pages/app/student/Home'
import AppStudentUser from '@/pages/app/student/User'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'AppStudentIndex',
      component: AppStudentIndex
    },
    //student routes
    {
      path: '/app/student',
      name: 'AppStudentMain',
      component: AppStudentMain,
      children:[
        {
          path: '/app/student/home',
          name: 'AppStudentHome',
          component: AppStudentHome
        },
        {
          path: '/app/student/user',
          name: 'AppStudentUser',
          component: AppStudentUser
        }
      ]
    }
  ]
})
