import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'
const Menu = 'Menu'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function setMenu(menu) {
  return Cookies.set(Menu, menu)
}

export function getMenu() {
  const m = Cookies.get(Menu);
  if (!m) {
    return []
  }
  return m
}
