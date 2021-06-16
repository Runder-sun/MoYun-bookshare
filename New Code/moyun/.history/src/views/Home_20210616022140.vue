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
          <v-btn class="button" max-width="30px" :to="'/Login'">
            <p class="login_">登录</p>
          </v-btn>
        </template>
      </v-row>
    </v-app-bar>
    <v-img :src="require('@/assets/墨韵.jpg')" class="mainPage"></v-img>
    <h1 class="words g-img1 font-weight-bold">热门圈子</h1>
    <v-card>
      <v-row>
              <template v-for="(group, i) in groups">
                <v-col :key="i" cols="12" md="3">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      :to="'/Group/GroupIndex/' + group.groupID"
                      width="200"
                    >
                      <v-img :src="'/home/moyun/file/'+group.groupImage" height="225px">
                        <v-card-title >
                          <v-row
                            class="fill-height flex-column"
                            justify="space-between"
                          >
                            <p class="mt-4 subheading text-left">
                              {{ group.groupName }}
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
                                {{ group.tag}}
                              </p>
                              <p
                                class="
                                  caption
                                  font-weight-medium font-italic
                                  text-left
                                "
                              >
                                {{ group.introduce }}
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
    </v-card>

    <h1 class="words">热门书籍</h1>
    <div class="g-img3 myimg"></div>
  </div>
</template>

<script>
import avatar from "../components/Avatar.vue";
export default {
  data: () => ({
    groups: [
      {groupID:1,
      groupImage:"../asset/prince.jpg",
      tag:"Story",
      introduce:"This is a story about a prince and his travel..."},
      {groupID:2,
      groupImage:"../asset/prince.jpg",
      tag:"Story",
      introduce:"This is a story about a prince and his travel..."},
      {groupID:3,
      groupImage:"../asset/prince.jpg",
      tag:"Story",
      introduce:"This is a story about a prince and his travel..."},
      {groupID:4,
      groupImage:"../asset/prince.jpg",
      tag:"Story",
      introduce:"This is a story about a prince and his travel..."},
    ],
    books: [],
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
.mainPage{
  height:100vh;
  width:100vw;
}

.myimg {
  width: 100vw;
  height: 100vh;
}
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
  top:10%;
  margin-top: 5px;
  outline: none;
  border: none;
}
.login_ {
  margin-top: 20%;
  font-size: 15px;
}

.groupTitle{
  height:100vh;
  background-image: url('../assets/UpdatesB3.jpg');
  background-attachment: fixed;
  background-size: cover;
  background-position: center center;
}

.words {
    text-align: center;
    margin:0 auto;
    font-size: 70px;
    line-height:60vh;
    font-family: "黑体";
    color: #fff;
}

.g-img1 {
    background-image: url('../assets/1.png');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
} 

.g-img2 {
    background-image: url('../assets/2.png');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
} 

.g-img3 {
    background-image: url('../assets/UpdatesB3.jpg');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
} 
</style>
