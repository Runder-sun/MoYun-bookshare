<template>
  <div class="AddBook">
    <v-app>
      <bar></bar>
      <v-container>
        <el-form ref="form" :rules="rules" :model="form" label-width="380px">
          <v-container>
            <el-form-item label="图书名称" prop="bookName">
              <el-input
                v-model="this.form.bookName"
                placeholder="请输入图书名称"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="图书分类" prop="kind">
              <v-col cols="12" sm="6">
                <v-select
                  v-model="this.form.kind"
                  :items="kinds"
                  attach
                  chips
                  label="选择图书类别"
                >
                </v-select>
              </v-col>
            </el-form-item>
            <el-form-item label="作者" prop="author">
              <el-input
                v-model="this.form.author"
                placeholder="请输入作者"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="ISBN号" prop="ISBN">
              <el-input
                v-model="this.form.ISBN"
                placeholder="请输入ISBN号"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="出版社" prop="publisher">
              <el-input
                v-model="this.form.publisher"
                placeholder="请输入出版社"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="简介" prop="introduce">
              <el-input
                type="textarea"
                v-model="this.form.introduce"
                placeholder="请输入简介"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="上传封面" prop="filebookcover">
              <v-file-input show-size counter chips multiple label="上传图书封面" v-model="this.form.files.filebookcover"></v-file-input>
            </el-form-item>
            <el-form-item label="上传电子书" prop="fileebook">
              <v-file-input show-size counter chips multiple label="上传电子书" v-model="this.form.files.fileebook"></v-file-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmitAndCheck('form')"
                >添加并查看新书</el-button
              >
            </el-form-item>
          </v-container>
        </el-form>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
    kinds: [
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
      form:{
      bookName: "",
      author: "",
      ISBN: "",
      publisher: "",
      introduce: "",
      kind:"",
	  files:[
		  {fileebook:null},
		  {filebookcover:null},
	  ],
      },
    rules: {
      bookName: [
        {
          required: true,
          message: "请输入图书名称",
          trigger: "blur",
        },
        {
          min: 2,
          max: 30,
          message: "长度在 2 到 30 个字符",
          trigger: "blur",
        },
      ],
      kind: [
        {
          required: true,
          message: "请选择图书分类",
          trigger: "blur",
        },
      ],
      author: [
        {
          required: true,
          message: "请输入作者",
          trigger: "blur",
        },
        {
          min: 2,
          max: 30,
          message: "长度在 2 到 30 个字符",
          trigger: "blur",
        },
      ],
      ISBN: [
        {
          required: true,
          message: "请输入ISBN号",
          trigger: "blur",
        },
        {
          min: 2,
          max: 50,
          message: "长度在 2 到 30 个字符",
          trigger: "blur",
        },
      ],
      publisher: [
        {
          required: true,
          message: "请输入出版社",
          trigger: "blur",
        },
        {
          min: 2,
          max: 100,
          message: "长度在 2 到 30 个字符",
          trigger: "blur",
        },
      ],
      introduce: [
        {
          required: true,
          message: "请输入简介",
          trigger: "blur",
        },
        {
          min: 2,
          max: 300,
          message: "长度在 2 到 300个字符",
          trigger: "blur",
        },
      ],
    },
  }),

  methods: {
    onSubmitAndCheck(ruleForm) {
      this.$refs[ruleForm].validate((valid) => {
        if (valid) {
      this.$http({
            method: "post",
            url: "/uploadBook",
            data: this.form,
          })
            .then((res) => {
              this.message = res.data.message;
              if (res.data.success) {
                alert("上传成功");
              }
			  else{
				  alert("上传失败");
			  }
            })
            .catch((err) => {
              console.log(err);
            });
        }
      });
    },


    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
  },
  components: {
    Bar,
  },
};
</script>