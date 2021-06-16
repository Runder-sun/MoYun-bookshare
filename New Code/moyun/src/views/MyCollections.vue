<template>
  <div class="MyCollections">
    <v-app>
      <v-img src="../assets/widthPic.jpg" width="100%" height="100%">
        <bar></bar>
        <v-card max-width="400" class="mx-auto">
          <v-app-bar dark color="pink">
            <v-toolbar-title>个人收藏</v-toolbar-title>

            <v-spacer></v-spacer>
          </v-app-bar>

          <v-container>
            <v-row dense>
              <v-col cols="12">
                <v-card color="#385F73" dark>
                  <v-card-title class="text-h5"> 我收藏的日志 </v-card-title>

                  <v-card-subtitle
                    >在日志浏览界面收藏的日志将会存放在此，点击查看按钮转到我收藏的日志界面</v-card-subtitle
                  >

                  <v-card-actions>
                      <v-btn class="ml-2 mt-5" outlined rounded small @click="toBlogPersonalCollection"> 查看 </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>

              <v-col cols="12">
                <v-card color="#4A148C" dark>
                  <v-card-title class="text-h5"> 我收藏的书评 </v-card-title>

                  <v-card-subtitle
                    >在书评浏览界面收藏的书评将会存放在此，点击查看按钮转到我收藏的书评界面</v-card-subtitle
                  >

                  <v-card-actions>
                      <v-btn class="ml-2 mt-5" outlined rounded small @click="toBookReviewCollection"> 查看 </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>

              <v-col cols="12">
                <v-card color="#1F7087" dark>
                  <v-card-title class="text-h5"> 我收藏的圈子 </v-card-title>

                  <v-card-subtitle
                    >在圈子浏览界面收藏的圈子将会存放在此，点击查看按钮转到我收藏的圈子界面</v-card-subtitle
                  >

                  <v-card-actions>
                      <v-btn class="ml-2 mt-5" outlined rounded small @click="toGroupCollection"> 查看 </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>

              <v-col cols="12">
                <v-card color="#952175" dark>
                  <v-card-title class="text-h5"> 我关注的图书 </v-card-title>

                  <v-card-subtitle
                    >在书籍浏览界面关注的图书将会存放在此，点击查看按钮转到我关注的图书界面</v-card-subtitle
                  >
                  <v-card-actions>
                      <v-btn class="ml-2 mt-5" outlined rounded small @click="toBookCollection"> 查看 </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </v-card>
      </v-img>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
    items: [
      {
        color: "#1F7087",
        src: "https://cdn.vuetifyjs.com/images/cards/foster.jpg",
        title: "Supermodel",
        artist: "Foster the People",
      },
      {
        color: "#952175",
        src: "https://cdn.vuetifyjs.com/images/cards/halcyon.png",
        title: "Halcyon Days",
        artist: "Ellie Goulding",
      },
    ],
  }),
  setup() {},
  components: {
    Bar,
  },
  methods : {
      toBlogPersonalCollection(){
        this.$router.push({ path: "/BlogList/PersonalCollection" });
      },
      toGroupCollection(){
        this.$router.push({ path: "/Group/GroupList" });
      },
      toBookCollection(){
        this.$router.push({ path: "/Book/BookWareHouse" });
      },
      toBookReviewCollection(){
        this.$router.push({ path: "/Book/BookReview" });
      }
  },
};
</script>
