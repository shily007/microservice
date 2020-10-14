<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <div class="app_content">
      <Header class="app_content_header" v-if="title!=null&&title!=''" :title="title"></Header>
      <div class="app_content_header_camouflage" v-if="title!=null&&title!=''">1</div>
      <router-view class="app_content_router" v-on:titleChanged="updateHeader"/>
    </div>
  </div>
</template>

<script>
import Header from "@/components/app/student/Header";
export default {
  components: {
    Header,
  },
  name: "App",
  data(){
    return{
      title:null
    }
  },
  methods:{
    updateHeader(e) {
      this.title = e;
    },
  }
};
</script>

<style>
/* .app_content_router{
  margin-top: 39px;
  height: auto !important;
  overflow-y: auto;
  overflow-x: hidden;
} */
.app_content_header_camouflage{
  width: 100%;
  height: 39px;
  opacity: 0;
  font-size: 39px;
}
.app_content_header{
  position: absolute;
  z-index: 9999;
}
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
  background-image: linear-gradient(
    to bottom right,
    rgba(75, 152, 245, 1),
    rgba(1, 32, 79, 1)
  );
  /* overflow: auto; */
}
.app_content {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  align-content: center;
  overflow:auto;
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
