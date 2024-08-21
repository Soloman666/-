import Vue from 'vue'
import VueRouter from 'vue-router'



Vue.use(VueRouter)

const routes = [
  {
    path: '/users',
    name: 'users',
    component: () => import( '../views/tlias/UsersView.vue')
  },
  {
    path:'/addusers',
    name:'addusers',
    component:() => import('../views/tlias/AddUsers.vue')

  },
  {
    path:'/addgoods',
    name:'addgoods',
    component:() => import('../views/tlias/AddGoods.vue')

  },
  {
    path: '/goods',
    name: 'goods',
    component: () => import( '../views/tlias/GoodsView.vue')
  },
  {
    path: '/orders',
    name: 'orders',
    component: () => import( '../views/tlias/OrdersView.vue')
  },
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: () => import( '../views/tlias/UserLogin.vue')
  },
  {
    path: '/adminlogin',
    name: 'adminlogin',
    component: () => import( '../views/tlias/AdminLogin.vue')
  },
  {
    path: '/userlogin',
    name: 'userlogin',
    component: () => import( '../views/tlias/UserLogin.vue')
  },
  {
    path: '/homeshopping',
    name: 'homeshopping',
    component: () => import( '../views/tlias/HomeShopping.vue')
  },
  {
    path: '/homemyorders',
    name: 'homemyorders',
    component: () => import( '../views/tlias/HomeMyOrders.vue')
  },
  {
    path: '/homesellinggoods',
    name: 'homesellinggoods',
    component: () => import( '../views/tlias/HomeSellingGoods.vue')
  },
  {
    path: '/onshopping',
    name: 'onshopping',
    component: () => import( '../views/tlias/OnShopping.vue')
  },
  {
    path: '/useraddgoods',
    name: 'useraddgoods',
    component: () => import( '../views/tlias/UserAddGoods.vue')
  },
  {
    path: '/registerview',
    name: 'registerview',
    component: () => import( '../views/tlias/RegisterView.vue')
  },
  {
    path: '/homeundeliveredgoods',
    name: 'homeundeliveredgoods',
    component: () => import( '../views/tlias/HomeUndeliveredGoods.vue')
  },
  
]

const router = new VueRouter({
  routes
})

export default router
