<template>
  <div class="WriteBookReview">
    <v-app>
      <div class="background">
            <img src="../assets/widthPic.jpg"  width="100%" height="100%" alt="" />
      </div>
      <bar></bar>
      <v-container>
        <div class="card">
          <div class="front">
            <v-form>
              <v-container fluid>
                <v-col cols="12">
                  <v-text-field
                    color="blue darken-2"
                    label="书评题目"
                    required
                  ></v-text-field>
                  <v-textarea color="teal">
                    <template v-slot:label>
                      <div>书评内容</div>
                    </template>
                  </v-textarea>
                  <v-col class="d-flex" cols="12" sm="6">
                    <v-select :items="items" label="下拉选择给该书评分" solo></v-select>
                  </v-col>
                </v-col>
                <v-btn class="button" large @click="commitSuccess">
                  <p class="create">发布书评</p>
                </v-btn>
              </v-container>
            </v-form>
          </div>
        </div>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Bar from "../components/Bar.vue";
export default {
  setup() {},
  components: {
    Bar,
  },
  data: () => ({
      items: ['5', '4', '3', '2','1'],
    }),
  methods:{
      commitSuccess(){
          alert('发布成功');
          this.$router.push({path:"/Book/CheckBook"});
      }
  }
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
  height: 500px;
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
