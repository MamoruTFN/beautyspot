<template>
  <HelloWorld />
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import "./assets/css/nucleo-icons.css";
import "./assets/css/nucleo-svg.css";

export default {
  name: "App",
  components: {
    HelloWorld,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100%;
}
</style>
