<template>
    <div class="BlogList">
    <v-app>
        <bar></bar>
        <v-container>
        <v-toolbar flat>
        <v-toolbar-title>圈子</v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn text color="cyan" href="/BlogList/WriteBlog" rounded> 发表日志 </v-btn>

        <v-btn text color="teal" href="/BlockList/PersonalCollection" rounded> 查看日志收藏 </v-btn>
        </v-toolbar>
        <template>
        <v-card>
            <v-card-title>
            <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                hide-details
            ></v-text-field>
            </v-card-title>
            <v-data-table
            :headers="headers"
            :items="blogs"
            :search="search"
            class="elevation-1"
            >
            <v-btn>第一个按钮</v-btn>
            <v-btn>第二个按钮</v-btn>
            </v-data-table>
        </v-card>
        </template>
 
        </v-container>
    </v-app>
    </div>
</template>

<script>
import bar from "../components/Bar.vue"

export default({
    data() {
    return {
      search: "",
      headers: [
        { text: "日志名称",
          align: "start",
          filterable: false,
          value: "name",
          },
        { text: "发布时间", value: "time" },
      ],
      blogs: [
        {
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
        
      ],
    };
  },
    components:{
    bar,
},
})


</script>

<style scoped>
</style>
