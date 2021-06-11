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
                prop="name"
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
                prop="date"
                label="创作日期"
                style="width: 15%">
                </el-table-column>
                <el-table-column
                fixed="right"
                label="操作"
                style="width: 25%">
                <template slot-scope="scope">
                    <v-btn text color="blue darken-1" rounded @click="handleEdit(scope.$index, scope.row)"> 查看日志</v-btn>
                    <v-btn text color="pink lighten-1" rounded @click="handleDelete(scope.$index, scope.row)"> 取消收藏 </v-btn>
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
        tableData: [{
          name: "在墨韵收藏的第一篇日志",
          writer:"AStudent",
          date: "2021/5/21",
        },
        {
          name: "在墨韵收藏的第二篇日志",
          writer:"ATeacher",
          date: "2021/5/22",
        },
        {
          name: "在墨韵收藏的第三篇日志",
          writer:"BStudent",
          date: "2021/5/23",
        },
        {
          name: "在墨韵收藏的第5篇日志",
          writer:"AStudent",
          date: "2021/4/22",
        },
        {
          name: "在墨韵收藏的第4篇日志",
          writer:"BStudent",
          date: "2021/5/12",
        },
        {
          name: "在墨韵收藏的第三篇日志12",
          writer:"BSomeone",
          date: "2021/5/22",
        },
        {
          name: "在墨韵收藏的第123篇日志",
          writer:"Anonymous",
          date: "2021/5/22",
        },
        {
          name: "收藏了很多",
          writer:"Anoynomous",
          date: "2021/5/27",
        },
        {
          name: "有用的日志",
          writer:"Anonymous",
          date: "2021/5/22",
        },        
        ]
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
      })
        .then((res) => {
          this.tableData=res.data.blogCollectionBlog;
        })
        .catch((err) => {
          console.log(err);
        });
      },
    handleEdit(){
      this.$router.push({path:"/BlogList/ScanBlog"});
    },
    handleDelete(){
      this.snackbar=true;
        this.$http({
        method: "post",
        url: "/cancelCollectBlog",
        data:{
          BlogID: this.tableData(index).BlogID,
        }
      }).then((res) => {
          this.snackbar=true;
          this.$router.push({path:"/BlogList/PersonalCollection"})
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