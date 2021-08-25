import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '@/views/IndexPage.vue'
import Engineers from '@/views/CityListPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/tms/index',
    component: Index
  },
  {
    path: '/tms',
    redirect:'/tms/index',
    component: Index
  },
  {
    path:'/tms/index',
    component: Index
  },
  {
    path:'/tms/cities',
    component: Engineers
  },

  {
    path: '/tms/about',
    name: 'About',
    component: () => import('@/views/AboutPage.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  // base: process.env.BASE_URL,
  routes
})

export default router
