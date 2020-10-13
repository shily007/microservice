<template>
  <div class="student_info">
    1111ereter
    <!-- <Header title="student.name+'基本信息'"></Header>
    <div v-if="studentInfo.isSure==0||studentInfo.isSure==null">

    </div>-->
  </div>
</template>

<script>
export default {
  name: "",
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
        IdType: "", //证件类型
        idno: "511822200506051244", //证件号
        avatarUrl: "", //头像地址
        state: 0,
        isSure: 0
      },
      studentInfo: {
        studentId: 1, //学生ID
        politicalStatus: "", //政治面貌
        maritalStatus: "", //婚姻状况
        healthStatus: "", //健康状况
        nationality: "", //国籍
        overseasChinese: "", //港澳台侨外
        province: "", //省
        city: "", //市
        county: "", //县
        DetailedAddr: "", //详细地址
        policeStation: "", //派出所
        birthPlaceCode: "", //出生地行政区划码
        nationPlaceCode: "", //籍贯地行政区划码
        registeredPlaceCode: "", //户口所在地行政区划码
        huKouXingZhi: "", //户口性质
        habitationType: "", //学生居住地类型
        addr: "", //家庭现地址
        homeZipCode: "", //家庭邮政编码
        homeTel: "", //家庭电话
        isPoor: "", //是否建档立卡贫困户
        joinType: "", //入学方式
        studentCategory: "", //学生类别
        leaningType: "", //就读方式
        leaningForm: "", //学习形式
        trainSection: "", //乘火车区间
        isMoveChild: "", //是否随迁子女
        section: "", //分段培养方式
        studentType: "", //学生类型
        date: "", //入学年月
        unionType: "", //联招合作办学形式
        unionCode: "", //联招合作办学形式
        offCampus: "", //校外教学点
        isSure: 0
      },
      studentSource: {
        studentId: 1, //学生ID
        source: "", //学生来源
        target: "", //招生对象
        enrollmentMethod: "", //招生方式
        graduateSchool: 1, //毕业学校
        sourcePlaceCode: "", //生源地行政区划码
        examNo: "", //准考证号
        examineeNo: "", //考生号
        examScore: 550, //考试总分
        isSure: 0
      }
    };
  },

  components: {  },

  computed: {},

  beforeMount() {},

  mounted() {
    this.$emit("titleChanged", "基本资料");
  },

  methods: {},

  watch: {}
};
</script>
<style>
.student_info {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: brown;
}
</style>