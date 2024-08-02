import { createRouter, createWebHistory } from 'vue-router';
import AppLayout from '@/components/layout/AppLayout.vue';
import HomieView from '@/views/HomieView.vue';
import GameSearchView from '@/views/GameSearchView.vue';
import LoginView from '@/views/LoginView.vue';
import CreateView from '@/views/CreateView.vue';
import UserView from '@/views/UserView.vue';
import GameView from '@/views/GameView.vue';
import UserSearch from '@/views/UserSearchView.vue';

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
        path: '', // Home view at the root path
        name: 'home-view',
        component: HomieView,
        meta: { requiresAuth: true }
      },
      {
        path: 'friends',
        name: 'userSearchView',
        component: UserSearch // Update component
      },
      {
        path: 'game',
        name: 'gameSearchView',
        component: GameSearchView,
      },
      {
        path: 'user',
        name: 'userView',
        component: UserView
      },
      {
        path: 'game',
        name: 'game-view',
        component: GameView,
      }
    ]
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
