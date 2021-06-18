<template>
  <div class="CheckBookReview">
    <v-app>
      <bar></bar>
      <v-container>
        <v-card class="mx-auto" outlined style="margin-top:40px;">
          <v-toolbar class="lxtToolbar ">
            <v-toolbar-title>书评信息</v-toolbar-title>
            <v-spacer></v-spacer>
              <v-btn class="ma-2" text icon color="blue lighten-2" @click="like">
                 <v-icon>mdi-thumb-up</v-icon>
              </v-btn>
            <el-button type="info" round v-if="isCollect" @click="cancelCollect" class="applyBtn">取消收藏</el-button>
            <el-button color="#8fc19c" round v-else @click="collect" class="applyBtn">收藏书评</el-button>
            <el-button 	color="#45a165" v-if="$store.state.person.userID==this.bookReviewInfo.userID" @click="toEditBookReview" class="applyBtn">修改书评</el-button>
          </v-toolbar>

          <v-list-item three-line>
            <v-list-item-avatar left size="200" color="grey">
              <img
                src="https://cdn.vuetifyjs.com/images/john.jpg"
                alt="作者用户名"
              />
            </v-list-item-avatar>
            <v-list-item-content>
              <div class="headline mb-4" style="margin-left:70px">{{bookReviewInfo.title}}</div>
              <v-list-item-title style="margin-left:70px"> {{bookReviewInfo.content}}</v-list-item-title>
              <v-list-item-subtitle style="margin-left:70px">{{bookReviewInfo.score}}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-card-actions> </v-card-actions>
        </v-card>

        <v-card class="content">
          <v-toolbar class="elevation-1">
            <v-toolbar-title>书评评论区</v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
            <v-container class="pa-4 text-center">
               <v-card>>
        <v-expansion-panels v-model="panel" multiple>
          <v-expansion-panel v-for="(bookReviewComment, i) in bookReviewCommentList" :key="i">
            <v-expansion-panel-header>
              <template>
                <v-container>
              
            <p >
              <v-avatar size="30">
              <img :src="'/'+bookReviewCommentUser[i].headImage"/>
            </v-avatar>
              {{bookReviewCommentUser[i].username}}
              ——
              {{bookReviewComment.commentTime}} :
              </p>
              </v-container>
              </template>
              </v-expansion-panel-header>
            <v-expansion-panel-content>
              {{ bookReviewComment.content }}
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-card>
      <v-card>
          <v-container fluid>
        <v-textarea v-model="content" color="teal">
          <template v-slot:label>
            <div>内容</div>
          </template>
        </v-textarea>
          </v-container>
              <v-spacer></v-spacer>
              <v-btn text color="cyan" @click="addMessage">发布评论</v-btn>
      </v-card>
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
  created() {
    this.getInit();
  },
  data: () => ({
    content:"",
    panel:[0],
    bookReviewInfo:{
      
    },
    isCollect: false,
    bookReviewCommentList:[
      {content:"从前有座山.........",
       commentTime:"2020-4-12"}
    ],
    bookReviewCommentUser:[
      {username:"LONG"}
    ],
  }),
  methods: {
    toEditBookReview() {
      this.$router.push({ path: "/Book/EditBookReview/"+this.$route.params.id });
    },
    like() {
      this.$http({
        method: "post",
        url: "/likeBookReview",
        data: {
          BookReviewID:this.$route.params.id,
        },
      })
        .then((res) => {
          if (res.data.success) {
            alert("点赞成功");
          } 
        })
        .catch((err) => {
          console.log(err);
        });
    },
    cancelCollect() {
      this.$http({
        method: "post",
        url: "/cancelCollectBookReview",
        data: {
          BookReviewID:this.$route.params.id,
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
    collect() {
      this.$http({
        method: "post",
        url: "/collectBookReview",
        data: {
          BookReviewID:this.$route.params.id,
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
    },
    addMessage(){
        this.$http({
          method:'post',
          url:"/commentReview",
          data:{
            BookReviewID:this.$route.params.id,
            Content:this.content,
          }
        }).then(res=>{
          this.getInit()
        })
        this.content="";
      },
    getInit() {
      this.$http({
        method: "get",
        url: "/inspectBookReview",
        params:{ BookReviewID:this.$route.params.id,}
      })
        .then((res) => {
          if (res.data.success) {
            this.bookReviewInfo = res.data.bookReviewInfo;
            this.bookReviewCommentList = res.data.bookReviewCommentList;
            this.bookReviewCommentUser = res.data.bookReviewCommentUser;
            this.isCollect = res.data.isCollect;
          }
        })
        .catch((err) => {
          console.log(err);
        });
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

.lxtBtn{
  margin-right: 80px;

box-shadow:  18px 18px 36px rgba(0, 0, 0, 0.1),
             -18px -18px 36px #ffffff;
    		transition: box-shadow 0.2s ease-out;         
		background-color: #efeeee;
		position: relative;  
    		outline: none;
		border: none;                   
}

.applyBtn{
    margin-right:15px;
  	
		box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
			-9px -9px 18px rgba(255, 255, 255, 1);
		border-radius: 3rem;
		transition: box-shadow 0.2s ease-out;
		background-color: #efeeee;
		position: relative;
		top: 0px;
		width: 140px;
		height: 70 px;
		outline: none;
		border: none;
}


</style>