<template>
    <div class="BlogList">
    <v-app>
        <bar></bar>
        <v-container>
        <v-toolbar flat style="margin-top:30px">
        <v-toolbar-title>个人日志列表</v-toolbar-title>

        <v-spacer></v-spacer>
        
        <template>
          <v-btn
            color="blue darken-3"
            text
            @click.stop="dialog = true"
          >
            发表日志
          </v-btn>

          <v-dialog
            v-model="dialog"
            width="1200px"
            height="3000px"
          >
              <v-card>
                <v-container>
                <v-card-title class="headline" center> Post Blog</v-card-title>
                  <v-snackbar
                  v-model="snackbar"
                  absolute
                  top
                  center
                  color="success"
                  >
                  <span>Blog Post successful!</span>
                  <v-icon dark>mdi-checkbox-marked-circle</v-icon>
                  </v-snackbar>
                    <v-form ref="form" @submit.prevent="submit">
                      <v-container fluid>
                        <v-row>
                          <v-col cols="12" sm="6">
                            <v-text-field
                              v-model="form.postTitle"
                              :rules="rules.name1"
                              color="purple darken-2"
                              label="Blog Title"
                              required
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12">
                            <v-textarea
                              v-model="form.postContent"
                              color="teal"
                            >
                              <template v-slot:label>
                                <div>
                                  Content
                                </div>
                              </template>
                            </v-textarea>
                          </v-col>
                        </v-row>
                      </v-container>
                      <v-card-actions>
                    <v-btn text @click="resetForm">Clear</v-btn>
                    <v-spacer></v-spacer>
                    <v-btn
                      :disabled="!formIsValid"
                      text
                      color="primary"
                      type="submit"
                      @click="officialPostBlog"
                    >Post</v-btn>
                  </v-card-actions>
                </v-form> 
                </v-container>
              </v-card>
          </v-dialog>
         
        </template>


        <v-btn text color="teal" href="/BlogList/PersonalCollection" rounded> 查看日志收藏 </v-btn>
        </v-toolbar>
        <template>
        <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            :default-sort = "{prop: 'name', order: 'descending'}">
            <el-table-column
            fixed
            sortable
            prop="blogTitle"
            label="日志名称"
            style="width: 35%">
            </el-table-column>
            <el-table-column 
            sortable           
            prop="recentFinishTime"
            label="日期"
            style="width: 30%">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            style="width: 35%">
            <template slot-scope="scope">
                <v-btn text color="cyan lighten-1" rounded :to="'/BlogList/ScanBlog' + scope.$index.blogID"> 查看 </v-btn>
                <v-btn text color="blue darken-1" rounded :to="'/BlogList/EditBlog' + scop.$index.blogID"> 编辑 </v-btn>
                <v-btn text color="pink lighten-1" rounded @click="handleDelete(scope.$index.blogID, scope.row)"> 删除 </v-btn>
            </template>
            </el-table-column>
        </el-table>
        </template> 
        </v-container>
    </v-app>
    </div>
</template>

<script>
import bar from "../components/Bar.vue"

export default({
    data() {

      const defaultForm = Object.freeze({
        postContent: '',
        postTitle: '',
      })

      return {
        form: Object.assign({}, defaultForm),
        rules: {
          name1: [val => (val || '').length > 0 || '文件内容不可为空'],
        },
        conditions: false,
        snackbar: false,
        terms: false,
        defaultForm,
        dialog: false,
        tableData: [{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },
{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },{
          blogID:1,
          blogTitle: "在墨韵的第一天",
          recentFinishTime: "2021/5/21",
        },       
        ]
      }
    },

    components:{
    bar,

    },

    computed: {
      formIsValid () {
        return (
          this.form.postContent &&
          this.form.postTitle
        )
      },
    },



      methods: {

      handleDelete(idNum, row) {
        this.$http({
          method:"post",
          url:"/deleteBlog",
          data:{
            BlogID:idNum,
          }
        }).then((res)=>{
          if(res.data.success===1){
            this.$router.push({path:"/BlogList",query:{id:" idNum "}});
          }
          else{
            alert("删除失败！");
          }
        }).catch(err=>{
          console.log(err)
        });
      },
      resetForm () {
        this.form = Object.assign({}, this.defaultForm)
        this.$refs.form.reset()
      },
      submit () {
        this.snackbar = true
        this.resetForm()
      },
      show(){
        this.$http({
          method:"get",
          url:"/BlogList",
        })
          .then((res)=>{
            this.tableData = res.data.blogList;
          })
          .catch((err)=>{
            console.log(err);
          })
      },
      officialPostBlog(){
        this.$http({
          method:"post",
          url:"/WriteBlog",
          data: {
            BlogTitle: this.form.postTitle,
            Content: this.form.postContent,
          },
        }).then((res)=>{
            if(res.data.success===1){
              this.submit();
              this.$router.push({path:"/BlogList"});
            }
            else{
              alert("发表失败！");
            }
            this.dialog=false;
        }).catch(err=>{
          console.log(err);
        });
      },
    },


})
</script>

<style scoped>
.BlogList{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};

</style>
