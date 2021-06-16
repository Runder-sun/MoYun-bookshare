<template>
  <div class="SearchBook">
    <bar></bar>
    <v-container>
      <v-card>
        <v-card-title>
          <v-tooltip top>
            <template v-slot:activator="{ on, attrs }">
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
            @keyup.enter="searchBook"
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
          </template>
          <span>请选择一个标签再进行搜索哦</span>
          </v-tooltip>
        </v-card-title>
        <v-row justify="center">
          <v-chip-group active-class="primary--text">
            <v-chip
              v-for="(tag,i) in tags"
              :key="i"
              @click="choosedTag = tag.Tag"
            >
              {{ tag.Tag }}
            </v-chip>
          </v-chip-group>
        </v-row>
        <v-row class="searchText" justify="center">搜索结果</v-row>
        <v-data-table
          :headers="headers"
          :items="book"
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
      choosedTag:"",
      tags: [
        {
          Tag: "文学",
        },
        {
          Tag: "科幻",
        },
        {
          Tag: "侦探",
        },
        {
          Tag: "纪实",
        },
        {
          Tag: "儿童",
        },
        {
          Tag: "艺术",
        },
        {
          Tag: "历史",
        },
        {
          Tag: "武侠小说",
        },
        {
          Tag: "地理",
        },
        {
          Tag: "IT",
        },
      ],
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
      book: [],
    };
  },
  components: {
    bar,
  },
  methods: {
    searchBook() {
      this.$http({
        method: "post",
        url: "/searchBook",
        data: {
          KeyWord: this.search,
          Tag: this.choosedTag,
        },
      })
        .then((res) => {
          if (res.data.success) {
            this.book = res.data.book;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>
