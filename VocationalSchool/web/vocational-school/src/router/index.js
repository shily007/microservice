import Vue from 'vue'
import Router from 'vue-router'
import App_Student_Index from '@/pages/app/student/Index'
import App_Student_Main from '@/pages/app/student/Main'
import App_Student_Home from '@/pages/app/student/Home'
import App_Student_Personal from '@/pages/app/student/Personal'
import App_Student_Personal_Student from '@/pages/app/student/personal/Student'
import App_Student_Personal_Phone from '@/pages/app/student/personal/Phone'
import App_Student_Personal_Email from '@/pages/app/student/personal/Email'
import App_Student_Personal_Clazz from '@/pages/app/student/personal/Clazz'
import App_Student_Personal_StudentInfo from '@/pages/app/student/personal/StudentInfo'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'App_Student_Index',
      component: App_Student_Index
    },
    //student routes
    {
      path: '/app/student/home',
      name: 'App_Student_Home',
      component: App_Student_Home,
      meta:{
        showFooter: false
      }
    },
    {
      path: '/app/student/personal',
      name: 'App_Student_Personal',
      component: App_Student_Personal,
      meta:{
        showFooter: false
      }
    },
    {
      path: '/app/student/personal/student',
      name: 'App_Student_Personal_Student',
      component: App_Student_Personal_Student,
      meta:{
        showFooter: false
      }
    },
    {
      path: '/app/student/personal/phone',
      name: 'App_Student_Personal_Phone',
      component: App_Student_Personal_Phone,
      meta:{
        showFooter: false
      }
    },
    {
      path: '/app/student/personal/email',
      name: 'App_Student_Personal_Email',
      component: App_Student_Personal_Email,
      meta:{
        showFooter: false
      }
    },
    {
      path: '/app/student/personal/clazz',
      name: 'App_Student_Personal_Clazz',
      component: App_Student_Personal_Clazz,
      meta:{
        showFooter: false
      }
    },
    {
      path: '/app/student/personal/studentInfo',
      name: 'App_Student_Personal_StudentInfo',
      component: App_Student_Personal_StudentInfo,
      meta:{
        showFooter: false
      }
    }
  ]
})
