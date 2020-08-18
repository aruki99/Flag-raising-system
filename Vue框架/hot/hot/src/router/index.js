import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '/components/HelloWorld'
import Appindex from "../components/directory/Appindex";
import Login from "../components/Login";
import flag from "../components/flag";
import raiseFlag from "../components/raiseFlag";
import outFlag from "../components/outFlag";

Vue.use(Router);
export default new Router({
  routes: [

    {
      path: '/',
      // name: 'HelloWorld',
      // component: HelloWorld,
      redirect:'/flag'
    },

    {
      path: '/login',
      name: 'Login',
      component: Login
    },

    {
      path:'/index',
      name:'Appindex',
      component:Appindex
    },
  //升旗用的路由
    {
      path:'/flag',
      name:'flag1',
      component:flag
    },

     {
      path: '/raiseFlag',
      name: 'raiseFlag',
      component: raiseFlag
    },

    {
      path: '/outFlag',
      name: 'outFlag',
      component: outFlag
    },
    // {
    //   path:'/list',
    //   name:'flag',
    //   component:flag,
    //
    //   children:[
    //     {
    //       path: '/list/raiseFlag',
    //       name: 'raiseFlag',
    //       component: raiseFlag,
    //       children:[
    //         {
    //           path: '/outFlag',
    //           name: 'outFlag',
    //           component: outFlag,
    //         }
    //       ]
    //     }
    //
    //   ]
    // }



  ],

      mode:'history'//去除地址栏#

});
