<template>
  <div class="user">
    <div class="user_head">
      <div class="user_head_01">
        <img class="user_head_img" src="@/assets/head.png" />
        <div class="user_head_text">
          <span class="user_head_text_name">{{ user.name }}</span>
          <span class="user_head_text_other">
            班级：{{ clazz.name }}
            <!-- 性别：{{user.gender}}&emsp; -->
            <!-- 民族：{{user.nation}}&emsp; -->
            <!-- 生日：{{user.birthday}} -->
          </span>
        </div>
      </div>
      <div class="user_head_02">
        <div class="user_head_02_item">
          <span class="user_head_02_item_score">100</span>
          <span class="user_head_02_item_type">操行分</span>
        </div>
        <div class="user_head_02_item">
          <span class="user_head_02_item_score">99</span>
          <span class="user_head_02_item_type">综合评分</span>
        </div>
        <div class="user_head_02_item">
          <span class="user_head_02_item_score">80</span>
          <span class="user_head_02_item_type">学分</span>
        </div>
      </div>
    </div>
    <div class="user_content">
      <div class="user_content_item" @click="info">
        <div class="user_content_item_left">
          <span>个人信息</span>
        </div>
        <div class="user_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="user_content_item" @click="baseInfo">
        <div class="user_content_item_left">
          <span>基本资料</span>
        </div>
        <div class="user_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="user_content_item" @click="phone">
        <div class="user_content_item_left">
          <span>手机</span>
        </div>
        <div class="user_content_item_right">
          <span>{{
            user.phone != null && user.phone != "" ? user.phone : "绑定手机"
          }}</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="user_content_item" @click="email">
        <div class="user_content_item_left">
          <span>邮箱</span>
        </div>
        <div class="user_content_item_right">
          <span>{{
            user.email != null && user.email != "" ? user.email : "绑定邮箱"
          }}</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="user_content_item" @click="clazz">
        <div class="user_content_item_left">
          <span>班级信息</span>
        </div>
        <div class="user_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="user_content_item" @click="source">
        <div class="user_content_item_left">
          <span>生源信息</span>
        </div>
        <div class="user_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="user_content_item" @click="family">
        <div class="user_content_item_left">
          <span>家庭成员</span>
        </div>
        <div class="user_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
    </div>

    <el-button type="danger" class="user_exit_btn" @click="exit"
      >退出登录</el-button
    >
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        id: 1,
        name: "扬扬",
        gender: "女",
        nation: "汉族",
        birthday: "2005-06-05",
        phone: "",
        email: "",
        idno: "511822200506051244",
      },
      clazzInfo: {
        id: 1,
        name: "19级舞蹈一班",
      },
    };
  },
  methods: {
    info() {
      this.$router.replace("/app/student/personal/student");
    },
    baseInfo() {
      this.$router.replace("/app/student/personal/studentInfo");
    },
    phone() {
      this.$router.replace("/app/student/personal/phone");
    },
    email() {
      this.$router.replace("/app/student/personal/email");
    },
    clazz() {
      this.$router.replace("/app/student/personal/clazz");
    },
    source() {},
    family() {},
    exit() {
      this.$confirm("是否退出登录?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          var storage = window.localStorage;
          storage.clear()
          this.$router.replace("/");
          this.$message({
            type: "success",
            message: "退出成功!",
          });
        })
        .catch(() => {
        });
    },
  },
};
</script>

<style>
.el-message {
  width: auto;
  min-width: auto;
}
.el-message-box {
  width: 80%;
  min-width: 80%;
  max-width: 80%;
}
.el-message-box {
  width: auto !important;
}
.user_exit_btn {
  width: auto;
  margin: 10px;
  font-size: 20px;
}
.user_content_item_right > i {
  color: #a6a6a6;
}
.user_content_item_right > span {
  color: #b2b2b2;
}
.user_content_item:active {
  background-color: #aed0fa;
}
.user_content_item {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  border-bottom: 1px solid #e0e0e2;
  color: #777777;
  padding: 15px;
}
.user_content {
  background-color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* border-radius: 5px; */
  margin: 10px;
  margin-top: 20px;
}
.user {
  display: flex;
  flex-direction: column;
}
.user_head {
  display: flex;
  flex-direction: column;
}
.user_head_01 {
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 20px;
}
.user_head_img {
  height: 70px;
  border-radius: 100px;
}
.user_head_text {
  margin-left: 10px;
}
.user_head_text {
  height: 70px;
  display: flex;
  flex-direction: column;
  vertical-align: bottom;
}
.user_head_text_name {
  font-size: 20px;
  color: aliceblue;
  margin-top: 15px;
}
.user_head_text_other {
  font-size: 13px;
  color: #f0f0f0;
}
.user_head_02 {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.user_head_02_item {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.user_head_02_item_score {
  font-size: 18px;
  color: aliceblue;
}
.user_head_02_item_type {
  font-size: 12px;
  color: #c9cee2;
}
</style>