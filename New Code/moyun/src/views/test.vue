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
            window.open("http://39.105.38.175/images/011923e7-09a8-42a8-9c0c-85a7322dfbc4images.jpg")
        }
    }
})
</script>
