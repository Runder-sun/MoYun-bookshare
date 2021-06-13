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
            @keyup.enter="searchGroup"
          ></v-text-field>
        </v-card-title>
        <v-row justify="center">
          <v-chip-group active-class="primary--text">
            <v-chip
              v-for="tag in tags"
              :key="tag"
              @click="choosedTag = tag.Tag"
            >
              {{ tag.Tag }}
            </v-chip>
          </v-chip-group>
        </v-row>
        <v-container>
          <el-table :data="groups" border style="width: 100%">
            <el-table-column fixed sortable prop="GroupID" label="圈子编号">
            </el-table-column>
            <el-table-column prop="GroupName" sortable label="名称">
            </el-table-column>
            <el-table-column prop="Tag" label="标签" sortable>
            </el-table-column>
            <el-table-column prop="CreateID" label="创建者ID" sortable>
            </el-table-column>
            <el-table-column prop="CreateTime" label="创建时间" sortable>
            </el-table-column>
            <el-table-column prop="MemberNum" label="人数" sortable>
            </el-table-column>
            <el-table-column prop="Introduce" label="简介" sortable>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  :to="'/Group/GroupIndex/' + scope.row.GroupID"
                  type="text"
                  >查看</el-button
                >
                <el-button @click="join(scope.row.GroupID)" type="text"
                  >申请加入</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </v-container>
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
      choosedTag: "",
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
      groups: [],
    };
  },
  components: {
    bar,
  },
  methods: {
    searchGroup() {
      this.$http({
        method: "post",
        url: "/searchGroup",
        data: {
          GroupName: this.search,
          Tag: this.choosedTag,
        },
      })
        .then((res) => {
          if (res.data.success) {
            this.group = res.data.group;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>
