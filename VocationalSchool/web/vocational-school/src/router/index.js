import Vue from 'vue'
import Router from 'vue-router'
import AppStudentIndex from '@/pages/app/student/Index'
import AppStudentMain from '@/pages/app/student/Main'
import AppStudentHome from '@/pages/app/student/Home'
import AppStudentUser from '@/pages/app/student/User'
import AppStudentUser_info from '@/pages/app/student/info/Info'
import AppStudentUser_phone from '@/pages/app/student/info/Phone'
import AppStudentUser_email from '@/pages/app/student/info/Email'
import AppStudentUser_clazz from '@/pages/app/student/info/Clazz'
import AppStudentUser_BaseInfo from '@/pages/app/student/info/BaseInfo'

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
          }
        },
        {
          path: '/app/student/user/info',
          name: 'AppStudentUser_info',
          component: AppStudentUser_info,
          meta:{
            showFooter: false
          }
        },
        {
          path: '/app/student/user/phone',
          name: 'AppStudentUser_phone',
          component: AppStudentUser_phone,
          meta:{
            showFooter: false
          }
        },
        {
          path: '/app/student/user/email',
          name: 'AppStudentUser_email',
          component: AppStudentUser_email,
          meta:{
            showFooter: false
          }
        },
        {
          path: '/app/student/user/clazz',
          name: 'AppStudentUser_clazz',
          component: AppStudentUser_clazz,
          meta:{
            showFooter: false
          }
        },
        {
          path: '/app/student/user/baseInfo',
          name: 'AppStudentUser_BaseInfo',
          component: AppStudentUser_BaseInfo,
          meta:{
            showFooter: false
          }
        }
      ]
    }
  ]
})
