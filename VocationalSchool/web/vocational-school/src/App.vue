<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
html,
body,
#app {
  height: 100%;
  width: 100%;
  margin: 0px;
  padding: 0px;
  overflow: hidden;
  position: fixed;
  /* background-image: image('/bg/app_student_index_bg.jpg') */
}
/* #app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  margin: 0;
  padding: 0;
} */
</style>
