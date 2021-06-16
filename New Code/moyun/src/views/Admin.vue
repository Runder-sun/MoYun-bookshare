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
                <el-table-column fixed prop="userID" label="学号" sortable>
                </el-table-column>
                <el-table-column prop="username" label="姓名" sortable>
                </el-table-column>
                <el-table-column prop="isTeacher" label="身份" sortable>
                </el-table-column>
                <el-table-column prop="email" label="邮箱" sortable>
                </el-table-column>
                <el-table-column prop="birthday" label="生日" sortable>
                </el-table-column>
                <el-table-column prop="signature" label="个性签名" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Person/PersonalInfo' + scope.row.userID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button type="text" @click="shield(scope.row.userID)"
                      >封禁</el-button
                    >
                    <el-button type="text" @click="deShield(scope.row.userID)"
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
                <el-table-column fixed prop="blogID" label="编号" sortable>
                </el-table-column>
                <el-table-column prop="blogTitle" label="题目" sortable>
                </el-table-column>
                <el-table-column prop="authorID" label="作者ID" sortable>
                </el-table-column>
                <el-table-column prop="recentFinishTime" label="完成时间" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      @click="seeBlog(scope.row.BlogID)"
                      :to="'/BlogList/ScanBlog/' + scope.row.blogID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button type="text" @click="delBlog(scope.row.blogID)"
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
                <el-table-column fixed sortable prop="groupID" label="圈子编号">
                </el-table-column>
                <el-table-column prop="groupName" sortable label="名称">
                </el-table-column>
                <el-table-column prop="tag" label="标签" sortable>
                </el-table-column>
                <el-table-column prop="createID" label="创建者ID" sortable>
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" sortable>
                </el-table-column>
                <el-table-column prop="memberNum" label="人数" sortable>
                </el-table-column>
                <el-table-column prop="introduce" label="简介" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Group/GroupIndex/' + scope.row.groupID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button type="text" @click="delGroup(scope.row.groupID)"
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
                <el-table-column fixed prop="forumID" label="讨论编号" sortable>
                </el-table-column>
                <el-table-column prop="topic" label="主题" sortable> </el-table-column>
                <el-table-column prop="groupID" label="所在圈子" sortable>
                </el-table-column>
                <el-table-column prop="createID" label="创建者ID" sortable>
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" sortable>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Group/Forum/Forum/'+scope.row.forumID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button
                      type="text"
                      @click="delForum(scope.row.forumID)"
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
                <el-table-column fixed prop="bookID" label="图书编号" sortable>
                </el-table-column>
                <el-table-column prop="bookName" label="书名" sortable>
                </el-table-column>
                <el-table-column prop="author" label="作者" sortable> </el-table-column>
                <el-table-column prop="publisher" label="出版商" sortable>
                </el-table-column>
                <el-table-column prop="kind" label="类型" sortable> </el-table-column>
                <el-table-column prop="score" label="评分" sortable> </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Book/CheckBook' + scope.row.bookID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button
                      type="text"
                      @click="delBook(scope.row.bookID)"
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
                <el-table-column fixed prop="bookReviewID" label="书评编号" sortable>
                </el-table-column>
                <el-table-column prop="title" label="题目" sortable> </el-table-column>
                <el-table-column prop="bookID" label="所属图书" sortable>
                </el-table-column>
                <el-table-column prop="userID" label="评论者" sortable>
                </el-table-column>
                <el-table-column prop="reviewTime" label="评论时间" sortable>
                </el-table-column>
                <el-table-column prop="content" label="内容" sortable> </el-table-column>
                <el-table-column prop="score" label="得分" sortable> </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      :to="'/Book/CheckBookReview/' + scope.row.bookReviewID"
                      type="text"
                      >查看</el-button
                    >
                    <el-button
                      type="text"
                      @click="delBookReview(scope.row.bookReviewID)"
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
        top
      >
        {{ message }}
      </v-snackbar>
    </v-main>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
  inject: ["reload"],
  data: () => ({
    snackbar: false,
    message: "",
    timer: null,
    users: [],
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "封禁失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "解封失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
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
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        } else {
          this.message = "删除失败！";
          this.snackbar = true;
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.reload();
            }, 1000);
        }
      }).catch(e=>{
        console.log(e)
      });
    },
  },
};
</script>
