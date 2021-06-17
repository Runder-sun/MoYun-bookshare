<template>
  <div class="BookReview">
    <v-app>
      <v-img src="../assets/widthPic.jpg" width="100%" height="100%">
      <bar></bar>
      <v-container style="margin-top:90px" >
        <v-toolbar flat>
          <v-toolbar-title>书评列表</v-toolbar-title>

          <v-spacer></v-spacer>

          <template v-slot:extension>
            <v-tabs v-model="tab">
              <v-tab>我的书评</v-tab>
              <v-tab>收藏书评</v-tab>

              <v-tab-item>
                <v-container class="pa-4 text-center">
                  <v-row class="fill-height" align="center" justify="center">
                    <v-container>
                      <el-table :data="myBookReview" style="width: 100%" height="600" width="1600" :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}">
                        <el-table-column fixed prop="reviewTime" label="发布日期" width="150"></el-table-column>
                        <el-table-column prop="title" label="题目" width="170"></el-table-column>
                        <el-table-column prop="author" label="作者" width="120"></el-table-column>
                        <el-table-column prop="content" label="书评内容" width="320"></el-table-column>
                        <el-table-column prop="score" label="评分" width="50"></el-table-column>
                        <el-table-column align="right">
                          <template slot-scope="scope">
                          <el-button type="warning" round class="check" @click="toCheckBookReview(scope.row.bookReviewID)">查看</el-button>
                        </template>
                        </el-table-column>
                      </el-table>
                      <el-pagination background layout="prev, pager, next" :total="1000" >
                      </el-pagination>
                    </v-container>
                  </v-row>
                </v-container>
              </v-tab-item>

              <v-tab-item>
                <v-container class="pa-4 text-center">
                  <v-row class="fill-height" align="center" justify="center">
                    <v-container>
                      <el-table :data="bookReviewCollection" style="width: 100%" height="600" width="1600" :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}" >
                        <el-table-column fixed prop="reviewTime" label="发布日期" width="150"></el-table-column>
                        <el-table-column prop="title" label="题目" width="170"></el-table-column>
                        <el-table-column prop="userID" label="作者" width="120"></el-table-column>
                        <el-table-column prop="content" label="书评内容" width="320"></el-table-column>
                        <el-table-column prop="score" label="评分"  width="50" ></el-table-column>
                        <el-table-column align="right">
                          <template slot-scope="scope">
              <el-button type="warning" round class="check" @click="toCheckBookReview(scope.row.bookReviewID)">查看</el-button>
          </template>
          </el-table-column>
                      </el-table>
                      <el-pagination  background  layout="prev, pager, next"  :total="1000" >
                      </el-pagination>
                    </v-container>
                  </v-row>
                </v-container>
              </v-tab-item>

            </v-tabs>
          </template>
        </v-toolbar>
      </v-container>
      </v-img>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
    tab:[],
    bookReviewCollection:[],
    myBookReview:[],
    form: {
      name: "",
      region: "",
      date1: "",
      date2: "",
      delivery: false,
      type: [],
      resource: "",
      desc: "",
    },
  }),
  created() {
    this.showBookReview();
  },
  methods: {
    showBookReview(){
      this.$http({
        method: "get",
        url: "/BookReview",
      }).then((res) => {
          console.log(res.data);
          this.bookReviewCollection = res.data.bookReviewCollection;
          this.myBookReview = res.data.MyBookReview;
        }).catch((err) => {
          console.log(err);
      });
    },
    toCheckBookReview(bookReviewID){
        this.$router.push({ path: "/Book/CheckBookReview/"+ bookReviewID});
    },
  },
  setup() {},
  components: {
    Bar,
  },
};
</script>
