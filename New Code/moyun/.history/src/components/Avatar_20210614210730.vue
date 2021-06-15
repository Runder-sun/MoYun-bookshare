<template>
  <v-menu bottom min-width="200px" round offset-y>
    <template v-slot:activator="{ on }">
      <v-btn icon v-on="on">
        <v-avatar  size="40">
          <img :src="user.userImage">
        </v-avatar>
      </v-btn>
    </template>
    <v-card>
      <v-list-item-content class="justify-center">
        <div class="mx-auto text-center">
          <v-avatar >
            <img :src="user.userImage">
          </v-avatar>
          <h3>{{user.username}}</h3>
          <p class="caption mt-1">
            {{user.signature}}
          </p>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="toPersonalInfo"> 个人主页 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="toMSG"> 消息 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="toBlogs"> 日志 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="$store.commit('setLogout')"> 退出登录 </v-btn>
        </div>
      </v-list-item-content>
    </v-card>
  </v-menu>
</template>

<script>
export default {
  data:()=>({
    user:{
      username:"zy",
      userImage:"https://cdn.vuetifyjs.com/images/john.jpg",
      signature:"hhh",
    }
  }),
  created(){
    this.setup()
  },
  methods: {
    toPersonalInfo(){
        this.$router.push({ path: "/PersonalInfo/0" });
      },
      toMSG(){
        this.$router.push({path:"/MessageListFromFriend"})
      },
      toBlogs()
      {
        this.$router.push({path:"/BlogList"});
      },
      setup() {
    this.$http({
      method:"get",
      url:"/PersonnalInfo",
    }).then(res=>{
      if (res.data.success){
        this.user=res.data.personalInfo
      }
    }).catch(err=>{
      console.log(err)
    })
  },
  },
  
}
</script>