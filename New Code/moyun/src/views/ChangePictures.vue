<template>
  <div class="ChangePicture">
    <v-app>
      <v-img src="../assets/widthPic.jpg" width="100%" height="100%">
      <h1 class="textCenter">墨韵</h1>
        <bar></bar>
              <div class="front">
              <v-container>
                  <el-form ref="form" :rules="rules" :model="form" label-width="380px">
                      <el-form-item label="上传头像" prop="fileHead">
							<el-upload class="upload-demo" ref="upload"
								action="https://jsonplaceholder.typicode.com/posts/"  :auto-upload="false">
								<el-button slot="trigger" size="small" type="primary">选取文件</el-button>
								<el-button style="margin-left: 10px" size="small" type="success" @click="submitUpload">
									上传到服务器</el-button>
								<div slot="tip" class="el-upload__tip">
									只能上传图片，且不超过500kb
								</div>
							</el-upload>
						</el-form-item>

                        <el-form-item label="上传个人背景" prop="fileBackground">
							<el-upload class="upload-demo" ref="upload"
								action="https://jsonplaceholder.typicode.com/posts/"  :auto-upload="false">
								<el-button slot="trigger" size="small" type="primary">选取文件</el-button>
								<el-button style="margin-left: 10px" size="small" type="success" @click="submitUpload">
									上传到服务器</el-button>
								<div slot="tip" class="el-upload__tip">
									只能上传图片，且不超过500kb
								</div>
							</el-upload>
						</el-form-item>

                        <el-form-item>
							<el-button type="primary" @click="onSubmit('form')">保存</el-button>
							<el-button type="primary" @click="onSubmitAndCheck('form')">保存并跳转到个人信息</el-button>
						</el-form-item>
                  </el-form>
              </v-container>
              </div>
      </v-img>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  data: () => ({
      form: {
				delivery: false,
				resource: "",
				fileHead: [{
						name: "",
						url: "",
					},
					{
						name: "",
						url: "",
					},
				],
				fileBackGround: [{
						name: "",
						url: "",
					},
					{
						name: "",
						url: "",
					},
				],
			},
  }),
  setup() {},

  rules : {

  },

  methods: {
			onSubmit(ruleForm) {
				this.$refs[ruleForm].validate(valid => {
					if (valid) {
						console.log("success submit");
						alert("保存成功");
					} else {
						console.log("error submit");
						return false;
					}
				});
			},
			onSubmitAndCheck(ruleForm) {
				//alert("添加成功");
				this.$refs[ruleForm].validate(valid => {
					if (valid) {
						this.$router.push({
							path: "/PersonalInfo"
						});
						console.log("success submit");
					} else {
						console.log("error submit");
						return false;
					}
				});
				
			},
			submitUpload() {
				 this.$refs.upload.submit();
			}, 
		},

  components: {
    Bar,
  },
};
</script>

<style>
.login {
  background-color: #efeeee;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
#logo {
  position: relative;
  bottom: -20px;
}

.button {
  color: #596275;
  box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
    -9px -9px 18px rgba(255, 255, 255, 1);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  background-color: #efeeee;
  position: relative;
  top: 30px;
  margin-top: 20px;
  width: 130px;
  height: 55px;
  outline: none;
  border: none;
}
.login_ {
  font-size: 20px;
  margin-top: 15px;
}
.button:hover {
  font-size: 19px;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2),
    -1px -1px 2px rgba(255, 255, 255, 0.8);
  border-radius: 3rem;
  transition: box-shadow 0.2s ease-out;
  transition: font-size 0.2s ease-out;
}

.card {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  height: 700px;
  width: 550px;
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
.return {
  top: 40px;
}

.textCenter {
  position: absolute;
  text-align: center;
  left: 50%;
  top: 30%;
  margin-left: -200px;
  text-shadow: 5px -5px black, 4px -4px white;
  font-weight: bold;
  -webkit-text-fill-color: transparent;
  font-size: 200px;
}
</style>
