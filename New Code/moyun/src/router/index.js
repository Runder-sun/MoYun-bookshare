import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

const Admin = () => import("../views/Admin.vue");
const Login = () => import("../views/Login.vue");
const Register = () => import("../views/Register.vue");
const ForgetPassword = () => import("../views/ForgetPassword.vue");
const GroupList = () => import("../views/GroupList.vue");
const GroupIndex = () => import("../views/GroupIndex.vue");
const CreatGroup = () => import("../views/CreateGroup.vue");
const AllGroup = () => import("../views/AllGroup.vue");
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path:"/Admin",
    name:"Admin",
    component:Admin,
  },
  {
    path:"/Login",
    name:"Login",
    component:Login,
  },
  {
    path:"/Register",
    name:"Register",
    component:Register,
  },
  {
    path:"/ForgetPassword",
    name:"ForgetPassword",
    component:ForgetPassword,
  },
  {
    path:"/Group/GroupList",
    name:"GroupList",
    component:GroupList,
  },
  {
    path:"/Group/GroupIndex",
    name:"GroupIndex",
    component:GroupIndex,
  },
  {
    path:"/Group/CreatGroup",
    name:"CreatGroup",
    component:CreatGroup,
  },
  {
    path:"/Group/AllGroup",
    name:"AllGroup",
    component:AllGroup,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
