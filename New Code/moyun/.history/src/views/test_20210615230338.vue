<template>



<body>
<v-img @click="toHome" :src="require('@/assets/墨韵.jpg')" ></v-img>
</body>

</template>

<script>
export default {
methods:{
    toHome(){
    this.$router.push({path:"/"});
}
}
}
</script>

<style>
.v-img{
    width:100%;
    height: 100%;
    background-size: cover;
    }        

</style>