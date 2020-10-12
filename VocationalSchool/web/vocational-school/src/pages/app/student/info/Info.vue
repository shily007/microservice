<template>
  <div class="info">
    <Header title="个人信息" />
    <img
      v-if="user.avatarUrl != null && user.avatarUrl != ''"
      class="head_img"
      :src="user.avatarUrl"
    />
    <img
      v-if="user.avatarUrl == null || user.avatarUrl == ''"
      class="head_img"
      src="@/assets/head.png"
    />
    <el-form
      v-if="user.isSure == 0 || user.isSure == null"
      :model="user"
      :rules="userRules"
      ref="user"
      label-width="80px"
      class="demo-user"
    >
      <el-form-item label="姓名" prop="name">
        <el-col :span="20">
          <el-input v-model="user.name" maxlength="5"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-col :span="20">
          <el-radio-group v-model="user.gender">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-col>
      </el-form-item>
      <el-form-item label="民族" prop="nation">
        <el-col :span="20">
          <el-select
            v-model="user.nation"
            placeholder="--请选择--"
            @focus="loadNations"
          >
            <el-option
              v-for="item in nations"
              :key="item"
              :label="item"
              :value="item"
            ></el-option>
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="身份证号" prop="idno">
        <el-col :span="20">
          <el-input v-model="user.idno" maxlength="18" disabled></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-col :span="20">
          <el-input v-model="user.birthday" :disabled="true"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="手机">
        <el-col :span="20">
          <el-input v-model="user.phone" :disabled="true"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-col :span="20">
          <el-input v-model="user.email" :disabled="true"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="form_btn" @click="open"
          >保存</el-button
        >
      </el-form-item>
    </el-form>
    <div v-if="user.isSure == 1" class="demo-user">
      <el-form>
        <el-form-item label="姓名:" style="border-bottom: 1px solid #a6a6a6">
          <span>{{ user.name }}</span>
        </el-form-item>
        <el-form-item label="性别:" style="border-bottom: 1px solid #a6a6a6">
          <span>{{ user.gender }}</span>
        </el-form-item>
        <el-form-item label="民族:" style="border-bottom: 1px solid #a6a6a6">
          <span>{{ user.nation }}</span>
        </el-form-item>
        <el-form-item
          label="身份证号:"
          style="border-bottom: 1px solid #a6a6a6"
        >
          <span>{{ user.idno }}</span>
        </el-form-item>
        <el-form-item
          label="出生日期:"
          style="border-bottom: 1px solid #a6a6a6"
        >
          <span>{{ user.birthday }}</span>
        </el-form-item>
        <el-form-item label="手机:" style="border-bottom: 1px solid #a6a6a6">
          <span>{{ user.phone }}</span>
        </el-form-item>
        <el-form-item label="邮箱:" style="border-bottom: 1px solid #a6a6a6">
          <span>{{ user.email }}</span>
        </el-form-item>
      </el-form>
    </div>
    <div style="height:50px;width100%;color:#184683;">
      1
    </div>
  </div>
</template>

<script>
import Header from "@/components/app/student/Header";
export default {
  name: "",
  props: [""],
  data() {
    return {
      user: {
        id: 1,
        name: "扬扬",
        gender: "女",
        nation: "汉族",
        birthday: "20050605",
        phone: "19934524003",
        email: "752401007@qq.com",
        idno: "511822200506051244",
        autograph: "奔涌吧，后浪！！！",
        avatarUrl: "",
        state: 0,
        isSure: 0,
      },
      nations: [],
      userRules: {
        name: this.Global.name,
        gender: this.Global.gender,
        nation: this.Global.nation,
        idno: this.Global.idno
      },
    };
  },

  components: { Header },

  computed: {},

  beforeMount() {},

  mounted() {},

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
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
    open() {
      this.$confirm("请再次确认信息，保存后将不能进行修改?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.user.isSure = 1;
          console.log(this.user.isSure);
          this.$message({
            type: "success",
            message: "保存成功!",
          });
        })
        .catch(() => {
          // this.$message({
          //   type: "info",
          //   message: "已取消删除"
          // });
        });
    },
  },

  watch: {
    "user.idno": {
      handler: function (newVal, oldVal) {
        console.log(111);
        if (newVal.length == 18) {
          this.user.birthday = newVal.slice(6, 14);
        }
      },
    },
  },
};
</script>
<style>
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
.demo-user {
  background-color: #ffffff;
  padding: 10px;
  border-radius: 5px;
  width: 90%;
}
.info {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  width: 90%;
}
</style>