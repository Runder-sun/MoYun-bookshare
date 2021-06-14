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
const BookWareHouse = () => import("../views/BookWareHouse.vue");
const SearchBook = () => import("../views/SearchBook.vue");
const WriteBookReview = () => import("../views/WriteBookReview");
const CheckBook = () => import("../views/CheckBook");
const BookRecommmand = () => import("../views/BookRecommand");
const BookReview = () =>import("../views/BookReview");
const AddBook = () =>import("../views/AddBook");
const EditBook = () =>import("../views/EditBook")
const Reading = () =>import("../views/Reading")
const Forum = () => import("../views/Forum.vue");
const ForumHome = () => import("../views/ForumHome.vue");
const BlogList = () => import("../views/BlogList.vue");
const WriteBlog = () => import("../views/WriteBlog.vue");
const PersonalCollection = () => import("../views/PersonalCollection.vue");
const EditBlog = () => import("../views/EditBlog.vue");
const ScanBlog = () => import("../views/ScanBlog.vue");
const CheckBookReview = () => import("../views/CheckBookReview");
const EditBookReview = () => import("../views/EditBookReview");
const PersonalInfo = () => import("../views/PersonalInfo");
const ChangePersonalInfo = () => import("../views/ChangePersonalInfo");
const ChangePictures = () => import("../views/ChangePictures");
const MyCollections = () => import("../views/MyCollections")
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
    path:"/message",
    name:"Message",
    component: () =>
    import("../views/Message.vue"),
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
    name:"Recommend",
    component: () =>
    import("../views/Recommend.vue"),
  },
  {
    path:"/updates/block",
    name:"BlockPerson",
    component: () =>
    import("../views/BlockPerson.vue"),
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
    component: CheckBookReview
  },
  {
    path:"/Book/EditBookReview",
    name:"EditBookReview",
    component: EditBookReview
  },
  {
    path:"/PersonalInfo",
    name:"PersonalInfo",
    component: PersonalInfo
  },
  {
    path:"/ChangePersonalInfo",
    name:"ChangePersonalInfo",
    component: ChangePersonalInfo
  },
  {
    path:"/ChangePictures",
    name:"ChangePictures",
    component: ChangePictures
  },
  {
    path:"/MyCollections",
    name:"MyCollections",
    component: MyCollections
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
