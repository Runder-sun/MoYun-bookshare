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
    setUserName(state, username) {
      state.person.username = username
    },
    setUserEmail(state, email) {
      state.person.email = email
    },
    setUserSignature(state, signature) {
      state.person.signature = signature
    },
    setUserHeadImage(state, headImage) {
      state.person.headImage = headImage
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