import Vue from 'vue'
import Router from 'vue-router'
import AppStudentIndex from '@/pages/app/student/Index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'AppStudentIndex',
      component: AppStudentIndex
    }
  ]
})
