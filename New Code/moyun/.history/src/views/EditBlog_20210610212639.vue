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
                            v-model="recommendcontent" 
                            :counter="300" 
                            required
                            :rules="titleRules">
                            <template v-slot:label>
                              <div>Title</div>
                            </template>
                          </v-textarea>
                          <v-textarea color="teal" 
                            v-model="recommendcontent" 
                            :counter="300" 
                            required
                            :rules="contentRules">
                            <template v-slot:label>
                              <div>Content</div>
                            </template>
                          </v-textarea>
                        </v-col>
                        <v-btn class="button" 
                        :disabled="!valid" 
                        large 
                        @click="commitSuccess">
                          <p class="create">发送</p>
                        </v-btn>
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
      blogid:'192312',
      title: 'JohnAblog',
      content: 'DoeBcontent',
      snackbar: false,
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