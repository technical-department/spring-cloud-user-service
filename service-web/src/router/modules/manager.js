/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const managerRouter = {
  path: '/manager',
  component: Layout,
  redirect: 'noRedirect',
  name: 'Manager',
  meta: {
    title: '基础数据',
    icon: 'component'
  },
  children: [
    {
      path: 'banner',
      component: () => import('@/views/banner/index'),
      name: 'banner',
      meta: { title: 'banner管理' }
    },
    {
      path: 'msgnotify',
      component: () => import('@/views/msgnotify/index'),
      name: 'msgnotify',
      meta: { title: '通知管理' }
    },
    {
      path: 'videoManager',
      component: () => import('@/views/videoManager/index'),
      name: 'videoManager',
      meta: { title: '视频管理' }
    },
    {
      path: 'newVideoManager',
      component: () => import('@/views/videoManager/newVideoManager'),
      name: 'newVideoManager',
      meta: { title: '新视频管理' }
    },
    {
      path: 'commonProblem',
      component: () => import('@/views/commonProblem/index'),
      name: 'commonProblem',
      meta: { title: '常见问题' }
    },
    {
      path: 'userFeedBack',
      component: () => import('@/views/userFeedBack/index'),
      name: 'userFeedBack',
      meta: { title: '用户反馈' }
    },
    {
      path: 'appVersion',
      component: () => import('@/views/appVersion/index'),
      name: 'appVersion',
      meta: { title: '版本升级' }
    },
    {
      path: 'nmetNouns',
      component: () => import('@/views/nmetNouns/index'),
      name: 'nmetNouns',
      meta: { title: '高考名词' }
    },
    {
      path: 'pdfManager',
      component: () => import('@/views/nmetNouns/file'),
      name: 'pdfManager',
      meta: { title: 'PDF文件管理' }
    },
    {
      path: 'supplement',
      component: () => import('@/views/nmetNouns/supplement'),
      name: 'supplement',
      meta: { title: '补录数据' }
    }
  ]
}

export default managerRouter
