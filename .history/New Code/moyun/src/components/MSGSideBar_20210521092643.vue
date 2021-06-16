<template>
<v-app class="left">
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
            v-for="item in items"
            :key="item.title"
            link
            @click="jump('',`${items.type}`)"
          >
            <v-col>
            <v-row style="margin-bottom:15px; margin-top:10px;" align="center">
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
            </v-row>
            <v-divider></v-divider>
            </v-col>
          </v-list-item>

        </v-list>
      </v-navigation-drawer>
      </v-app>
</template>

<script>
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
      jump(index,type){
				if(type=='fri'){

					this.$router.push('/MessageListFromFriend');  
				}else if(type=='sys'){
					this.$router.push('/MessageListFromSystem');
				}else if(type=='rec'){
					this.$router.push('/recommend');
				}
			},

      toFriend(){
        this.$router.push({path:"/MessageListFromFriend"});
      },
      toSystem(){
        this.$router.push({path:"/MessageListFromSystem"});
      },
      toRec(){
        this.$router.push({path:"/recommend"});
      }
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
