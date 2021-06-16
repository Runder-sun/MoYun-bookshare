<template>
<div>
    <h1 class="g-word">Header</h1>
<h1 class="g-img">IMG1</h1>
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

h1 {
    text-align: center;
    margin:0 auto;
    font-size: 80px;
    line-height:60vh;
    font-family: "微雅软黑";
    color: #000;
}
 
p {
    height: 100vh;
    text-align: center;
    margin:auto;
    padding-top: 40%;
    padding-bottom: 40%;
}
 
.g-img {
    background-image: url('../assets/UpdatesB3.jpg');
    background-attachment: fixed;
    background-size: cover;
    background-position: center center;
}        

</style>