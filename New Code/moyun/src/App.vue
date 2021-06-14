<template>
  <v-app>
    <v-main>
      <router-view v-if="isRouterAlive"></router-view>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "App",
  provide() {
    return {
      reload: this.reload,
    };
  },
  data() {
    return {
      isRouterAlive: true,
    };
  },
  methods: {
    reload() {
      this.isRouterAlive = false;
      this.$nextTick(function () {
        this.isRouterAlive = true;
      });
    },
  },


};
</script>
