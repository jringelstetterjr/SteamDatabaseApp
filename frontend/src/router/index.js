import { createRouter, createWebHistory } from 'vue-router';
import AppLayout from '@/components/layout/AppLayout.vue';
import HomieView from '@/views/HomieView.vue';
import Friends from '@/views/FriendsView.vue';
import Games from '@/views/GamesView.vue';
import LoginView from '@/views/LoginView.vue';

const routes = [
  {
    path: '/',
    component: AppLayout,
    children: [
      {
        path: 'login', // Home view at the root path
        name: 'login',
        component: LoginView
      },
      {
        path: 'home', // Home view at the root path
        name: 'home-view',
        component: HomieView
      },
      {
        path: 'friends',
        name: 'friendsView',
        component: Friends
      },
      {
        path: 'games',
        name: 'gamesView',
        component: Games
      }
    ]
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

// Remove authentication-related navigation guards
// router.beforeEach((to, from, next) => {
//   const isAuthenticated = false; // Authentication logic removed

//   if (to.matched.some(record => record.meta.requiresAuth) && !isAuthenticated) {
//     next({ name: 'login' });
//   } else {
//     next();
//   }
// });

export default router;
