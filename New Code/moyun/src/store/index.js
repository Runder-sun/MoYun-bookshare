import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
Vue.config.devtools = true

export default new Vuex.Store({
  state: {
    login: false,
    isAdmin: false,
    person: {
      userID: "",
      username: "",
      isTeacher: 0,
      email: "",
      signature: "",
      headImage: "",
    }
  },
  mutations: {
    setLogin(state) {
      state.login = true
    },
    setAdmin(state) {
      state.isAdmin = true
    },
    setUserID(state, UserID) {
      state.person.userID = UserID
    },
    setIsTeacher(state,isTeacher){
      state.person.isTeacher=isTeacher;
    },
    setLogout(state) {
      state.login = false
    },
    setUser(state, Person){
      state.person=Person
    },
    
  },
  actions: {},
  modules: {},
});