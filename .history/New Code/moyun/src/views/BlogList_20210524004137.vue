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
            color="indigo lighten-3"
            text
            @click.stop="dialog = true"
          >
            发表日志
          </v-btn>

          <v-dialog
            v-model="dialog"
            width="1000px"
            height="1200px"
          >
            <v-card>
              <v-card-title class="headline" center>POST BLOG</v-card-title>
              <v-card-text>
                <template>
                  <div>
                    <v-text-field label="Please Input Title" :rules="rules" hide-details="auto"></v-text-field>
                    <v-text-field label="Please Input Content"></v-text-field>
                  </div>
                </template>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn
                  color="green darken-1"
                  text
                  @click="dialog = false"
                >
                  CANCEL
                </v-btn>

                <v-btn
                  color="green darken-1"
                  text
                  @click="dialog = false"
                >
                  SAVE
                </v-btn>
              </v-card-actions>
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
                <v-btn text color="cyan lighten-1" href="/BlogList/ScanBlog" rounded @click="handleEdit(scope.$index, scope.row)"> 查看 </v-btn>
                <v-btn text color="blue darken-1" href="/BlogList/EditBlog" rounded @click="handleEdit(scope.$index, scope.row)"> 编辑 </v-btn>
                <v-btn text color="pink lighten-1" rounded @click="handleDelete(scope.$index, scope.row)"> 删除 </v-btn>
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
        dialog: false,
        rules: [
          value => !!value || 'Required.',
          value => (value && value.length >= 3) || 'Min 3 characters',
        ],
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
.BlogList{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};

</style>
