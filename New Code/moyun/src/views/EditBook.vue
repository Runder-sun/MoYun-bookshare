<template>
  <div class="EditBook">
    <v-app>
      <bar></bar>
      <v-container>
            <el-form ref="form" :model="form" label-width="380px">
              <v-cintainer>
                <el-form-item label="图书名称">
                  <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="图书分类">
                  <v-col cols="12" sm="6">
                    <v-select
                      v-model="value"
                      :items="items"
                      attach
                      chips
                      label="选择图书类别"
                      multiple
                    ></v-select>
                  </v-col>
                </el-form-item>
                <el-form-item label="作者">
                  <el-input v-model="form.author"></el-input>
                </el-form-item>
                <el-form-item label="ISBN号">
                  <el-input v-model="form.ISBN"></el-input>
                </el-form-item>
                <el-form-item label="出版社">
                  <el-input v-model="form.出版社"></el-input>
                </el-form-item>
                <el-form-item label="简介">
                  <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>
                <el-form-item label="上传封面">
                  <el-upload
                    class="upload-demo"
                    ref="upload"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="fileList"
                    :auto-upload="false"
                  >
                    <el-button slot="trigger" size="small" type="primary"
                      >选取文件</el-button
                    >
                    <el-button
                      style="margin-left: 10px"
                      size="small"
                      type="success"
                      @click="submitUpload"
                    >
                      上传到服务器</el-button
                    >
                    <div slot="tip" class="el-upload__tip">
                      只能上传jpg/png文件，且不超过500kb
                    </div>
                  </el-upload>
                </el-form-item>
                <el-form-item label="上传电子书">
                  <el-upload
                    class="upload-demo"
                    ref="upload"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="fileList2"
                    :auto-upload="false"
                  >
                    <el-button slot="trigger" size="small" type="primary"
                      >选取文件</el-button
                    >
                    <el-button
                      style="margin-left: 10px"
                      size="small"
                      type="success"
                      @click="submitUpload"
                    >
                      上传到服务器</el-button
                    >
                    <div slot="tip" class="el-upload__tip">
                      只能上传pdf文件，且不超过500kb
                    </div>
                  </el-upload>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onEdit">保存编辑</el-button>
                  <el-button type="primary" @click="onEditAndCheck">保存编辑并查看</el-button>
                  <el-button type="primary" @click="cancel">取消编辑并返回</el-button>
                </el-form-item>
              </v-cintainer>
            </el-form>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
    items: [
      "文学",
      "科幻",
      "侦探",
      "纪实",
      "儿童",
      "艺术",
      "历史",
      "武侠",
      "地理",
      "医药健康",
      "IT",
      "数学",
    ],
    value: [],
    form: {
      name: "书名",
      author: "作者",
      ISBN: "1651645",
      出版社: "清华出版社",
      desc: "从前有座山........................................",
      delivery: false,
      type: [],
      resource: "",
      fileList: [
        {
          name: "food.jpeg",
          url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
        },
        {
          name: "food2.jpeg",
          url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
        },
      ],
      fileList2: [
        {
          name: "food.jpeg",
          url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
        },
        {
          name: "food2.jpeg",
          url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
        },
      ],
    },
  }),

  methods: {
    onEdit() {
      alert("编辑成功");
      console.log("submit!");
    },
    onEditAndCheck() {
      alert("编辑成功");
      this.$router.push({ path: "/Book/CheckBook" });
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    cancel() {
      alert("取消编辑成功");
      this.$router.push({ path: "/Book/CheckBook" });
    },
  },
  components: {
    Bar,
  },
};
</script>