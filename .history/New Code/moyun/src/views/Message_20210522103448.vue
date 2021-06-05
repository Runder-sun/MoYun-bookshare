<template>
  <div class="msg">
        <v-container fluid class="pa-4 text-center">
        <v-row>
        <sideBar></sideBar>
        <v-card
            color="grey lighten-4"
            height="700px"
            width="800px"
            tile
            align="center"
            justify="center"
            class="mx-auto"
            style="margin-top:50px"
        >
            <v-toolbar dense extended>
            <v-app-bar-nav-icon></v-app-bar-nav-icon>

            <v-toolbar-title>Title</v-toolbar-title>

            <v-spacer></v-spacer>

            <v-btn icon>
                <v-icon>mdi-magnify</v-icon>
            </v-btn>

            <v-btn icon>
                <v-icon>mdi-heart</v-icon>
            </v-btn>

            <v-btn icon>
                <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
            </v-toolbar>
        </v-card>
        </v-row>
        </v-container>          
  </div>

</template>


<script>

import sideBar from"../components/MSGSideBar.vue";
  export default {
    data: () => ({
        recordContent:[
            {headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'ture',
            nickName:'me',
            timestamp:'2021-2-5',
            contactText:'Wanna hang out?'},
            {headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'false',
            nickName:'Jackson',
            timestamp:'2021-2-6',
            contactText:'Coool'},
            {headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'ture',
            nickName:'me',
            timestamp:'2021-2-7',
            contactText:'Kay'},
        ]
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


