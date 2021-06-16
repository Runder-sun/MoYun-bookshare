<template>
<div>
    <p class="g-word">Header</p>
<p class="g-img">IMG1</p>
<p class="g-word">Content1</p>
<p class="g-img">IMG2</p>
<p class="g-word">Content2</p>
<p class="g-img">IMG3</p>
<p class="g-word">Footer</p>
</div>

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

p {
    height: 100vh;
    text-align: center;
}
 
.g-img {
    background-image: url('../assets/UpdatesB3.jpg');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
}        

</style>