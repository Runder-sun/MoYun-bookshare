<template>
  <div class="CheckBookReview">
    <v-app>
      <bar></bar>
      <v-container>
        <v-card class="mx-auto" outlined style="margin-top:40px;">
          <v-toolbar class="lxtToolbar ">
            <v-toolbar-title>书评信息</v-toolbar-title>
            <v-spacer></v-spacer>
            <template>
              <v-btn class="ma-2" text icon color="blue lighten-2" v-if="isLike" @click="cancelLike" >
                 <v-icon>mdi-thumb-up</v-icon>
              </v-btn>
              <v-btn class="ma-2" text icon v-else @click="like">
                 <v-icon>mdi-thumb-up</v-icon>
              </v-btn>
            </template>
            <el-button type="info" round v-if="isCollect" @click="cancelCollect">取消收藏</el-button>
            <el-button type="success" round v-else @click="collect">收藏书评</el-button>
            <el-button type="text" @click="toEditBook">修改书评</el-button>
          </v-toolbar>

          <v-list-item three-line>
            <v-list-item-avatar left size="200" color="grey">
              <img
                src="https://cdn.vuetifyjs.com/images/john.jpg"
                alt="作者用户名"
              />
            </v-list-item-avatar>
            <v-list-item-content>
              <div class="headline mb-4">《书评标题》</div>
              <v-list-item-title> 书评内容</v-list-item-title>
              <v-list-item-subtitle>该书评给该书的打分</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-card-actions> </v-card-actions>
        </v-card>

        <v-card class="content">
          <v-toolbar class="elevation-0">
            <v-divider></v-divider>
            <v-toolbar-title>书评评论区</v-toolbar-title>
            <v-spacer></v-spacer>
            <el-button type="text" @click="commment">我要评论</el-button>
          </v-toolbar>
            <v-container class="pa-4 text-center">
              <v-row class="fill-height" align="center" justify="center">
                <el-table :data="tableData" style="width: 100%" height="250" stripe :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}">
                  <el-table-column
                    fixed
                    prop="date"
                    label="发布日期"
                    width="150"
                  ></el-table-column>
                  <el-table-column
                    prop="author"
                    label="用户"
                    width="120"
                  ></el-table-column>
                  <el-table-column
                    prop="bookReview"
                    label="评论内容"
                    width="900"
                  ></el-table-column>
                </el-table>
              </v-row>
            </v-container>
        </v-card>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  setup() {},
  data: () => ({
    isLike: false,
    isCollect: false,

    tableData: [
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
      {
        date: "2016-05-03",
        title: "《西游记读后感》",
        author: "lx",
        bookReview: "普陀区",
        scores: 8.0,
      },
    ],
  }),
  methods: {
    comment() {
      this.$prompt("请输入评论内容", "提示", {
        confirmButtonText: "评论",
        cancelButtonText: "取消",
        showInput: true,
        inputValue: "评论内容",
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "评论成功",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消评论",
          });
        });
    },
    toEditBookReview() {
      this.$router.push({ path: "/Book/EditBookReview" });
    },
    cancelLike() {
      this.isLike = false;
    },
    like() {
      this.isLike = true;
    },
    cancelCollect() {
      this.isCollect = false;
    },
    collect() {
      this.isCollect = true;
    },
  },
  components: {
    Bar,
  },
};
</script>

<style scoped>
.content{
  margin-top:30px;
}

.lxtToolbar{
    padding-right:10px;
  
}

.pages{
  text-align: center; 
}
</style>