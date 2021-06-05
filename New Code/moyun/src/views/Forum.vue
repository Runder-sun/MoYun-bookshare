<template>
  <div class="forum">
    <bar></bar>
    <v-container>
      <v-card>
        <v-expansion-panels v-model="panel" focusable multiple>
          <v-expansion-panel v-for="(item, i) in forums" :key="i">
            <v-expansion-panel-header>{{
              item.title
            }}</v-expansion-panel-header>
            <v-expansion-panel-content>
              {{ item.text }}
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-card>
      <v-card>
          <v-container fluid>
        <v-text-field required label="题目"></v-text-field>
        <v-textarea color="teal">
          <template v-slot:label>
            <div>内容</div>
          </template>
        </v-textarea>
          </v-container>
          <v-card-action>
              <v-spacer></v-spacer>
              <v-btn text color="cyan">提交</v-btn>
          </v-card-action>
      </v-card>
    </v-container>
  </div>
</template>

<script>
import bar from "../components/Bar.vue";
export default {
    methods: {
        create(){
        this.panel=[...Array(this.forums).keys()].map((k, i) => i)
    },
    },
    
  data: () => ({
      panel:[],
    forums: [
      {
        title: "讨论1",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论2",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论3",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论4",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论5",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论6",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论7",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
      {
        title: "讨论8",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
      },
    ],
  }),
  components: {
    bar,
  },
};
</script>
