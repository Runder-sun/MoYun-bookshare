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
            style="width: 100%">
            <el-table-column
            fixed
            prop="name"
            label="日志名称"
            style="width: 35%">
            </el-table-column>
            <el-table-column            
            prop="time"
            label="日期"
            style="width: 30%">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            style="width: 35%">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
                <el-button type="text" size="small">删除</el-button>
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
      handleClick(row) {
        console.log(row);
      }
    },
    data() {
      return {
        tableData: [{
          name: "在墨韵的第一天",
          time: "2021/5/21",
        },
        {
          name: "在墨韵的第二天",
          time: "2021/5/22",
        },
        {
          name: "在墨韵的第三天",
          time: "2021/5/23",
        },
        {
          name: "在墨韵的第三天2",
          time: "2021/4/22",
        },
        {
          name: "在墨韵的第三天3",
          time: "2021/5/12",
        },
        {
          name: "在墨韵的第四天",
          time: "2021/5/22",
        },
        {
          name: "在墨韵的第四天1",
          time: "2021/5/22",
        },
        {
          name: "在墨韵的第四天2",
          time: "2021/5/22",
        },
        {
          name: "在墨韵的第四天3",
          time: "2021/5/22",
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
