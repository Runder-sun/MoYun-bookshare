<template>
    <div class="EditBlog">
    <v-app>
        <bar></bar>
        <v-container fluid justify="center">
        <v-col cols="12" sm="6" center>
          <v-text-field
            v-model="title"
            label="Title"
            filled
            shaped
            width=600
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="6" md="4" center>
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
        <v-row>
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
        </v-app>
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
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>