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
    created(){
      this.show();
    },
    methods:{
    show() {
      this.$http({
        method: "get",
        url: "/PersonalCollection",
      }).then((res) => {
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
      //this.snackbar=true;
        this.$http({
        method: "post",
        url: "/cancelCollectBlog",
        data:{
          blogID: id,
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
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
      width:400%;
    height:400%;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}};
</style>