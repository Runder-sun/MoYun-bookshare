<template>
  <div class="AddBook">
    <v-app>
      <bar></bar>
      <v-container>
      <div class="cardlx">
        <div class="front">
          <v-form>
            <v-container fluid>
              <v-col cols="12">
                <v-file-input show-size counter chips multiple label="上传图书图片" v-model="ImageFile"></v-file-input>
                <v-file-input show-size counter chips multiple label="上传电子书资源" v-model="BookFile"></v-file-input>
                <v-text-field
                  v-model="bookName"
                  :rules="bookNameRules"
                  color="blue darken-2"
                  label="图书名称"
                  required
                ></v-text-field>
                <v-text-field
                  v-model="author"
                  :rules="authorRules"
                  color="blue darken-2"
                  label="作者"
                  required
                ></v-text-field>
                <v-text-field
                  v-model="ISBN"
                  :rules="ISBNRules"
                  color="blue darken-2"
                  label="ISBN号"
                  required
                ></v-text-field>
                <v-text-field
                  v-model="publisher"
                  :rules="publisherRules"
                  color="blue darken-2"
                  label="出版社"
                  required
                ></v-text-field>
                <v-col cols="12" sm="6">
                <v-select
                  :rules="kindRules"
                  v-model="kind"
                  :items="kinds"
                  attach
                  chips
                  label="选择图书类别"
                >
                </v-select>
              </v-col>
                <v-textarea v-model="introduce" :rules="introduceRules" color="teal">
                  <template v-slot:label>
                    <div>该书简介</div>
                  </template>
                </v-textarea>
              </v-col>
              <v-btn class="button" large @click="onSubmitAndCheck">
                <p class="create">上传图书</p>
              </v-btn>
            </v-container>
          </v-form>
        </div>
        <v-snackbar
        v-model="snackbar"
        :timeout="3000"
        color="blue-grey"
        absolute
        rounded="pill"
        top
      >
        {{ message }}
      </v-snackbar>
      </div>
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
      
      snackbar: false,
    message: "error",

      bookName: "",
      author: "",
      ISBN: "",
      publisher: "",
      introduce: "",
      kind:"",
      ImageFile:null,
		  BookFile:null,

      bookNameRules: [(v) => !!v || "请填写图书名称"],
      publisherRules: [(v) => !!v || "请填写图书出版商"],
      introduceRules: [(v) => !!v || "请填写图书简介"],
      kindRules: [(v) => !!v || "请选择图书分类"],
      authorRules: [(v) => !!v || "请填写图书作者"],
      ISBNRules: [(v) => !!v || "请填写图书ISBN号"],
  }),

  methods: {
    onSubmitAndCheck() {
      let data = new FormData();
      for(let file of this.ImageFile){
        data.append("ImageFile", file,file.name)
      }
      for(let file of this.BookFile){
        data.append("BookFile", file,file.name)
      }
      data.append('BookName',this.bookName)
      data.append('Author',this.author)
      data.append('ISBN',this.ISBN)
      data.append('Publisher',this.publisher)
      data.append('Introduce',this.introduce)
      data.append('Kind',this.kind)
      this.$http({
        method: "post",
        url: "/uploadBook",
        data: data,
      }).then((res) => {
        console.log(res.data)
        if (res.data.success) {
          this.message="创建成功！"
          this.snackbar=true
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.$router.push({ path: "/Book/BookWareHouse" });
            }, 1000);
        }else{
          this.message="创建失败！"
          this.snackbar=true
        }
      });
      this.message="创建成功！"
          this.snackbar=true
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

<style>
.createGroup {
  background-color: #efeeee;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.cardlx {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  height: 800px;
  width: 600px;
  z-index: 1;
  transition: transform 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}
.cardlx .front {
  position: absolute;
  text-align: center;
  box-shadow: 12px 12px 24px rgba(0, 0, 0, 0.1),
    -12px -12px 24px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  background-color: #efeeee;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  transition: 1s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}
.cardlx .front {
  z-index: 1;
}
.avatar-uploader .el-upload {
  border: 1px dashed #5d5d6d;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  top: 10px;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #2a436e;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.button {
  color: #596275;
  box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
    -9px -9px 18px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  background-color: #efeeee;
  position: relative;
  top: 0px;
  margin-top: 20px;
  width: 130px;
  height: 55px;
  outline: none;
  border: none;
}
.button:hover {
  font-size: 19px;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2),
    -1px -1px 2px rgba(255, 255, 255, 0.8);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  transition: font-size 0.2s ease-out;
}
.create {
  font-size: 20px;
  margin-top: 15px;
}
</style>
