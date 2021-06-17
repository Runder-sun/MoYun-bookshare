<template >
  <div class="updates">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <template class="bkColor" v-if="!this.Bookflag">
          <v-item v-for="(item, index) in blogDT" v-bind:key="index">
            <div>
              <v-hover v-slot:default="{ hover }">
                <v-card
                  class="mx-auto"
                  color="grey lighten-4"
                  dark
                  max-width="800"
                  :elevation="hover ? 16 : 4"
                  :class="{ 'on-hover': hover }"
                  :to="'/BlogList/ScanBlog/' + item.blogID"
                >
                  <v-card-title class="title font-weight-bold black--text">
                    <v-icon large left color="grey darken-2">
                      mdi-twitter
                    </v-icon>
                    {{ item.blogTitle }}
                  </v-card-title>

                  <v-card-text class="headline font-italic black--text">
                    <div class="textDisplay">{{ item.content }}</div>
                  </v-card-text>

                  <v-card-actions align="right">
                    <v-list-item class="grow">
                      <v-list-item-title
                        class="title font-weight-bold black--text"
                        >{{ blogDTUsers[index].username }}</v-list-item-title
                      >
                      <v-list-item-avatar color="grey darken-3">
                        <v-img
                          class="elevation-6"
                          :src="'/images/' + blogDTUsers[index].headImage"
                        ></v-img>
                      </v-list-item-avatar>
                    </v-list-item>
                  </v-card-actions>
                </v-card>
              </v-hover>
            </div>
          </v-item>
        </template>
        <template v-else>
          <v-item v-for="(item, index) in bookReviewDT" v-bind:key="index">
            <div>
              <v-hover v-slot:default="{ hover }">
                <v-card
                  class="mx-auto"
                  color="grey lighten-4"
                  dark
                  max-width="800"
                  :elevation="hover ? 24 : 2"
                  :class="{ 'on-hover': hover }"
                  :to="'/images/' + item.bookReviewID"
                >
                  <v-card-title class="title font-weight-bold black--text" >
                    <v-icon large left color="grey darken-2">
                      mdi-twitter
                    </v-icon>
                    {{ item.title }}
                  </v-card-title>

                  <v-card-text class="headline font-italic black--text">
                    <div class="textDisplay">{{ item.content }}</div>
                  </v-card-text>

                  <v-card-actions align="right">
                    <v-list-item class="grow">
                      <v-list-item-title
                        class="title font-weight-bold black--text"
                        >{{ bookReviewDTUsers[index].username }}</v-list-item-title
                      >
                      <v-list-item-avatar color="grey darken-3">
                        <v-img
                          class="elevation-6"
                          
                          :src="'/images/' + bookReviewDTUsers[index].headImage"
                        ></v-img>
                      </v-list-item-avatar>
                    </v-list-item>
                  </v-card-actions>
                </v-card>
              </v-hover>
            </div>
          </v-item>
        </template>

        <v-speed-dial
          fixed
          bottom
          right
          v-model="fab"
          direction="top"
          transition="slide-y-reverse-transition"
        >
          <template v-slot:activator>
            <v-btn v-model="fab" color="blue darken-2" dark fab>
              <v-icon v-if="fab"> mdi-close </v-icon>
              <v-icon v-else> mdi-plus </v-icon>
            </v-btn>
          </template>

          <v-tooltip left>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                fab
                dark
                small
                color="green"
                v-bind="attrs"
                v-on="on"
                v-on:click="changeToBlog"
              >
                <v-icon>mdi-book-account-outline</v-icon>
              </v-btn>
            </template>
            <span>Check Out Blog Updates!</span>
          </v-tooltip>

          <v-tooltip left>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                fab
                dark
                small
                color="indigo"
                v-bind="attrs"
                v-on="on"
                v-on:click="changeToBook"
              >
                <v-icon>mdi-comment-bookmark</v-icon>
              </v-btn>
            </template>
            <span>Check Out Book Review Updates!</span>
          </v-tooltip>
          <v-tooltip left>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                fab
                dark
                small
                color="red"
                v-bind="attrs"
                v-on="on"
                v-on:click="toBlock"
              >
                <v-icon>mdi-account-circle</v-icon>
              </v-btn>
            </template>
            <span>Manage Blocks And Follows!</span>
          </v-tooltip>
        </v-speed-dial>
      </v-container>
    </v-main>
  </div>
</template>

<script>
//0是bookreview 1是blog
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    Bookflag: true,
    fab: false,
    blogDT: [
      {
        blogID: 1,
        blogTitle: "Just another day in paradise",
        content: `t takes some effort to reach the stunning Nā Pali Coast on the Hawaiian island of Kauai. Located on the island's northwest side and stretching about 16 miles, Nā Pali isn't accessible by car. You have to hike in, fly in by`,
        authorID: "Jeff",
        personPhoto: "../assets/UpdatesA1",
        recentFinishTime: "2021-04-28",
        author:"Jeff",
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
      {
        blogID: 2,
        blogTitle: "Been Reading History",
        content: `Frenchman Jacques Marquette and French-Canadian Louis Jolliet set their canoes down on the river Native Americans called the "Mesipi," near what will be Prairie du Chien, Wisconsin. These early European explorers will map the huge waterway's course to within 435 miles of the Gulf of Mexico.
`,
        authorID: "Kathy",
        personPhoto: "../assets/UpdatesA1",
        recentFinishTime: "2021-04-28",
        author:"Kathy",
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
      {
        blogID: 3,
        blogTitle: "Put your flippers in the air…",
        content: `it's World Sea Turtle Day! The gentle giant seen here doing the wave was snapped mid-dive, headed to the seafloor near the Great Barrier Reef to munch some marine grass. The green sea turtle is among the larger of the seven sea turtle species, with some individuals reaching 5 feet in length and weighing 700 pounds. They live throughout the world's subtropical waters, and like other sea turtles, they migrate long distances for food. Despite all that traveling, they return to hatch their eggs on the same select nesting beaches where they were born.`,
        authorID: "Kol",
        personPhoto: "../assets/UpdatesA1",
        recentFinishTime: "2021-04-28",
        author:"Kol",
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
      {
        blogID: 4,
        blogTitle: "Thinking about life..",
        content: `Guys I'm back to Moyun now after a while of being sober!`,
        authorID: "Joe",
        personPhoto: "../assets/UpdatesA1",
        recentFinishTime: "2021-04-28",
        author:"Sik",
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
    ],
      bookReviewDT : [
      {
        bookReviewID: 1,
        title: "Great Book!",
        reviewTime:'2020-01-01',
        content: `This is a book about Jesus and how mankind react to atheism,deeply revealling the truth of religious...`,
        userID:'1',
        author:'Kathy',
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
      {
        bookReviewID: 2,
        title: "About Jimmy Carter",
        reviewTime:'2020-01-01',
        content: `Kai Bird’s “The Outlier” takes a close look at the Carter administration and concludes that the 39th president deserves a better reputation.`,
        userID:'1',
        author:'Vince',
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
      {
        bookReviewID: 3,
        title: "Civil war legend!",
        reviewTime:'2020-01-01',
        content: `Set in the Deep South just after the war, “The Sweetness of Water,” by Nathan Harris, includes death and violence. But its plotlines suggest a vision of race and sexual relations rarely depicted in fiction about the period.`,
        userID:'1',
        author:'Cardi',
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
      {
        bookReviewID: 4,
        title: "A book about Heart and devotion",
        reviewTime:'2020-01-01',
        content: `And whom would you trust along the way? These questions are the foundation of Caitlin Wahrer’s suspense novel, “The Damage.”`,
        userID:'1',
        author:'Jeff',
        authorImage:"https://cdn.vuetifyjs.com/images/john.jpg"
      },
    ],

    blogDTUsers:[{
      userID:1,
      username:"Jeff",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },{
      userID:2,
      username:"Tay",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },{
      userID:3,
      username:"Ann",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },{
      userID:4,
      username:"Vincent",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },],
    bookReviewDTUsers:[{
      userID:1,
      username:"Jeff",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },{
      userID:2,
      username:"Tay",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },{
      userID:3,
      username:"Ann",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },{
      userID:4,
      username:"Vincent",
      headImage:"https://cdn.vuetifyjs.com/images/john.jpg"
    },],
  }),
  components: {
    bar,
  },

  created: function () {
    this.showUpdates();
    this.showRW();
  },
  methods: {
    changeToBook() {
      this.Bookflag = true;
    },
    changeToBlog() {
      this.Bookflag = false;
    },
    toBlock() {
      this.$router.push({ path: "/updates/block" });
    },
    like(news) {
      news.likes++;
      news.myLike = true;
    },
    unlike(news) {
      news.likes--;
      news.myLike = false;
    },
    showUpdates() {
      this.$http({
        method: "get",
        url: "/blogDT",
      })
        .then((res) => {
          console.log(res.data);
          this.blogDT = res.data.blogDT;
          this.blogDTUsers = res.data.blogDTUser;
          console.log(this.blogDTUsers);
        })
        .catch((err) => {
          console.log(err);
        });

//      for (var blog in this.blogDT) {
//        for (var user in this.blogDTUsers) {
//          if (blog.authorID === user.userID) {
//            blog.append(author, user.username);
//            blog.append(authorImage, user.headImage);
//          }
//        }
//      }
      console.log(this.blogDT);
    },
    showRW() {
      this.$http({
        method: "get",
        url: "/bookReviewDT",
      })
        .then((res) => {
          console.log(res.data);
          this.bookReviewDT = res.data.bookReviewDT;
          this.bookReviewDTUsers = res.data.bookReviewDTUser;
        })
        .catch((err) => {
          console.log(err);
        });
//      for (var rw in this.bookReviewDT) {
//        for (var user in this.bookReviewDT) {
//          if (rw.userID === user.userID) {
//            rw.append(author, user.username);
//            rw.append(authorImage, user.headImage);
//          }
//        }
//      }
      console.log(this.bookReviewDT);
    },
  },
};
</script>

<style scoped>
.updates {
  background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
  background-size: 400% 400%;
  animation: gradient 15s ease infinite;
  width:100%;
  height:100%;
}

@keyframes gradient {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

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

.bkColor {
  background-color: transparent;
}

.textDisplay {
  overflow: hidden;
  -webkit-line-clamp: 2;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
}
</style>
