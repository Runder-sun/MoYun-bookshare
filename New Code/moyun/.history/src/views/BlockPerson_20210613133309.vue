<template>
  <div class="block">
    <bar></bar>
    <v-main>
      <v-container fluid>
        <v-container class="pa-4 text-center">
          <v-row class="fill-height flex-row box" align="center" justify="space-around">
            <template>
                <div>
                    <v-hover v-slot:default="{ hover }">
                    <template>
                    <v-card
                        class="mx-auto"
                        width="500"
                        max-height="30000"
                        :elevation="hover ? 12 : 2"
                        :class="{ 'on-hover': hover }"
                    >
                    <v-toolbar
                    flat
                    color="transparent"
                    >
                    <v-app-bar-nav-icon></v-app-bar-nav-icon>
                    <v-toolbar-title>Follow List</v-toolbar-title>
                    <v-spacer></v-spacer>
                    <v-btn
                    icon
                    @click="$refs.search.focus()"
                    >
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>
                    </v-toolbar>

                    <v-container class="py-0">
                    <v-row
                        align="center"
                        justify="start"
                    >
                        <v-col
                        v-for="(selection, i) in selections"
                        :key="selection.name"
                        class="shrink"
                        >
                        <v-chip
                            :disabled="loading"
                            close
                            @click:close="selected.splice(i, 1)"
                        >
                            <v-avatar left src="https://cdn.vuetifyjs.com/images/john.jpg">                                
                            </v-avatar>
                            {{ selection.name }}
                        </v-chip>
                        </v-col>

                        <v-col v-if="!allSelected" cols="12">
                        <v-text-field
                            ref="search"
                            v-model="search"
                            full-width
                            hide-details
                            label="Search"
                            single-line
                        ></v-text-field>
                        </v-col>
                    </v-row>
                    </v-container>

                    <v-divider v-if="!allSelected"></v-divider>

                    <v-list>
                    <template v-for="item in categories">
                        <v-list-item
                        v-if="!selected.includes(item)"
                        :key="item.name"
                        :disabled="loading"
                        @click="selected.push(item)"
                        >
                        <v-list-item-avatar>
                            <v-img
                            :disabled="loading"
                            src="https://cdn.vuetifyjs.com/images/john.jpg"
                            ></v-img>
                        </v-list-item-avatar>
                        <v-list-item-title v-text="item.name"></v-list-item-title>
                        </v-list-item>
                    </template>
                    </v-list>

                    <v-divider></v-divider>

                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                        :disabled="!selected.length"
                        :loading="loading"
                        color="purple"
                        text
                        @click="cancelFollow"
                    >Unfollow</v-btn>
                    </v-card-actions>
                    </v-card>
                    </template>
                </v-hover>
                </div>
            </template>   

            <template>
                    <div>
                    <v-hover v-slot:default="{ hover }">
                    <template>
                    <v-card
                        class="mx-auto"
                        width="500"
                        :elevation="hover ? 12 : 2"
                        :class="{ 'on-hover': hover }"
                    >
                    <v-toolbar
                    flat
                    color="transparent"
                    >
                    <v-app-bar-nav-icon></v-app-bar-nav-icon>
                    <v-toolbar-title>Block List</v-toolbar-title>
                    <v-spacer></v-spacer>
                    <v-btn
                    icon
                    @click="$refs.search.focus()"
                    >
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>
                    </v-toolbar>

                    <v-container class="py-0">
                    <v-row
                        align="center"
                        justify="start"
                    >
                        <v-col
                        v-for="(selection1, i) in selections1"
                        :key="selection1.name"
                        class="shrink"
                        >
                        <v-chip
                            :disabled="loading1"
                            close
                            @click:close="selected1.splice(i, 1)"
                        >
                            <v-avatar left src="https://cdn.vuetifyjs.com/images/john.jpg">                                
                            </v-avatar>
                            {{ selection1.name }}
                        </v-chip>
                        </v-col>

                        <v-col v-if="!allSelected1" cols="12">
                        <v-text-field
                            ref="search"
                            v-model="search1"
                            full-width
                            hide-details
                            label="Search"
                            single-line
                        ></v-text-field>
                        </v-col>
                    </v-row>
                    </v-container>

                    <v-divider v-if="!allSelected1"></v-divider>

                    <v-list>
                    <template v-for="item in categories1">
                        <v-list-item
                        v-if="!selected1.includes(item)"
                        :key="item.name"
                        :disabled="loading1"
                        @click="selected1.push(item)"
                        >
                        <v-list-item-avatar>
                            <v-img
                            :disabled="loading1"
                            src="https://cdn.vuetifyjs.com/images/john.jpg"
                            ></v-img>
                        </v-list-item-avatar>
                        <v-list-item-title v-text="item.name"></v-list-item-title>
                        </v-list-item>
                    </template>
                    </v-list>

                    <v-divider></v-divider>

                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                        :disabled="!selected1.length"
                        :loading1="loading1"
                        color="purple"
                        text
                        @click="cancelBlack"
                    >Unblock</v-btn>
                    </v-card-actions>
                    </v-card>
                    </template>
                </v-hover>
                </div>
            </template>

          </v-row>
        </v-container>          
      </v-container>
    </v-main>
  </div>
</template>              


<script>
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    followList: [
      {
        id: 1,
        name: "Jeff",
        personPhoto: "../assets/UpdatesA1",
      },
      {
        id: 2,
        name: "Kitty",
        personPhoto: "../assets/UpdatesA2",
      },
      {
        id: 3,
        name: "Ken",
        personPhoto: "../assets/UpdatesA3",
      },
      {
        id: 1,
        name: "Jeffie",
        personPhoto: "../assets/UpdatesA1",
      },
      {
        id: 2,
        name: "Kitten",
        personPhoto: "../assets/UpdatesA2",
      },
      {
        id: 3,
        name: "Kenny",
        personPhoto: "../assets/UpdatesA3",
      },],
      blockList:[{
        id: 4,
        name: "Micki",
        personPhoto: "../assets/UpdatesB1",
      },
      {
        id: 5,
        name: "Kol",
        personPhoto: "../assets/UpdatesB2",
      },
      {
        id: 6,
        name: "Kathy",
        personPhoto: "../assets/UpdatesB3",
      },
      {
        id: 4,
        name: "Mickin",
        personPhoto: "../assets/UpdatesB1",
      },
      {
        id: 5,
        name: "Kolin",
        personPhoto: "../assets/UpdatesB2",
      },
      {
        id: 6,
        name: "Kath",
        personPhoto: "../assets/UpdatesB3",
      },
    ],
    loading: false,
    loading1: false,
    search: '',
    selected: [],
    selected1: [],
    search1: '',
    blockListProperty:[],
    followListProperty:[],
    }),

    computed: {
      allSelected () {
        return this.selected.length === this.followList.length
      },
      categories () {
        const search = this.search.toLowerCase()

        if (!search) return this.followList

        return this.followList.filter(item => {
          const text = item.name.toLowerCase()

          return text.indexOf(search) > -1
        })
      },
      allSelected1 () {
        return this.selected1.length === this.blockList.length
      },
      categories1 () {
        const search1 = this.search1.toLowerCase()

        if (!search1) return this.blockList

        return this.blocksList.filter(item => {
          const text = item.name.toLowerCase()

          return text.indexOf(search1) > -1
        })
      },
      selections1 () {
        const selections1 = []

        for (const selection1 of this.selected1) {
          selections1.push(selection1)
        }

        return selections1
      },
      selections () {
        const selections = []

        for (const selection of this.selected) {
          selections.push(selection)
        }

        return selections
      },
    },

    watch: {
      selected () {
        this.search = ''
      },
      selected1 () {
        this.search1 = ''
      },
    },

    methods: {
      next () {
        this.loading = true

        setTimeout(() => {
          this.search = ''
          this.selected = []
          this.loading = false
        }, 2000)
      },
      next1 () {
        this.loading1 = true

        setTimeout(() => {
          this.search1 = ''
          this.selected1 = []
          this.loading1 = false
        }, 2000)
      },
      showGuys(){
        this.$http({
        method: "get",
        url: "/followListAndBalcklist",
      })
        .then((res) => {
          this.blockListProperty=res.data.blacklist;
          this.blockList=res.data.blacklistUser;
          this.followListProperty=res.data.followList;
          this.followList=res.data.follow;
        })
        .catch((err) => {
          console.log(err);
        });
      },
      cancelFollow(id){
        var neededID;
        for(var toCancel in this.selected){
            for(var property in this.followListProperty){
              if(property.followedID===this.selected.uid){
                neededID=property.followListID;
                this.$http({
                  method: "post",
                  url: "/cancelFollow",
                  data: {
                    followListID:neededID,
                  },
                }).then((res) => {
                  if (res.data.success===1) {
                    }
                }).catch(err=>{
                  console.log(err);
                })
              }
            }
        }
      this.next();
      },

      cancelBlack(){
         var neededID;
        for(var toCancel in this.selected1){
            for(var property in this.blockListProperty){
              if(property.banUserID===this.selected1.uid){
                neededID=property.blackListID;
                this.$http({
                  method: "post",
                  url: "/cancelBlackList",
                  data: {
                    blackListID:neededID,
                  },
                }).then((res) => {
                  if (res.data.success===1) {
                    }
                }).catch(err=>{
                  console.log(err);
                })
              }
            }
        }
      this.next1();
    },

  components: {
    bar,
  },
};
</script>

<style scoped>
.block{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;
}
</style>