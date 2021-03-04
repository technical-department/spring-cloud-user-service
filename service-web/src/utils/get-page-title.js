import defaultSettings from '@/settings'

const title = defaultSettings.title || '我慧志愿'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
