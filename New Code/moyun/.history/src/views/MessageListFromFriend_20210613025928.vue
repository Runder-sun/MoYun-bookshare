<template>
  <div class="friMsg">
    <template>
      <v-app 
        app>
          <v-app-bar 
          app 
          elevate-on-scroll 
          color="#efeeee" 
          light
          clipped-left="true"
          >
            <el-menu
              :default-active="activeIndex"
              class="menu"
              mode="horizontal"
              router
              @select="handleSelect"
              background-color="#efeeee"
            >
              <el-menu-item index="/">首页</el-menu-item>
              <el-submenu index="2">
                <template slot="title">书库</template>
                <el-menu-item index="/Book/BookReview">书评</el-menu-item>
                <el-menu-item index="/Book/BookWareHouse">书籍</el-menu-item>
              </el-submenu>
              <el-menu-item index="/Group/GroupList">圈子</el-menu-item>
              <el-menu-item index="/updates">动态</el-menu-item>
            </el-menu>
            <v-row justify="end">
              <template v-if="this.$store.state.login">
                <avatar></avatar>
              </template>
              <template v-else>
                <v-btn class="button" href="/Login">
                  <p class="login_">登录</p>
                </v-btn>
              </template>
            </v-row>
          </v-app-bar>
            <v-navigation-drawer
              left
              floating
              permanent
              elevate-on-scroll
              expand-on-hover
              app
            >
              <v-list
                :default-active="activeIndex"
                dense
                rounded
                align="center"
                justify="center"
                height=50%
              >
                <v-list-item
                style="margin-top:200px;"
                @click="toFriend"
                class="px-2"
                >

                  <v-list-item-icon >
                    <v-icon>mdi-message-text</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title class="font-italic">Friends</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-list-item
                  link
                  @click="toSystem"
                  class="px-2"
                  style="margin-top:200px"
                >
                  <v-list-item-icon >
                    <v-icon>mdi-view-dashboard</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title class="font-italic">System</v-list-item-title>
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
                          width="1000px"
                          height="1000px"
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

                      <div class="content" v-for="(item,index) in recordContent" :key="index">
                        <div 
                        v-if="item.mineMsg"
                        class="RList">
                          <v-snackbar
                              :timeout="-1"
                              :value="true"
                              color="blue-grey"
                              rounded="pill"
                              >
                              {{item.contactText}}
                          </v-snackbar>
                        </div>
                        <div 
                        v-else
                        class="LList">
                          <v-row>
                          <v-avatar src="item.headUrl"></v-avatar>
                          <v-col>
                              <v-text>{{item.nickName}}</v-text>
                          <v-snackbar
                              :timeout="-1"
                              :value="true"
                              color="blue-grey"
                              rounded="pill"
                              >
                              {{item.contactText}}
                          </v-snackbar>
                          </v-col>
                          </v-row>
                        </div>
                      </div>
                      <v-card-action>
                      <v-form align="bottom" absolute bottom>
                          <v-container >
                          <v-row>
                              <v-col cols="12">
                              <v-text-field
                                  v-model="message"
                                  :append-icon="marker ? 'mdi-map-marker' : 'mdi-map-marker-off'"
                                  :append-outer-icon="message ? 'mdi-send' : 'mdi-microphone'"
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
        </v-app>
      </template>
     
  </div>
</template>

<script>
import avatar from "../components/Avatar.vue"
  export default {
    data: () => ({
        password: 'Password',
        show: false,
        message: '',
        marker: true,
      friends: [
        { header: 'Today' },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          title: 'Brunch this weekend?',
          subtitle: "<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
          subtitle: "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: 'Oui oui',
          subtitle: "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: 'Birthday gift',
          subtitle: "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?",
        },
        { divider: true, inset: true },
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
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
          subtitle: "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: 'Oui oui',
          subtitle: "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: 'Birthday gift',
          subtitle: "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?",
        },
        { divider: true, inset: true },
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
    }),
    components:{
       avatar,
    },

    created(){
      this.showFriMsg;
    },

    methods :{
        toMsg(){
            this.$router.push({path:"/message"});
          },
        toggleMarker () {
            this.marker = !this.marker
        },
        sendMessage () {
            this.recordContent.push({headUrl:"https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
            mineMsg:'ture',
            nickName:'me',
            timestamp:'2021-2-10',
            contactText:this.message})
            this.resetIcon()
            this.clearMessage()
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
            url: "/Home",
          })
            .then((res) => {
              this.books = res.data.hotBook;
              this.groups = res.data.hotGroup;
            })
            .catch((err) => {
              console.log(err);
        });
        },
        toMsgPage(){
          this.$router.push({path:"/messageListFromFriend"});
          },
        toBlogPage(){
         this.$router.push({path:"/BlogList"});
       },
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

