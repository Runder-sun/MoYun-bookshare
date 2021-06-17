<template>
  <div class="CheckBook">
    <v-app>
      <bar></bar>
      <v-container>  
          <v-card class="mx-auto" style="margin-top:30px" width="1000px" height="500">
          <v-toolbar class="elevation-1 btns" >
          <v-toolbar-title>基本信息</v-toolbar-title>
          <v-spacer></v-spacer>
          <el-button type="success" round v-if="isCollect" @click="cancelCare">取消收藏</el-button>
          <el-button type="success" round v-else @click="care">收藏</el-button>
          <el-button type="info" round v-if="$store.state.person.userID == this.bookAdder.userID" @click="toEditBook">编辑</el-button>
          <el-button type="warning" v-if="$store.state.person.userID == this.bookAdder.userID" round @click="deleteBook(book.bookID)">删除</el-button>
          <el-button type="danger" round @click="downloadBook(book.link)">阅读</el-button>
          
        </v-toolbar>
            <v-img
              class="white--text align-end"
              height="250px"
              :src="'/'+this.book.bookImage"
            >
              <v-card-title>
                <v-col>
                <h2>{{this.book.bookName}}</h2>
                                <br>
                <h4> {{this.book.author}}</h4>
                <br>
                <h4> {{this.book.kind}}</h4>
                </v-col>
                </v-card-title>
            </v-img>

            <v-card-subtitle class="pb-0 text-right" >
              <p>{{this.book.publisher}}</p>
              <p>ISBN号：{{this.book.isbn}}</p>
            </v-card-subtitle>

            <v-card-text class="text--primary short">
              简介:{{this.book.introduce}}
        </v-card-text>

          </v-card>
        </v-container>
      <v-container class="comment">
        <v-card width="1000px" class="mx-auto" >
        <v-toolbar class="elevation-0">
            <v-toolbar-title>书评列表</v-toolbar-title>
            <v-spacer></v-spacer>
            <el-button type="primary" round @click="toWriteBookReview" class="write">撰写书评</el-button>
        </v-toolbar>
        <v-divider></v-divider>
        <el-table :data="bookReviewList" style="width: 100%" height="400" stripe :header-cell-style="{'text-align':'center'}"
    :cell-style="{'text-align':'center'}">
          <el-table-column fixed prop="reviewTime" label="发布日期" width="150" ></el-table-column>
          <el-table-column prop="title" label="题目" width="170"></el-table-column>
          <el-table-column prop="userID" label="作者" width="120"></el-table-column>
          <el-table-column prop="content" label="书评内容" width="320"></el-table-column>
          <el-table-column prop="score" label="评分" width="50"></el-table-column>
          <el-table-column align="right">
               <template slot-scope="scope">
              <el-button type="warning" round class="check" @click="toCheckBookReview(scope.row.bookReviewID)">查看</el-button>
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
    book:{

    },
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
        method: "post",
        url: "/inspectBook",
        data: { BookID :this.$route.params.id,}
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
      this.$router.push({ path: "/Book/WriteBookReview/" +this.book.bookID});
    },
    toEditBook(){
        this.$router.push({ path: "/Book/EditBook/" +this.book.bookID});
    },
    toCheckBookReview(bookReviewID){
        this.$router.push({ path: "/Book/CheckBookReview/"+ bookReviewID});
    },
    deleteBook(bookID){
        this.$http({
        method: "post",
        url: "/deleteBook",
        data: {BookID: bookID}
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
    downloadBook(link){
      let url="http://39.105.38.175/download/"+link
       window.open(url);
    },
    cancelCare(){
        this.$http({
        method: "post",
        url: "/cancelCollectBook",
        data: {
          BookID:this.$route.params.id,
        },
      })
        .then((res) => {
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
          BookID:this.$route.params.id,
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
  margin-top:20px;
}
.pages{
  text-align: center; 
}
.imgAlign{
  vertical-align: middle;
}

.detail{
  padding:10px;
  height:300px;
}

.short{
  margin-top: 20px auto;
}

.btns .el-button{
  width: 74px;
  height: 37px;
  margin-right:16px auto;
}

.write{
  margin-right: 10px;
}

.check{
    width: 76px;
  height: 38px;
}
</style>
