import { createRouter, createWebHistory } from 'vue-router';
import AppLayout from '@/components/layout/AppLayout.vue';
import HomieView from '@/views/HomieView.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: AppLayout,
            children: [
                {
                    path: '/',
                    name: 'home-view',
                    component: HomieView
                }
            ]
        }
    ]
})

export default router;