import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

import Admin from "../views/Admin.vue";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import ForgetPassword from "../views/ForgetPassword.vue";
import GroupList from "../views/GroupList.vue";
import GroupIndex from "../views/GroupIndex.vue";
import CreatGroup from "../views/CreateGroup.vue";
import AllGroup from "../views/AllGroup.vue";
import BookWareHouse from "../views/BookWareHouse.vue";
import SearchBook from "../views/SearchBook.vue";
import WriteBookReview from "../views/WriteBookReview";
import CheckBook from "../views/CheckBook";
import BookRecommmand from "../views/BookRecommand";
import BookReview from "../views/BookReview";
import AddBook from "../views/AddBook";
import EditBook from "../views/EditBook";
import Reading from "../views/Reading";
import Forum from "../views/Forum.vue";
import ForumHome from "../views/ForumHome.vue";
import BlogList from "../views/BlogList.vue";
import WriteBlog from "../views/WriteBlog.vue";
import PersonalCollection from "../views/PersonalCollection.vue";
import EditBlog from "../views/EditBlog.vue";
import ScanBlog from "../views/ScanBlog.vue";
import CheckBookReview from "../views/CheckBookReview";
import EditBookReview from "../views/EditBookReview";
import PersonalInfo from "../views/PersonalInfo";
import ChangePersonalInfo from "../views/ChangePersonalInfo";
import ChangePictures from "../views/ChangePictures";
import MyCollections from "../views/MyCollections";
import Updates from "../views/Updates";
import MessageListFromFriend from "../views/MessageListFromFriend";
import BlockPerson from "../views/BlockPerson";
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
    component: About,
  },
  {
    path:"/Admin",
    name:"Admin",
    component:Admin,
  },
  {
    path:"/updates/block",
    name:"BlockPerson",
    component: BlockPerson,
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
    path:"/Group/GroupIndex/:id",
    name:"GroupIndex",
    component:GroupIndex,
  },
  {
    path:"/Group/CreateGroup",
    name:"CreatGroup",
    component:CreatGroup,
  },
  {
    path:"/Group/AllGroup",
    name:"AllGroup",
    component:AllGroup,
  },
  {
    path:"/Book/BookWareHouse",
    name:"BookWareHouse",
    component:BookWareHouse,
  },
  {
    path:"/Book/SearchBook",
    name:"SearchBook",
    component:SearchBook
  },
  {
    path:"/Book/WriteBookReview",
    name:"WriteBookReview",
    component:WriteBookReview
  },
  {
    path:"/Book/CheckBook",
    name:"CheckBook",
    component:CheckBook
  },
  {
    path:"/Book/BookRecommand",
    name:"BookRecommand",
    component: BookRecommmand
  },
  {
    path:"/Book/BookReview",
    name:"BookReview",
    component: BookReview
  },
  {
    path:"/Book/AddBook",
    name:"AddBook",
    component: AddBook
  },
  {
    path:"/Book/EditBook",
    name:"EditBook",
    component:EditBook
  },
  {
    path:"/Book/Reading",
    name:"Reading",
    component:Reading},
  {
    path:"/Group/Forum/ForumHome/:id",
    name:"ForumHome",
    component:ForumHome,
  },
  {
    path:"/Group/Forum/Forum/:id",
    name:"Forum",
    component:Forum,
  },

  {
    path:"/BlogList",
    name:"BlogList",
    component:BlogList,
  },
  {
    path:"/BlogList/PersonalCollection",
    name:"PersonalCollection",
    component:PersonalCollection,
  },
  {
    path:"/BlogList/WriteBlog/:id",
    name:"WriteBlog",
    component:WriteBlog,
  },
  {
    path:"/BlogList/EditBlog/:id",
    name:"EditBlog",
    component:EditBlog,
  },
  {
    path:"/BlogList/ScanBlog/:id",
    name:"ScanBlog",
    component:ScanBlog,
  },
  {
    path:"/Book/CheckBookReview",
    name:"CheckBookReview",
    component: CheckBookReview,
  },
  {
    path:"/Book/EditBookReview",
    name:"EditBookReview",
    component: EditBookReview,
  },
  {
    path:"/PersonalInfo",
    name:"PersonalInfo",
    component: PersonalInfo,
  },
  {
    path:"/ChangePersonalInfo",
    name:"ChangePersonalInfo",
    component: ChangePersonalInfo,
  },
  {
    path:"/ChangePictures",
    name:"ChangePictures",
    component: ChangePictures,
  },
  {
    path:"/MyCollections",
    name:"MyCollections",
    component: MyCollections,
  },
  {
    path:"/Updates",
    name:"Updates",
    component: Updates,
  },
  {
    path:"/MessageListFromFriend/:id",
    name:"MessageListFromFriend",
    component: MessageListFromFriend,
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
