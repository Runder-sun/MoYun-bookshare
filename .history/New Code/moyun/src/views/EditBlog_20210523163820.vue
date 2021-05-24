<template>
    <div class="EditBlog">
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
                prop="date"
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
                    <v-btn text color="blue darken-1" href="/BlogList/ScanBlog" rounded @click="handleEdit(scope.$index, scope.row)"> 查看日志</v-btn>
                    <v-btn text color="pink lighten-1" rounded @click="handleDelete(scope.$index, scope.row)"> 取消收藏 </v-btn>
                </template>
                </el-table-column>
            </el-table>
            </template>
        </v-app>
    </div>
    </template>

<script>
import bar from "../components/Bar.vue"
export default({

    components:{
        bar,
    },
})
</script>

<style scope>
.EditBlog{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>