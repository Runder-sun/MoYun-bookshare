<template>
  <div class="createGroup">
    <bar></bar>
    <v-container>
      <div class="card">
          <div class="front"> 
        点击“+”号上传个人头像
        <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess1"
          :before-upload="beforeAvatarUpload1"
        >
          <img v-if="imageUrl1" :src="imageUrl1" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i></el-upload>

          <v-row></v-row>
          <v-row></v-row>
          <v-row></v-row>
          <v-row></v-row>
        点击“+”号上传个人背景
          <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess2"
          :before-upload="beforeAvatarUpload2"
        >
          <img v-if="imageUrl2" :src="imageUrl2" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i></el-upload>
          <v-form>
          <v-container fluid>
                <v-btn
                class="button"
                large
              >
                <p class="create" @click="changePictures">保存更改</p>
              </v-btn>
          </v-container>
        </v-form>
      </div>
      </div>
    </v-container>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";

export default {
  data: () => ({
    files:[
      {image1:null},
      {image2:null}
    ],
    imageUrl1: "",
    imageUrl2: "",
  }),
  components: {
    bar,
  },
  methods: {
    handleAvatarSuccess1(res, file) {
      this.files.image1 = file;
      this.imageUrl1 = URL.createObjectURL(file.raw);
    },
    handleAvatarSuccess2(res, file) {
      this.files.image2 = file;
      this.imageUrl2 = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload1(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      
      return isJPG && isLt2M;
    },
    beforeAvatarUpload2(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      
      return isJPG && isLt2M;
    },
    changePictures(){
      this.$http({
        method: "post",
        url: "/ChangePicture",
        data: {
          files:this.files
        },
    }).then(res=>{
      if(res.data.success){
        this.$router.push({ path: "/PersonalInfo/"+this.$store.state.userID});
      }
    });
  }
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
.card {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  height: 700px;
  width: 600px;
  z-index: 1;
  transition: transform 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}
.card .front {
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
.card .front {
  z-index: 1;
}
.avatar-uploader .el-upload {
  border: 1px dashed #5d5d6d;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  top:10px;
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