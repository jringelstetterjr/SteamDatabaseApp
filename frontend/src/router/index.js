import { createRouter, createWebHistory } from 'vue-router';
import AppLayout from '@/components/layout/AppLayout.vue';
import HomieView from '@/views/HomieView.vue';
import Friends from '@/views/FriendsView.vue';
import Games from '@/views/GamesView.vue';
import LoginView from '@/views/LoginView.vue';
import CreateView from '@/views/CreateView.vue';
import UserView from '@/views/UserView.vue';

const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/create',
    name: 'create',
    component: CreateView
  },
  {
    path: '/',
    component: AppLayout,
    children: [
      {
        path: '',
        name: 'home-view',
        component: HomieView,
        meta: { requiresAuth: true }
      },
      {
        path: 'friends',
        name: 'friendsView',
        component: Friends,
        meta: { requiresAuth: true }
      },
      {
        path: 'games',
        name: 'gamesView',
        component: Games,
        meta: { requiresAuth: true }
      },
      {
        path: 'user', // Route for User page
        name: 'userView',
        component: UserView
      }
    ]
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
