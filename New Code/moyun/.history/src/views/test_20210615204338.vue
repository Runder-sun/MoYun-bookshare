<template>



<body>
<v-img v:on="toHome" src="https://cdn.vuetifyjs.com/images/john.jpg"></v-img>
</body>

</template>

<script>
export default {
toHome(){
    this.$router.push({path:"/"});
}
}
</script>

<style>
.img{
    width:100%;
    height: 100%;
    background: url(00e6ff.png);
    background-size: cover;
    }        

</style>