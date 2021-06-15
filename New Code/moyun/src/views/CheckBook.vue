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
          <el-button type="success" round v-if="careBoolean" @click="cancelCare">取消收藏（关注）</el-button>
          <el-button type="success" round v-else @click="care">收藏（关注）</el-button>
          <el-button type="info" round v-if="$store.state.person.userID==this.bookAdder.userID" @click="toEditBook">编辑</el-button>
          <el-button type="warning" v-if="$store.state.person.userID==this.bookAdder.userID" round @click="deleteBook">删除</el-button>
          <el-button type="danger" round @click="downloadBook">下载</el-button>
        </v-toolbar>
          <div class="line" />
          <div class="bookinfocontainer">
            <v-col>
            <div class="bookinfoleft">
              <div class="demo-image__preview">
              </div>
            </div>
            <div class="bookinforight"
            >
              <v-row>
                <el-image
                  style="width: 200px; height: 200px"
                  :src="'/home/moyun/file/'+this.book.BookImage"
                  class="imgAlign"
                >
                </el-image>
                <v-col 
                align="center"
                class="mx-0">
                <div >图书名称：{{this.book.bookName}}</div>
                  <div class="text ms-4">
                    {{this.book.author}}
                </div>
                <div class="my-4 text-subtitle-1">书籍类别：{{this.book.kind}}</div>
                <div class="my-4 text-subtitle-1 ">出版社：{{this.book.publisher}}</div>
                <v-card-subtitle>ISBN号：{{this.book.ISBN}}</v-card-subtitle>
                <div class="my-4 text-subtitle-1">简介;{{this.book.introduce}}</div>
                </v-col>
              </v-row>
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
        <el-table :data="bookReviewList" style="width: 100%" height="400" stripe :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}">
          <el-table-column fixed prop="reviewTime" label="发布日期" width="150" ></el-table-column>
          <el-table-column prop="title" label="题目" width="120"></el-table-column>
          <el-table-column prop="author" label="作者" width="120"></el-table-column>
          <el-table-column prop="content" label="书评内容" width="120"></el-table-column>
          <el-table-column prop="score" label="评分" width="300"></el-table-column>
          <el-table-column align="right">
              <el-button type="warning" round @click="toCheckBookReview('bookReviewID')">查看</el-button>
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
    book:[],
    bookAdder:{
      userID:"2"
    },
    bookReviewList:[],
    isCollect:false,
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
    this.initCheckBook();
  },
  
  methods: {
    initCheckBook() {
      this.$http({
        method: "get",
        url: "/inspectBook",
        params: this.$route.params.id,
      })
        .then((res) => {
          if (res.data.success) {
            this.book = res.data.book;
            this.bookAdder = res.data.bookAdder;
            this.bookReviewList=res.data.bookReviewList;
            this.isCollect = res.data.isCollect;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    
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
    toWriteBookReview(){
      this.$router.push({ path: "/Book/WriteBookReview" +this.book.bookID});
    },
    toEditBook(){
        this.$router.push({ path: "/Book/EditBook/" +this.book.bookID});
    },
    toCheckBookReview(bookReviewID){
        this.$router.push({ path: "/Book/CheckBookReview"+ bookReviewID});
    },
    deleteBook(){
        this.$http({
        method: "get",
        url: "/deleteBook",
        params: this.$route.params.id,
      })
        .then((res) => {
          if (res.data.success) {
            alert("删除成功");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    downloadBook(){
        alert("下载成功");
    },
    cancelCare(){
        this.$http({
        method: "post",
        url: "/cancelCollectionBook",
        data: {
          bookCollectionID:this.$route.params.id,
        },
      })
        .then((res) => {
          console.log(res.data.message);
          this.message = res.data.message;
          this.snackbar = true;
          if (res.data.success) {
            this.isCollect=false;
          } 
        })
        .catch((err) => {
          console.log(err);
        });
    },
    care(){
        this.$http({
        method: "post",
        url: "/collectBook",
        data: {
          bookID:this.$route.params.id,
        },
      })
        .then((res) => {
          if (res.data.success) {
            this.isCollect=true;
          } 
        })
        .catch((err) => {
          console.log(err);
        });
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
  display:flex;
  flex-direction: row;
  align-items: center;
  float: right;
  width: 69%;
  font-size: 25px;
}
/*lxt美化部分*/ 
.comment{
  margin-top:80px;
}
.pages{
  text-align: center; 
}
.imgAlign{
  vertical-align: middle;
}
</style>
