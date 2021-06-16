<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
                <div class="card">
                  <div class="front">
                    <v-form ref="form" v-model="valid" lazy-validation>
                      <v-container fluid>
                        <v-col cols="12">
                          <v-textarea color="teal" 
                            v-model="blog[0].title" 
                            :counter="30" 
                            required
                            :rules="titleRules">
                            <template v-slot:label>
                              <div>Title</div>
                            </template>
                          </v-textarea>
                          <v-textarea color="teal" 
                            v-model="blog[0].content" 
                            :counter="300" 
                            required
                            :rules="contentRules">
                            <template v-slot:label>
                              <div>Content</div>
                            </template>
                          </v-textarea>
                        </v-col>
                        <v-row align="center">
                            <v-btn
                            large
                            rounded
                            :disabled="!validCancel"
                            class="buttonleft button" 
                            margin-left="20px"
                            @click="cancelBlog">
                            <p >Cancel Edit</p>
                            </v-btn>
                            <v-spacer></v-spacer>
                            <v-btn
                            v-model="save"
                            large
                            rounded
                            class="buttonright button"
                            @click="saveBlog"
                            margin-right="20px">
                               <p >Save Edit</p>
                            </v-btn>
                            <v-snackbar
                            v-model="snackbar"
                            absolute
                            top
                            center
                            color="success"
                                >
                            <span>Edit Blog successful!</span>
                            <v-icon dark>mdi-checkbox-marked-circle</v-icon>
                            </v-snackbar>
                        </v-row>    
                      </v-container>
                    </v-form>
                  </div>
                </div>
              </v-container>
    </div>
</template>


<script>
import bar from "../components/Bar.vue"
  export default {
    setup(){},
    data: () => ({
      blog:[],
      validSave:true,
      validCancel:true,

      snackbar: false,
      titleRules: [
				v => !!v || '题目不能为空',
				v => (v && v.length <= 20) || '题目为30个字符以内',
			],
      contentRules: [
				v => !!v || '内容不能为空',
			],
    }),
    created(){
      this.show();
    },
    components:{
        bar,
    },
    methods:{
      saveBlog(){
        if(this.$refs.form.validate()){
          this.$http({
            method:"post",
            url:"/EditBlog",
            data:{
              BlogID: this.blogid,
              BlogTitle: this.title,
              Content: this.content,
            },
          }).then((res)=>{
            if(res.data.success){
              this.snackbar=true;
              this.$router.push({path:"/BlogList"});
            }
            else{
              alert("编辑失败！");
            }
          }).catch(err=>{
            console.log(err);
          })
        }
      },
      cancelBlog(){
        this.$router.push("/BlogList");
      },
      show(){
          this.$http({
          method:"get",
          url:"/inspectBlog",
          params:{
            BlogID : this.$router.params.id,
          }
        })
          .then((res)=>{
            this.blog=res.data.Blog;
          })
          .catch((err)=>{
            console.log(err);
          })
      }

    }
  }
</script>

<style scoped>

.EditBlog {
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

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}

	.buttonleft {
		color: #596275;
		box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
			-9px -9px 18px rgba(255, 255, 255, 1);
		border-radius: 3rem;
		transition: box-shadow 0.2s ease-out;
		background-color: #efeeee;
		position: relative;
		top: 0px;
		margin-top: 30px;
		width: 130px;
		height: 55px;
		outline: none;
		border: none;
    margin-left: 100px;
	}

  	.buttonright {
		color: #596275;
		box-shadow: 9px 9px 18px rgba(0, 0, 0, 0.1),
			-9px -9px 18px rgba(255, 255, 255, 1);
		border-radius: 3rem;
		transition: box-shadow 0.2s ease-out;
		background-color: #efeeee;
		position: relative;
		top: 0px;
		margin-top: 30px;
		width: 130px;
		height: 55px;
		outline: none;
		border: none;
    margin-right: 90px;
	}

	.button:hover {
		font-size: 19px;
		box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2),
			-1px -1px 2px rgba(255, 255, 255, 0.8);
		border-radius: 3rem;
		transition: box-shadow 0.2s ease-out;
		transition: font-size 0.2s ease-out;
	}
</style>    

