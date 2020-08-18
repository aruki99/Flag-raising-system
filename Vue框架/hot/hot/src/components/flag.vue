<template>

  <div>
<!--    <a @click="next">升旗活动</a>-->
    <router-link to="raiseFlag" id="list2">升旗活动</router-link>
    <div id="bt">东莞理工学院城市学院</div>
    <img src="static/img/bj6.jpg" id="bj6" alt="">
    <img src="static/img/cxw1.png" id="cxw1" alt="">
    <img src="static/img/cxw2.png" id="cxw2" alt="">
    <img src="static/img/cxw3.png" id="cxw3" alt="">
    <audio src="static/img/校歌.mp3" autoplay></audio>
    <img src="static/img/cxw1.png">
    <router-view></router-view>
  </div>


</template>


<script>
    export default {
      name: "flag1",
      data() {
        return {
          mid:'false'
        }
      },
      methods:{
      next(){
        this.$router.push('/raiseFlag')
      }
      }

    }

</script>









<style scoped>
  #list2 {
        z-index: 20;
        margin: 0px 0px;
        color: white;
        text-align: center;
        line-height: 150px;
        font-size: 130px;
        text-decoration: none;
        border-radius: 50px;
        width: 300px;
        height: 300px;
        border: black 1px solid;
        background-color: red;
        position:absolute;
        top:1600px;
        left: 350px;
    }
    #bt{
        z-index: 19;
        margin: 0px 0px;
        color: gold;
        text-align: center;
        line-height: 150px;
        font-size: 130px;
        text-decoration: none;
        border-radius: 60px;
        width: 800px;
        height: 300px;
        border: black 1px solid;
        background-color: green;
        position:absolute;
        top:300px;
        left: 100px;
    }
    #bj6{
        top: 0px;
        left: 0px;
        background-size: 100% 100%;
        height: 100%;
        position: fixed;
        width: 100%;
    }
    #cxw1{
        z-index: 21;
        position:absolute;
        top:600px;
        left: 500px;
        border-radius: 100px;
    }
    #cxw2{
        z-index: 21;
        position:absolute;
        top:0px;
        right: 0px;
        border-radius: 0px 0px 0px 100px;

    }
    #cxw3 {
      z-index: 21;
      width: 200px;
      height: 200px;
      position: absolute;
      top: 0px;
      left: 0px;
      border-radius: 0px 0px 100px 0px;
    }





</style>
