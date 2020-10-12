<template>
  <div class="clazz">
    <Header title="班级信息"></Header>
    <el-form class="clazz_content">
      <span>年级：{{ grade }}</span>
      <span>专业：{{ major }}</span>
      <span style="margin-bottom:15px;">班级：{{ clazzName }}</span>
      <el-divider content-position="center">班主任信息</el-divider>
      <span style="margin-top:0px;">姓名：{{ clazzMaster.name }}</span>
      <span>性别：{{ clazzMaster.gender }}</span>
      <span>手机：{{ clazzMaster.phone }}</span>
      <span>邮箱：{{ clazzMaster.email }}</span>
    </el-form>
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
      grade: "2019级",
      major: "艺术舞蹈专业",
      clazzName: "19级舞蹈一班",
      clazzMaster: {
        name: "周萌",
        phone: "18866666666",
        email: "666666@qq.com",
        gender: "女",
      },
    };
  },
};
</script>

<style>
.clazz_content>span{
    margin-top: 12px;
    color: #4B4B4C;
}
.clazz_content {
  background-color: #ffffff;
  padding: 20px;
  border-radius: 5px;
  width: 86%;
  margin-top: 10%;
  display: flex;
  flex-direction: column;
  font-size: 18px;
  padding-bottom: 30px;
}
.clazz {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  width: 90%;
}
</style>