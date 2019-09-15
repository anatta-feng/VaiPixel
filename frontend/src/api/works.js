import request from '@/api/request'

export function submitWork (work) {
  return request({
    url: '/work/submit',
    method: 'put',
    data: work
  })
}
