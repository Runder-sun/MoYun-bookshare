<template>
  <div class="forumhome">
    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <v-card>
          <v-card-title>
            <span class="text-h5">发起讨论</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12">
                  <v-text-field
                    v-model="newTopic"
                    color="blue darken-2"
                    label="讨论主题"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="addForum"> 发起 </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
    <v-app>
      <bar></bar>

      <v-container>
        <v-card>
          <v-toolbar flat>
            <v-toolbar-title>讨论区</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn text @click="dialog = !dialog">发起讨论</v-btn>
          </v-toolbar>
          <v-card flat>
            <v-container class="pa-4 text-center">
              <v-row align="center" justify="center">
                <template v-for="(forum, i) in forums">
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
        top
      >
        {{ message }}
      </v-snackbar>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  inject: ["reload"],
  created() {
    this.getInit();
  },
  methods: {
    getInit() {
      this.$http({
        method: "get",
        url: "/ForumHome",
        params: {
          GroupID: this.$route.params.id,
        },
      }).then((res) => {
        this.forums = res.data.GroupForum;
      });
    },
    addForum() {
      this.dialog = false;
      this.$http({
        method: "post",
        url: "/addForum",
        data: {
          GroupID: this.$route.params.id,
          Topic: this.newTopic,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "成功!";
          this.snackbar = true;
          this.timer = setTimeout(() => {
            //设置延迟执行
            this.reload();
          }, 1000);
        }
      });
      this.newTopic = "";
    },
  },
  data: () => ({
    dialog: false,
    newTopic: "",
    timer: null,
    snackbar: false,
    message: "",
    forums: [
    
    ],
  }),
  components: {
    Bar,
  },
};
</script>
