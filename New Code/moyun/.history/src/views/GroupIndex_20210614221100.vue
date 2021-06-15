<template>
  <div class="groupIndex">
    <bar></bar>
    <v-navigation-drawer v-model="drawer" absolute bottom temporary right>
      <v-list nav dense two-lines>
        <v-chip-group column v-if="$store.state.userID == group.createID">
          <v-chip
            v-for="(user,i) in groupApplyUser"
            :key="i"
            class="ma-2"
            close
            label
            text-color="white"
            @click:close="refuse(user)"
          >
            <v-avatar left size="10" :to="'/PersonalInfo/'+user.userID" class="lxtAva">
              <img :src="user.headImage" :alt="user.username" />
            </v-avatar>
            {{ user.username }}
            <v-spacer></v-spacer>
            <v-btn text color="cyan" @click="acceptApply(user)"> 同意</v-btn>
          </v-chip>
        </v-chip-group>
        <v-divider></v-divider>
        <v-list-item-group active-class="deep-purple--text text--accent-4">
          <v-list-item v-for="(member, i) in members" :key="i">
            <v-list-item-avatar :to="'/PersonalInfo/'+member.userID">
              <img :src="member.headImage" />
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title v-text="member.username"></v-list-item-title>
              <v-btn
                v-if="$store.state.userID == group.createID"
                right
                @click="removeMember(member)"
                >删除</v-btn
              >
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <v-card>
          <v-card-title>
            <span class="text-h5">修改圈子信息</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" >
                  <v-text-field
                    v-model="group.groupName"
                    color="blue darken-2"
                    label="圈子名称"
                    required
                  ></v-text-field>
                  <v-textarea v-model="group.introduce" color="teal">
                    <template v-slot:label>
                      <div>圈子简介</div>
                    </template>
                  </v-textarea>
                  <v-checkbox v-model="group.isPrivate" label="私密"></v-checkbox>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="changeGroupInfo">
              关闭
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
    <v-row justify="center">
      <v-dialog v-model="dialog1" persistent max-width="600px">
        <v-card>
          <v-card-title>
            <span class="text-h5">添加任务</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" >
                  <v-text-field
                    v-model="newTask"
                    color="blue darken-2"
                    label="任务名称"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="addTask">
              关闭
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
    <v-container>
      <v-card class="mx-auto" >
        <v-toolbar class="lxtToolbar">
          <v-toolbar-title>圈子主页</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn v-if="!isMember" @click="apply" class="applyBtn"
            >申请加入</v-btn
          >
          <template v-if="isCollect">
            <v-btn icon @click="cancelCollectGroup" class="lxtBtn">
              <v-icon>mdi-heart-remove</v-icon>
            </v-btn>
          </template>
          <template v-else>
            <v-btn icon @click="collectGroup" class="lxtBtn">
              <v-icon>mdi-heart</v-icon>
            </v-btn>
          </template>
          <v-btn icon @click.stop="drawer = !drawer" class="lxtBtn">
            <v-icon>mdi-account-details</v-icon>
          </v-btn>
        </v-toolbar>

        <v-list-item three-line>
          <v-list-item-avatar left size="200" color="grey">
            <img :src="group.groupImage">
          </v-list-item-avatar>
          <v-list-item-content>
            <div class="headline mb-4">{{group.groupName}}</div>
            <v-list-item-title> {{group.tag}}</v-list-item-title>
            <v-list-item-subtitle>{{group.introduce}}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>

        <v-card-actions> 
          <v-spacer></v-spacer>
          <v-btn  icon v-if="$store.state.userID == group.createID" @click="dialog=!dialog">
            <v-icon>
              mdi-circle-edit-outline
            </v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>

      <v-card class="task">
        <v-card-title>
          任务版
          <v-spacer></v-spacer>
          <v-btn icon v-if="$store.state.userID == group.createID" @click="dialog1=!dialog1">
            <v-icon>
              mdi-clipboard-plus-outline
            </v-icon>
            </v-btn
          >
        </v-card-title>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">任务</th>
                <th class="text-left">创建时间</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(task,i) in tasks" :key="i">
                <td>{{ task.taskContent }}</td>
                <td>{{ task.createTime }}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-card>

      <v-card class="discussion">
        <v-toolbar>
          <v-toolbar-title>热门讨论</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn
            color="cyan"
            :to="'/Group/Forum/ForumHome/' + this.$route.params.id"
            >讨论区</v-btn
          >
        </v-toolbar>
        <v-card flat>
          <v-container class="pa-4 text-center">
            <v-row class="fill-height" align="center" justify="center">
              <template v-for="(forum, i) in hotForum">
                <v-col :key="i" cols="12">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      :to="'/Group/Forum/Forum/' + forum.forumID"
                    >
                      <v-card-title>
                        <v-row
                          class="fill-height flex-column"
                          justify="space-between"
                        >
                          <p class="mt-4 subheading text-left">
                            {{ forum.topic }}
                          </p>
                        </v-row>
                      </v-card-title>
                      <v-card-text>
                        <div>
                          <p
                            class="
                              ma-0
                              body-1
                              font-weight-bold font-italic
                              text-left
                            "
                          >
                            {{ forum.createTime }}
                          </p>
                        </div>
                      </v-card-text>
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
    drawer: null,
    dialog: false,
    dialog1: false,
    //groupID: this.$route.params.id,
    isCollect: false,
    isMember: false,
    newTask:"",
    group: {
      groupName: "这是圈子名称",
      introduce: "这是圈子简介",
      tag: "这是标签",
      isPrivate:false,
      groupImage:"https://cdn.vuetifyjs.com/images/john.jpg",
    },
    members: [
      {
        headImage: "https://cdn.vuetifyjs.com/images/john.jpg",
        username: "zy",
      },
    ],
    tasks: [
      {
        taskContent: "读书",
        createTime: "2021.1.1",
      },
    ],
    hotForum: [
      {
        forumID: 1,
        topic: "主题",
        forumMessages: "内容",
      },
    ],
    groupApplyUser: [
      {
        headImage: "https://cdn.vuetifyjs.com/images/john.jpg",
        username: "zy",
      },
    ],
    model: 1,
    snackbar: false,
    message: "",
  }),

  components: {
    bar,
  },
  created() {
    this.getInit();
    this.getApply();
  },
  methods: {
    getInit() {
      this.$http({
        method: "get",
        url: "/GroupInfo",
        params: this.$route.params.id,
      })
        .then((res) => {
          if (res.data.success) {
            if (isGroupMember(this.$store.state.userID, res.data.MemberList)) {
              this.isMember = true;
            } else {
              this.isMember = false;
            }
            this.groups = res.data.GroupInfo;
            this.members = res.data.MemberUser;
            this.hotForum = res.data.HotForum;
            this.isCollect = res.data.isCollect;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    isGroupMember(userID, memberList) {
      for (var i in memberList) {
        if (userID === i.userID) return true;
      }
      return false;
    },
    getMemberApplyID(userID, memberList) {
      for (var i in memberList) {
        if (userID === i.userID) {
          return i.groupApplyID;
        }
      }
      return null;
    },
    getApply() {
      this.$http({
        method: "get",
        url: "/GroupApplyList",
        params: this.$route.params.id,
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
        url: "/refuseApply",
        params: {
          GroupApplyID: this.getMemberApplyID(item.userID, this.memberList),
          GroupID: this.$route.params.id,
        },
      });
    },
    acceptApply(item) {
      this.groupApplyUser.splice(this.groupApplyUser.indexOf(item), 1);
      this.groupApplyUser = [...this.groupApplyUser];
      this.$http({
        method: "post",
        url: "/addMember",
        params: {
          GroupApplyID: this.getMemberApplyID(item.userID, this.memberList),
          GroupID: this.$route.params.id,
          UserID: item.userID,
        },
      });
    },
    apply() {
      this.$http({
        method: "post",
        url: "/applyGroup",
        params: {
          GroupID: this.$route.params.id,
        },
      });
    },
    removeMember(member) {
      this.members.splice(this.members.indexOf(member), 1);
      this.members = [...this.members];
      this.$http({
        method: "post",
        url: "/deleteMember",
        params: {
          MemberID: member.userID,
        },
      });
    },
    collectGroup() {
      this.$http({
        method: "post",
        url: "/CollectGroup",
        params: {
          GroupID: this.$route.params.id,
        },
      }).then((res) => {
        if (res.data.success) this.isCollect = true;
      });
    },
    cancelCollectGroup() {
      this.$http({
        method: "post",
        url: "/cancelCollectGroup",
        params: {
          GroupID: this.$route.params.id,
        },
      }).then((res) => {
        if (res.data.success) this.isCollect = false;
      });
    },
    addTask() {
      //TODO:生成弹窗输入任务
      this.dialog1 = false;
      this.$http({
        method: "post",
        url:"/addTask",
        data: {
          GroupID:this.$route.params.id,
          TaskContent:this.newTask,
        }
      });
      this.getInit();
      newTask="";
    },
    changeGroupInfo(){
      this.dialog = false
      this.$http({
        method: "post",
        url:"/changeGroupInfo",
        data: {
          GroupID:this.$route.params.id,
          GroupName:this.group.groupName,
          Introduce:this.group.introduce,
          isPrivate:this.group.isPrivate,
          Tag:this.group.tag,
        }
      })
    }
  },
};
</script>

<style scoped>
.lxtAva{
    border-radius: 137px;
    background: #eee7e7;
    box-shadow: inset -20px 20px 41px #b3adad,
    inset 20px -20px 41px #ffffff;
}

.lxtToolbar{
  margin-top:40px;
  padding-right:10px;
}

.lxtBtn{
  color: #383d49;
  margin-right: 30px;

box-shadow:  18px 18px 36px rgba(0, 0, 0, 0.1),
             -18px -18px 36px #ffffff;
    		transition: box-shadow 0.2s ease-out;         
		background-color: #efeeee;
		position: relative;  
    		outline: none;
		border: none;                   
}

.applyBtn{
    margin-right:35px;
  	border-radius: 128px;
background: #8fc19c;
box-shadow:  18px 18px 36px #84b290,
             -18px -18px 36px #9ad0a8;
		transition: box-shadow 0.2s ease-out;
		background-color: #efeeee;
		position: relative;
		top: 0px;
		width: 140px;
		height: 70 px;
		outline: none;
		border: none;
}

.task{
  margin-top:30px;
}

.discussion{
  margin-top:30px;
}
</style>