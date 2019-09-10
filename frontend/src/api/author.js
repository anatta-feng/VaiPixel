import request from '@/api/request'

export function getUploadToken () {
  return request({
    url: '/work/upload/auth',
    method: 'POST'
  })
}
