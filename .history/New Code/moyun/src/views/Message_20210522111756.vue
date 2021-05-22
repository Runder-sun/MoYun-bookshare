<template>
  <div class="msg">
        <v-container fluid class="pa-4 text-center">
        <v-row>
        <sideBar></sideBar>
        <v-card
            color="grey lighten-4"
            height="780px"
            width="1300px"
            rounded
            align="center"
            justify="center"
            class="mx-auto"
            style="margin-top:50px"
        >
            <v-toolbar dense             
            text-align="center"
            justify="center">
            <v-app-bar-nav-icon></v-app-bar-nav-icon>

            <v-toolbar-title>{{object}}</v-toolbar-title>

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
            <div class="content" v-for="item in recordContent" :key="item.mineMsg" :class="item.mineMsg?'RList':'LList'">
                <v-row>
                <v-avatar src="item.headUrl"></v-avatar>
                <v-col>
                    <v-text>{{item.nickName}}</v-text>
                <v-snackbar
                    :timeout="-1"
                    :value="true"
                    color="blue-grey"
                    absolute
                    rounded="pill"
                    top
                    >
                    {{item.contactText}}
                </v-snackbar>
                </v-col>
                </v-row>
            </div>
            <v-card-action>
            <v-form align="bottom">
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
  </div>

</template>


<script>

import sideBar from"../components/MSGSideBar.vue";
  export default {
    data: () => ({
        object:"Jackson",
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
        password: 'Password',
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
    }),
    components:{
       sideBar,
    },

    computed: {
        icon () {
            return this.icons[this.iconIndex]
        },
        },

        methods: {
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
        },
  }
</script>

              
<style scoped>
.msg{
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


