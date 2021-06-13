<template>
  <div class="forum">
    <bar></bar>
    <v-container>
      <v-card>
        <v-toolbar flat>
            <v-toolbar-title>{{forum.topic}}</v-toolbar-title>
          </v-toolbar>
        <v-expansion-panels v-model="panel" multiple>
          <v-expansion-panel v-for="(forumMessage, i) in messages" :key="i">
            <v-expansion-panel-header>
              <template>
                <v-container>
              
            <p >
              <v-avatar size="30">
              <img :src="forumMessageUser[i].headImage"/>
            </v-avatar>
              {{forumMessageUser[i].username}} :
              </p>
              </v-container>
              </template>
              </v-expansion-panel-header>
            <v-expansion-panel-content>
              {{ forumMessage.text }}
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-card>
      <v-card>
          <v-container fluid>
        <v-textarea v-model="content" color="teal">
          <template v-slot:label>
            <div>内容</div>
          </template>
        </v-textarea>
          </v-container>
          <v-card-action>
              <v-spacer></v-spacer>
              <v-btn text color="cyan" @click="addMessage">提交</v-btn>
          </v-card-action>
      </v-card>
    </v-container>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
  create(){
    this.getInit()
    },
    methods: {
      getInit(){
        this.$http({
          method:'get',
          url:"/getForumMessage",
          params:{
            ForumID:this.$route.params.id,
          }
        }).then(res=>{
          if(res.data.success){
            this.messages = res.data.ForumMessageList
          }
        }).catch(err=>{
          console.log(err)
        })
      },
      addMessage(){
        this.$http({
          method:'post',
          url:"addMessage",
          data:{
            ForumID:this.$route.params.id,
            Comment:this.content,
          }
        }).then(res=>{
          this.getInit()
        })
        this.content="";
      },
    },
  data: () => ({
      panel:[0],
      content:"",
      forumMessageUser:[
        {
          username:"赵阳",
          headImage:"https://cdn.vuetifyjs.com/images/john.jpg",
        },
        {
          username:"zy",
          headImage:"https://cdn.vuetifyjs.com/images/john.jpg",
        },
        {
          username:"zy",
          headImage:"https://cdn.vuetifyjs.com/images/john.jpg",
        },
        {
          username:"zy",
          headImage:"https://cdn.vuetifyjs.com/images/john.jpg",
        },
        {
          username:"zy",
          headImage:"https://cdn.vuetifyjs.com/images/john.jpg",
        },
      ],
      forum:{
        topic:"羊为什么吃草",
      },
      messages: [
      {
        title: "讨论1",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论2",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论3",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论4",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论5",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
    ],
  }),
  components: {
    bar,
  },
};
</script>
