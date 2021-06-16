<template>
    <div class="BlogList">
    <v-app>
        <bar></bar>
        <v-container>
        <v-toolbar flat style="margin-top:30px">
        <v-toolbar-title>圈子</v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn text color="cyan" href="/BlogList/WriteBlog" rounded> 发表日志 </v-btn>

        <v-btn text color="teal" href="/BlockList/PersonalCollection" rounded> 查看日志收藏 </v-btn>
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
            prop="date"
            label="日期"
            style="width: 30%">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            style="width: 35%">
            <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="primary"
                  round
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="success"
                  round
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                <v-btn text color="aliceblue" href="/BlogList/WriteBlog" rounded @click="handleEdit(scope.$index, scope.row)"> 编辑</v-btn>
                <v-btn text color="teal" href="/BlockList/PersonalCollection" rounded @click="handleDelete(scope.$index, scope.row)"> 删除 </v-btn>
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
        tableData: [{
          name: "在墨韵的第一天",
          date: "2021/5/21",
        },
        {
          name: "在墨韵的第二天",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第三天",
          date: "2021/5/23",
        },
        {
          name: "在墨韵的第三天2",
          date: "2021/4/22",
        },
        {
          name: "在墨韵的第三天3",
          date: "2021/5/12",
        },
        {
          name: "在墨韵的第四天",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第四天1",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第四天2",
          date: "2021/5/22",
        },
        {
          name: "在墨韵的第四天3",
          date: "2021/5/22",
        },        
        ]
      }
    },
    components:{
    bar,
},
})


</script>

<style scoped>
</style>
