<template>
  <div class="createGroup">
    <bar></bar>
    <v-container>
      <div class="picturescard">
          <div class="front"> 
          <v-form>
          <v-container fluid>
                <v-file-input show-size counter chips multiple label="上传用户个人头像图片" v-model="files1"></v-file-input>
                <v-btn
                class="button"
                large
              >
                <p class="create" @click="changePictures1">保存更改</p>
              </v-btn>
          </v-container>
        </v-form>
          
          <v-form>
          <v-container fluid>
                <v-file-input show-size counter chips multiple label="上传用户个人背景图片" v-model="files2"></v-file-input>
                <v-btn
                class="button"
                large
              >
                <p class="create" @click="changePictures2">保存更改</p>
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
    files1:null,
    files2:null,
  }),
  components: {
    bar,
  },
  methods: {

    changePictures1(){
      let data = new FormData();
      for(let file of this.files1){
        data.append("file", file,file.name)
      }
      this.$http({
        method: "post",
        url: "/ChangeHeadImage",
        data: data,
    }).then(res=>{
      if(res.data.success){
        alert("保存个人头像图片成功");
      }
    });    
  },

  changePictures2(){
      let data = new FormData();
      for(let file of this.files2){
        data.append("file", file,file.name)
      }
      this.$http({
        method: "post",
        url: "/ChangeBackgroundImage",
        data: data,
    }).then(res=>{
      if(res.data.success){
        alert("保存个人背景图片成功");
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
.picturescard {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  height: 400px;
  width: 600px;
  z-index: 1;
  transition: transform 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}
.picturescard .front {
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
.picturescard .front {
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