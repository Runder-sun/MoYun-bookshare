<template>
<v-app 
  app
  class="left">
      <bar></bar>
      <v-navigation-drawer
  
        floating
        permanent
      elevate-on-scroll
        expand-on-hover
      >
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
            style="margin-top:15px"
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
    methods :{
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
  },
  components:{
    bar,
  }
}
</script>


<style lang="scss" scoped>
.left{
    height: 100%;
    z-index: 100;
    display: flex;
    background-color:rgb(220, 228, 220);
    box-shadow: 5px 0 8px -4px #000;
    }
 
 
</style>
