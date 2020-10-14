<template>
  <div class="student_info">
    <el-form
      class="student_info_form"
      v-if="studentInfo.isSure == 0"
      :model="student"
      ref="student"
      label-width="145px"
    >
      <el-form-item label="姓名" class="student_info_form_item">
        <span class="student_info_form_item_span">{{ student.name }}</span>
      </el-form-item>
      <el-form-item label="学号" class="student_info_form_item">
        <span class="student_info_form_item_span">{{ student.studentID }}</span>
      </el-form-item>
      <el-form-item label="政治面貌" class="student_info_form_item">
        <el-col :span="selectLength">
          <el-select
            v-model="studentInfo.politicalStatus"
            placeholder="--请选择--"
            size="small"
          >
            <el-option
              v-for="item in this.Global.politicalStatus"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="婚姻状况" class="student_info_form_item">
        <el-col :span="selectLength">
          <el-select
            v-model="studentInfo.maritalStatus"
            placeholder="--请选择--"
            size="small"
          >
            <el-option
              v-for="item in this.Global.maritalStatus"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="健康状况" class="student_info_form_item">
        <el-col :span="inputLenth">
          <el-input
            v-model="studentInfo.healthStatus"
            maxlength="20"
            size="small"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="国籍" class="student_info_form_item">
        <el-col :span="selectLength">
          <el-select
            v-model="studentInfo.nationality"
            placeholder="--请选择--"
            size="small"
          >
            <el-option
              v-for="item in this.Global.countrys"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="港澳台侨外" class="student_info_form_item">
        <el-col :span="selectLength">
          <el-select
            v-model="studentInfo.overseasChinese"
            placeholder="--请选择--"
            size="small"
          >
            <el-option
              v-for="item in this.Global.overseasChinese"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="省市县" class="student_info_form_item">
        <Ssx v-on:ssxChanged="updateSsx" :selectLength="selectLength"/>
      </el-form-item>
      <el-form-item label="详细地址" class="student_info_form_item">
        <el-col :span="inputLenth">
          <el-input
            v-model="studentInfo.detailedAddr"
            maxlength="100"
            size="small"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="所属派出所" class="student_info_form_item">
        <el-col :span="inputLenth">
          <el-input
            v-model="studentInfo.policeStation"
            maxlength="100"
            size="small"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="出生地行政区划码" class="student_info_form_item">
        <el-col :span="inputLenth">
          <el-input
            v-model="studentInfo.birthPlaceCode"
            maxlength="100"
            size="small"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="籍贯地行政区划码" class="student_info_form_item">
        <el-col :span="inputLenth">
          <el-input
            v-model="studentInfo.nationPlaceCode"
            maxlength="100"
            size="small"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="户口所在地行政区划码" class="student_info_form_item">
        <el-col :span="inputLenth">
          <el-input
            v-model="studentInfo.registeredPlaceCode"
            maxlength="100"
            size="small"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="户口性质" class="student_info_form_item">
        <el-col :span="selectLength">
          <el-select
            v-model="studentInfo.huKouXingZhi"
            placeholder="--请选择--"
            size="small"
          >
            <el-option
              v-for="item in this.Global.huKouXingZhi"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="学生居住地类型" class="student_info_form_item">
        <el-col :span="selectLength">
          <el-select
            v-model="studentInfo.habitationType"
            placeholder="--请选择--"
            size="small"
          >
            <el-option
              v-for="item in this.Global.huKouXingZhi"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-col>
      </el-form-item>
    </el-form>
    <el-form v-if="studentInfo.isSure == 1"></el-form>
  </div>
</template>

<script>
import Ssx from '@/components/app/Ssx'
export default {
  name: "",
  props: [""],
  data() {
    return {
      inputLenth: 20,
      selectLength: 20,
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
        isSure: 0,
      },
      studentInfoRules: {},
      studentInfo: {
        studentId: 1, //学生ID
        politicalStatus: "群众", //政治面貌
        maritalStatus: "", //婚姻状况
        healthStatus: "", //健康状况
        nationality: "", //国籍
        overseasChinese: "", //港澳台侨外
        province: "", //省
        city: "", //市
        county: "", //县
        detailedAddr: "", //详细地址
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
        isSure: 0,
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
        isSure: 0,
      },
    };
  },

  components: {Ssx},

  computed: {},

  beforeMount() {},

  mounted() {
    this.$emit("titleChanged", "基本资料");
  },

  methods: {
    updateSsx(e){
      if(e!=null&&e.length==3){
        this.studentInfo.province=e[0]
        this.studentInfo.city=e[1]
        this.studentInfo.county=e[2]
      }else{
        this.studentInfo.province=''
        this.studentInfo.city=''
        this.studentInfo.county=''
      }
    }
  },

  watch: {},
};
</script>
<style>
.student_info_form_item_span {
  color: #606266;
}
.student_info_form_item {
  margin: 0;
  padding: 0;
}
.student_info_form {
  width: 90%;
  background-color: white;
  margin-top: 20px;
  padding: 10px;
  border-radius: 5px;
}
.student_info {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.el-cascader-menu{
  min-width: auto;
}
/* .el-cascader-node__label{
  padding: 0 3;
}
.el-cascader-node{
  padding: 0 3px 0 3px;
} */
</style>