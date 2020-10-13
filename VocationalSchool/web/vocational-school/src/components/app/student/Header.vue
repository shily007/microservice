<template>
  <div class="header">
    <!-- <slot name="header_left"></slot> -->
    <div class="header_div">
      <router-link to="/app/student/home">
      <li class="el-icon-s-home"/>
      </router-link>
    </div>
    <span class="header_title">{{ title }}</span>
    <!-- <slot name="header_right"></slot> -->
    <div class="header_div"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      schoolName: this.Global.schoolName
    };
  },
  props: {
    title: String
  }
};
</script>

<style>
.header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  align-content: center;
  font-size: 18px;
  padding: 5px;
  width: 100%;
  border-bottom: 1px solid aliceblue;
  background-image: linear-gradient(
    to bottom right,
    rgba(75, 152, 245, 1),
    rgba(36, 89, 157)
  );
}
.header > span {
  color: aliceblue;
}
.header>div>a>li{
  font-size: 25px;
}
.header>div>a>.el-icon-s-home:active{
  background-color:  #aed0fa;
}
.header>div>a>.el-icon-s-home{
  color: white;
  margin-left: 10px;
}
.header_div{
  width: 48px;
  height: 28px;
}
</style>