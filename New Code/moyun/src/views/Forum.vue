<template>
  <div class="forum">
    <bar></bar>
    <v-container>
      <v-card>
        <v-toolbar flat>
          <v-toolbar-title>{{ forum.topic }}</v-toolbar-title>
        </v-toolbar>
        <v-expansion-panels v-model="panel" multiple>
          <v-expansion-panel v-for="(forumMessage, i) in messages" :key="i">
            <v-expansion-panel-header>
              <template>
                <v-container>
                  <p>
                    <v-avatar size="30" color="#96CDCD">
                      <template v-if="forumMessageUser[i].headImage !==null">
                        <img
                          :src="'/' + forumMessageUser[i].headImage"
                        />
                      </template>
                      <template v-else>
                        <span>{{forumMessageUser[i].userID.substr(0,1)}}</span>
                      </template>
                    </v-avatar>

                    {{ forumMessageUser[i].username }} :
                  </p>
                </v-container>
              </template>
            </v-expansion-panel-header>
            <v-expansion-panel-content>
              {{ forumMessage.comment }}
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
        <v-spacer></v-spacer>
        <v-btn text color="cyan" @click="addMessage">提交</v-btn>
      </v-card>
    </v-container>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
  inject: ["reload"],

  mounted() {
    this.getInit();
  },

  methods: {
    getInit() {
      this.$http({
        method: "get",
        url: "/getForumMessage",
        params: {
          ForumID: this.$route.params.id,
        },
      })
        .then((res) => {
          console.log(res.data);
          if (res.data.success) {
            this.messages = res.data.ForumMessageList;
            this.forum = res.data.Forum;
            this.forumMessageUser = res.data.ForumMessageUser;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    addMessage() {
      this.$http({
        method: "post",
        url: "/addMessage",
        data: {
          ForumID: this.$route.params.id,
          Comment: this.content,
        },
      }).then((res) => {
        this.reload();
      });
      this.content = "";
    },
  },
  data: () => ({
    panel: [0],
    content: "",
    forumMessageUser: [],
    forum: {},
    messages: [],
  }),
  components: {
    bar,
  },
};
</script>
