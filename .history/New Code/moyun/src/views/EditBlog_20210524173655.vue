<template>
    <div class="EditBlog">
    <v-app>
        <bar></bar>
        <v-container>
        <v-col cols="12" sm="6">
          <v-text-field
            v-model="last"
            label="Last Name"
            filled
            shaped
            width=600
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="6" md="4">
          <v-text-field
            label="Outlined"
            placeholder="Placeholder"
            outlined
            dense
            width=1200
            height=900
          ></v-text-field>
        </v-col>
        </v-container>
        </v-app>
    </div>
</template>


<script>
import bar from "../components/Bar"
  export default {
    data: () => ({
      first: 'John',
      last: 'Doe',
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