<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
        <v-header align="center" justify="center">
        <v-col cols="12" sm="6" align="center">
          <v-text-field
            v-model="title"
            label="Title"
            filled
            shaped
            width=600
          ></v-text-field>
        </v-col>
        </v-header>
        <v-main align="center" justify="center">
          <v-text-field
            v-model="content"
            label="content"
            placeholder="Placeholder"
            outlined
            dense
            width=1200
            height=500
          ></v-text-field>
        </v-main>
        <v-footer>
            <v-btn
            text
            color="red">
                Cancel Edit
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn
            text
            color="green">
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