import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import huodong from '@/views/modules/huodong/list'
    import huodongCollection from '@/views/modules/huodongCollection/list'
    import huodongLiuyan from '@/views/modules/huodongLiuyan/list'
    import huodongYuyue from '@/views/modules/huodongYuyue/list'
    import junazheng from '@/views/modules/junazheng/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import ziyuan from '@/views/modules/ziyuan/list'
    import ziyuanCollection from '@/views/modules/ziyuanCollection/list'
    import ziyuanLiuyan from '@/views/modules/ziyuanLiuyan/list'
    import config from '@/views/modules/config/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryHuodong from '@/views/modules/dictionaryHuodong/list'
    import dictionaryHuodongCollection from '@/views/modules/dictionaryHuodongCollection/list'
    import dictionaryHuodongYuyueYesno from '@/views/modules/dictionaryHuodongYuyueYesno/list'
    import dictionaryJunazheng from '@/views/modules/dictionaryJunazheng/list'
    import dictionaryJunazhengYesno from '@/views/modules/dictionaryJunazhengYesno/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryStatus from '@/views/modules/dictionaryStatus/list'
    import dictionaryYonghu from '@/views/modules/dictionaryYonghu/list'
    import dictionaryZiyuan from '@/views/modules/dictionaryZiyuan/list'
    import dictionaryZiyuanCollection from '@/views/modules/dictionaryZiyuanCollection/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryHuodong',
        name: '活动类型',
        component: dictionaryHuodong
    }
    ,{
        path: '/dictionaryHuodongCollection',
        name: '收藏表类型',
        component: dictionaryHuodongCollection
    }
    ,{
        path: '/dictionaryHuodongYuyueYesno',
        name: '报名状态',
        component: dictionaryHuodongYuyueYesno
    }
    ,{
        path: '/dictionaryJunazheng',
        name: '捐赠类型',
        component: dictionaryJunazheng
    }
    ,{
        path: '/dictionaryJunazhengYesno',
        name: '报名状态',
        component: dictionaryJunazhengYesno
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryStatus',
        name: '活动状态',
        component: dictionaryStatus
    }
    ,{
        path: '/dictionaryYonghu',
        name: '用户类型',
        component: dictionaryYonghu
    }
    ,{
        path: '/dictionaryZiyuan',
        name: '资源类型',
        component: dictionaryZiyuan
    }
    ,{
        path: '/dictionaryZiyuanCollection',
        name: '收藏表类型',
        component: dictionaryZiyuanCollection
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '广场论坛',
        component: forum
      }
    ,{
        path: '/huodong',
        name: '志愿活动',
        component: huodong
      }
    ,{
        path: '/huodongCollection',
        name: '活动收藏',
        component: huodongCollection
      }
    ,{
        path: '/huodongLiuyan',
        name: '活动留言',
        component: huodongLiuyan
      }
    ,{
        path: '/huodongYuyue',
        name: '活动报名',
        component: huodongYuyue
      }
    ,{
        path: '/junazheng',
        name: '捐赠信息',
        component: junazheng
      }
    ,{
        path: '/news',
        name: '公告通知',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/ziyuan',
        name: '志愿资源',
        component: ziyuan
      }
    ,{
        path: '/ziyuanCollection',
        name: '资源收藏',
        component: ziyuanCollection
      }
    ,{
        path: '/ziyuanLiuyan',
        name: '资源留言',
        component: ziyuanLiuyan
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
