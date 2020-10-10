<template>
  <!-- <div class="bottom">
    <div class="bottom_item" @click="home">
      <i class="el-icon-house"></i>
      <span>首页</span>
    </div>
    <div class="bottom_item" @click="courseTable">
      <i class="el-icon-tickets"></i>
      <span>我的课表</span>
    </div>
    <div class="bottom_item" @click="test">
      <i class="el-icon-edit-outline"></i>
      <span>在线考试</span>
    </div>
    <div class="bottom_item" @click="user">
      <i class="el-icon-user"></i>
      <span>个人中心</span>
    </div>
  </div> -->
  <el-menu default-active="1"
      class="el-menu-vertical-demo bottom">
       <el-menu-item style="padding:0;margin:0;margin-left:-27px;" index="1" class="bottom_item" @click="home">
        <i style="font-size: 23px;margin:0;" class="el-icon-house"></i>
        <span slot="title">首&emsp;页</span>
      </el-menu-item>
      <el-menu-item style="padding:0" index="2" class="bottom_item" @click="courseTable">
        <i style="font-size: 23px;margin:0;" class="el-icon-tickets"></i>
        <span slot="title">我的课表</span>
      </el-menu-item>
      <el-menu-item style="padding:0" index="3" class="bottom_item" @click="test">
        <i style="font-size: 23px;margin:0;" class="el-icon-edit-outline"></i>
        <span slot="title">在线考试</span>
      </el-menu-item>
      <el-menu-item style="padding:0;margin-right:-27px;" index="4" class="bottom_item" @click="user">
        <i style="font-size: 23px;margin:0;" class="el-icon-user"></i>
        <span slot="title">个人中心</span>
      </el-menu-item>
</el-menu>
</template>

<script>
export default {
  methods: {
    home: function () {
      this.$router.push("/app/student/home");
    },
    courseTable: function () {
      this.$router.push("/app/student/user");
    },
    test: function () {
      this.$router.push("/app/student/user");
    },
    user: function () {
      this.$router.push("/app/student/user");
    }
  },
};
</script>

<style>
.el-menu-item{
    color: #909399;
    padding: 0;
    margin: 0;
    font-size: 25px;
}
.bottom {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  border-top: 1px solid #d8d8d8;
  padding: 1px;
}
.bottom_item {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 70px;
}
.el-menu-item:hover{
    background-color: white;
}
.bottom_item > span {
  line-height: 20px;
  font-size: 15px;
}

</style>