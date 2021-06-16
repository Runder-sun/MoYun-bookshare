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
                <v-list-item-icon>
                  <v-icon>{{ item.icon }}</v-icon>
                </v-list-item-icon>

                <v-list-item-content>
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-navigation-drawer>
    </template>

<script>
  export default {
       data: () => ({
      items: [
      { title: 'Friends',
       icon: 'question_answer' },
      { title: 'Home',
       icon: 'dashboard' },
       { title: 'Recommendations',
       icon: 'heart' },
      ],
      }),

    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
