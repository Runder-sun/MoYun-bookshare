<template>
  <div class="updates">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">
            <v-btn class="block" fab dark large color="primary" v-on:click="toBlock">
              <v-icon dark>mdi-account</v-icon>
            </v-btn>          
        <v-row class="fill-height" align="center" justify="center">
            <template 
            v-for="(book, i) in books"
            margin-left="300px">
            <v-col :key="i" 
            cols="12" 
            md="3" 
            >
                <v-hover v-slot="{ hover }">
                        <v-card
                          :elevation="hover ? 24 : 2"
                          :class="{ 'on-hover': hover }"
                          width="200px"
                          align="center"
                          :to="'/Book/CheckBook/'+book.id"
                        >
                          <v-img :src="book.img" height="225px">
                            <v-card-title class="title white--text">
                              <v-row
                                class="fill-height flex-column"
                                justify="space-between"
                              >
                                <p class="mt-4 subheading text-left">
                                  {{ book.title }}
                                </p>

                            <div>
                              <p
                                class="
                                  ma-0
                                  body-1
                                  font-weight-bold font-italic
                                  text-left
                                "
                              >
                                {{ book.text }}
                              </p>
                              <p
                                class="
                                  caption
                                  font-weight-medium font-italic
                                  text-left
                                "
                              >
                                {{ book.subtext }}
                              </p>
                            </div>

                          </v-row>
                        </v-card-title>
                      </v-img>
                    </v-card>
                  </v-hover>
                </v-col>
            </template>
  
            <v-card>
            <v-tabs v-model="tab">
              <v-tab>日志</v-tab>
              <v-tab>书评</v-tab>

             
            </v-tabs>
            </v-card>

        </v-row>
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
    blogDT: [
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
      bookReviewDT : [
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
        books:[
      {
        title: "Little Prince",
        text: "Story",
        subtext: "An adventure and a love scene",
        img: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
      {
        title: "Little Prince",
        text: "Novel",
        subtext: "An adventure and a love scene",
        img: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
      {
        title: "Little Prince",
        text: "Ambient Bass",
        subtext: "An adventure and a love scene",
        img: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
      {
        title: "Little Prince",
        text: "Ambient Bass",
        subtext: "An adventure and a love scene",
        img: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
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

</style>
