<template>
  <div class="personal">
    <div class="personal_head">
      <div class="personal_head_01">
        <img class="personal_head_img" src="@/assets/head.png" />
        <div class="personal_head_text">
          <span class="personal_head_text_name">{{ student.name }}</span>
          <span class="personal_head_text_other">
            班级：{{ clazzInfo.name }}
          </span>
        </div>
      </div>
      <div class="personal_head_02">
        <div class="personal_head_02_item">
          <span class="personal_head_02_item_score">100</span>
          <span class="personal_head_02_item_type">操行分</span>
        </div>
        <div class="personal_head_02_item">
          <span class="personal_head_02_item_score">99</span>
          <span class="personal_head_02_item_type">综合评分</span>
        </div>
        <div class="personal_head_02_item">
          <span class="personal_head_02_item_score">80</span>
          <span class="personal_head_02_item_type">学分</span>
        </div>
      </div>
    </div>
    <div class="personal_content">
      <router-link class="personal_content_item" to="/app/student/personal/student">
        <div class="personal_content_item_left">
          <span>个人信息</span>
        </div>
        <div class="personal_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
      <router-link class="personal_content_item" to="/app/student/personal/studentInfo">
        <div class="personal_content_item_left">
          <span>基本资料</span>
        </div>
        <div class="personal_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
      <router-link class="personal_content_item" to="/app/student/personal/phone">
        <div class="personal_content_item_left">
          <span>手机</span>
        </div>
        <div class="personal_content_item_right">
          <span>{{
            student.phone != null && student.phone != ""
              ? student.phone
              : "绑定手机"
          }}</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
      <router-link class="personal_content_item" to="/app/student/personal/email">
        <div class="personal_content_item_left">
          <span>邮箱</span>
        </div>
        <div class="personal_content_item_right">
          <span>{{
            student.email != null && student.email != ""
              ? student.email
              : "绑定邮箱"
          }}</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
      <router-link class="personal_content_item" to="/app/student/personal/clazz">
        <div class="personal_content_item_left">
          <span>班级信息</span>
        </div>
        <div class="personal_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
      <router-link class="personal_content_item" to="source">
        <div class="personal_content_item_left">
          <span>生源信息</span>
        </div>
        <div class="personal_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
      <router-link class="personal_content_item" to="family">
        <div class="personal_content_item_left">
          <span>家庭成员</span>
        </div>
        <div class="personal_content_item_right">
          <i class="el-icon-arrow-right"></i>
        </div>
      </router-link>
    </div>

    <el-button type="danger" class="personal_exit_btn" @click="exit"
      >退出登录</el-button
    >
  </div>
</template>

<script>
import Header from "@/components/app/student/Header";
export default {
  components: {
    Header,
  },
  data() {
    return {
      student: {
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
  mounted(){
    this.$emit("titleChanged", "个人中心");
  },
  methods: {
    exit() {
      this.$confirm("是否退出登录?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          var storage = window.localStorage;
          storage.clear();
          this.$router.replace("/");
          this.$message({
            type: "success",
            message: "退出成功!",
          });
        })
        .catch(() => {});
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
.personal_exit_btn {
  width: auto;
  margin: 10px;
  font-size: 20px;
  margin-bottom: 20px;
}
.personal_content_item_right > i {
  color: #a6a6a6;
}
.personal_content_item_right > span {
  color: #b2b2b2;
}
.personal_content_item:active {
  background-color: #aed0fa;
}
.personal_content_item {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  border-bottom: 1px solid #e0e0e2;
  color: #777777;
  padding: 15px;
  text-decoration: none;
  -webkit-tap-highlight-color: rgba(255, 255, 255, 0);
  -webkit-user-select: none;
	-moz-user-focus: none;
  -moz-user-select: none;
}
.personal_content {
  background-color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* border-radius: 5px; */
  margin: 10px;
  margin-top: 20px;
}
.personal {
  width: 100%;
  display: flex;
  flex-direction: column;
}
.personal_head {
  display: flex;
  flex-direction: column;
}
.personal_head_01 {
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 20px;
}
.personal_head_img {
  height: 70px;
  border-radius: 100px;
}
.personal_head_text {
  margin-left: 10px;
}
.personal_head_text {
  height: 70px;
  display: flex;
  flex-direction: column;
  vertical-align: bottom;
}
.personal_head_text_name {
  font-size: 20px;
  color: aliceblue;
  margin-top: 15px;
}
.personal_head_text_other {
  font-size: 13px;
  color: #f0f0f0;
}
.personal_head_02 {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.personal_head_02_item {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.personal_head_02_item_score {
  font-size: 18px;
  color: aliceblue;
}
.personal_head_02_item_type {
  font-size: 12px;
  color: #c9cee2;
}
</style>