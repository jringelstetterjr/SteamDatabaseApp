import { createApp } from 'vue'
import { createPinia } from 'pinia'
import Toast from "vue-toastification"
import App from './App.vue'
import router from './router'
import  VueGoodTablePlugin  from 'vue-good-table-next'
import 'vue-good-table/dist/vue-good-table.css'
import "vue-toastification/dist/index.css"

const app = createApp(App)
const pinia = createPinia()

app.use(Toast)
app.use(pinia)
app.use(router)
app.use(VueGoodTablePlugin)
app.mount('#app')
