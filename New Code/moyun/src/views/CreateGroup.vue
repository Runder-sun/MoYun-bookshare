<template>
  <div class="createGroup">
    <bar></bar>
    <v-container>
      <div class="card">
        <div class="front">
          <v-form>
            <v-container fluid>
              <v-col cols="12">
                <v-file-input show-size counter chips multiple label="上传圈子头像" v-model="files"></v-file-input>
                <v-text-field
                  v-model="groupName"
                  :rules="groupNameRules"
                  color="blue darken-2"
                  label="圈子名称"
                  required
                ></v-text-field>
                <v-textarea v-model="groupIntroduce" :rules="groupIntroduceRules" color="teal">
                  <template v-slot:label>
                    <div>圈子简介</div>
                  </template>
                </v-textarea>
                <v-checkbox v-model="checkbox" label="私密"></v-checkbox>
                <p>圈子标签</p>
                <v-row justify="center">
                  <v-chip-group active-class="primary--text">
                    <v-chip
                      v-for="(tag, i) in tags"
                      :key="i"
                      @click="choosedTag = tag.Tag"
                    >
                      {{ tag.Tag }}
                    </v-chip>
                  </v-chip-group>
                </v-row>
              </v-col>
              <v-btn class="button" large @click="createGroup">
                <p class="create">创建</p>
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
  </div>
</template>

<script>
import bar from "../components/Bar.vue";

export default {
  data: () => ({
    Private: false,
    choosedTag: "",
    imageUrl: "",
    groupIntroduce: "",
    groupName: "",
    groupNameRules: [(v) => !!v || "请填写圈子名称"],
    groupIntroduceRules: [(v) => !!v || "请填写圈子简介"],
    image: null,
    checkbox: false,
    isPrivate: 0,
    snackbar: false,
    message: "error",
    timer: null,
    files:null,
    form:{
      GroupName: "",
      Tag: "",
      Introduce: "",
      isPrivate: 0,
    },
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
  }),
  components: {
    bar,
  },
  methods: {
    
    createGroup() {
      
      if (this.checkbox) this.isPrivate = 1;
      else this.isPrivate = 0;
      let data = new FormData();
      for(let file of this.files){
        data.append("file", file,file.name)
      }
      data.append('GroupName',this.groupName)
      data.append('Tag',this.choosedTag)
      data.append('Introduce',this.groupIntroduce)
      data.append('isPrivate',this.isPrivate)
      this.$http({
        method: "post",
        url: "/addGroup",
        data: data,
      }).then((res) => {
        console.log(res.data)
        if (res.data.success) {
          this.message="创建成功！"
          this.snackbar=true
          this.timer = setTimeout(() => {
              //设置延迟执行
              this.$router.push({ path: "/Group/GroupList" });
            }, 1000);
        }else{
          this.message="创建失败！"
          this.snackbar=true
        }
      });
      this.message="创建成功！"
          this.snackbar=true
    },
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
