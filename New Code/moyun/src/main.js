import Vue from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import ElementUI from "element-ui";
import "./styles.scss";
import axios from "axios"

Vue.use(ElementUI);

Vue.config.productionTip = false;
axios.defaults.baseURL ='http://localhost:8080/'
Vue.prototype.$http = axios

new Vue({
  router,
  store,
  vuetify,
  axios,
  render: (h) => h(App),
}).$mount("#app");
