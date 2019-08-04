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

# 条件渲染

* v-if

* v-else-if

* v-else

* v-show

## v-if 和 v-show 的区别

# 列表渲染

* v-for
* v-for 和 v-if 结合使用
* v-for 高阶用法

# 路由

1. 编写 vue 组件
2. 在 route 文件中配置
3. 在页面中加入 route 指向

# Vuex

> 单向数据流概念

## 解决的问题

* 多个视图依赖于同一状态
* 来自不同视图的行为需要变更同一状态

## 简介

* 为Vue开发的状态管理模式
* 组建状态集中管理
* 组建状态改变遵循统一的规则

# JavaScript

## 问题1

> methods 内部匿名对象无法调用 methods 的方法

是因为 js 的 this 关键字指向的问题，具体的 this 可以参考阮一峰的文章。
在对象中 this 指向本对象，导致无法获取上一级对象的引用去调用方法，解决方法有很多种。

* 匿名函数：在 es6 中引入 `=>` 尖括号来延伸 this
* 修改母对象（保存上级对象的引用）
* 保存外部 this 指向的变量进行调用
