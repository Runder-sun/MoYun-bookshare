<template>
  <div class="updates">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">
          <v-col class="fill-height flex-column box" align="center" justify="space-between">
            <v-btn class="block" fab dark large color="primary" v-on:click="toBlock">
              <v-icon dark>mdi-account</v-icon>
            </v-btn>
              <template v-slot:extension>
              <v-tabs tab-position="left" style="height: 200px;" class="sideChoice">
              <v-tab>书评</v-tab>
              <v-tab>日志</v-tab>
                  
              </v-tabs>
            </template>

            <template>
            <el-backtop target=".page-component__scroll .el-scrollbar__wrap"></el-backtop>
            </template>

          </v-col>
        </v-container>          
      </v-container>
    </v-main>
  </div>
</template>

<script>
//0是bookreview 1是blog
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    news: [
      {
        id: 1,
        title: "Book1",
        type: "BookReview",
        typeStamp:0,
        content: `This is a book about Jesus and how mankind react to atheism,deeply revealling the truth of religious...`,
        name: "Jeff",
        personPhoto: "../assets/UpdatesA1",
        time: "2021-04-28",
        postPic: "../assets/UpdatesB2",
        likes: 5,
        shares: 5,
        myLike:false,
      },
      {
        id: 2,
        title: "Tweet",
        type: "Blog",
        typeStamp:1,
        content: `Just had a good day！`,
        name: "Kitty",
        personPhoto: "../assets/UpdatesA2",
        time: "2021-04-20",
        postPic: "../assets/UpdatesB1",
        likes: 71,
        shares: 75,
        myLike:true,
      },
      {
        id: 3,
        title: "Tweet",
        type: "Blog",
        typeStamp:1,
        content: `Kinda ok`,
        name: "Ken",
        personPhoto: "../assets/UpdatesA3",
        time: "2021-04-20",
        postPic: "../assets/UpdatesB3",
        likes: 10,
        shares: 11,
        myLike:false,
      },
      {
        id: 2,
        title: "Book44",
        type: "BookReview",
        typeStamp:0,
        content: `Worthy book`,
        name: "Micki",
        personPhoto: "../assets/UpdatesA2",
        time: "2021-04-20",
        postPic: "../assets/UpdatesB3",
        likes: 71,
        shares: 75,
        myLike:false,
      },
    ],
  }),
  components: {
    bar,
  },
  methods:{
    toBlock(){
        this.$router.push({path:"/updates/block"});
    },
    like(news){
      news.likes++;
      news.myLike=true;
    },
    unlike(news){
      news.likes--;
      news.myLike=false;
    }
  }
};
</script>

<style scoped>
.box {
  display: flex;
  flex-direction: column;
}
.v-card {
  margin-bottom: 30px;
}
.middle {
    height: 445px;
    width: 300px;
    background: no-repeat center top;
    background-size: contain;
}    
.updates{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;
}

.sideChoice{
  position: absolute center left;
}

.block{
  position: absolute right bottom;
}
</style>
