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
                            v-model="title" 
                            :counter="300" 
                            required
                            :rules="titleRules">
                            <template v-slot:label>
                              <div>Title</div>
                            </template>
                          </v-textarea>
                          <v-textarea color="teal" 
                            v-model="content" 
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
                            text
                            color="red"
                            width="800px"
                            height="50px"
                            :disabled="!validCancel" >
                                Cancel Edit
                            </v-btn>
                            <v-spacer></v-spacer>
                            <v-btn
                            text
                            color="green"
                            width="800px"
                            height="50px"
                            :disabled="!validSave" 
                            large
                            @click="snackbar = true">
                                Save Edit
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
import bar from "../components/Bar"
  export default {
    data: () => ({
      validSave:true,
      validCancel
      blogid:'192312',
      title: 'JohnAblog',
      content: 'DoeBcontent',
      snackbar: false,
      titleRules: [
				v => !!v || '题目不能为空',
				v => (v && v.length <= 20) || '题目为30个字符以内',
			],
      contentRules: [
				v => !!v || '内容不能为空',
			],
    }),
    components:{
        bar,
    }
  }
</script>

<style scope>
.EditBlog{
    display:flex;
    align-content: center;}
</style>