<template>
  <div class="allGroup">
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
                    <v-chip-group  active-class="primary--text">
                      <v-chip v-for="tag in 10" :key="tag"> tag </v-chip>
                    </v-chip-group>
                    </v-row>
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
          text: "圈子",
          align: "start",
          filterable: false,
          value: "name",
        },
        { text: "标签", value: "tag" },
        { text: "导师", value: "teacher" },
        { text: "人数", value: "people" },
        { text: "创建时间", value: "time" },
      ],
      groups: [
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 20,
          time: "2021/5/21",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 24,
          time: "2021/5/22",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 24,
          time: "2021/5/23",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 24,
          time: "2021/4/22",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 24,
          time: "2021/5/12",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 15,
          time: "2021/5/22",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 24,
          time: "2021/5/22",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 30,
          time: "2021/5/22",
        },
        {
          name: "虚拟现实",
          tag: "计算机",
          teacher: "张三",
          people: 5,
          time: "2021/5/22",
        },
        {
          name: "人工智能",
          tag: "计算机",
          teacher: "赵四",
          people: 24,
          time: "2021/5/22",
        },
      ],
    };
  },
  components: {
    bar,
  },
};
</script>
