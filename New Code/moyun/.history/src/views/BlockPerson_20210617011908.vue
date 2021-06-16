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
                        min-height="600"
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
                        :key="selection.username"
                        class="shrink"
                        >
                        <v-chip
                            :disabled="loading"
                            close
                            @click:close="selected.splice(i, 1)"
                        >
                            <v-avatar left :src="'/images/' +selection.headImage">                                
                            </v-avatar>
                            {{ selection.username }}
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
                        :key="item.username"
                        :disabled="loading"
                        @click="selected.push(item)"
                        >
                        <v-list-item-avatar>
                            <v-img
                            :disabled="loading"
                            :src="'/images/' +item.headImage"
                            ></v-img>
                        </v-list-item-avatar>
                        <v-list-item-title v-text="item.username"></v-list-item-title>
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
                        min-height="600"
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
                        :key="selection1.username"
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
                            ref="search1"
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
                        :key="item.username"
                        :disabled="loading1"
                        @click="selected1.push(item)"
                        >
                        <v-list-item-avatar>
                            <v-img
                            :disabled="loading1"
                            :src="'/images/' +item.headImage"
                            ></v-img>
                        </v-list-item-avatar>
                        <v-list-item-title v-text="item.username"></v-list-item-title>
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
  inject: ["reload"],
  data: () => ({
    followList: [],
      blockList:[],
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

        return this.blockList.filter(item => {
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

    created(){
      this.showGuys();
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
        url: "/FollowListAndBlacklist",
      })
        .then((res) => {
          this.blockListProperty=res.data.Blacklist;
          this.blockList=res.data.BlacklistUser;
          this.followListProperty=res.data.FollowList;
          this.followList=res.data.Follow;
        })
        .catch((err) => {
          console.log(err);
        });
      },

      cancelFollow(){
        var neededID;
        for(var toCancel in this.selected){
            for(var property in this.followListProperty){
              if(property.followedID===this.toCancel.userID){
                neededID=property.followListID;
                this.$http({
                  method: "post",
                  url: "/cancelFollow",
                  data: {
                    FollowListID:neededID,
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
              if(property.banUserID===this.toCancel.userID){
                neededID=property.blackListID;
                this.$http({
                  method: "post",
                  url: "/cancelBlackList",
                  data: {
                    BlackListID:neededID,
                  },
                }).then((res) => {
                  if (res.data.success) {
                    this.reload();
                    }
                }).catch(err=>{
                  console.log(err);
                })
              }
            }
        }
      this.next1();
    },
    },

  components: {
    bar,
  },
};
</script>

<style scoped>
.block{
    	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a5d57e, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
      width:400%;
    height:400%;
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

	.card {
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		height: 500px;
		width: 600px;
		z-index: 1;
		transition: transform 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
	}

	.card .front {
		position: absolute;
		text-align: center;
		box-shadow: 12px 12px 24px rgba(0, 0, 0, 0.1),
			-12px -12px 24px rgba(255, 255, 255, 1);
		border-radius: 3rem;
		background-color: #efeeee;
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
		transition: 1s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	}

	.card .front {
		z-index: 1;
	}
</style>