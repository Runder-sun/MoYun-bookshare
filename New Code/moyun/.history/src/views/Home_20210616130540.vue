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
    <div class=" g-img1 ">
      <div class="font-weight-bold words1">热门圈子</div>
      <div class="font-weight-bold words2">为您推荐墨韵读书会热门读书圈</div>
    </div>
    <div class="groups">
      <div style="height:1px"></div>
      <div class="cardsMid">
      <v-row align="auto">
              <template v-for="(group, i) in groups">
                <v-col :key="i" cols="12" md="4" >
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 8 : 2"
                      :class="{ 'on-hover': hover }"
                      :to="'/Group/GroupIndex/' + group.groupID"
                      width="300"
                      height="400"
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
        </div>
    </div>
    <div class="g-img3 myimg">
      <div class="font-weight-bold words1">热门圈子</div>
      <div class="font-weight-bold words2">为您推荐墨韵读书会热门读书圈</div>
    </div>
        <div class="groups2">
      <div style="height:1px"></div>
      <div class="cardsMid">
      <v-row align="center auto" justify="center">
              <template v-for="(book, i) in books">
                <v-col :key="i" cols="12" md="4">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 12 : 2"
                      :class="{ 'on-hover': hover }"
                      width="300"
                      height="400"
                    >
                      <v-img
                        :src="'/home/moyun/file/'+book.bookImage"
                        height="225px"
                        @click="toCheckBook"
                      >
                        <v-card-title >
                          <v-row
                            class="fill-height flex-column"
                            justify="space-between"
                          >
                            <p class="mt-4 subheading text-left">
                              {{ book.bookName }}
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
                                {{ book.author }}
                              </p>
                              <p
                                class="
                                  caption
                                  font-weight-medium font-italic
                                  text-left
                                "
                              >
                                {{ book.kind }}
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
        </div>
    </div>
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
    ],
    books: [{
      bookImage:"1",
      bookName:"1",
      author:"123",
      kind:"story",
    },{
      bookImage:"1",
      bookName:"1",
      author:"123",
      kind:"story",
    },{
      bookImage:"1",
      bookName:"1",
      author:"123",
      kind:"story",
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

.words1 {
    text-align: center;
    margin:0 auto;
    font-size: 70px;
    position: 40vh;
    line-height:60vh;
    font-family: "宋体";
    color: #fff;
    
}

.words2 {
    text-align: center;
    margin:0 auto;
    font-size: 40px;

    position: 50vh;
    font-family: "宋体";
    color: #fff;
}

.g-img1 {
   width: 100vw;
  height: 100vh;
    background-image: url('../assets/set9.jpg');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
} 

.g-img2 {
    background-image: url('../assets/set7.jpg');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
} 

.g-img3 {
    background-image: url('../assets/set7.jpg');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
} 
.groups{
 background-color: #6d7175;
 width: 100vw;
  height: 100vh;
  justify-content: center;
}

.cardsMid{
  height: 80vh;
  width:80vw;
    margin:0px auto;
  margin-top:25vh;
}

.groups2{
 background-color: #4f5153;
 width: 100vw;
  height: 100vh;
  justify-content: center;
}

</style>
