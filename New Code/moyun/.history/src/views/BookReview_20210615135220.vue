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
              <v-tab>热门书评</v-tab>
              <v-tab>我的书评</v-tab>
              <v-tab>收藏书评</v-tab>

              <v-tab-item>
                <v-container class="pa-4 text-center">
                  <v-row class="fill-height" align="center" justify="center">
                    <v-container>
                      <el-table :data="commentsData" style="width: 100%" height="700" width="1600" :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}">
                        <el-table-column fixed prop="date" label="发布日期" width="150" ></el-table-column>
                        <el-table-column prop="title" label="题目" width="150"></el-table-column>
                        <el-table-column prop="author" label="作者" width="150"></el-table-column>
                        <el-table-column prop="bookReview" label="书评内容" width="150"></el-table-column>
                        <el-table-column prop="scores" label="评分" width="300"></el-table-column>
                        <el-table-column align="right">
                          <template slot-scope="scope">
                            <el-button
                              type="warning"
                              round
                              @click="toCheckBookReview(scope.$index, scope.row)">查看</el-button
                            >
                          </template>
                        </el-table-column>
                      </el-table>
                      <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
                    </v-container>
                  </v-row>
                </v-container>
              </v-tab-item>

              <v-tab-item>
                <v-container class="pa-4 text-center">
                  <v-row class="fill-height" align="center" justify="center">
                    <v-container>
                      <v-toolbar>
                        <v-toolbar-title>我的书评列表</v-toolbar-title>
                        <v-spacer></v-spacer>
                      </v-toolbar>
                      <el-table :data="commentsData" style="width: 100%" height="250">
                        <el-table-column fixed prop="date" label="发布日期" width="150"></el-table-column>
                        <el-table-column prop="title" label="题目" width="120"></el-table-column>
                        <el-table-column prop="author" label="作者" width="120"></el-table-column>
                        <el-table-column prop="bookReview" label="书评内容" width="120"></el-table-column>
                        <el-table-column prop="scores" label="评分" width="300"></el-table-column>
                        <el-table-column align="right">
                          <template slot-scope="scope">
                            <el-button type="warning" round @click="toCheckBookReview(scope.$index, scope.row)">查看</el-button>
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
                      <v-toolbar>
                        <v-toolbar-title>收藏书评列表</v-toolbar-title>
                        <v-spacer></v-spacer>
                      </v-toolbar>
                      <el-table :data="commentsData" style="width: 100%" height="250" >
                        <el-table-column fixed prop="date" label="发布日期" width="150"></el-table-column>
                        <el-table-column prop="title" label="题目" width="120"></el-table-column>
                        <el-table-column prop="author" label="作者" width="120"></el-table-column>
                        <el-table-column prop="bookReview" label="书评内容" width="120"></el-table-column>
                        <el-table-column prop="scores" label="评分"  width="300" ></el-table-column>
                        <el-table-column align="right">
                          <template slot-scope="scope">
                            <el-button type="warning" round @click="toCheckBookReview(scope.$index, scope.row)">查看</el-button >
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
    careBoolean:false,
    
    bookinfourl:"https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
    bookinfosrcList: [
      "https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg",
      "https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg",
    ],
    commentsData: [
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores:8.0
      },
    ],
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
  methods: {
    toCheckBookReview(){
        this.$router.push({ path: "/Book/CheckBookReview" });
    },
  },
  setup() {},
  components: {
    Bar,
  },
};
</script>
