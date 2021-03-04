import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken, getMenu } from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'
import Layout from "@/layout/index";

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['/login', '/auth-redirect'] // no redirect whitelist

router.beforeEach(async(to, from, next) => {
  // start progress bar
  NProgress.start()

  // set page title
  document.title = getPageTitle(to.meta.title)

  // determine whether the user has logged in
  const hasToken = getToken()

  if (hasToken) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({ path: '/' })
      NProgress.done()
    } else if (to.path === '/system/index') {
      next()
      NProgress.done()
    }
    else {
      // determine whether the user has obtained his permission roles through getInfo
      const hasRoles = store.getters.roles && store.getters.roles.length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          // get user info
          // note: roles must be a object array! such as: ['admin'] or ,['developer','editor']

          const { roles } = await store.dispatch('user/getInfo')

          // generate accessible routes map based on roles
          let accessRoutes = await store.dispatch('permission/generateRoutes', roles)

          let menu = getMenu();
          let item = localStorage.getItem("SYSTEM_MNU");
          let menus = JSON.parse(item);
          let constRoutes = generateChildRouters(menus);

          let rotes = await store.dispatch('permission/UpdateAppRouter', constRoutes)
          router.addRoutes(constRoutes)
          const redirect = decodeURIComponent(from.query.redirect || to.path)
          if (to.path === redirect) {
            // hack方法 确保addRoutes已完成 ,set the replace: true so the navigation will not leave a history record
            next({ ...to, replace: true })
          } else {
            // 跳转到目的路由
            next({ path: redirect })
          }
        } catch (error) {
          // remove token and go to login page to re-login
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* has no token*/

    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
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
          meta: { title: ele.name }
        }

        children.push(childMenu);
      })
    }

    let menu = {
      path: '/' + item.path,
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
  // routers = recursive(menus, routers);

  return routers
}


function getViews(path) {
  // return import(`../views/${path}`)

  // route.component = () => import(`../${route.componentPath}.vue`)

  return resolve => {
    require.ensure([], (require) => {
      resolve(require(`@/views/${path}`))
    })
  }
}

// function recursive(data, routers) {
//   data.forEach(item => {
//
//
//     /////////
//
//
//       let menu = {
//         path: (item.type == '0' ? '/' : '') + item.path,
//         component: Layout,
//         redirect: 'noRedirect',
//         name: item.name,
//         meta: {
//           title: item.name,
//           icon: 'component'
//         }
//         // children: children
//       }
//     ////////
//
// debugger
//     // 判断有子元素,并且子元素的长度大于0就再次调用自身
//     if (item.children && item.children.length > 0) {
//       let children = [];
//       item.children.forEach((ele) => {
//         let childMenu = {
//           path: ele.path,
//           component:  getViews(ele.url),
//           name: ele.url,
//           meta: { title: ele.name }
//         }
//
//         children.push(childMenu);
//         recursive(ele, routers)
//       })
//       menu.children = children;
//     }
//
//     routers.push(menu);
//
//   })
//   return routers;
//
// }
