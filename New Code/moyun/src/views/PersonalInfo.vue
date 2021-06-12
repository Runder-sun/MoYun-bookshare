<template>
  <div class="PersonalInfo">
    <v-app>
    <bar></bar>
    <v-img src="../assets/widthPic.jpg" width="100%" height="100%">
    <v-card :loading="loading" class="mx-auto my-12" max-width="500" min-height="600">
      <template slot="progress">
        <v-progress-linear
          color="deep-purple"
          height="10"
          indeterminate
        ></v-progress-linear>
      </template>

      <v-img
        height="250"
        src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
      >
        <v-card-title class="white--text mt-8">
          <v-avatar size="56">
            <img
                src="https://cdn.vuetifyjs.com/images/john.jpg"
                alt="用户"
              />
          </v-avatar>
          <p class="ml-3">John Doe</p>
        </v-card-title>
      </v-img>

      <v-card-text>
        <div class="my-4 text-subtitle-1">学号：19231097</div>
        <div class="my-4 text-subtitle-1">密码：000000</div> 
        <div class="my-4 text-subtitle-1">生日：2004.2.29</div>
        <div class="my-4 text-subtitle-1">邮箱：xiebudongle@qq.com</div>
        <div>
          签名：什么时候能写完软工呢？
        </div>
      </v-card-text>

      <v-divider class="mx-4"></v-divider>

      <v-card-title>操作</v-card-title>
         
      <v-card-text>
         <el-button type="warning" round @click="toChangePersonalInfo">修改个人信息</el-button>
         <el-button type="success" round @click="toChangePictures">编辑个人页面</el-button>
         <el-button type="primary" round @click="toMyCollections">查看个人收藏</el-button>
      </v-card-text>

    </v-card>
    </v-img>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
      loading: false,
  }),
  methods: {
    toChangePersonalInfo() {
      this.$router.push({ path: "/ChangePersonalInfo" });
    },
    toChangePictures() {
      this.$router.push({ path: "/ChangePictures" });
    },
    toMyCollections() {
      this.$router.push({ path: "/MyCollections" });
    },
  },
  setup() {},
  components: {
    Bar,
  },
};
</script>
