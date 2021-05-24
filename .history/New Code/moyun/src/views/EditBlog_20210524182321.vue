<template>
    <div class="EditBlog">
        <bar></bar>
        <v-container>
        <v-row align="center">
        <v-col cols="12" sm="6" align="center">
          <v-text-field
            v-model="title"
            label="Title"
            filled
            shaped
            width=600
          ></v-text-field>
        </v-col>
        </v-row>
        <v-row absolute align="center">
        <v-col cols="12" sm="6" md="4" justify="center" align="center">
          <v-text-field
            v-model="content"
            label="content"
            placeholder="Placeholder"
            outlined
            dense
            width=1200
            height=500
          ></v-text-field>
        </v-col>
        </v-row>
        <v-row justify="center" align="center">
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