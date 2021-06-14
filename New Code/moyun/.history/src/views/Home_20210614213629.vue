<template>
  <div class="home">
    <v-app-bar app elevate-on-scroll color="#efeeee" light inverted-scroll>
      <el-menu
        class="menu"
        mode="horizontal"
        router
        background-color="#efeeee"
      >
        <el-menu-item :to="'/'">首页</el-menu-item>
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
          <v-btn class="button" :to="'/Login'">
            <p class="login_">登录</p>
          </v-btn>
        </template>
      </v-row>
    </v-app-bar>
    <v-img src="../assets/widthPic.jpg" dark></v-img>
    <h1 class="textCenter">墨韵</h1>
    <v-main>
      <v-container fluid>
        <h2 class="text-center">
          热门圈子
          <v-container class="pa-4 text-center">
            <v-row class="fill-height" align="center" justify="center">
              <template v-for="(group, i) in groups">
                <v-col :key="i" cols="12" md="2">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      :to="'/Group/GroupIndex/' + group.groupID"
                      width="300"
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
        </h2>
      </v-container>
      <v-container fluid>
        <h2 class="text-center">
          热门书籍
          <v-container class="pa-4 text-center">
            <v-row class="fill-height" align="center" justify="center">
              <template v-for="(group, i) in groups">
                <v-col :key="i" cols="12" md="2">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      width="300"
                    >
                      <v-img
                        :src="group.img"
                        height="225px"
                        @click="toCheckBook"
                      >
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
        </h2>
      </v-container>
    </v-main>
  </div>
</template>

<script>
import avatar from "../components/Avatar.vue";
export default {
  data: () => ({
    groups: [
      {
        title: "New Releases",
        text: `It's New Release Friday`,
        subtext: "Newly released songs. Updated daily.",
        img: "https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
      },
      {
        title: "Rock",
        text: "Greatest Rock Hits",
        subtext: "Lose yourself in rock tunes.",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
    ],
    books: [
      {
        title: "New Releases",
        text: `It's New Release Friday`,
        subtext: "Newly released songs. Updated daily.",
        img: "https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80",
      },
      {
        title: "Rock",
        text: "Greatest Rock Hits",
        subtext: "Lose yourself in rock tunes.",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
    ],
    transparent: "rgba(255, 255, 255, 0)",
  }),
  components: {
    avatar,
  },
  created() {
    this.show();
  },
  methods: {
    toCheckBook() {
      this.$router.push({ path: "/Book/CheckBook" });
    },
    show() {
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
  },
};
</script>

<style scoped>
.home {
  width: 100%;
  height: 100vh;
}
.home v-img {
  height: 100%;
  width: 100%;
  position: abosulte;
  background-size: cover;
  opacity: 0.8;
  filter: alpha(opacity=60);
}
.textCenter {
  position: absolute;
  text-align: center;
  left: 50%;
  top: 30%;
  margin-left: -200px;
  text-shadow: 5px -5px black, 4px -4px white;
  font-weight: bold;
  -webkit-text-fill-color: transparent;
  font-size: 200px;
}
.button {
  color: #596275;
  box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
    -9px -9px 18px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  background-color: #efeeee;
  position: relative;
  top: 15%;
  outline: none;
  border: none;
}
.login_ {
  margin-top: 20%;
  font-size: 15px;
}
</style>
