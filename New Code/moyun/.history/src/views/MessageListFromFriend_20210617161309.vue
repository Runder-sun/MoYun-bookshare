<template>
  <div class="friMsg">
    <template>
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
            height="50%"
          >
            <br />
            <br />
            <br />
            <br />
            <br />
            <v-list-item
              link
              @click="toFriend(item.userID)"
              class="px-2"
              v-for="(item, index) in messageTargetList"
              v-bind:key="index"
              style="margin-left=5px"
            >
              <v-list-item-avatar>
                <img
                  :src="'/images/' + item.headImage"
                  :alt="item.username"
                />
              </v-list-item-avatar>
              <v-list-item-content>
                <v-list-item-title class="font-italic">{{
                  item.username
                }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <router-view />
          </v-list>
        </v-navigation-drawer>

        <v-main app>
          <v-container fluid class="pa-4 text-center" direction="horizontal">
            <v-row>
              <v-card width="1200px" class="mx-auto" style="margin-top: 50px" min-height="600"> 
                <v-toolbar dense text-align="center" justify="center">
                  <v-app-bar-nav-icon></v-app-bar-nav-icon>

                  <v-toolbar-title>{{ this.messageBoxTitle }}</v-toolbar-title>

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
                    <v-divider :key="index" :inset="inset"></v-divider>

                    <v-list-item
                      :key="item.title"
                      v-if="getUser.userID === item.getID"
                    >
                      <v-list-item-avatar>
                        <v-img
                          :src="'/images/' + getUser.headImage"
                        ></v-img>
                      </v-list-item-avatar>

                      <v-list-item-content>
                        <v-list-item-title
                          v-html="getUser.username"
                        ></v-list-item-title>
                        <v-list-item-subtitle
                          v-html="item.message"
                        ></v-list-item-subtitle>
                      </v-list-item-content>
                    </v-list-item>

                    <v-list-item :key="item.title" v-else>
                      <v-list-item-avatar>
                        <v-img
                          :src="'/images/' + sendUser.headImage"
                        ></v-img>
                      </v-list-item-avatar>

                      <v-list-item-content>
                        <v-list-item-title
                          v-html="sendUser.username"
                        ></v-list-item-title>
                        <v-list-item-subtitle
                          v-html="item.message"
                        ></v-list-item-subtitle>
                      </v-list-item-content>
                    </v-list-item>
                  </template>
                </v-list>
                <v-card-action style="margin-bottom:10px">
                  <v-form align="bottom" absolute bottom>
                    <v-container>
                      <v-row>
                        <v-col cols="12">
                          <v-text-field
                            v-model="message"
                            :append-icon="
                              marker ? 'mdi-map-marker' : 'mdi-map-marker-off'
                            "
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
                            position:bottom
                            relative
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
    </template>
  </div>
</template>

<script>
import avatar from "../components/Avatar.vue";
import bar from "../components/Bar.vue";
export default {
  inject: ["reload"],
  data: () => ({
    myInterval: null,
    messageBoxTitle: "System",
    password: "Password",
    divider: true,
    inset: true,
    show: false,
    message: "",
    marker: true,
    iconIndex: 0,
    icons: [
      "mdi-emoticon",
      "mdi-emoticon-cool",
      "mdi-emoticon-dead",
      "mdi-emoticon-excited",
      "mdi-emoticon-happy",
      "mdi-emoticon-neutral",
      "mdi-emoticon-sad",
      "mdi-emoticon-tongue",
    ],
    sendUser: [],
    getUser: [],
    messageTargetList: [],
    friends: [],
    systemMessageList: [],
    userMessageList: [],
  }),

  components: {
    bar,
  },

  created:function() {
    this.showFriMsg();
    this.initList();
  },

  computed: {
    icon() {
      return this.icons[this.iconIndex];
    },
  },

  methods: {
    toggleMarker() {
      this.marker = !this.marker;
    },
    clearMessage() {
      this.message = "";
    },
    resetIcon() {
      this.iconIndex = 0;
    },
    changeIcon() {
      this.iconIndex === this.icons.length - 1
        ? (this.iconIndex = 0)
        : this.iconIndex++;
    },
    showFriMsg() {
      this.$http({
        method: "get",
        url: "/MessageHome",
      })
        .then((res) => {
          this.messageTargetList = res.data.MessageTargetList;
          this.systemMessageList = res.data.SystemMessageList;
          this.friends = this.systemMessageList;
        })
        .catch((err) => {
          console.log(err);
        });
      if (this.$route.params.id !== 0) {
        this.$http({
          method: "get",
          url: "/ChatMessageList",
          params: {
            GetID: this.$route.params.id,
          },
        })
          .then((res) => {
            this.userMessageList = res.data.UserMessageList;
            this.sendUser = res.data.sendUser;
            this.getUser = res.data.getUser;
            if (res.data.success) {
              this.friends = this.userMessageList;
              this.messageBoxTitle = this.getUser.username;
            }
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },

    toFriend(id) {
      this.$router.push({ path: `/messageListFromFriend/${id}` });
    },

    sendMessage() {
      if(this.message!==''){
        this.$http({
        method: "post",
        url: "/SendMessage",
        data: {
          GetID: this.sendUser,
          Message: this.message,
        },
      }).then((res) => {
        if (res.data.success) {
          alert("Send Message Success");
          this.reload();
        } else {
          alert("发送信息失败！");
        }
      });
      }
      else {
        alert("消息为空，无法发送！")；
      }
      this.resetIcon();
      this.clearMessage();
    },

      initList() {
        this.myInterval = window.setInterval(() => {
          setTimeout(() => {
            this.showFriMsg();
          }, 1);
        }, 5000);
      },

  },

  destroyed() {
    clearInterval(this.myInterval);
  },
};
</script>

<style scoped>
.RList v-snackbar {
  text-align: "right";
  margin: 10px;
  display: inline-block;
  padding: 3px 10px;
  border: 1px solid aliceblue;
  border-radius: 15px;
}
.LList v-snackbar {
  text-align: "left";
  display: inline-block;
  padding: 3px 10px;
  border: 1px solid aliceblue;
  border-radius: 15px;
  padding: 5px 10px;
}

.friMsg {
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a5d57e, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
      width:100%;
    height:100%;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

</style>
