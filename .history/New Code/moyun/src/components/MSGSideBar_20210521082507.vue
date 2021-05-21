<template>
      <v-navigation-drawer
        floating
        permanent
      >
        <v-list
          dense
          rounded
        >
          <v-list-item
            v-for="item in items"
            :key="item.title"
            link
          >
            <v-col>
            <v-row>
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
</template>

<script>
  export default {
    data: () =>({
        items: [
          { title: 'Friends', icon: 'mdi-message-text' },
          { title: 'System', icon: 'mdi-view-dashboard'  },
          { title: 'Recommendations',icon: 'mdi-heart' },
        ],
    }),
  }
</script>

