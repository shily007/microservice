<template>
  <div class="email">
    <Header title="绑定邮箱"></Header>
    <div class="email_content">
      <div v-if="oldEmail == null || oldEmail == ''">
        <Bind
          v-if="step == 1"
          :step="step"
          v-on:stepChanged="updateStep"
        ></Bind>
        <BindOk v-if="step == 2"></BindOk>
      </div>
      <div v-if="oldEmail != null && oldEmail != ''">
        <Up v-if="step == 1" :step="step" v-on:stepChanged="updateStep"></Up>
        <Bind
          v-if="step == 2"
          :step="step"
          v-on:stepChanged="updateStep"
        ></Bind>
        <BindOk v-if="step == 3"></BindOk>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/app/student/Header";
import Bind from "@/components/app/bind/email/Bind";
import Up from "@/components/app/bind/email/Up";
import BindOk from "@/components/app/bind/Ok";
export default {
  data() {
    return {
      step: 1,
      oldEmail: "",
    };
  },
  components: {
    Header,
    Bind,
    Up,
    BindOk,
  },
  methods: {
    updateStep(e) {
      this.step = e;
    },
  },
};
</script>

<style>
.email_content_span {
  color: #606266;
}
.email_content {
  background-color: white;
  width: 88%;
  margin-top: 20%;
  padding: 10px;
  height: 40%;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
}
.email {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.form_btn {
  width: 70%;
}
</style>