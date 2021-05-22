<template>
    <v-app-bar
      app
      elevate-on-scroll
      color="write"
      light
    >
      <el-menu
        :default-active="activeIndex"
        class="menu"
        mode="horizontal"
        router
        @select="handleSelect"
        background-color="#efeeee"
      >
        <el-menu-item index="/">首页</el-menu-item>
        <el-submenu index="2">
          <template slot="title">书库</template>
          <el-menu-item index="2-1">书评</el-menu-item>
          <el-menu-item index="2-2">书籍</el-menu-item>
        </el-submenu>
        <el-menu-item index="/Group/GroupList" >圈子</el-menu-item>
        <el-menu-item index="/updates">动态</el-menu-item>
      </el-menu>
      <v-row justify="end">
        <v-menu bottom min-width="200px" round offset-y>
          <template v-slot:activator="{ on }">
            <v-btn icon v-on="on">
              <v-avatar color="brown" size="40">
                <span class="white--text headline">{{ Z }}</span>
              </v-avatar>
            </v-btn>
          </template>
          <v-card>
            <v-list-item-content class="justify-center">
              <div class="mx-auto text-center">
                <v-avatar color="brown">
                  <span class="white--text headline">{{ 1 }}</span>
                </v-avatar>
                <h3>{{ Z }}</h3>
                <p class="caption mt-1">
                  {{ Z }}
                </p>
                <v-divider class="my-3"></v-divider>
                <v-btn depressed rounded text> 个人主页 </v-btn>
                <v-divider class="my-3"></v-divider>
                <v-btn depressed rounded text v-on:click="toMsg"> 消息 </v-btn>
                <v-divider class="my-3"></v-divider>
                <v-btn depressed rounded text> 日志 </v-btn>
                <v-divider class="my-3"></v-divider>
                <v-btn depressed rounded text> 退出登录 </v-btn>
              </div>
            </v-list-item-content>
          </v-card>
        </v-menu>
      </v-row>
    </v-app-bar>
</template>

<script>

export default {
  name:"Bar",
  methods:{
    toMsg(){
      this.$router.push({path:"/messageListFromFriend"});
    }
  }
}
</script>
