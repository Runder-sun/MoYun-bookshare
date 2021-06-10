<template>
    <div class="ScanBlog">
        <v-app>
        <bar></bar>
        <v-container>
            <template>
            <v-card
                class="mx-auto my-12"
                width="1400"
                min-height="1000"
                center
                elevation="24"
            >  
            <v-card-title class="text-h2" 
            text-align="center"
            :headStyle="{ 'text-align': 'center' }" 
            jusify="center" 
            >
            <span
            text-align="center"
            :headStyle="{ 'text-align': 'center' }" 
            >{{title}}</span>
            </v-card-title> 
            <p>{{title}}<p>
            <v-row justify="center" style="margin-top:20px">
            <v-snackbar
              v-model="snackbar1"
              absolute
              top
              center
              color="success"
              timeout="5"
              >
              <span>ReTweet successful!</span>
              <v-icon dark>mdi-checkbox-marked-circle</v-icon>
              </v-snackbar>    
                <v-btn
                    fab
                    color="deep-purple darken-1"
                    dark
                    @click.stop="dialog = true"
                    class="button"
                    style="margin-left:40px"
                    >
                    <v-icon>mdi-share-variant</v-icon>
                    </v-btn>

                    <v-dialog
                    v-model="dialog"
                    max-width="290"
                    >
                    <v-card>
                        <v-card-title class="headline">是否确定转载?</v-card-title>
                        <v-card-text>
                        该日志将被转载到您的动态
                        </v-card-text>

                        <v-card-actions>
                        <v-spacer></v-spacer>

                        <v-btn
                            color="green darken-1"
                            text
                            @click="dialog = false"
                        >
                            No
                        </v-btn>

                        <v-btn
                            color="green darken-1"
                            text
                            @click="post"
                        >
                            Yes
                        </v-btn>
                        </v-card-actions>
                    </v-card>
                    </v-dialog>

                <v-btn
                    fab
                    color="blue"
                    @click.stop="dialog1 = true"
                    dark
                    class="button"
                >
                <v-icon>mdi-message-text</v-icon>
                </v-btn>

                <v-dialog
                    v-model="dialog1"
                    width="1200px"
                    height="3000px"
                >
                    <v-card>
                        <v-container>
                        <v-card-title class="headline" center> Post Comment</v-card-title>
                        <v-snackbar
                        v-model="snackbar2"
                        absolute
                        top
                        center
                        color="success"
                        vertical
                        >
                        <span>Comment Post successful!</span>
                        <v-icon dark>mdi-checkbox-marked-circle</v-icon>
                        </v-snackbar>
                            <v-form ref="form" @submit.prevent="submit">
                            <v-container fluid>
                                <v-row>
                                <v-col cols="12">
                                    <v-textarea
                                    v-model="form.bio"
                                    color="teal"
                                    >
                                    <template v-slot:label>
                                        <div>
                                        Content
                                        </div>
                                    </template>
                                    </v-textarea>
                                </v-col>
                                </v-row>
                            </v-container>
                            <v-card-actions>
                            <v-btn text @click="resetForm">Clear</v-btn>
                            <v-spacer></v-spacer>
                            <v-btn
                            :disabled="!formIsValid"
                            text
                            color="primary"
                            type="submit"
                            >Post</v-btn>
                        </v-card-actions>
                        </v-form> 
                        </v-container>
                    </v-card>
                </v-dialog>  
                <v-btn
                        fab
                        dark
                        color="indigo"
                        style="space around"
                        v-on:click="collect"
                        class="button"
                    >
                        <v-icon>mdi-star</v-icon>
                    </v-btn>
                <v-btn
                        :class="this.like?'like':'dislike'"
                        fab
                        dark
                        v-on:click="likeBlog"
                        class="button"
                    >
                    <v-icon>mdi-heart</v-icon>                    
                    </v-btn> 
            </v-row>
                <br>
                <br>
                <br>
                <v-card-text right>
                <v-row
                align="center"
                class="mx-0">
                <div class="my-4 subtitle-1 ">{{author}}</div> 
                <v-spacer></v-spacer>   
                <div class="my-4 subtitle-1 ">{{date}}</div>
                <v-spacer></v-spacer>  
                <div v-if="trans">原创</div>
                <div v-else>转载</div>
                </v-row>
                </v-card-text>
                <v-divider class="mx-4"></v-divider>
                <v-card-title>Content</v-card-title>
                <v-card-text>
                    <div>{{content}}</div>
                </v-card-text>                                   
                </v-card>
            </template>           
        </v-container>
        
        </v-app>
        </div>
</template>

<script>
import bar from "../components/Bar.vue"
export default({
    data() {
    
    const defaultForm = Object.freeze({
        first: '',
        bio: '',
      })
    
    return{
        form: Object.assign({}, defaultForm),
        rules: {
          name1: [val => (val || '').length > 0 || 'This field is required'],
        },
        cantCollect: false,
        ableCollect: false,
        alert1: false,
        conditions: false,
        snackbar1: false,
        snackbar2: false,
        terms: false,
        defaultForm,
        dialog1: false,
        dialog: false,
        trans: false,
        bio:'',
        direction: 'bottom',
        fab: false,
        fling: false,
        hover: false,
        tabs: null,
        transition: 'slide-y-reverse-transition',
        //backend content
        title:"Blog4Test",
        date:"2020-12-25",
        author:"Jackson",
        like: false,
        incollection: false,
        content:"This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.",
        }
    },
    components:{
        bar,
    },
    computed: {
      formIsValid () {
        return (
          this.form.bio
        )
      },
    },

    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      resetForm () {
        this.form = Object.assign({}, this.defaultForm)
        this.$refs.form.reset()
      },
      submit () {
        this.snackbar2 = true
        this.resetForm()
      },
      post(){
        this.snackbar1=true
        this.dialog=false
        //this.alert1=true
      },
      collect(){
        if(this.incollection){
          this.cantCollect=true
        }
        else this.ableCollect=true
      },
      likeBlog(){
       /* if(this.like){
          this.likes--
        }
        else this.likes++*/
        this.like=!this.like
      },
    },
})
</script>

<style scope>
.ScanBlog{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};

  .v-speed-dial {
    position: absolute;
  }
  .v-btn--floating {
    position: relative;
  }
  .like{
    color: palevioletred;
  }
  .dislike{
    color:rgb(22, 158, 29);
  }    
  .button{
    margin-right: 25px;

  }
</style>