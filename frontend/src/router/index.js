import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import About from "../views/About.vue";
import Category from "../views/Category.vue";
import Market from "../views/Market.vue";
import MyLibrary from "../views/MyLibrary.vue";
import Login from "../views/Login.vue";
import Signup from "../views/Signup.vue";
import Detail from "../views/Detail.vue";
import BookSearch from "../views/BookSearch.vue";
import MyInfo from "../views/MyInfo.vue";
import UserPage from "../views/UserPage.vue";

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
    component: About,
  },
  {
    path: "/category",
    name: "Category",
    component: Category,
  },
  {
    path: "/market",
    name: "Market",
    component: Market,
  },
  {
    path: "/mylibrary",
    name: "MyLibrary",
    component: MyLibrary,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/detail",
    name: "Detail",
    component: Detail,
  },
  {
    path: "/temp",
    name: "Temp",
    component: Detail,
  },
  {
    path: "/booksearch",
    name: "BookSearch",
    component: BookSearch,
  },
  {
    path: "/myinfo",
    name: "MyInfo",
    component: MyInfo,
  },
  {
    path: "/userpage",
    name: "UserPage",
    component: UserPage,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
