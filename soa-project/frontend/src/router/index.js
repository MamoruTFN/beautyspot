import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/Home'
import StoreSelect from '@/components/StoreSelect'
import Promotion from '@/components/Promotion'
import Reservation from '@/components/Reservation'
import Payment from '@/components/Payment'
import Statistics from '@/components/statistics'

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
      path: '/reservation/:storeid/:promotionid',
      name: 'Reservation',
      component: Reservation
    },
    {
      path: '/storeselect',
      name: 'StoreSelect',
      component: StoreSelect
    },
    {
      path: '/promotion/:storeId',
      name: 'Promotion',
      component: Promotion
    },
    {
      path: '/payment/:reservationid',
      name: 'Payment',
      component: Payment
    },
    {
      path: '/statistics',
      name: 'Statistics',
      component: Statistics
    }
  ]
})
