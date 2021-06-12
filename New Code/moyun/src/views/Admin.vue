<template>
  <div class="Admin">
    <bar></bar>
    <v-main>
      <v-row justify="center">
        <v-expansion-panels popout>
          <v-expansion-panel>
            <v-expansion-panel-header> 成员管理 </v-expansion-panel-header>
            <v-expansion-panel-content>
              <el-table :data="users" border style="width: 100%">
                <el-table-column fixed prop="UserID" label="学号" sortable>
                </el-table-column>
                <el-table-column prop="Username" label="姓名" sortable>
                </el-table-column>
                <el-table-column prop="isTeacher" label="身份" sortable>
                </el-table-column>
                <el-table-column prop="Email" label="邮箱" sortable>
                </el-table-column>
                <el-table-column prop="Birthday" label="生日" sortable>
                </el-table-column>
                <el-table-column prop="Signature" label="个性签名" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Person/PersonalInfo' + scope.row.UserID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button type="text" @click="shield(scope.row.UserID)"
                      >封禁</el-button
                    >
                    <el-button type="text" @click="deShield(scope.row.UserID)"
                      >解封</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel>
            <v-expansion-panel-header> 日志管理 </v-expansion-panel-header>
            <v-expansion-panel-content>
              <el-table :data="blogs" border style="width: 100%">
                <el-table-column fixed prop="BlogID" label="编号" sortable>
                </el-table-column>
                <el-table-column prop="BlogTitle" label="题目" sortable>
                </el-table-column>
                <el-table-column prop="AuthorID" label="作者ID" sortable>
                </el-table-column>
                <el-table-column prop="RecentFinishTime" label="完成时间" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      @click="seeBlog(scope.row.BlogID)"
                      :to="'/BlogList/ScanBlog/' + scope.row.BlogID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button type="text" @click="delBlog(scope.row.BlogID)"
                      >删除</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel>
            <v-expansion-panel-header> 圈子管理 </v-expansion-panel-header>
            <v-expansion-panel-content>
              <el-table :data="groups" border style="width: 100%">
                <el-table-column fixed sortable prop="GroupID" label="圈子编号">
                </el-table-column>
                <el-table-column prop="GroupName" sortable label="名称">
                </el-table-column>
                <el-table-column prop="Tag" label="标签" sortable>
                </el-table-column>
                <el-table-column prop="CreateID" label="创建者ID" sortable>
                </el-table-column>
                <el-table-column prop="CreateTime" label="创建时间" sortable>
                </el-table-column>
                <el-table-column prop="MemberNum" label="人数" sortable>
                </el-table-column>
                <el-table-column prop="Introduce" label="简介" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Group/GroupIndex/' + scope.row.GroupID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button type="text" @click="delGroup(scope.row.GroupID)"
                      >删除</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel>
            <v-expansion-panel-header> 讨论管理 </v-expansion-panel-header>
            <v-expansion-panel-content>
              <el-table :data="forums" border style="width: 100%">
                <el-table-column fixed prop="ForumID" label="讨论编号" sortable>
                </el-table-column>
                <el-table-column prop="Topic" label="主题" sortable> </el-table-column>
                <el-table-column prop="GroupID" label="所在圈子" sortable>
                </el-table-column>
                <el-table-column prop="CreateID" label="创建者ID" sortable>
                </el-table-column>
                <el-table-column prop="CreateTime" label="创建时间" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Group/Forum/Forum/'+scope.row.ForumID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button
                      type="text"
                      @click="delForum(scope.row.ForumID)"
                      >删除</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel>
            <v-expansion-panel-header> 图书管理 </v-expansion-panel-header>
            <v-expansion-panel-content>
              <el-table :data="books" border style="width: 100%">
                <el-table-column fixed prop="BookID" label="图书编号" sortable>
                </el-table-column>
                <el-table-column prop="BookName" label="书名" sortable>
                </el-table-column>
                <el-table-column prop="Author" label="作者" sortable> </el-table-column>
                <el-table-column prop="Publisher" label="出版商" sortable>
                </el-table-column>
                <el-table-column prop="Kind" label="类型" sortable> </el-table-column>
                <el-table-column prop="Score" label="评分" sortable> </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Book/CheckBook' + scope.row.BookID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button
                      type="text"
                      @click="delBook(scope.row.BookID)"
                      >编辑</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel>
            <v-expansion-panel-header> 书评管理 </v-expansion-panel-header>
            <v-expansion-panel-content>
              <el-table :data="bookReviews" border style="width: 100%">
                <el-table-column fixed prop="BookReviewID" label="书评编号" sortable>
                </el-table-column>
                <el-table-column prop="Title" label="题目" sortable> </el-table-column>
                <el-table-column prop="BookID" label="所属图书" sortable>
                </el-table-column>
                <el-table-column prop="UserID" label="评论者" sortable>
                </el-table-column>
                <el-table-column prop="ReviewTime" label="评论时间" sortable>
                </el-table-column>
                <el-table-column prop="Content" label="内容" sortable> </el-table-column>
                <el-table-column prop="Score" label="得分" sortable> </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Book/CheckBookReview/' + scope.row.BookReviewID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button
                      type="text"
                      @click="delBookReview(scope.row.BookReviewID)"
                      >删除</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-row>
      <v-snackbar
        v-model="snackbar"
        :timeout="3000"
        color="blue-grey"
        absolute
        rounded="pill"
      >
        {{ message }}
      </v-snackbar>
    </v-main>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    snackbar: false,
    message: "",
    users: [
      {
        UserID: "19231074",
        Username: "王小虎",
        isTeacher: "1",
        Email: "111@qq.com",
        Birthday: "2000.1.1",
        Signature: "色情暴力信息",
      },
    ],
    blogs: [],
    groups: [],
    forums: [],
    books: [],
    bookReviews: [],
  }),
  components: {
    bar,
  },
  created() {
    this.getInitList();
  },
  methods: {
    getInitList() {
      this.$http({
        method: "get",
        url: "/admin",
      }).then((res) => {
        this.users = res.data.users;
        this.blogs = res.data.blogs;
        this.groups = res.data.groups;
        this.forums = res.data.forums;
        this.books = res.data.books;
        this.bookReviews = res.data.bookReviews;
      }).catch(e=>{
        console.log(e)
      });
    },
    shield(userID) {
      this.$http({
        method: "post",
        url: "/forbidUser",
        data: {
          UserID: userID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "封禁成功！";
          this.snackbar = true;
          
        } else {
          this.message = "封禁失败！";
          this.snackbar = true;
          
        }
      }).catch(e=>{
        console.log(e)
      });
    },
    deShield(userID) {
      this.$http({
        method: "post",
        url: "/unblockUser",
        data: {
          UserID: userID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "解封成功！";
          this.snackbar = true;
          
        } else {
          this.message = "解封失败！";
          this.snackbar = true;
        }
      }).catch(e=>{
        console.log(e)
      });
    },
    delBlog(blogID) {
      this.$http({
        method: "post",
        url: "/deleteBlog",
        data: {
          BlogID: blogID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "删除成功！";
          this.snackbar = true;
          
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
        }
      }).catch(e=>{
        console.log(e)
      });
    },
    delGroup(groupID) {
      this.$http({
        method: "post",
        url: "/deleteGroup",
        data: {
          GroupID: groupID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "删除成功！";
          this.snackbar = true;
          
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
        }
      }).catch(e=>{
        console.log(e)
      });
    },
    delForum(forumID) {
      this.$http({
        method: "post",
        url: "/deleteForum",
        data: {
          ForumID: forumID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "删除成功！";
          this.snackbar = true;
          
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
        }
      }).catch(e=>{
        console.log(e)
      });
    },
    delBook(bookID) {
      this.$http({
        method: "post",
        url: "/deleteBook",
        data: {
          BookID: bookID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "删除成功！";
          this.snackbar = true;
          
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
        }
      }).catch(e=>{
        console.log(e)
      });
    },
    delBookReview(bookReviewID) {
      this.$http({
        method: "post",
        url: "/deleteBookReview",
        data: {
          BookReviewID: bookReviewID,
        },
      }).then((res) => {
        if (res.data.success) {
          this.message = "删除成功！";
          this.snackbar = true;
          
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
        }
      }).catch(e=>{
        console.log(e)
      });
    },
  },
};
</script>
