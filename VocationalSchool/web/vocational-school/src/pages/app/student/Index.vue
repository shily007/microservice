<template>
  <div id="index_bg" style="index_bg">
    <div id="index_head">
      <img id="index_head_logo" src="@/assets/logo_01.png" />
      <span id="index_head_lb">{{ schoolName }}</span>
    </div>
    <div id="login_box">
      <el-input
        class="login_box_input_username"
        prefix-icon="el-icon-user"
        v-model="username"
        placeholder="请输入身份证号码"
      ></el-input>
      <el-input
        prefix-icon="el-icon-lock"
        class="login_box_input_password"
        placeholder="请输入登录密码"
        v-model="password"
        show-password
      ></el-input>
      <div id="login_box_forget_pwd">
        <el-link
          id="login_box_forget_pwd_link"
          href="https://element.eleme.io"
          target="_blank"
          >忘记密码</el-link
        >
      </div>
      <el-button
        id="login_box_login_btn"
        class="login_box_btn"
        type="primary"
        :disabled="username.length == 18 && password.length >= 6 ? false : true"
        @click="login"
        >登&emsp;录</el-button
      >
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      schoolName: this.Global.schoolName
    };
  },
  methods: {
    login: function () {
      this.$router.push("/app/student/home");
    },
  },
};
</script>
<style>
#index_bg {
  width: 100%;
  height: 100%;
  position: fixed;
  background-image: url(../../../assets/app_student_index_bg.png);
  background-repeat: no-repeat;
  background-size: 100% 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
#index_head {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 70%;
}
#index_head_logo {
  height: 3rem;
}
#index_head_lb {
  font-size: 1.2rem;
  color: #58adee;
  margin: 0;
  padding: 0;
  margin-left: 0.5rem;
}
#login_box {
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: white;
  padding: 2rem;
  border-radius: 1rem;
  opacity: 0.8;
}
.login_box_input_username {
  font-size: 1rem;
}
.login_box_input_password {
  margin-top: 1rem;
  font-size: 1rem;
}
.login_box_btn {
  margin-top: 2rem;
  font-size: 1.3rem;
}
#login_box_forget_pwd {
  width: 100%;
  margin-top: 1rem;
}
#login_box_forget_pwd_link {
  float: right;
}
</style>