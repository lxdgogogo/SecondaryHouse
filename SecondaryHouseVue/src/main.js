import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import VueRouter from "vue-router";
import TablePage from "@/components/TablePage";
import Login from "@/components/Login";
import Test from "@/components/Test";
import register from "@/components/register";
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import user from "@/components/user";
import mapLocation from "@/components/mapLocation"

Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.config.productionTip = false

const router = new VueRouter({
    routes: [
        {
            path: '/login',
            component: Login,
            meta: {
                title: "登录界面"
            }
        },
        {
            path: '/table',
            component: TablePage,
            meta: {
                title: "房源信息查看"
            }
        },
        {
            path: '/test',
            component: Test,
            meta: {
                title: "测试界面"
            }
        },
        {
            path: '/register',
            component: register
        },
        {
            path: '/userInfo',
            component: user
        },
        {
            path: '/map',
            component: mapLocation
        }
    ]
})

new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app')
