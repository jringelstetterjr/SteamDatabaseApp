import { createRouter, createWebHistory } from 'vue-router';
import AppLayout from '@/components/layout/AppLayout.vue';
import GameSearchView from '@/views/GameSearchView.vue';
import LoginView from '@/views/LoginView.vue';
import CreateView from '@/views/CreateView.vue';
import UserView from '@/views/UserView.vue';
import GameView from '@/views/GameView.vue';
import UserSearch from '@/views/UserSearchView.vue';
import ScoreSearchView from '@/views/ScoreSearchView.vue';
import RecommendationsSearchView from '@/views/RecommendationsSearchView.vue';
import CreatorSearchView from '@/views/CreatorSearchView.vue';
import LeaderboardView from '@/views/LeaderboardView.vue';
import HomeView from '@/views/HomeView.vue';

const routes = [
  {
    path: '/',
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
        path: 'home', // Home view at the root path
        name: 'home-view',
        component: HomeView,
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
      },
      {
        path: 'recommendations',
        name: 'recommendationsSearchView',
        component: RecommendationsSearchView,
      },
      {
        path: 'score',
        name: 'scoreSearchView',
        component: ScoreSearchView,
      },
      {
        path: 'creator',
        name: 'creatorSearchView',
        component: CreatorSearchView,
      },
      {
        path: 'leaderboard',
        name: 'leaderboardView',
        component: LeaderboardView,
      }
    ]
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
