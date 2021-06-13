<template>
  <div class="updates">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">      
        <v-row class="fill-height" align="center" justify="center">
            <template 
            v-for="(book, i) in books"
            margin-left="100px">
            <v-col :key="i" 
            cols="12" 
            md="3" 
            >
                <v-hover v-slot="{ hover }">
                        <v-card
                          :elevation="hover ? 24 : 2"
                          :class="{ 'on-hover': hover }"
                          width="200px"
                          height="180px"
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
  

            <br>
            <br>
            <br>

            <v-tabs v-model="tab" margin-top="70px">
              <v-tab>日志</v-tab>
              <v-tab>书评</v-tab>
              <v-tab-item>
                <v-lazy>
                  <v-container class="pa-4 text-center">
                    <v-col class="fill-height" align="center" justify="center">
                    <template>
                    <v-item v-for="(item, index) in blogDT" v-bind:key="index">
                      <div>
                        <v-hover v-slot:default="{ hover }">
                          <v-card
                            class="mx-auto"
                            color="blue-grey darken-1"
                            dark
                            max-width="800"
                            :elevation="hover ? 12 : 2"
                            :class="{ 'on-hover': hover }"
                            :to="'/BlogList/ScanBlog'+item.id"
                          >
                            <v-card-title>
                              <v-icon
                                large
                                left
                              >
                                mdi-twitter
                              </v-icon>
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
                                <v-list-item-title class="title font-weight-bold" >{{item.name}}</v-list-item-title>
                              </v-list-item>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </div>
                    </v-item>
                  </template>    
                    </v-col>
                  </v-container>
                </v-lazy>
              </v-tab-item>

              <v-tab-item>
                <v-lazy>
                  <v-container class="pa-4 text-center">
                    <v-col class="fill-height" align="center" justify="center">
                    <template>
                    <v-item v-for="(item, index) in bookReviewDT" v-bind:key="index">
                      <div>
                        <v-hover v-slot:default="{ hover }">
                          <v-card
                            class="mx-auto"
                            color="blue-grey darken-1"
                            dark
                            max-width="800"
                            :elevation="hover ? 12 : 2"
                            :class="{ 'on-hover': hover }"
                            :to="'/Book/BookReview'+item.id"
                          >
                            <v-card-title>
                              <v-icon
                                large
                                left
                              >
                                mdi-twitter
                              </v-icon>
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
                                  <v-list-item-title class="title font-weight-bold" >{{item.name}}</v-list-item-title>
                              </v-list-item>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </div>
                    </v-item>
                  </template>    
                    </v-col>
                  </v-container>
                </v-lazy>
              </v-tab-item>
           
            </v-tabs>

        </v-row>

          <v-btn
            fixed
            color="primary"
            fab
            large
            dark
            bottom
            left
            class="v-btn--example"
            v-on:click="toBlock"
          >
            <v-icon>mdi-account</v-icon>
          </v-btn>
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
        bookID:1,
        bookName: "Little Prince",
        kind: "Story",
        author: "An adventure and a love scene",
        bookImage: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
      {
        bookID:1,
        bookName: "Little Prince",
        kind: "Story",
        author: "An adventure and a love scene",
        bookImage: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
      {
        bookID:1,
        bookName: "Little Prince",
        kind: "Story",
        author: "An adventure and a love scene",
        bookImage: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
      {
        bookID:1,
        bookName: "Little Prince",
        kind: "Story",
        author: "An adventure and a love scene",
        bookImage: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
    ],
  }),
  components: {
    bar,
  },

  created(){
    this.showUpdates;
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
    },
    showUpdates(){
        this.$http({
        method: "get",
        url: "/blogDT",
      })
        .then((res) => {
          this.blogDT=res.data.blogDT;
          this.blogUsers=res.data.blogDTUser;
        })
        .catch((err) => {
          console.log(err);
        });
        this.$http({
        method: "get",
        url: "/bookReviewDT",
      })
        .then((res) => {
          this.bookReviewDT=res.data.bookReviewDT;
          this.bookReviewDTUsers=res.data.bookReviewDTUser;
        })
        .catch((err) => {
          console.log(err);
        });
        this.$http({
        method: "get",
        url: "/getRecommend",
      })
        .then((res) => {
          this.books=this.res.recommend;
        })
        .catch((err) => {
          console.log(err);
        });
      },
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
  background-color:white;
}
</style>
