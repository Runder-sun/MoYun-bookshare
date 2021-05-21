<template>
  <div class="rec">
    <sideBar></sideBar>

        <v-container fluid class="pa-4 text-center" direction="horizontal">

        <el-tabs :tab-position="tabPosition" style="height: 200px;">
        <el-tab-pane label="用户管理">用户管理</el-tab-pane>
        <el-tab-pane label="配置管理">配置管理</el-tab-pane>
        <el-tab-pane label="角色管理">角色管理</el-tab-pane>
        <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
      </el-tabs>
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