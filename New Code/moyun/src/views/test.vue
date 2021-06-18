<template>
    <v-main>
        <v-btn @click="downlowd">
            下载
        </v-btn>
    </v-main>
</template>

<script>
export default({
    methods: {
        downlowd(){
            window.open("http://39.105.38.175/download/bushu.pdf")
        }
    }
})
</script>
