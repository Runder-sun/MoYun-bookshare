<template>
    <div class="BlogList">
    <v-app>
        <bar></bar>  
            <v-toolbar-title font-weight-bold diection="horizontal">日志列表

            <v-spacer></v-spacer>

            <v-btn text color="cyan" href="/BlogList/PersonalCollection" font-weight-bold> 查看日志收藏 </v-btn>

            <v-btn text color="teal" href="/BlogList/WriteBlog" font-weight-bold> 发表日志 </v-btn>
            </v-toolbar-title>
                <v-card class="overflow-hidden">
                <v-app-bar
                absolute
                color="white"
                elevate-on-scroll
                scroll-target="#scrolling-techniques-7"
                >
                <v-app-bar-nav-icon></v-app-bar-nav-icon>

                <v-toolbar-title>我的日志</v-toolbar-title>

                <v-spacer></v-spacer>

                <v-btn icon>
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>

                <v-btn icon>
                    <v-icon>mdi-heart</v-icon>
                </v-btn>

                <v-btn icon>
                    <v-icon>mdi-dots-vertical</v-icon>
                </v-btn>
                </v-app-bar>
                <v-sheet
                id="scrolling-techniques-7"
                class="overflow-y-auto"
                max-height="600"
                >
                <v-container style="height: 1500px;">
                </v-container>
                </v-sheet>
                
            </v-card>

    </v-app>
    </div>
</template>

<script>
import bar from "../components/Bar.vue"

export default({
    setup() {
        
    },
    components:{
    bar,
},
})


</script>

<style scoped>
</style>
