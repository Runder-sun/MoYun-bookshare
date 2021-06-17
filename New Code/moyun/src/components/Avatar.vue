<template>
  <v-menu bottom min-width="200px" round offset-y>
    <template v-slot:activator="{ on }">
      <v-btn icon v-on="on">
        <v-avatar  size="40" color="#96CDCD">
          <template v-if="$store.state.person.headImage!==''">
            <img :src="'/'+$store.state.person.headImage">
            </template>
            <template v-else>
              <span>{{$store.state.person.userID.substr(0,1)}}</span>
            </template>
        </v-avatar>
      </v-btn>
    </template>
    <v-card>
      <v-list-item-content class="justify-center">
        <div class="mx-auto text-center">
          <v-avatar color="#96CDCD">
            <template v-if="$store.state.person.headImage!==''">
            <img :src="'/'+$store.state.person.headImage">
            </template>
            <template v-else>
              <span>{{$store.state.person.userID.substr(0,1)}}</span>
            </template>
          </v-avatar>
          <h3>{{$store.state.person.username}}</h3>
          <p class="caption mt-1">
            {{$store.state.person.signature}}
          </p>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="toPersonalInfo"> 个人主页 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="toMSG"> 消息 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="toBlogs"> 日志 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text @click="logout"> 退出登录 </v-btn>
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
      userImage:"",
      signature:"",
      userID:"123",
    }
  }),

  methods: {
    toPersonalInfo(){
        this.$router.push({ path: "/PersonalInfo/"+this.$store.state.person.userID});
      },
      toMSG(){
        this.$router.push({path:"/MessageListFromFriend/0"})
      },
      toBlogs()
      {
        this.$router.push({path:"/BlogList"});
      },
      logout(){
//        this.$store.commit('setLogout')
//        this.$router.push({path:"/"});
        this.$http({
          method:'post',
          url:"/logout",
        }).then(res=>{
          if(res.data.success){
            this.$store.commit('setLogout')
            this.$router.push({path:"/"});
            sessionStorage.clear();
          }
        })
        
      }
  },
}
</script>