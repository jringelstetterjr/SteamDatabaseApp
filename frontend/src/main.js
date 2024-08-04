import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import  VueGoodTablePlugin  from 'vue-good-table-next'
import 'vue-good-table/dist/vue-good-table.css'

const app = createApp(App)
const pinia = createPinia()

app.use(pinia)
app.use(router)
app.use(VueGoodTablePlugin)
app.mount('#app')
