<template>
  <div class="SearchBook">
    <bar></bar>
    <v-container>
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
        <v-row justify="center">
          <v-chip-group active-class="primary--text">
            <v-chip color="#B3E5FC" v-for="tag in tags" :key="tag">
              {{ tag }}
            </v-chip>
          </v-chip-group>
        </v-row>
        <v-row class="searchText" justify="center">搜索结果</v-row>
        <v-data-table
          :headers="headers"
          :items="groups"
          :search="search"
        ></v-data-table>
      </v-card>
    </v-container>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";

export default {
  data() {
    return {
      search: "",
      headers: [
        {
          text: "书名",
          align: "start",
          filterable: false,
          value: "name",
        },
        { text: "类别", value: "tag" },
        { text: "作者", value: "author" },
        { text: "评分", value: "score" },
      ],
      tags: [
        "文学",
        "科幻",
        "侦探",
        "纪实",
        "儿童",
        "艺术",
        "历史",
        "武侠小说",
        "地理",
        "医药健康",
        "IT",
        "数学",
      ],
      groups: [
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.2,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.4,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 9.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "aaaa",
          score: 8.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.1,
        },
        {
          name: "西游记",
          tag: "文学",
          author: "吴承恩",
          score: 8.1,
        },
      ],
    };
  },
  components: {
    bar,
  },
};
</script>
