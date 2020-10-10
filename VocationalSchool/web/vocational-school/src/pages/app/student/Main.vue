<template>
  <div id="main">
    <router-view id="main_content" />
    <Bottom id="main_bottom"></Bottom>
  </div>
</template>

<script>
import Header from "@/components/app/student/Header";
import Bottom from "@/components/app/student/Bottom";

export default {
  components: {
    Header,Bottom
  },
};
</script>

<style>
#main{
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
}
#main_content{
	position: absolute !important;
	position: relative;
	/* top: 40px !important; */
	top: 0;
	bottom: 56px;
	width: 100%;
	overflow: hidden;
	height: auto !important;
	height: 100%;
}
#main_bottom{
  position: absolute;
  height: 56;
  width: 100%;
  bottom: 0;
}
</style>