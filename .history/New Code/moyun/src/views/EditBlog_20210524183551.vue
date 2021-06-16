<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
        <v-header align="center" justify="center">
          <v-text-field
            v-model="title"
            label="Title"
            filled
            shaped
          ></v-text-field>
        </v-header>
        <v-main align="center" justify="center">
          <v-text-field
            v-model="content"
            label="content"
            outlined
            height=500
          ></v-text-field>
        </v-main>
        <v-footer>
            <v-btn
            text
            color="red"
            width="400px">
                Cancel Edit
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn
            text
            color="green"
            width="400px">
                Save Edit
            </v-btn>
        </v-footer>
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