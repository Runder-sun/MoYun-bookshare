<template>
  <div class="msg">
        <v-container fluid class="pa-4 text-center">
        <v-row>
        <sideBar></sideBar>
        <v-card class="chat-content">
        <div v-for="(itemc,indexc) in recordContent" :key="indexc">
            <div class="word" v-if="!itemc.mineMsg">
                <img :src="itemc.headUrl">
                <div class="info">
                        <p class="time">{{itemc.nickName}}  {{chatTime(itemc.timestamp)}}</p>
                        <div class="info-content">{{itemc.contactText}}</div>
                </div>
            </div>
            <div class="word-my" v-else>
                <div class="info">
                        <p class="time">{{itemc.nickName}}  {{chatTime(itemc.timestamp)}}</p>
                        <div class="info-content">{{itemc.contactText}}</div>
                </div>
                <img :src="itemc.headUrl">
            </div>
        </div>
        </v-card>
        </v-row>
        </v-container>          
  </div>

  
</template>


<script>

import sideBar from"../components/MSGSideBar.vue";
  export default {
    data: () => ({
  
    }),
    components:{
       sideBar,
    },
    methods :{

        },
  }
</script>

              
<style scoped>
.msg{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
    
</style>   


