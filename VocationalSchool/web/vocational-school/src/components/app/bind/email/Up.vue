<template>
  <el-form
    label-width="1px"
    class="demo-dynamic"
    :rules="rules"
    ref="ruleForm"
    :model="ruleForm"
  >
    <el-form-item prop="email">
      <span class="email_content_span">原邮箱：{{ ruleForm.email }}</span>
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
    <el-form-item prop="code">
      <el-col :span="5">
        <span class="email_content_span">验证码</span>
      </el-col>
      <el-col :span="8">
        <el-input v-model="ruleForm.code" size="small" maxlength="6"></el-input>
      </el-col>
    </el-form-item>
    <el-form-item>
      <el-button
        type="primary"
        class="form_btn"
        size="small"
        style="margin-top: 10px; width: 100%"
        @click="netStep"
        >下一步</el-button
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
        email: "7524@qq.com",
        code: "666666",
      },
      rules: {
        code: this.Global.code,
      },
    };
  },
  methods: {
    netStep() {
      this.$emit("stepChanged", this.step + 1);
    },
  },
};
</script>

<style>
</style>