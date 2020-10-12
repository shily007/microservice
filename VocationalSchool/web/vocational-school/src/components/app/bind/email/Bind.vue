<template>
  <el-form
    label-width="79px"
    class="demo-dynamic"
    :rules="rules"
    ref="ruleForm"
    :model="ruleForm"
  >
    <el-form-item label="邮箱" prop="email">
      <el-col :span="15">
        <el-input
          v-model="ruleForm.email"
          size="small"
          maxlength="11"
        ></el-input>
      </el-col>
      <el-button
        size="small"
        style="
          margin-left: 10px;
          width: 70px;
          padding-left: 0;
          padding-right: 0;
        "
        >获取验证码</el-button
      >
    </el-form-item>
    <el-form-item label="验证码" prop="code">
      <el-col :span="8">
        <el-input v-model="ruleForm.code" size="small" maxlength="6"></el-input>
      </el-col>
    </el-form-item>
    <el-form-item>
      <el-button
        type="primary"
        class="form_btn"
        size="small"
        style="margin-top: 20px"
        @click="bindemail"
        >确认绑定</el-button
      >
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  props: {
    step: {
      type: Number,
      requred: true,
    },
  },
  data() {
    return {
      ruleForm: {
        email: "19934524003",
        code: "666666",
      },
      rules: {
        email: this.Global.email,
        code: this.Global.code,
      },
    };
  },
  methods: {
    bindemail() {
      this.$emit("stepChanged", this.step + 1);
    },
  },
};
</script>

<style>
</style>