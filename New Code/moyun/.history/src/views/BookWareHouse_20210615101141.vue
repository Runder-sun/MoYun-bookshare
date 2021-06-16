<template>
  <div class="BookWareHouse">
    <v-app>
      <bar></bar>
      <v-container>
        <v-card style="margin-top:30px">
          <v-card-title>
            <v-text-field
              v-model="search"
              label="搜索图书(按回车)"
              single-line
              hide-details
              @keyup.enter="toSearch"

            ></v-text-field>
            <v-btn icon>
              <v-icon @click="toSearch">mdi-magnify</v-icon>
            </v-btn>
          </v-card-title>

          <v-row justify="center">
            <v-chip-group active-class="primary--text">
              <v-chip color="#B3E5FC" v-for="tag in tags" :key="tag">
                {{ tag }}
              </v-chip>
            </v-chip-group>
          </v-row>
        </v-card>
        
          <v-card style="margin-top:30px">
            <v-toolbar flat>
              <v-toolbar-title>书库</v-toolbar-title>

              <v-spacer></v-spacer>

              <v-btn text color="cyan" href="/Book/AddBook">
                添加新书
              </v-btn>
              <template v-slot:extension>
                <v-tabs v-model="tab">
                  <v-tab>热门书籍</v-tab>
                  <v-tab>我的关注</v-tab>

                  <v-tab-item>
                      <v-row
                        class="fill-height"
                        align="center"
                        justify="center"
                      >
                        <template v-for="(group, i) in bookGroups">
                          <v-col :key="i" cols="12" md="3">
                            <v-hover v-slot="{ hover }">
                              <v-card
                                :elevation="hover ? 24 : 2"
                                :class="{ 'on-hover': hover }"
                                width="300"
                              >
                                <v-img :src="group.img" height="225px" @click="toCheckBook">
                                  <v-card-title class="title white--text">
                                    <v-row
                                      class="fill-height flex-column"
                                      justify="space-between"
                                    >
                                      <p class="mt-4 subheading text-left">
                                        《{{ group.title }}》
                                        <v-chip> {{ group.tag }} </v-chip>
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
                                          {{ group.author }}
                                        </p>

                                        <p
                                          class="
                                            caption
                                            font-weight-medium font-italic
                                            text-left
                                          "
                                        >
                                          评分：{{ group.scores }}
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

                  <v-tab-item>
                      <v-row
                        class="fill-height"
                        align="center"
                        justify="center"
                      >
                        <template v-for="(group, i) in bookGroups">
                          <v-col :key="i" cols="12" md="3">
                            <v-hover v-slot="{ hover }">
                              <v-card
                                :elevation="hover ? 24 : 2"
                                :class="{ 'on-hover': hover }"
                                width="300"
                              >
                                <v-img :src="group.img" height="225px" @click="toCheckBook">
                                  <v-card-title class="title white--text">
                                    <v-row
                                      class="fill-height flex-column"
                                      justify="space-between"
                                    >
                                      <p class="mt-4 subheading text-left">
                                        {{ group.title }}
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
    bookGroups: [
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "西游记",
        author: "吴承恩",
        scores: 8.2,
        tag: "传说小说",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
    ],
  }),
  setup() {},
  components: {
    Bar,
  },
  methods: {
    toSearch() {
      this.$router.push({ path: "/Book/SearchBook" });
    },
    toCheckBook(){
       this.$router.push({ path: "/Book/CheckBook" });
    }
  },
};
</script>

<style scoped></style>
