<template>
  <v-app class="rec">
    
    
      <v-row>
      <sideBar></sideBar>
      <v-container class="pa-4 text-center" style="margin-top:30px">
      <v-tabs
      background-color="blue-lighten 3"
      center-active
    >
    <v-tab class="font-weight-bold">书籍</v-tab>
    <v-tab class="font-weight-bold">圈子</v-tab>
    </v-tabs>
    </v-container>
    </v-row>
    
  </v-app>
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
.rec{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>   