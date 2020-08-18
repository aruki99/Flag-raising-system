

<template>
  <div>

    <img src="../../static/img/bj.jpg" id="bj" alt="">
    <div id="list1">
      <a href="http://www.yiban.cn/" id="l1">易班</a>
      <a href="https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzUxODgzMzUzMw==&scene=124#wechat_redirect" id="l2">易班公众号</a>
      <a href="http://csxy.dgut.edu.cn/" id="l3">学校官网</a>
      <div id="yjx">&copy 易班技术部</div>
    </div>

  </div>
</template>

<script>
    export default {
      name: "outFlag"


    }
</script>


<style scoped>
  #bj{
        top: 0px;
        left: 0px;
        height: 100%;
        position: absolute;
        width: 100%;
    }

    #list1{
        text-align: center;
        font-size: 30px;
        line-height: 200px;
        display: block;
        text-decoration: none;
    }
    #yjx{
        width: 200px;
        height: 100px;
        line-height: 100px;
        color: white;
        /*border-radius: 100px;*/
        /*background-color: #FFE53B;*/
        /*background-image: linear-gradient(90deg, #FFE53B 0%, #FF2525 74%);*/
        /*background-color:*/
        position:absolute;
        bottom:0;
        right: 0px;
    }
    a{
        text-decoration: none;      /*超链接去除下划线*/
    }
    #l1{
        width: 200px;
        height: 200px;
        border-radius: 75px 0px 0px 0px;
        background-color: #FFE53B;
        background-image: linear-gradient(90deg, #FFE53B 0%, #FF2525 74%);
        position:absolute;
        top: 1180px;
        right: 0px;
    }
    #l2{
        width: 200px;
        height: 200px;
        background-color: #FFE53B;
        background-image: linear-gradient(90deg, #FFE53B 0%, #FF2525 74%);
        position:absolute;
        top: 1380px;
        right: 0px;
    }
    #l3{
        width: 200px;
        height: 200px;
        border-radius: 0px 0px 0px 75px;
        background-color: #FFE53B;
        background-image: linear-gradient(90deg, #FFE53B 0%, #FF2525 74%);
        position:absolute;
        top: 1580px;
        right: 0px;
    }

















</style>
