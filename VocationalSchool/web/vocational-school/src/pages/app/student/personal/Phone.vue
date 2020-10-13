<template>
  <div class="phone">
    <div class="phone_content">
      <div v-if="oldPhone == null || oldPhone == ''">
        <BindPhone
          v-if="step == 1"
          :step="step"
          v-on:stepChanged="updateStep"
        ></BindPhone>
        <BindOk v-if="step == 2"></BindOk>
      </div>
      <div v-if="oldPhone != null && oldPhone != ''">
        <UpBindPhone
          v-if="step == 1"
          :step="step"
          v-on:stepChanged="updateStep"
        ></UpBindPhone>
        <BindPhone
          v-if="step == 2"
          :step="step"
          v-on:stepChanged="updateStep"
        ></BindPhone>
        <BindOk v-if="step == 3"></BindOk>
      </div>
    </div>
  </div>
</template>

<script>
import BindPhone from "@/components/app/bind/phone/Bind";
import UpBindPhone from "@/components/app/bind/phone/Up";
import BindOk from "@/components/app/bind/Ok";
export default {
  data() {
    return {
      step: 1,
      oldPhone: ""
    };
  },
  mounted() {
    this.$emit("titleChanged", "绑定手机");
  },
  components: {
    BindPhone,
    UpBindPhone,
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
.phone_content_span {
  color: #606266;
}
.phone_content {
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
.phone {
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