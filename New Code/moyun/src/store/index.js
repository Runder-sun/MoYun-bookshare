import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    login:true,
    isAdmin:false,
  },
  mutations: {
    setLogin(state){
      state.login=true
    },
    setAdmin(state){
      state.isAdmin=true
    },
  },
  actions: {},
  modules: {},
});