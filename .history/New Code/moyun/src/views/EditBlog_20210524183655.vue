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
            <v-btn
            text
            color="red"
            width="800px">
                Cancel Edit
            </v-btn>

            <v-btn
            text
            color="green"
            width="800px">
                Save Edit
            </v-btn>
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