<template>
  <div class="updates">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">
          <v-col class="fill-height flex-column box" align="center" justify="space-between">
            <v-btn class="mx-2" fab dark large color="primary" v-on:click="toBlock">
              <v-icon dark>mdi-account</v-icon>
            </v-btn>
          <template>
              <v-item v-for="(item, index) in news" v-bind:key="index">
                <div>
                  <v-hover v-slot:default="{ hover }">
                    <v-card
                      class="mx-auto"
                      color="blue lighten-2"
                      dark
                      max-width="800"
                      :elevation="hover ? 12 : 2"
                      :class="{ 'on-hover': hover }"
                    >
                      <v-card-title>
                        <v-icon
                          large
                          left
                        >
                          mdi-twitter
                        </v-icon>
                        <span class="title font-weight-bold">{{item.type}}</span>
                      </v-card-title>

                      <v-card-text class="headline font-weight-bold font-italic">
                        {{item.content}}
                      </v-card-text>

                      <v-card-actions>
                        <v-list-item class="grow">

                          <v-list-item-avatar color="grey darken-3">
                            <v-img
                              class="elevation-6"
                              src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortCurly&accessoriesType=Prescription02&hairColor=Black&facialHairType=Blank&clotheType=Hoodie&clotheColor=White&eyeType=Default&eyebrowType=DefaultNatural&mouthType=Default&skinColor=Light"
                            ></v-img>
                          </v-list-item-avatar>

                          <v-list-item-content style="margin-left:-150px;">
                            <v-list-item-title class="title font-weight-bold">{{item.name}}</v-list-item-title>
                          </v-list-item-content>
                        <v-row
                            align="center"
                            justify="end"
                          >
                            <v-btn icon color="pink lighten-2" style="margin-right:50px;" v-if="item.myLike">
                              <v-icon v-on:click="item.likes++">mdi-heart</v-icon>
                              <span class="subheading mr-3">{{
                                item.likes
                              }}</span>
                            </v-btn>
                            <v-btn icon color="teal" style="margin-right:30px;">
                              <v-icon v-on:click="item.shares++">mdi-share-variant</v-icon>
                              <span class="subheading mr-3">{{item.shares}}</span>
                            </v-btn>
                          </v-row>
                        </v-list-item>
                      </v-card-actions>
                    </v-card>
                  </v-hover>
                </div>
              </v-item>
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
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    news: [
      {
        id: 1,
        title: "Book1",
        type: "BookReview",
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

</style>
