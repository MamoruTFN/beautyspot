import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import StoreSelect from '@/components/StoreSelect'
import Promotion from '@/components/Promotion'
import Reservation from '@/components/Reservation'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/storeselect',
      name: 'StoreSelect',
      component: StoreSelect
    },
    {
      path: '/promotion',
      name: 'Promotion',
      component: Promotion
    },
    {
      path: '/reservation',
      name: 'Reservation',
      component: Reservation
    }
  ]
})
