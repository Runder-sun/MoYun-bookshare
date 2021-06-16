import Vue from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import ElementUI from "element-ui";
import "./styles.scss";
import axios from "axios"
import qs from "qs";
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

Vue.use(ElementUI);

Vue.config.productionTip = false;
axios.defaults.baseURL ='/api/'
Vue.prototype.$http = axios
Vue.prototype.$qs = qs
Vue.config.devtools = true;

NProgress.configure({     
       easing: 'ease',  // 动画方式    
       speed: 500,  // 递增进度条的速度    
       showSpinner: false, // 是否显示加载ico    
       trickleSpeed: 200, // 自动递增间隔    
       minimum: 0.3 // 初始化时的最小百分比
  })
//当路由进入前
router.beforeEach((to, from , next) => {
  // 每次切换页面时，调用进度条
 NProgress.start();
 // 这个一定要加，没有next()页面不会跳转的。这部分还不清楚的去翻一下官网就明白了
  next();
});
//当路由进入后：关闭进度条
router.afterEach(() => {  
 // 在即将进入新的页面组件前，关闭掉进度条
 NProgress.done()
})

new Vue({
  router,
  store,
  vuetify,
  axios,
  qs,
  render: (h) => h(App),
}).$mount("#app");
