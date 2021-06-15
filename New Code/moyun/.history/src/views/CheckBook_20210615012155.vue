<template>
  <div class="CheckBook">
    <v-app>
      <bar></bar>
      <v-container>
        <v-container>
          <v-card>
          <v-toolbar class="elevation-0" >
          <v-toolbar-title>基本信息</v-toolbar-title>
          <v-spacer></v-spacer>
          <el-button type="primary" round @click="toBookRecommand">推荐</el-button>
          <el-button type="success" round v-if="careBoolean" @click="cancelCare">取消关注</el-button>
          <el-button type="success" round v-else @click="care">关注</el-button>
          <el-button type="info" round @click="toEditBook">编辑</el-button>
          <el-button type="warning" round @click="deleteBook">删除</el-button>
          <el-button type="danger" round @click="onReadingBook('1234')">阅读</el-button>
          <el-button type="danger" round @click="downloadBook">下载</el-button>
        </v-toolbar>
          <div class="line" />
          <div class="bookinfocontainer">
            <v-col>
            <div class="bookinfoleft">
              <div class="demo-image__preview">
                <el-image
                  style="width: 200px; height: 200px"
                  :src="bookinfourl"
                  :preview-src-list="bookinfosrcList"
                >
                </el-image>
              </div>
            </div>
            <div class="bookinforight">
              <!-- 不应该用el-link控件，应该直接就可以显示了 -->
              <v-card-text>
                <v-col 
                align="center"
                >
                <div class="my-4 text-subtitle-1">图书名称：图书名称</div>
                  <div class="my-4 text-subtitle-1">
                    作者
                </div>
                <div class="my-4 text-subtitle-1">
                  图书分类
                </div>
                <v-card-subtitle>ISBN号：ISBN号</v-card-subtitle>
                <div class="grey--text ms-4">
                  出版社
                </div>
                <div>这里是简介</div>
                </v-col>
              </v-card-text>
            </div>
            </v-col>
          </div>
          </v-card>
        </v-container>
      </v-container>
      <v-container class="comment">
        <v-card>
        <v-toolbar class="elevation-0">
            <v-toolbar-title>书评列表</v-toolbar-title>
            <v-spacer></v-spacer>
            <el-button type="primary" round @click="toWriteBookReview">撰写书评</el-button>
        </v-toolbar>
        <v-divider></v-divider>
        <el-table :data="tableData" style="width: 100%" height="400" stripe :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}">
          <el-table-column fixed prop="date" label="发布日期" width="150" ></el-table-column>
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
        <el-pagination background center layout="prev, pager, next" :total="1000" class="pages">
        </el-pagination>
        </v-card>
      </v-container>
      <v-container>
        <div class="line" />

      </v-container>
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
    tableData: [
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
    onSubmit() {
      console.log("submit!");
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    onReadingBook(bookid) {
      this.$router.push("/Book/Reading?BookID=" + bookid);
    },
    toBookRecommand(){
      this.$router.push({ path: "/Book/BookRecommand" });
    },
    toWriteBookReview(){
      this.$router.push({ path: "/Book/WriteBookReview" });
    },
    toEditBook(){
        this.$router.push({ path: "/Book/EditBook" });
    },
    toCheckBookReview(){
        this.$router.push({ path: "/Book/CheckBookReview" });
    },
    deleteBook(){
        alert("删除成功");
    },
    downloadBook(){
        alert("下载成功");
    },
    cancelCare(){
        this.careBoolean =false;
    },
    care(){
        this.careBoolean = true;
    }
  },
  components: {
    Bar,
  },
};
</script>
<style>
/* 横线 
.line {
  float: right;
  width: 100%;
  height: 1px;
  margin-top: 10px;
  margin-bottom: 10px;
  background: #d4c4c4;
  position: relative;
  text-align: center;
}*/

.bookinfocontainer {
  background: white;
  margin-top: 35px;
  text-align: center;
  float: left;
  width: 100%;
  height: 200px;
}

.bookinfoleft {
  font-size: 16px;
  width: 30%;
  position: absolute;
  display: flex;
  display: -webkit-flex;
  align-items: center;
  justify-content: center;
  color: #008cff;
  border-right: 1px solid #ebedf0;
}

.bookinfoleft img {
  width: 100%;
}

.bookinforight {
  float: right;
  width: 69%;
  font-size: 25px;
}
/*lxt美化部分*/ 
.comment{
  margin-top:50px;
}
.pages{
  text-align: center; 
}
</style>
