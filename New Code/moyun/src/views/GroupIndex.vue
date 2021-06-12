<template>
  <div class="groupIndex">
    <bar></bar>
    <v-navigation-drawer v-model="drawer" absolute bottom temporary right>
      <v-list nav dense two-lines>
        <v-chip-group column>
          <v-chip
            v-for="user in groupApplyUser"
            :key="user"
            class="ma-2"
            close
            label
            text-color="white"
            @click:close="refuse(user)"
          >
            <v-avatar left size="10">
              <img :src="user.headImage" :alt="user.username" />
            </v-avatar>
            {{ user.username }}
            <v-spacer></v-spacer>
            <v-btn text color="cyan" @click="acceptApply"> 同意</v-btn>
          </v-chip>
        </v-chip-group>
        <v-divider></v-divider>
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item v-for="(item, i) in items" :key="i">
            <v-list-item-avatar>
              <v-icon v-text="item.icon"></v-icon>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <v-container>
      <v-card class="mx-auto" outlined>
        <v-toolbar>
          <v-toolbar-title>圈子主页</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn v-if="!isMember" color="#76EEC6" @click="apply"
            >申请加入</v-btn
          >
          <v-btn icon @click='getApply'>
            <v-icon>mdi-account-details</v-icon>
          </v-btn>
        </v-toolbar>

        <v-list-item three-line>
          <v-list-item-avatar left size="200" color="grey"></v-list-item-avatar>
          <v-list-item-content>
            <div class="headline mb-4">这是圈子名称</div>
            <v-list-item-title> 这是圈子导师 </v-list-item-title>
            <v-list-item-subtitle>这是圈子简介</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>

        <v-card-actions> </v-card-actions>
      </v-card>

      <v-card>
        <v-card-title>任务版</v-card-title>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">Name</th>
                <th class="text-left">Calories</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="task in tasks" :key="task">
                <td>{{ task.taskContent }}</td>
                <td>{{ task.createTime }}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-card>

      <v-card>
        <v-toolbar>
          <v-toolbar-title>热门讨论</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn color="cyan" href="/Group/Forum/ForumHome">讨论区</v-btn>
        </v-toolbar>
        <v-card flat>
          <v-container class="pa-4 text-center">
            <v-row class="fill-height" align="center" justify="center">
              <template v-for="(group, i) in groups">
                <v-col :key="i" cols="auto">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      height="60px"
                    >
                      <v-img :src="group.img" height="60px">
                        <v-card-title class="title white--text">
                          <v-row
                            class="fill-height flex-column"
                            justify="space-between"
                          >
                            <p class="mt-4 subheading text-left">
                              {{ group.title }}
                            </p>

                            <div>
                              <p
                                class="
                                  ma-0
                                  body-1
                                  font-weight-bold font-italic
                                  text-left
                                "
                              >
                                {{ group.text }}
                              </p>
                              <p
                                class="
                                  caption
                                  font-weight-medium font-italic
                                  text-left
                                "
                              >
                                {{ group.subtext }}
                              </p>
                            </div>
                          </v-row>
                        </v-card-title>
                      </v-img>
                    </v-card>
                  </v-hover>
                </v-col>
              </template>
            </v-row>
          </v-container>
        </v-card>
      </v-card>
    </v-container>
    <v-snackbar
      v-model="snackbar"
      :timeout="3000"
      color="blue-grey"
      absolute
      rounded="pill"
    >
      {{ message }}
    </v-snackbar>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    drawer: false,
    group: null,
    groupID: this.$route.params.id,
    isMember: false,
    groups: {},
    members: [],
    tasks: [],
    hotForum: [],
    groupApplyUser: [],
    model: 1,
  }),

  watch: {
    group() {
      this.drawer = false;
    },
  },
  components: {
    bar,
  },
  created() {
    this.getInit();
  },
  methods: {
    getInit() {
      this.$http({
        method: "get",
        url: "/GroupInfo",
        params: this.groupID,
      })
        .then((res) => {
          if (res.data.success) {
            if (isMember(this.$store.state.userID, res.data.MemberList)) {
              this.isMember = true;
            } else {
              this.isMember = false;
            }
            this.groups = res.data.GroupInfo;
            this.members = res.data.MemberUser;
            this.hotForum = res.data.HotForum;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    isMember(userID, memberList) {
      for (var i in memberList) {
        if (userID === i.userID) return true;
      }
      return false;
    },
    getMemberApplyID(userID,memberList){
      for (var i in memberList){
        if (userID ===i.userID){
          return i.groupApplyID;
        }
      }
      return null;
    },
    getApply() {
      this.drawer=!this.drawer;
      this.$http({
        method: "get",
        url: "/GroupApplyList",
        params: this.groupID,
      })
        .then((res) => {
          if (res.data.success) {
            this.groupApplyUser = res.data.GroupApplyUser;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    refuse(item) {
      this.groupApplyUser.splice(this.groupApplyUser.indexOf(item), 1);
      this.groupApplyUser = [...this.groupApplyUser];
      this.$http({
        method: "post",
        url:"/refuseApply",
        params:{
          GroupApplyID:this.getMemberApplyID(item.userID,this.memberList),
          GroupID:this.groupID,
        }
      }).then(res=>{
        
      });
    },
    acceptApply(){

    },
  },
};
</script>
