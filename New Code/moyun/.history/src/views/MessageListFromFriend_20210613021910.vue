<template>
  <div class="friMsg">
    <template>
      <v-app 
        app>
            <v-navigation-drawer
              class="left"
              floating
              permanent
            elevate-on-scroll
              expand-on-hover
            >
                        <bar></bar>
              <v-list
                :default-active="activeIndex"
                dense
                rounded
                align="center"
                justify="center"
                height=50%
              >
                <v-list-item
                style="margin-top:200px;"
                @click="toFriend"
                class="px-2"
                >

                  <v-list-item-icon >
                    <v-icon>mdi-message-text</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title class="font-italic">Friends</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-list-item
                  link
                  @click="toSystem"
                  class="px-2"
                  style="margin-top:200px"
                >
                  <v-list-item-icon >
                    <v-icon>mdi-view-dashboard</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title class="font-italic">System</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              <router-view />
              </v-list>
            </v-navigation-drawer>
              <v-content>
                <v-container fluid class="pa-4 text-center" direction="horizontal">
                  <v-row>
                    <v-card
                          max-width="1000"
                          class="mx-auto"
                          style="margin-top:50px"
                      >
                          <v-list three-line>
                          <template v-for="(item, index) in items">
                              <v-subheader
                              v-if="item.header"
                              :key="item.header"
                              v-text="item.header"
                              ></v-subheader>

                              <v-divider
                              v-else-if="item.divider"
                              :key="index"
                              :inset="item.inset"
                              ></v-divider>

                              <v-list-item
                              v-else
                              :key="item.title"
                              @click="toMsg"
                              >
                              <v-list-item-avatar>
                                  <v-img :src="item.avatar"></v-img>
                              </v-list-item-avatar>

                              <v-list-item-content>
                                  <v-list-item-title v-html="item.title"></v-list-item-title>
                                  <v-list-item-subtitle v-html="item.subtitle"></v-list-item-subtitle>
                              </v-list-item-content>
                              </v-list-item>
                          </template>
                          </v-list>
                      </v-card> 
                    </v-row>
              </v-container>     
            </v-content>
        </v-app>
      </template>
     
  </div>
</template>

<script>
import bar from"../components/Bar.vue";
  export default {
    data: () => ({
      friends: [
        { header: 'Today' },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          title: 'Brunch this weekend?',
          subtitle: "<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
          subtitle: "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: 'Oui oui',
          subtitle: "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: 'Birthday gift',
          subtitle: "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: 'Recipe to try',
          subtitle: "<span class='text--primary'>Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
        },
      ],

          system : [
        { header: 'Today' },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          title: 'Brunch this weekend?',
          subtitle: "<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: 'Summer BBQ <span class="grey--text text--lighten-1">4</span>',
          subtitle: "<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: 'Oui oui',
          subtitle: "<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: 'Birthday gift',
          subtitle: "<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?",
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: 'Recipe to try',
          subtitle: "<span class='text--primary'>Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
        },
      ],
    }),
    components:{
       bar,
    },

    created(){
      this.showFriMsg;
    },

    methods :{
        toMsg(){
            this.$router.push({path:"/message"});
          },
        },
        showFriMsg(){
          this.$http({
            method: "get",
            url: "/Home",
          })
            .then((res) => {
              this.books = res.data.hotBook;
              this.groups = res.data.hotGroup;
            })
            .catch((err) => {
              console.log(err);
        });
        }
  }
</script>

              
<style scoped>
.friMsg{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>   

