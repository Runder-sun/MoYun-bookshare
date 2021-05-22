<template>
  <div class="friMsg">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">
          <v-col class="fill-height flex-column box" align="center" justify="space-between">
            <template>
            <v-card
                max-width="450"
                class="mx-auto"
            >
                <v-toolbar
                color="cyan"
                dark
                >
                <v-app-bar-nav-icon></v-app-bar-nav-icon>

                <v-toolbar-title>Inbox</v-toolbar-title>

                <v-spacer></v-spacer>

                <v-btn icon>
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>
                </v-toolbar>

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
    setup() {
        
    },
    components:{
        bar,
    },
    methods:{

    },
}
</script>
              
<style scoped>
.friMsg{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;
}
</style>              
