<template>
  <div class="header">
    <!-- <slot name="header_left"></slot> -->
    <span class="header_title">{{ title }}</span>
    <!-- <slot name="header_right"></slot> -->
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
  justify-content: center;
  align-content: center;
  font-size: 18px;
  padding: 5px;
  width: 100%;
  border-bottom: 1px solid aliceblue;
}
.header > img {
  height: 40px;
}
.header > span {
  color: aliceblue;
}
</style>