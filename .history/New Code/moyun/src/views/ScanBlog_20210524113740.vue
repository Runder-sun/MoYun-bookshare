<template>
    <div class="ScanBlog">
        <v-app>
        <bar></bar>
        <v-container>
            <template>
            <v-card
                :loading="loading"
                class="mx-auto my-12"
                width="1200"
                min-height="1200"
                center
                elevation="24"
            >
                <v-card-title center>{{title}}</v-card-title>

                <v-card-text right>
                <v-row
                align="center"
                class="mx-0">
                <div class="my-4 subtitle-1 text-center">{{author}}</div>    
                <div class="my-4 subtitle-1 text-right">{{date}}</div>
                </v-row>
                </v-card-text>
                <v-divider class="mx-4"></v-divider>
                <v-card-title>Content</v-card-title>
                <v-card-text>
                    <div>{{content}}</div>
                </v-card-text>
                </v-card>
            </template>
        </v-container>
        </v-app>
        </div>
</template>

<script>
import bar from "../components/Bar.vue"
export default({
    data: () => ({
        title:"Blog4Test",
        date:"2020-12-25",
        author:"Jackson",
        content:"This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.vThis is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages.This is a test blog 4 testing vue pages."
    }),
    components:{
        bar,
    },
})
</script>

<style scope>
.ScanBlog{
    background:url("../assets/widthPic.jpg");
    width:100%;
    height:100%;
    background-size:100% 100%;};
</style>