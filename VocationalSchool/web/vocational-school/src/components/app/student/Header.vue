<template>
  <div class="boottom">
    <img src="@/assets/logo_01.png" />
    <span>{{ schoolName }}</span>
  </div>
</template>

<script>
export default {
  data() {
    return {
      schoolName: this.Global.schoolName,
    };
  },
};
</script>

<style>
.boottom {
  display: flex;
  flex-direction: row;
  align-items: center;
  background-color: #2472C8;
}
.boottom > img {
  height: 40px;
}
.boottom>span{
  margin-left: 10px;
  color: aliceblue;
}
</style>