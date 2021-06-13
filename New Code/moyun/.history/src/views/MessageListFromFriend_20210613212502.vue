<template>
  <div class="friMsg">
    <template>
      <v-app>
      <bar></bar>
        <v-row>
            <v-navigation-drawer
              left
              floating
              light
              permanent
              elevate-on-scroll
              expand-on-hover
              app
              color="#efeeee"
              mini-variant-width="80px"
            >
              <v-list
                :default-active="activeIndex"
                dense
                rounded
                align="center"
                justify="center"
                height=50%
              >
              <br>
              <br>
              <br>
              <br>
              <br>
                <v-list-item
                link
                @click="toFriend(item.userID)"
                class="px-2"
                v-for="(item,index) in messageTargetList" v-bind:key=index
                style="margin-left=5px"
                >

                  <v-list-item-avatar>
                    <img
                      :src="item.headImage"
                      :alt="item.username"
                    >
                  </v-list-item-avatar>
                  <v-list-item-content>
                    <v-list-item-title class="font-italic">{{item.username}}</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              <router-view />
              </v-list>
            </v-navigation-drawer>

            <v-main
              app
            >
                <v-container fluid class="pa-4 text-center" direction="horizontal">
                  <v-row>
                    <v-card
                          width="1200px"
                          class="mx-auto"
                          style="margin-top:50px"
                      >
                      <v-toolbar dense             
                      text-align="center"
                      justify="center">
                      <v-app-bar-nav-icon></v-app-bar-nav-icon>

                      <v-toolbar-title>System Messages</v-toolbar-title>

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
                        <v-list three-line>
                          <template v-for="(item, index) in friends">
                              <v-subheader
                              :key="item.header"
                              v-text="item.header"
                              ></v-subheader>

                              <v-divider
                              :key="index"
                              :inset="inset"
                              ></v-divider>

                              <v-list-item
                              :key="item.title"
                              >
                              <v-list-item-avatar>
                                  <v-img :src="item.avatar"></v-img>
                              </v-list-item-avatar>

                              <v-list-item-content>
                                  <v-list-item-title v-html="item.title"></v-list-item-title>
                                  <v-list-item-subtitle v-html="item.subtitle"></v-list-item-subtitle>
                              </v-list-item-content>
                              </v-list-item>
                          </template>
                          </v-list>
                      <v-card-action>
                      <v-form align="bottom" absolute bottom>
                          <v-container >
                          <v-row>
                              <v-col cols="12">
                              <v-text-field
                                  v-model="message"
                                  :append-icon="marker ? 'mdi-map-marker' : 'mdi-map-marker-off'"
                                  append-outer-icon="mdi-send"
                                  :prepend-icon="icon"
                                  filled
                                  clear-icon="mdi-close-circle"
                                  clearable
                                  label="Message"
                                  type="text"
                                  @click:append="toggleMarker"
                                  @click:append-outer="sendMessage"
                                  @click:prepend="changeIcon"
                                  @click:clear="clearMessage"
                              ></v-text-field>
                              </v-col>

                                </v-row>
                                </v-container>
                            </v-form>
                        </v-card-action>
                      </v-card> 
                    </v-row>
              </v-container>     
            </v-main>
            </v-row>
        </v-app>
      </template>
     
  </div>
</template>

<script>
import avatar from "../components/Avatar.vue"
import bar from "../components/Bar.vue"
  export default {
    data: () => ({
        password: 'Password',
        divider:true,
        inset:true,
        show: false,
        message: '',
        marker: true,
        iconIndex: 0,
        icons: [
            'mdi-emoticon',
            'mdi-emoticon-cool',
            'mdi-emoticon-dead',
            'mdi-emoticon-excited',
            'mdi-emoticon-happy',
            'mdi-emoticon-neutral',
            'mdi-emoticon-sad',
            'mdi-emoticon-tongue',
        ],
        messageTargetList: [
          {
            uid:"1",
            userID:"123",
            username:"Jhosephin",
            headImage:"https://cdn.vuetifyjs.com/images/lists/1.jpg"
          },
          {
            uid:"1",
            userID:"123",
            username:"Katinn",
            headImage:"https://cdn.vuetifyjs.com/images/lists/1.jpg"
          },
          {
            uid:"1",
            userID:"123",
            username:"Jhosephin",
            headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
          },
          {
            uid:"1",
            userID:"123",
            username:"Katinn",
            headImage:"https://cdn.vuetifyjs.com/images/lists/1.jpg"
          },
          {
            uid:"1",
            userID:"123",
            username:"Jhosephin",
            headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
          },
          {
            uid:"1",
            userID:"123",
            username:"Katinn",
            headImage:"https://cdn.vuetifyjs.com/images/lists/1.jpg"
          },
          {
            uid:"1",
            userID:"123",
            username:"Jhosephin",
            headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
          },

        ],
      friends: [
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          title: 'Brunch this weekend?',
          subtitle: "<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
        
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
          subtitle: "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: 'Oui oui',
          subtitle: "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: 'Birthday gift',
          subtitle: "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: 'Recipe to try',
          subtitle: "<span class='text--primary'>Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
        },
      ],

          system : [
        { header: 'Today' },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          title: 'Brunch this weekend?',
          subtitle: "<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
          subtitle: "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: 'Oui oui',
          subtitle: "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: 'Birthday gift',
          subtitle: "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?",
        },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: 'Recipe to try',
          subtitle: "<span class='text--primary'>Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
        },
      ],
              recordContent:[
            {headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'true',
            nickName:'me',
            timestamp:'2021-2-5',
            contactText:'Wanna hang out?'},
            {headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'false',
            nickName:'Jackson',
            timestamp:'2021-2-6',
            contactText:'Coool'},
            {headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'true',
            nickName:'me',
            timestamp:'2021-2-7',
            contactText:'Kay'},
        ],
        systemMessageList:[],
        userMessageList:[],
        sendUser:"John",
        getUser:"Quinn",
    }),
    components:{
       avatar,
       bar,
    },

    created(){
      this.showFriMsg;
    },

    computed: {
        icon () {
            return this.icons[this.iconIndex]
        },
        },

    methods :{
      
        toggleMarker () {
            this.marker = !this.marker
        },
        clearMessage () {
            this.message = ''
        },
        resetIcon () {
            this.iconIndex = 0
        },
        changeIcon () {
            this.iconIndex === this.icons.length - 1
            ? this.iconIndex = 0
            : this.iconIndex++
        },  
        showFriMsg(){
          this.$http({
            method: "get",
            url: "/MessageHome",
          })
            .then((res) => {
              this.messageTargetList=res.data.messageTargetList;
              this.systemMessageList=res.data.systemMessageList;
              this.friends=this.systemMessageList;
            })
            .catch((err) => {
              console.log(err);
        });
        if(this.$router.params.id.length!==0){
          this.$http({
            method: "get",
            url: "/ChatMessageList",
            params: this.$route.params.id,
          })
            .then((res) => {
              this.userMessageList=res.data.userMessageList;
              this.sendUser=res.data.sendUser;
              this.getUser=res.data.getUser;
              if(res.data.success===1){
                this.friends=this.userMessageList;
              }
            })
            .catch((err) => {
              console.log(err);
        });
        }
        },
      
        toFriend(id){
          thsi.$router.push({path:`/messageListFromFriend/${id}`});
        }
       },
       sendMessage () {
           this.$http({
              method: "post",
              url: "/SendMessage",
              params: {
                getID:this.sendUser,
                message:this.message,
              },
            }).then((res)=>{
              if(res.data.success===1){
                alert("Send Message Success");
                this.$router.go(0);
              }
            })
            this.resetIcon()
            this.clearMessage()
        },

        
  }
</script>

              
<style scoped>
.friMsg{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};

.RList v-snackbar{
    text-align:"right";
    margin:10px;
    display:inline-block;
    padding:3px 10px;
    border:1px solid aliceblue;
    border-radius:15px;
};
.LList v-snackbar{
    text-align:"left";
    display:inline-block;
    padding:3px 10px;
    border:1px solid aliceblue;
    border-radius: 15px;
    padding:5px 10px
};  
</style>   

