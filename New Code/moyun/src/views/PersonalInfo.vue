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
        :src="'/home/moyun/file/'+this.backGroundImage"
      >
        <v-card-title class="white--text mt-8">
          <v-avatar size="56">
            <img
                :src="'/home/moyun/file/'+this.headImage"
                :alt="this.username"
              />
          </v-avatar>
          <p class="ml-3">{{username}}</p>
        </v-card-title>
      </v-img>

      <v-card-text>
        <div class="my-4 text-subtitle-1">学号：{{userID}}</div>
        <div v-if="$store.state.person.userID==this.userID" class="my-4 text-subtitle-1">密码：{{password}}</div> 
        <div class="my-4 text-subtitle-1">生日：{{birthday}}</div>
        <div class="my-4 text-subtitle-1">邮箱：{{email}}</div>
        <div>
          {{signature}}
        </div>
      </v-card-text>

      <v-divider class="mx-4"></v-divider>

      <v-card-title>操作</v-card-title>
         
      <v-card-text v-if="$store.state.person.userID==this.userID">
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
      email:"xiebudongle@qq.com",
      birthday:2004-2-29,
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg",
      backGroundImage:"https://cdn.vuetifyjs.com/images/cards/cooking.png",
      signature:"签名：什么时候能写完软工呢？",
      password:"000000",
      userID:"",
      username:"John Doe"
  }),

  created() {
    this.getInit();
  },

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

    getInit() {
      this.$http({
        method: "get",
        url: "/inspectUser",
        params: this.$route.params.id,
      })
        .then((res) => {
          if (res.data.success) {
            this.backGroundImage = res.data.userinfo.backGroundImage;
            this.headImage = res.data.userinfo.headImage;
            this.email = res.data.userinfo.email;
            this.birthday = res.data.userinfo.birthday;
            this.userID = res.data.userinfo.userID;
            this.password = res.data.userinfo.password;
            this.signature = res.data.userinfo.signature;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  setup() {},
  components: {
    Bar,
  },
};
</script>
