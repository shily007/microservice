<template>
  <div class="info">
    <Header title="个人信息" />
    <el-form
      v-if="user.isSure==0||user.isSure==null"
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
          <el-select v-model="user.nation" placeholder="--请选择--" @focus="loadNations">
            <el-option v-for="item in nations" :key="item" :label="item" :value="item"></el-option>
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="身份证号" prop="idno">
        <el-col :span="20">
          <el-input v-model="user.idno" maxlength="18"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-col :span="20">
          <el-input v-model="user.birthday" :disabled="true"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="form_btn" @click="open">保存</el-button>
      </el-form-item>
    </el-form>
    <div></div>
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
        phone: "",
        idno: "511822200506051244",
        autograph: "奔涌吧，后浪！！！",
        state: 0,
        isSure: 0
      },
      nations: [],
      userRules: {
        name: [
          { required: true, message: "请输入姓名", trigger: "blur" },
          { min: 2, max: 5, message: "长度在 2 到 5 个字符", trigger: "blur" }
        ],
        gender: [{ required: true, message: "请选择性别", trigger: "change" }],
        nation: [{ required: true, message: "请选择民族", trigger: "change" }],
        idno: [
          { required: true, message: "请填写身份证号", trigger: "blur" },
          { min: 18, max: 18, message: "长度为18个字符", trigger: "blur" }
        ],
        desc: [{ required: true, message: "请填写完善信息", trigger: "blur" }]
      }
    };
  },

  components: { Header },

  computed: {},

  beforeMount() {},

  mounted() {},

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    loadNations: function() {
      console.log(this.nations.length);
      if (this.nations.length != 56) {
        console.log(this.nations.length);
        this.nations = this.Global.nations;
        console.log(this.nations.length);
      }
    },
    open() {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "删除成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    }
  },

  watch: {
    "user.idno": {
      handler: function(newVal, oldVal) {
        console.log(111);
        if (newVal.length == 18) {
          this.user.birthday = newVal.slice(6, 14);
        }
      }
    }
  }
};
</script>
<style lang='' scoped>
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
}
</style>