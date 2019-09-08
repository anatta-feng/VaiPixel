import request from '@/utils/request'

export function submitWork (work) {
  console.log(work)
  return request({
    url: '/work/submit',
    method: 'put',
    data: work
  })
}
