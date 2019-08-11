<template>
  <div id="app">
    <header>
      <NavbarView/>
    </header>
    <div>
      <router-view/>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import NavbarView from './components/NavbarView'
import Footer from './components/footer/Footer'

export default {
  components: { Footer, NavbarView }
}
</script>

<style lang="scss">
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

  #nav {
    padding: 30px;

    a {
      font-weight: bold;
      color: #2c3e50;

      &.router-link-exact-active {
        color: #42b983;
      }
    }
  }
</style>
