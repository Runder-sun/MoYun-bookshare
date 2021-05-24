<template>
  <div class="groupIndex">
    <bar></bar>
    <v-navigation-drawer v-model="drawer" absolute bottom temporary right>
      <v-list nav dense two-lines>
        <v-chip-group column>
          <v-chip class="ma-2" close label text-color="white">
            <v-avatar left size="10" color="grey"> </v-avatar>
            赵阳
            <v-spacer></v-spacer>
            <v-btn text color="cyan"> 同意</v-btn>
          </v-chip>
          <v-chip class="ma-2" close label text-color="white">
            <v-avatar left size="10" color="grey"> </v-avatar>
            赵阳
            <v-btn text color="cyan"> 同意</v-btn>
          </v-chip>
        </v-chip-group>
        <v-divider></v-divider>
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item v-for="(item, i) in items" :key="i">
            <v-list-item-avatar>
              <v-icon v-text="item.icon"></v-icon>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

      <v-container>
        <v-card class="mx-auto" outlined>
          <v-toolbar>
            <v-toolbar-title>圈子主页</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn icon @click.stop="drawer = !drawer">
              <v-icon>mdi-account-details</v-icon>
            </v-btn>
          </v-toolbar>

          <v-list-item three-line>
            <v-list-item-avatar
              left
              size="200"
              color="grey"
            ></v-list-item-avatar>
            <v-list-item-content>
              <div class="headline mb-4">这是圈子名称</div>
              <v-list-item-title> 这是圈子导师 </v-list-item-title>
              <v-list-item-subtitle>这是圈子简介</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-card-actions> </v-card-actions>
        </v-card>

        <v-card>
            <v-card-title >任务版</v-card-title>
            <v-simple-table>
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">
            Name
          </th>
          <th class="text-left">
            Calories
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="item in desserts"
          :key="item.name"
        >
          <td>{{ item.name }}</td>
          <td>{{ item.calories }}</td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
        </v-card>

        <v-card>
            <v-toolbar>
                <v-toolbar-title>热门讨论</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn color="cyan" href="/Group/Forum/ForumHome">讨论区</v-btn>
                </v-toolbar>
                <v-card flat>
                <v-container class="pa-4 text-center">
            <v-row class="fill-height" align="center" justify="center">
              <template v-for="(group, i) in groups">
                <v-col :key="i" cols="auto"  >
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 24 : 2"
                      :class="{ 'on-hover': hover }"
                      
                      height=60px
                    >
                      <v-img :src="group.img" height="60px">
                        <v-card-title class="title white--text">
                          <v-row
                            class="fill-height flex-column"
                            justify="space-between"
                          >
                            <p class="mt-4 subheading text-left">
                              {{ group.title }}
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
                                {{ group.text }}
                              </p>
                              <p
                                class="
                                  caption
                                  font-weight-medium font-italic
                                  text-left
                                "
                              >
                                {{ group.subtext }}
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
                </v-card>
            
        </v-card>
      </v-container>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
  data: () => ({
    drawer: false,
    group: null,
    groups: [
      {
        title: "Rock",
        text: "Greatest Rock Hits",
        subtext: "Lose yourself in rock tunes.",
        img: "https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
      {
        title: "Mellow Moods",
        text: "Ambient Bass",
        subtext: "Chill beats to mellow you out.",
        img: "https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80",
      },
    ],
    items: [
      {
        icon: "mdi-inbox",
        text: "Inbox",
      },
      {
        icon: "mdi-star",
        text: "Star",
      },
      {
        icon: "mdi-send",
        text: "Send",
      },
      {
        icon: "mdi-email-open",
        text: "Drafts",
      },
    ],
    desserts: [
          {
            name: 'Frozen Yogurt',
            calories: 159,
          },
          {
            name: 'Ice cream sandwich',
            calories: 237,
          },
          {
            name: 'Eclair',
            calories: 262,
          },
          {
            name: 'Cupcake',
            calories: 305,
          },
          {
            name: 'Gingerbread',
            calories: 356,
          },
          {
            name: 'Jelly bean',
            calories: 375,
          },
         
        ],
    model: 1,
  }),

  watch: {
    group() {
      this.drawer = false;
    },
  },
  components: {
    bar,
  },
};
</script>
