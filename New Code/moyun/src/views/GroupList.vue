<template>
  <div class="grouplist">
    <v-app>
      <bar></bar>
      <v-container>
        <v-toolbar flat>
          <v-toolbar-title>圈子</v-toolbar-title>

          <v-spacer></v-spacer>

          <v-btn text color="cyan" href="/Group/CreateGroup"> 创建圈子 </v-btn>

          <v-btn text color="deep-orange" href="/Group/AllGroup">
            所有圈子
          </v-btn>

          <template v-slot:extension>
            <v-tabs v-model="tab">
              <v-tab>热门圈子</v-tab>
              <v-tab>我的圈子</v-tab>

              <v-tab-item>
                <v-lazy>
                  <v-container class="pa-4 text-center">
                    <v-row class="fill-height" align="center" justify="center">
                      <template v-for="(group, i) in hotGroups">
                        <v-col :key="i" cols="12" md="3">
                          <v-hover v-slot="{ hover }">
                            <v-card
                              :elevation="hover ? 24 : 2"
                              :class="{ 'on-hover': hover }"
                              width="300"
                              :to="'/Group/GroupIndex/' + group.groupID"
                            >
                              <v-img :src="group.img" height="225px">
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
                </v-lazy>
              </v-tab-item>

              <v-tab-item>
                <v-lazy>
                  <v-container class="pa-4 text-center">
                    <v-row class="fill-height" align="center" justify="center">
                      <template v-for="(group, i) in myGroups">
                        <v-col :key="i" cols="12" md="3">
                          <v-hover v-slot="{ hover }">
                            <v-card
                              :elevation="hover ? 24 : 2"
                              :class="{ 'on-hover': hover }"
                              width="300"
                              :to="'/Group/GroupIndex/' + group.groupID"
                            >
                              <v-img :src="group.img" height="225px">
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
                </v-lazy>
              </v-tab-item>
            </v-tabs>
          </template>
        </v-toolbar>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
    tab:null,
    hotGroups: [
      {
        groupID: 1,
        title: "Rock",
        text: "Greatest Rock Hits",
        subtext: "Lose yourself in rock tunes.",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        groupID: 2,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        groupID: 3,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        groupID: 4,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        groupID: 5,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        groupID: 6,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        groupID: 7,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        groupID: 8,
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
    ],
    myGroups: [],
  }),
  components: {
    Bar,
  },
  created() {
    this.showGroupList();
  },
  methods: {
    showGroupList() {
      this.$http({
        method: "get",
        url: "/GroupHome",
      }).then((res) => {
          this.hotGroups = res.data.hotGroup;
          this.myGroups = res.data.UserGroup;
        }).catch((err) => {
          console.log(err);
      });
    },
  },
};
</script>
