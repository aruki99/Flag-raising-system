<template>
<div>
<span>
    <img src="static/img/bj4.jpg" id="bj4" alt="">
    <img src="static/img/bj3.jpg" id="bj3" alt="">
    <img src="static/img/bj3.jpg" id="bj32" alt="">
     <img src="static/img/bj3.jpg" id="bj33" alt="">
    <img src="static/img/bj5.jpg" id="bj5" alt="">


<!--    <a id="anniu" @click="nexts">升旗完成</a>-->
<!--  <button id="anniu" @click="nexts">神奇</button>-->
    <img src="static/img/tai2.png" alt="" id="tai2">
    <img src="static/img/qi2.png" alt="" id="qi2">
  <router-link to=outFlag  id="anniu">升旗完成</router-link>
</span>
</div>

</template>

<script>
  export default {
    name: "raiseFlag",
    methods:{
      nexts(){
        this.router.push('/outFlag')

      }



    }


  }
</script>

<style scoped>
       #anniu {
            z-index: 99;
            margin: 0px 0px;
            color: white;
            text-align: center;
            line-height: 140px;
            font-size: 120px;
            text-decoration: none;
            border-radius: 30px;
            width: 280px;
            height: 280px;
            border: black 1px solid;
            background-color: red;
            position:absolute;
            top:1825px;
            left: -350px;
            animation:mymove2 4s;
            animation-fill-mode: forwards ;
        }

        #bj4{
            top: 0px;
            left: 0px;
            background-size: 100% 100%;
            height: 100%;
            position: fixed;
            width: 100%;
        }
        #bj3{
            position:absolute;
            width: 300px;
            height: 307px;
            top: 1600px;
            left: 50px;
            z-index: 3;
            border-radius: 100px;
        }
        #bj32{
            position:absolute;
            width: 300px;
            height: 307px;
            top: 1170px;
            left: 210px;
            z-index: 2;
            border-radius:100px;
        }
        #bj33{
            position:absolute;
            width: 300px;
            height: 307px;
            top: 1300px;
            left: -20px;
            z-index: 1;
            border-radius: 100px;
        }
        #bj5{
            position:absolute;
            width: 400px;
            height: 282px;
            top: 1500px;
            left: -300px;
            border-radius: 100px;
            animation:mymove 4s;
            animation-fill-mode: forwards ;
            transform: rotate(-20deg);
        }

        #qi2{
            z-index: 8;
            margin: auto;
            position:absolute;
            left: 470px;
            top: 1500px;
            animation:myfirst 4s;
            animation-fill-mode: forwards ;

        }

        #tai2{
            margin: auto;
            position:absolute;
            left: 300px;
            top: 800px;
            z-index: 7;
        }


        @keyframes myfirst
          {
              14%  {left:470px;top:1500px;}
              100% {left:470px; top:790px;}
          }
        @keyframes mymove
        {
            /*0%  {left:-1000px;top:1000px;}*/
            98% {left:-300px;top:1500px;}
            100% {left:20px; top:400px;}
        }
        @keyframes mymove2
        {
            /*0%  {left:-1000px;top:1000px;}*/
            99% {top:1825px;left: -350px;}
            100% {top: 1825px;left: 350px;}
        }

</style>
