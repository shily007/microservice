import Vue from 'vue'
import Router from 'vue-router'
import AppStudentIndex from '@/pages/app/student/Index'
import AppStudentMain from '@/pages/app/student/Main'
import AppStudentHome from '@/pages/app/student/Home'
import AppStudentUser from '@/pages/app/student/User'
import AppStudentUser_info from '@/pages/app/student/info/Info'

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
          component: AppStudentHome,
          meta:{
            showFooter: false
          }
        },
        {
          path: '/app/student/user',
          name: 'AppStudentUser',
          component: AppStudentUser,
          meta:{
            showFooter: false
          },
          children:[
            
          ]
        },
        {
          path: '/app/student/user/info',
          name: 'AppStudentUser_info',
          component: AppStudentUser_info,
          meta:{
            showFooter: false
          },
          children:[
            
          ]
        }
      ]
    }
  ]
})
