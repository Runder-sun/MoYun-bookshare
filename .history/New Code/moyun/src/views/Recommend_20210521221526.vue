<template>
  <v-app class="rec">
    <sideBar></sideBar>
    <v-container>

    </v-container>
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