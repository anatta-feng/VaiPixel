# 模版语法

## 文件结构

template, script, style

## 模板语法

插值、指令（指令缩写）

# 其他

```javascript
var app = new Vue({
    el: '#app',
    data: {
        msg: 'Hello'
    },
    watch: {
        msg: function(newV, oldV) {
            
        }
    },
    computed: {
        msg1: function() {
            return msg
        }
    }
})
```



Vue 对象结构

* el 对象绑定的元素
* data 数据
* watch 监听属性 帧听器，只能监听指定的一个变量（异步场景
* computed  计算属性，可以监听方法体里所有的变量（数据联动