<template>
    <div class="ScanBlog">
        <v-app>
        <bar></bar>
        <v-container>
            <v-speed-dial
                    absolute
                    fixed
                    v-model="fab"
                    :direction="direction"
                    :open-on-hover="hover"
                    :transition="transition"
                    >
                    <template v-slot:activator>
                        <v-btn
                        v-model="fab"
                        color="blue darken-2"
                        dark
                        fab
                        >
                        <v-icon v-if="fab">mdi-close</v-icon>
                        <v-icon v-else>mdi-account-circle</v-icon>
                        </v-btn>
                    </template>
                    <v-btn
                        fab
                        dark
                        small
                        color="green"
                    >
                        <v-icon>mdi-pencil</v-icon>
                    </v-btn>
                    <v-btn
                        fab
                        dark
                        small
                        color="indigo"
                    >
                        <v-icon>mdi-plus</v-icon>
                    </v-btn>
                    <v-btn
                        fab
                        dark
                        small
                        color="red"
                    >
                    <v-icon>mdi-delete</v-icon>
                </v-btn>
            </v-speed-dial>
            <template>
            <v-card
                :loading="loading"
                class="mx-auto my-12"
                width="1400"
                min-height="1000"
                center
                elevation="24"
            >
                <v-card-title center>{{title}}</v-card-title>
                <v-card-text right>
                <v-row
                align="center"
                class="mx-0">
                <div class="my-4 subtitle-1 text-center">{{author}}</div>    
                <div class="my-4 subtitle-1 text-right">{{date}}</div>
                </v-row>
                </v-card-text>
                <v-divider class="mx-4"></v-divider>
                <v-card-title>Content</v-card-title>
                <v-card-text>
                    <div>{{content}}</div>
                </v-card-text>                                   
                </v-card>
            </template>           
        </v-container>
        
        </v-app>
        </div>
</template>

<script>
import bar from "../components/Bar.vue"
export default({
    data: () => ({
        direction: 'bottom',
        fab: false,
        fling: false,
        hover: false,
        tabs: null,
        transition: 'slide-y-reverse-transition',
        title:"Blog4Test",
        date:"2020-12-25",
        author:"Jackson",
        content:"This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages."
    }),
    components:{
        bar,
    },
    computed: {
      activeFab () {
        switch (this.tabs) {
          case 'one': return { class: 'purple', icon: 'account_circle' }
          case 'two': return { class: 'red', icon: 'edit' }
          case 'three': return { class: 'green', icon: 'keyboard_arrow_up' }
          default: return {}
        }
      },
    },
})
</script>

<style scope>
.ScanBlog{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};

  .v-speed-dial {
    position: absolute;
  }

  .v-btn--floating {
    position: relative;
  }    
</style>