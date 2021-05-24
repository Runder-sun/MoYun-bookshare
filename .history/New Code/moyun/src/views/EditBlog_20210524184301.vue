<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
        <v-header align="center" justify="center" style="margin-top:100px">
          <v-text-field
            v-model="title"
            label="Title"
            filled
            shaped
            height="60px"
          ></v-text-field>
        </v-header>
        <v-main align="center" justify="center">
          <v-text-field
            v-model="content"
            label="content"
            outlined
            height=600
          ></v-text-field>
        </v-main>
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
            height="50px">
                Save Edit
            </v-btn>
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