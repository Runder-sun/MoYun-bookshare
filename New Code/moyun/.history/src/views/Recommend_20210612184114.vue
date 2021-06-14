<template>
  <v-app class="rec">
    
    
      <v-row>
      <sideBar></sideBar>
      <v-container class="pa-4 text-center" style="margin-top:80px" color="transparent" justify="space-around" width="1300px" height="1000px" rounded>
            <v-container class="pa-4 text-center" >
            <v-row class="fill-height" align="center" justify="center">
              <template v-for="(book, i) in books">
                <v-col :key="i" cols="12" md="3" >
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      width="250px"
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
            </v-row>
          </v-container>
    </v-container>
    </v-row>
    
  </v-app>
</template>


<script>

import sideBar from"../components/MSGSideBar.vue";
  export default {
    data: () => ({
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
      {
        title: "Little Prince",
        text: "Ambient Bass",
        subtext: "An adventure and a love scene",
        img: "https://cdn.vuetifyjs.com/images/cards/server-room.jpg",
      },
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
    ]
    }),
    components:{
     sideBar,
    },

    created(){
      this.showRec();
    },

    methods :{
      showRec(){
        this.$http({
          method: "get",
          url:""
        })
      }
        },
  }
</script>

              
<style scoped>
.rec{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>   