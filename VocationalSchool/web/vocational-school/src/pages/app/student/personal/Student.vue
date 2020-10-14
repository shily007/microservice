<template>
  <div class="info">
    <div class="info_content">
      <img
        v-if="student.avatarUrl != null && student.avatarUrl != ''"
        class="head_img"
        :src="student.avatarUrl"
      />
      <img
        v-if="student.avatarUrl == null || student.avatarUrl == ''"
        class="head_img"
        src="@/assets/head.png"
      />
      <el-form
        v-if="student.isSure == 0 || student.isSure == null"
        :model="student"
        :rules="studentRules"
        ref="student"
        label-width="80px"
        class="demo-student"
        style="padding-top: 30px"
      >
        <el-form-item label="姓名" prop="name">
          <el-col :span="20">
            <el-input
              v-model="student.name"
              maxlength="20"
              size="small"
            ></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="姓名拼音" prop="namePhonetic">
          <el-col :span="20">
            <el-input
              v-model="student.namePhonetic"
              maxlength="20"
              size="small"
            ></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="英文姓名" prop="englishName">
          <el-col :span="20">
            <el-input
              v-model="student.englishName"
              maxlength="20"
              size="small"
            ></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-col :span="20">
            <el-radio-group v-model="student.gender" size="small">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-col>
        </el-form-item>
        <el-form-item label="民族" prop="nation">
          <el-col :span="20">
            <el-select
              v-model="student.nation"
              placeholder="--请选择--"
              size="small"
            >
              <el-option
                v-for="item in this.Global.nations"
                :key="item"
                :label="item"
                :value="item"
              ></el-option>
            </el-select>
          </el-col>
        </el-form-item>
        <!-- <el-form-item label="学号">
        <el-col :span="20">
          <el-input
            v-model="student.studentID"
            disabled
            size="small"
          ></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="学籍号">
        <el-col :span="20">
          <el-input
            v-model="student.studentCode"
            disabled
            size="small"
          ></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="证件类型">
        <el-col :span="20">
          <el-input v-model="student.idType" disabled size="small"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="证件号">
        <el-col :span="20">
          <el-input v-model="student.idno" disabled size="small"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-col :span="20">
          <el-input
            v-model="student.birthday"
            :disabled="true"
            size="small"
          ></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="手机">
        <el-col :span="20">
          <el-input
            v-model="student.phone"
            :disabled="true"
            size="small"
          ></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-col :span="20">
          <el-input
            v-model="student.email"
            :disabled="true"
            size="small"
          ></el-input>
        </el-col>
      </el-form-item> -->
        <el-form-item>
          <el-button
            type="primary"
            class="form_btn"
            @click="submitForm('student')"
            size="small"
            >保存</el-button
          >
        </el-form-item>
      </el-form>
      <div v-if="student.isSure == 1" class="demo-student demo-student-01">
        <el-form label-width="80px">
          <el-form-item label="姓名:" class="demo_student_item">
            <span class="demo-student-span">{{ student.name }}</span>
          </el-form-item>
          <el-form-item label="姓名拼音:" class="demo_student_item">
            <span class="demo-student-span">{{ student.namePhonetic }}</span>
          </el-form-item>
          <el-form-item label="英文姓名:" class="demo_student_item">
            <span class="demo-student-span">{{ student.englishName }}</span>
          </el-form-item>
          <el-form-item label="性别:" class="demo_student_item">
            <span class="demo-student-span">{{ student.gender }}</span>
          </el-form-item>
          <el-form-item label="民族:" class="demo_student_item">
            <span class="demo-student-span">{{ student.nation }}</span>
          </el-form-item>
          <el-form-item label="证件类型:" class="demo_student_item">
            <span class="demo-student-span">{{ student.idType }}</span>
          </el-form-item>
          <el-form-item label="证件号:" class="demo_student_item">
            <span class="demo-student-span">{{ student.idno }}</span>
          </el-form-item>
          <el-form-item label="出生日期:" class="demo_student_item">
            <span class="demo-student-span">{{ student.birthday }}</span>
          </el-form-item>
          <el-form-item label="学号:" class="demo_student_item">
            <span class="demo-student-span">{{ student.studentID }}</span>
          </el-form-item>
          <el-form-item label="学籍号:" class="demo_student_item">
            <span class="demo-student-span">{{ student.studentCode }}</span>
          </el-form-item>
          <el-form-item label="手机:" class="demo_student_item">
            <span class="demo-student-span">{{ student.phone }}</span>
          </el-form-item>
          <el-form-item label="邮箱:" class="demo_student_item">
            <span class="demo-student-span">{{ student.email }}</span>
          </el-form-item>
        </el-form>
      </div>
      <div style="height:50px;width100%;color:#184683;">1</div>
    </div>
  </div>
</template>

<script>
export default {
  props: [""],
  data() {
    return {
      student: {
        id: 1,
        studentID: "191010101", //学号
        studentCode: "511822200506051244G", //学籍号
        name: "扬扬",
        namePhonetic: "YangYang", //姓名拼音
        englishName: "YangYang", //英文姓名
        gender: "女",
        nation: "汉族",
        birthday: "20050605",
        phone: "19934524003",
        email: "752401007@qq.com",
        idType: "居民身份证", //证件类型
        idno: "511822200506051244", //证件号
        avatarUrl: "", //头像地址
        state: 0,
        isSure: 0,
      },
      // nations: this.Global.nations,
      studentRules: {
        name: this.Global.input_desc,
        gender: this.Global.gender,
        nation: this.Global.nation,
        namePhonetic: this.Global.input_desc,
        englishName: this.Global.input_desc,
      },
    };
  },

  components: {  },

  computed: {},

  beforeMount() {},

  mounted() {
    this.$emit("titleChanged", "个人信息");
  },

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm("请再次确认信息，保存后将不能进行修改?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning",
          })
            .then(() => {
              this.student.isSure = 1;
              console.log(this.student.isSure);
              this.$message({
                type: "success",
                message: "保存成功!",
              });
            })
            .catch(() => {});
        } else {
          this.$alert("请完善信息！", {
            confirmButtonText: "确定",
          });
          return false;
        }
      });
    },
    loadNations: function () {
      console.log(this.nations.length);
      if (this.nations.length != 56) {
        console.log(this.nations.length);
        this.nations = this.Global.nations;
        console.log(this.nations.length);
      }
    },
  },

  watch: {
    "student.idno": {
      handler: function (newVal, oldVal) {
        console.log(111);
        if (newVal.length == 18) {
          this.student.birthday = newVal.slice(6, 14);
        }
      },
    },
  },
};
</script>
<style>
.demo-student-01 > .el-form-item__label {
  line-height: 30px;
}
.demo-student-01 > .el-form-item {
  margin: 0;
  padding: 0;
}
.demo_student_item {
  margin: 0;
  padding: 0;
}
.head_img {
  width: 70px;
  border-radius: 100px;
  margin: 20px;
}
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
.form_btn {
  width: 70%;
}
.demo-student {
  background-color: #ffffff;
  padding: 10px;
  border-radius: 5px;
  width: 90%;
}
.info {
  /* display: flex;
  flex-direction: column; */
  width: 100%;
}
.info_content {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>