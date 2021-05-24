<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
          <v-text-field
            v-model="title"
            label="Title"
            filled
            shaped
            height="60px"
            style="margin-top:40px"
          ></v-text-field>
          <v-text-field
            v-model="content"
            label="content"
            outlined
            height=600
          ></v-text-field>
        <br>
        <v-row align="center">
            <v-btn
            text
            color="red"
            width="800px"
            height="50px">
                Cancel Edit
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn
            text
            color="green"
            width="800px"
            height="50px"
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
                        <span>Comment Post successful!</span>
                        <v-icon dark>mdi-checkbox-marked-circle</v-icon>
                        </v-snackbar>
        </v-row>    
        </v-container>
    </div>
</template>


<script>
import bar from "../components/Bar"
  export default {
    data: () => ({
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