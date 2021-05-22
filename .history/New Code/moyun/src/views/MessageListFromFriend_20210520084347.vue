<template>
  <div class="friMsg">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">
          <v-col class="fill-height flex-column box" align="center" justify="space-between">

          </v-col>
        </v-container>          
      </v-container>
    </v-main>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default ({
    setup() {
        
    },
    components:{
        bar,
    }
})
</script>
              
<style scoped>
.friMsg{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;
}
</style>              
