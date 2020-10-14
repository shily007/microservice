<template>
  <el-col :span="20">
    <el-cascader
      v-model="ssx"
      :options="areas"
      size="small"
      :collapse-tags="true"
      clearable
      @change="ssxChanged"
    >
      <template slot-scope="{ data }">
        <span>{{ data.label }}</span>
      </template>
    </el-cascader>
  </el-col>
</template>

<script>
import Vue from "vue";
export default {
  data() {
    return {
        areas: [],
        ssx:[]
    };
  },
  mounted() {
    this.$emit("titleChanged", "基本资料");
      var areas = this.Area.areas;
      areas.forEach((element) => {
        if (element.level == 1) {
          Vue.set(element, "children", []);
          Vue.set(element, "value", element.name);
          Vue.set(element, "label", element.name);
          areas.forEach((element2) => {
            if (element2.parentCode == element.code) {
              Vue.set(element2, "children", []);
              Vue.set(element2, "value", element2.name);
              Vue.set(element2, "label", element2.name);
              areas.forEach((element3) => {
                if (element3.parentCode == element2.code) {
                  Vue.set(element3, "value", element3.name);
                  Vue.set(element3, "label", element3.name);
                  element2.children.push(element3);
                }
              });
              element.children.push(element2);
            }
          });
          this.areas.push(element);
        }
      });
  },

  methods: {
    ssxChanged() {
      this.$emit("ssxChanged", this.ssx);
    },
  },
};
</script>

<style>
</style>