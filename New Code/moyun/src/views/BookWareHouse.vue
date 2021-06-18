<template>
  <div class="BookWareHouse">
    <v-app>
      <bar></bar>
      <v-container>

          <v-card style="margin-top:30px">
            <v-toolbar flat>
              <v-toolbar-title>书库</v-toolbar-title>

              <v-spacer></v-spacer>

              <v-btn text color="cyan" href="/Book/SearchBook">
                搜索图书
              </v-btn>
              <v-btn text color="cyan" href="/Book/AddBook">
                添加新书
              </v-btn>
              <template v-slot:extension>
                <v-tabs v-model="tab">
                  <v-tab>热门书籍</v-tab>
                  <v-tab>我关注的图书</v-tab>

                  <v-tab-item style="margin-top:20px">
                      <v-row
                        class="fill-height"
                        align="center"
                        justify="center"
                      >
                        <template v-for="(book, i) in hotBook">
                          <v-col :key="i" cols="12" md="3">
                            <v-hover v-slot="{ hover }">
                              <v-card
                                :elevation="hover ? 24 : 2"
                                :class="{ 'on-hover': hover }"
                                width="300"
                                :to="'/Book/CheckBook/' + book.bookID"
                              >
                                <v-img :src="'/'+book.bookImage" height="225px">
                                  <v-card-title class="title white--text">
                                    <v-row
                                      class="fill-height flex-column"
                                      justify="space-between"
                                    >
                                      <p class="mt-4 subheading text-left">
                                        《{{ book.bookName }}》
                                        <v-chip> {{ book.kind }} </v-chip>
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
                                          评分：{{ book.score }}
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
                  </v-tab-item>

                  <v-tab-item style="margin-top:20px">
                      <v-row
                        class="fill-height"
                        align="center"
                        justify="center"
                      >
                        <template v-for="(book, i) in bookCollectionBook">
                          <v-col :key="i" cols="12" md="3">
                            <v-hover v-slot="{ hover }">
                              <v-card
                                :elevation="hover ? 24 : 2"
                                :class="{ 'on-hover': hover }"
                                width="300"
                                :to="'/Book/CheckBook/' + book.bookID"
                              >
                                <v-img :src="'/'+book.bookImage" height="225px" >
                                  <v-card-title class="title white--text">
                                    <v-row
                                      class="fill-height flex-column"
                                      justify="space-between"
                                    >
                                      <p class="mt-4 subheading text-left">
                                        {{ book.bookName }}
                                      </p>
                                    </v-row>
                                  </v-card-title>
                                </v-img>
                              </v-card>
                            </v-hover>
                          </v-col>
                        </template>
                      </v-row>
                  </v-tab-item>
                </v-tabs>
              </template>
            </v-toolbar>
          </v-card>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";

export default {
  data: () => ({
    tab:[],
    tags: [
      "文学",
      "科幻",
      "侦探",
      "纪实",
      "儿童",
      "艺术",
      "历史",
      "武侠",
      "地理",
      "医药健康",
      "IT",
      "数学",
    ],
    hotBook: [
    ],
    bookCollectionBook: [
    ],

  }),
  setup() {},
  components: {
    Bar,
  },
  created() {
    this.showBookWareHouse();
  },
  methods: {
    showBookWareHouse() {
      this.$http({
        method: "get",
        url: "/bookWareHouse",
      }).then((res) => {
          this.hotBook = res.data.HotBook;
          this.bookCollectionBook = res.data.BookCollectionBook;
        }).catch((err) => {
          console.log(err);
      });
    },
  },
};
</script>

<style scoped></style>