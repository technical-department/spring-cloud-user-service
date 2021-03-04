import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import managerRouter from './modules/manager'
import store from '@/store/modules/user'
// import { formatRoutes } from '@/utils/util'

export let constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/system/index',
    component: () => import('@/views/system/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  // {
  //   path: '/videoManager/newVideoManager/detailMsg',
  //   component: Layout,
  //   redirect: '/videoManager/newVideoManager/detailMsg',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/videoManager/newVideoManager/detailMsg',
  //       component: () => import('@/views/videoManager/detailMsg'),
  //       name: 'videodetailMsg',
  //       meta: { title: '视频详情', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universityDetail',
  //   component: Layout,
  //   redirect: '/university/universityDetail/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universityDetail/index',
  //       component: () => import('@/views/university/detail'),
  //       name: 'UniversityDetail',
  //       meta: { title: '学校详情', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universityScenery',
  //   component: Layout,
  //   redirect: '/university/universityScenery/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universityScenery/index',
  //       component: () => import('@/views/university/scenery'),
  //       name: 'UniversityScenery',
  //       meta: { title: '校园风光', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universityMajor',
  //   component: Layout,
  //   redirect: '/university/universityMajor/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universityMajor/index',
  //       component: () => import('@/views/university/major'),
  //       name: 'UniversityMajor',
  //       meta: { title: '专业维护', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universityAbutment',
  //   component: Layout,
  //   redirect: '/university/universityAbutment/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universityAbutment/index',
  //       component: () => import('@/views/university/abutment'),
  //       name: 'UniversityAbutment',
  //       meta: { title: '院校对接', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universityJoionAbutment',
  //   component: Layout,
  //   redirect: '/university/universityJoionAbutment/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universityJoionAbutment/index',
  //       component: () => import('@/views/university/joionAbutment'),
  //       name: 'UniversityJoionAbutment',
  //       meta: { title: '专科专业', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universitySubject/admission',
  //   component: Layout,
  //   redirect: '/university/universitySubject/admission',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universitySubject/admission',
  //       component: () => import('@/views/university/admission'),
  //       name: 'SubjectAdmission',
  //       meta: { title: '录取数据', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/universityMajorIntroduce',
  //   component: Layout,
  //   redirect: '/university/universityMajorIntroduce/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: '/university/universityMajorIntroduce/index',
  //       component: () => import('@/views/university/majorIntroduce'),
  //       name: 'UniversityMajorIntroduce',
  //       meta: { title: '专业介绍', noCache: true, breadcrumb: false }
  //     }
  //   ]
  // },
  {
    path: '/',
    component: Layout,
    // redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: '首页', icon: 'dashboard' }
      }
    ]
  }
  // managerRouter,
  // {
  //   path: '/scoreParagraph',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/scoreParagraph/index'),
  //       name: 'scoreParagraph',
  //       meta: { title: '一分一段表', icon: 'user' }
  //     }
  //   ]
  // },
  // {
  //   path: '/userList',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/user/index'),
  //       name: 'userList',
  //       meta: { title: '注册用户列表', icon: 'user' }
  //     }
  //   ]
  // },
  // {
  //   path: '/university',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/university/index'),
  //       name: 'university',
  //       meta: { title: '学校管理', icon: 'user' }
  //     }
  //   ]
  // },
  // {
  //   path: '/volunteerTemplate',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/volunteerTemplate/index'),
  //       name: 'volunteerTemplate',
  //       meta: { title: '填报案例' }
  //     }
  //   ]
  // },
  // {
  //   path: '/subject',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/subject/index'),
  //       name: 'Subject',
  //       meta: { title: '专业维护' }
  //     }
  //   ]
  // },
  // {
  //   path: '/subjectHot',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/subject/hot'),
  //       name: 'SubjectHot',
  //       meta: { title: '热门专业' }
  //     }
  //   ]
  // },
  // {
  //   path: '/publicExamination',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/publicExamination/index'),
  //       name: 'PublicExamination',
  //       meta: { title: '公考分析' }
  //     }
  //   ]
  // },
  // {
  //   path: '/university/recruitRecord',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/university/recruitRecord'),
  //       name: 'RecruitRecord',
  //       meta: { title: '录取数据' }
  //     }
  //   ]
  // },
  // {
  //   path: '/order/index',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/order/index'),
  //       name: 'OrderList',
  //       meta: { title: '订单查看' }
  //     }
  //   ]
  // },
  // {
  //   path: '/servant/index',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/servant/index'),
  //       name: 'servantList',
  //       meta: { title: '公务员' }
  //     }
  //   ]
  // },
  // {
  //   path: '/chapter',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/chapter/index'),
  //       name: 'chapter',
  //       meta: { title: '知识大全'}
  //     }
  //   ]
  // },
  // {
  //   path: '/sysbase',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/sysbase/index'),
  //       name: 'sysbase',
  //       meta: { title: '系统管理'}
  //     }
  //   ]
  // },
  // // {
  // //   path: '/sysrescource',
  // //   component: Layout,
  // //   children: [
  // //     {
  // //       path: 'index',
  // //       component: () => import('@/views/sysrescource/index'),
  // //       name: 'sysrescource',
  // //       meta: { title: '资源列表'}
  // //     }
  // //   ]
  // // },
  // {
  //   path: '/sysrescource',
  //   component: Layout,
  //   redirect: 'noRedirect',
  //   name: 'Resource',
  //   meta: {
  //     title: '资源管理',
  //     icon: 'component'
  //   },
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/sysresource/index'),
  //       name: 'sysrescource-list',
  //       meta: { title: '资源列表' }
  //     }
  //     // ,
  //     // {
  //     //   path: 'msgnotify',
  //     //   component: () => import('@/views/sysbase/index'),
  //     //   name: 'msgnotify',
  //     //   meta: { title: '通知管理' }
  //     // }
  //   ]
  // },
  // ,
  // {
  //   path: '/sysuser',
  //   component: Layout,
  //   redirect: 'noRedirect',
  //   name: 'Sysuser',
  //   meta: {
  //     title: '用户管理',
  //     icon: 'component'
  //   },
  //   children: [
  //     {
  //       path: 'list',
  //       component: () => import('@/views/sysuser/list'),
  //       name: 'sysrescource-list',
  //       meta: { title: '用户列表' }
  //     }
  //     ,
  //     {
  //       path: 'role',
  //       component: () => import('@/views/sysuser/role'),
  //       name: 'role',
  //       meta: { title: '设置角色' }
  //     }
  //   ]
  // },
  // {
  //   path: '/sysrole',
  //   component: Layout,
  //   redirect: 'noRedirect',
  //   name: 'Sysrole',
  //   meta: {
  //     title: '角色管理',
  //     icon: 'component'
  //   },
  //   children: [
  //     {
  //       path: 'list',
  //       component: () => import('@/views/sysrole/role'),
  //       name: 'sysRole',
  //       meta: { title: '所有角色' }
  //     }
  //     ,
  //     {
  //       path: 'role',
  //       component: () => import('@/views/sysuser/role'),
  //       name: 'role',
  //       meta: { title: '我的角色' }
  //     }
  //   ]
  // }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

function generateChildRouters () {
  let menu = localStorage.getItem("SYSTEM_MNU");
  if (!menu) {
    return []
  }
  let menus = JSON.parse(menu);
  if (!menus) {
    return []
  }
  if (menus.length === 0) {
    return []
  }

  let routers = []
  menus.forEach((item) => {
    let children = [];
    if (item.children && item.children.length > 0) {
      item.children.forEach((ele) => {
        let childMenu = {
          path: ele.path,
          component:  getViews(ele.url),

          name: ele.url,
          meta: { title: item.name }
        }
        children.push(childMenu);
      })
    }

    let menu = {
      path: item.path,
      component: Layout,
      redirect: 'noRedirect',
      name: item.name,
      meta: {
        title: item.name,
        icon: 'component'
      },
      children: children
    }
    routers.push(menu);
  })

  return routers
}

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router


function getViews(path) {
  return resolve => {
    require.ensure([], (require) => {
      resolve(require(`@/views/${path}`))
    })
  }
}


