<template>
<v-app 
  app
  class="left">
      <bar></bar>
      <v-navigation-drawer
        floating
        permanent
        max-width=10%
      elevate-on-scroll
      >
        <v-list
          dense
          rounded
        >
          <v-list-item
            link
            v-on:click="toSystem"
            style="margin-top:50px;"
          >
            <v-col >
            <v-row style="margin-bottom:15px; " align="center">
            <v-list-item-icon>
              <v-icon>mdi-message-text</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Friends</v-list-item-title>
            </v-list-item-content>
            </v-row>
            <v-divider></v-divider>
            </v-col>
          </v-list-item>

          <v-list-item
            link
            @click="toFriend"
          >
            <v-col>
            <v-row style="margin-bottom:15px; margin-top:10px;" align="center">
            <v-list-item-icon>
              <v-icon>mdi-view-dashboard</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>System</v-list-item-title>
            </v-list-item-content>
            </v-row>
            <v-divider></v-divider>
            </v-col>
          </v-list-item>

          <v-list-item
            link
            @click="toSystem"
          >
            <v-col>
            <v-row style="margin-bottom:15px; margin-top:10px;" align="center">
            <v-list-item-icon>
              <v-icon>mdi-heart</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Recommendations</v-list-item-title>
            </v-list-item-content>
            </v-row>
            <v-divider></v-divider>
            </v-col>
          </v-list-item>
         <router-view />
        </v-list>
      </v-navigation-drawer>
      </v-app>
</template>

<script>
import bar from"../components/Bar";
  export default {
    data: () =>({
        items: [
          { title: 'Friends', 
          icon: 'mdi-message-text',
          type:'fri' },
          { title: 'System',
           icon: 'mdi-view-dashboard',
           type:'sys' },
          { title: 'Recommendations',
          icon: 'mdi-heart',
          type:'rec'
          },
        ],
    }),
    method:{
      jump(type){
				if(type=='fri'){

					this.$router.push('/MessageListFromFriend');  
				}else if(type=='sys'){
					this.$router.push('/MessageListFromSystem');
				}else if(type=='rec'){
					this.$router.push('/recommend');
				}
			},
      toFriend(){
        this.$router.push({path:"/messageListFromFriend"});
      },
      toSystem(){
        this.$router.push({path:"/messageListFromSystem"});
      },
      toRec(){
        this.$router.push({path:"/recommend"});
      }
  },
  components:{
    bar,
  }
}
</script>


<style lang="scss" scoped>
.left{
    width: 250px;
    height: 100%;
    z-index: 100;
    display: flex;
    background-color:honeydew;
    box-shadow: 5px 0 8px -4px #000;
    }
 
 
</style>
