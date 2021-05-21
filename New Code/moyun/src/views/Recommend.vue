<template>
  <div class="rec">


        <v-container fluid class="pa-4 text-center">
        <v-row>
          <sideBar></sideBar>

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
.rec{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>   