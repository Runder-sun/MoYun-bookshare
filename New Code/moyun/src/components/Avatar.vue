<template>
  <v-menu bottom min-width="200px" round offset-y>
    <template v-slot:activator="{ on }">
      <v-btn icon v-on="on">
        <v-avatar color="brown" size="40">
          <span class="white--text headline">{{ Z }}</span>
        </v-avatar>
      </v-btn>
    </template>
    <v-card>
      <v-list-item-content class="justify-center">
        <div class="mx-auto text-center">
          <v-avatar color="brown">
            <span class="white--text headline">{{ 1 }}</span>
          </v-avatar>
          <h3>{{ Z }}</h3>
          <p class="caption mt-1">
            {{ Z }}
          </p>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text> 个人主页 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text> 消息 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text> 日志 </v-btn>
          <v-divider class="my-3"></v-divider>
          <v-btn depressed rounded text> 退出登录 </v-btn>
        </div>
      </v-list-item-content>
    </v-card>
  </v-menu>
</template>
