<template>
  <div class="AddBook">
    <v-app>
      <bar></bar>
      <v-container>
        <el-form ref="form" :rules="rules" :model="form" label-width="380px">
          <v-container>
            <el-form-item label="图书名称" prop="bookName">
              <el-input
                v-model="form.bookName"
                placeholder="请输入图书名称"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="图书分类" prop="kind">
              <v-col cols="12" sm="6">
                <v-select
                  v-model="form.kind"
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
                v-model="form.author"
                placeholder="请输入作者"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="ISBN号" prop="ISBN">
              <el-input
                v-model="form.ISBN"
                placeholder="请输入ISBN号"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="出版社" prop="publisher">
              <el-input
                v-model="form.publisher"
                placeholder="请输入出版社"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="简介" prop="introduce">
              <el-input
                type="textarea"
                v-model="form.introduce"
                placeholder="请输入简介"
                clearable
              ></el-input>
            </el-form-item>
            <el-form-item label="上传封面" prop="filebookcover">
              <el-upload
                class="upload-demo"
                ref="upload"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :auto-upload="false"
				:on-success="handleAvatarSuccess1"
                :before-upload="beforeAvatarUpload1"
              >
                <el-button slot="trigger" size="small" type="primary"
                  >选取文件</el-button
                >
                <div slot="tip" class="el-upload__tip">
                  只能上传jpg/png文件，且不超过2MB
                </div>
              </el-upload>
            </el-form-item>
            <el-form-item label="上传电子书" prop="fileebook">
              <el-upload
                class="upload-demo"
                ref="upload"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :auto-upload="false"
				:on-success="handleAvatarSuccess2"
                :before-upload="beforeAvatarUpload2"
              >
                <el-button slot="trigger" size="small" type="primary"
                  >选取文件</el-button
                >
                <div slot="tip" class="el-upload__tip">
                  只能上传pdf文件，且不超过500kb
                </div>
              </el-upload>
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
    form: {
      bookName: "",
      author: "",
      ISBN: "",
      publisher: "",
      introduce: "",
      delivery: false,
      kind:"",
      resource: "",
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
            data: {
              BookName:this.form.bookName,
              ISBN:this.form.ISBN,
			  Introduce:this.form.introduce,
			  Kind:this.form.kind,
              Author:this.form.author,
              Publisher:this.publisher,
              Files:this.files,
            },
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

	handleAvatarSuccess1(res, file) {
      this.form.files.filebookcover=file
    },
    beforeAvatarUpload1(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.message="上传头像图片只能是 JPG 格式!"
        this.snackbar = true
      }
      if (!isLt2M) {
        this.message="上传头像图片大小不能超过 2MB!"
        this.snackbar = true
      }

      return isJPG && isLt2M;
    },
	handleAvatarSuccess2(res, file) {
      this.form.files.fileebook=file
    },
    beforeAvatarUpload2(file) {
      const isPDF = file.type === "pdf";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.message="上传电子书文件只能是 JPG 格式!"
        this.snackbar = true
      }
      if (!isLt2M) {
        this.message="上传电子书文件不能超过 2MB!"
        this.snackbar = true
      }

      return isPDF && isLt2M;
    },
  },
  components: {
    Bar,
  },
};
</script>