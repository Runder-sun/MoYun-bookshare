import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    login:true,
    isAdmin:false,
    userID:"",
  },
  mutations: {
    setLogin(state){
      state.login=true
    },
    setAdmin(state){
      state.isAdmin=true
    },
    setUserID(state,UserID){
      state.userID=UserID
    },
    setLogout(state){
      state.login=false
    }
  },
  actions: {},
  modules: {},
});
