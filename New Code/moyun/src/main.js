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

Vue.use(ElementUI);

Vue.config.productionTip = false;
axios.defaults.baseURL ='/api/'
Vue.prototype.$http = axios
Vue.config.devtools = true;

new Vue({
  router,
  store,
  vuetify,
  axios,
  qs,
  render: (h) => h(App),
}).$mount("#app");
