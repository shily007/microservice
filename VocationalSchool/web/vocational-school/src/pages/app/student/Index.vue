<template>
  <div id="bg" style="index_bg">
    <div id="login_box">
      <el-input prefix-icon="el-icon-user" v-model="username" placeholder="请输入身份证号码"></el-input>
      <el-input prefix-icon="el-icon-lock" class="login_box_input" placeholder="请输入登录密码" v-model="password" show-password></el-input>
      <el-button class="login_box_btn" type="primary" disabled>登 录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: ""
    };
  }
};
</script>
<style>
#bg {
  width: 100%;
  height: 100%;
  position: fixed;
  background-image: url(../../../assets/app_student_index_bg.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
#login_box {
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: white;
  padding: 2rem;
}
.login_box_input{
  margin-top: 1rem;
}
.login_box_btn{
  margin-top: 2.5rem;
}
</style>