<template>
  <div class="clazz">
    <!-- <el-form class="clazz_content">
      <span>年级：{{ grade }}</span>
      <span>专业：{{ major }}</span>
      <span style="margin-bottom:15px;">班级：{{ clazzName }}</span>
      <el-divider content-position="center">班主任信息</el-divider>
      <span style="margin-top:0px;">姓名：{{ clazzMaster.name }}</span>
      <span>性别：{{ clazzMaster.gender }}</span>
      <span>手机：{{ clazzMaster.phone }}</span>
      <span>邮箱：{{ clazzMaster.email }}</span>
    </el-form> -->
    <div class="demo-student clazz_content demo-student-01">
      <el-form label-width="80px">
        <el-form-item label="年级:" class="demo_student_item">
          <span class="demo-student-span">{{ grade }}</span>
        </el-form-item>
        <el-form-item label="专业:" class="demo_student_item">
          <span class="demo-student-span">{{ major }}</span>
        </el-form-item>
        <el-form-item label="班级:" class="demo_student_item">
          <span class="demo-student-span">{{ clazzName }}</span>
        </el-form-item>
        <el-divider content-position="center">班主任信息</el-divider>
        <el-form-item label="姓名:" class="demo_student_item">
          <span class="demo-student-span">{{ clazzMaster.name }}</span>
        </el-form-item>
        <el-form-item label="性别:" class="demo_student_item">
          <span class="demo-student-span">{{ clazzMaster.gender }}</span>
        </el-form-item>
        <el-form-item label="手机:" class="demo_student_item">
          <span class="demo-student-span">{{ clazzMaster.phone }}</span>
        </el-form-item>
        <el-form-item label="邮箱:" class="demo_student_item">
          <span class="demo-student-span">{{ clazzMaster.email }}</span>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
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
  mounted() {
    this.$emit("titleChanged", "班级信息");
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
  width: 100%;
}
</style>