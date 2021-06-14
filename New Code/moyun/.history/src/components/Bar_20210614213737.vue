<template>
    <v-app-bar app elevate-on-scroll color="#efeeee" light>
      <el-menu
        class="menu"
        mode="horizontal"
        router
        background-color="#efeeee"
      >
        <el-menu-item index="/">首页</el-menu-item>
        <el-submenu index="2">
          <template slot="title">书库</template>
          <el-menu-item index="/Book/BookReview">书评</el-menu-item>
          <el-menu-item index="/Book/BookWareHouse">书籍</el-menu-item>
        </el-submenu>
        <el-menu-item index="/Group/GroupList">圈子</el-menu-item>
        <el-menu-item index="/Updates">动态</el-menu-item>
      </el-menu>
      <v-row justify="end">
        <template v-if="this.$store.state.login">
          <avatar></avatar>
        </template>
        <template v-else>
          <v-btn class="button" href="/Login">
            <p class="login_">登录</p>
          </v-btn>
        </template>
      </v-row>
    </v-app-bar>
</template>

<script>
import avatar from "./Avatar.vue"
export default {
  name:"Bar",
  methods:{
    toMsg(){
      this.$router.push({path:"/messageListFromFriend"});
    },
    toBlog(){
      this.$router.push({path:"/BlogList"});
    },
  },
  components:{
    avatar,
  }
}
</script>
<style>
.button {
  color: #596275;
  box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
    -9px -9px 18px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  background-color: #efeeee;
  position: relative;
  top: 15%;
  outline: none;
  border: none;
}
.login_ {
  margin-top: 20%;
  font-size: 15px;
}
</style>