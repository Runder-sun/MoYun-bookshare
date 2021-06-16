import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

const Admin = () => import("../views/Admin.vue");
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
    path:"/updates",
    name:"Updates",
    component: () =>
    import("../views/Updates.vue"),
  },
  {
    path:"/updates/blockPerson",
    name:"BlockPerson",
    component: () =>
    import("../views/BlockPerson.vue"),
  },
  {
    path:"/messageListFromFriend",
    name:"MessageListFromFriend",
    component: () =>
    import("../views/MessageListFromFriend.vue"),
  },
  {
    path:"/messageListFromSystem",
    name:"MessageListFromSystem",
    component: () =>
    import("../views/MessageListFromSystem.vue"),
  },
  {
    path:"/recommend",
    name:"MessageListFromFriend",
    component: () =>
    import("../views/MessageListFromFriend.vue"),
  },
  {
    path:"/updates/block",
    name:"BlockPerson",
    component: () =>
    import("../views/BlockPerson.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
