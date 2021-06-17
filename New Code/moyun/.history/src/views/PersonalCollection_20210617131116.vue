<template>
    <div class="collection">
    <v-app>
        <bar></bar>
        <v-container>
        <v-toolbar flat style="margin-top:30px">
        <v-toolbar-title align="center" justify="center">收藏日志列表</v-toolbar-title>
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
                prop="writer"
                label="日志作者"
                style="width: 25%">
                </el-table-column>
                <el-table-column 
                sortable           
                prop="recentFinishTime"
                label="创作日期"
                style="width: 15%">
                </el-table-column>
                <el-table-column
                fixed="right"
                label="操作"
                style="width: 25%">
                <template slot-scope="scope">
                    <v-btn text color="blue darken-1" rounded :to="'/BlogList/ScanBlog/' + scope.row.blogID"> 查看日志</v-btn>
                    <v-btn text color="pink lighten-1" rounded @click="handleDelete(scope.$index, scope.row.blogID)"> 取消收藏 </v-btn>
                </template>
                </el-table-column>
            </el-table>
            <v-snackbar
              v-model="snackbar"
              :timeout="timeout"
            >
              {{ snacktext }}

              <template v-slot:action="{ attrs }">
                <v-btn
                  color="green"
                  text
                  v-bind="attrs"
                  @click="snackbar = false"
                >
                  Close
                </v-btn>
              </template>
            </v-snackbar>
        </template>
        </v-container>
        </v-app>
    </div>
</template>

<script>
import bar from "../components/Bar.vue"

export default({
  inject: ["reload"],
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
    data() {
      return {
      snackbar: false,
      snacktext: '取消收藏成功',
      timeout: 1000,
      tableData: [],
      blogAuthor:[],
      }
    },
    components:{
    bar,
    },
    created:function(){
      this.show();
    },
    methods:{
    show() {
      this.$http({
        method: "get",
        url: "/PersonalCollection",
      }).then((res) => {
        console.log(res.data);
          this.tableData=res.data.blogCollectionBlog;
          this.blogAuthor=res.data.blogAuthor
          for(var a in this.tableData){
            for (var b in this.blogAuthor){
              if(a.authorID===b.userID){
                a.append(writer,b.username);
              }
            }
          }
        })
        .catch((err) => {
          console.log(err);
        });
      },
    handleDelete(index,id){
      console.log(id);
      //this.snackbar=true;
        this.$http({
        method: "post",
        url: "/CancelCollectBlog",
        data:{
          BlogID: id,
        }
      }).then((res) => {
          this.snackbar=true;
          this.reload();
        })
        .catch((err) => {
          console.log(err);
        });
      },
    }
})
</script>

<style scope>
.collection{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>