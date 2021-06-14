import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    login: true,
    isAdmin: false,
    person: {
      userID: "",
      username: "",
      isTeacher: false,
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
    setLogout(state) {
      state.login = false
    },
    setUser(state, Person){
      state.person=Person
    }
  },
  actions: {},
  modules: {},
});