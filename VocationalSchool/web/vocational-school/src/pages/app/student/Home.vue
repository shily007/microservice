<template>
  <div class="home">
    <div class="home_banner">
      <el-carousel
        :interval="5000"
        arrow="always"
        class="d_jump"
        height="8rem"
        with="90%"
      >
        <el-carousel-item v-for="item in imgList" :key="item.id">
          <el-row>
            <el-col>
              <img :src="item.idView" class="banner_img" />
            </el-col>
          </el-row>
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="home_content">
      <router-link v-for="item in menuList" :key="item.id" :to="item.router">
        <div class="home_content_item">
          <img style="height: 50px" :src="item.ico" />
          <div class="home_content_item_text">
            <span class="home_content_item_text_01">{{ item.name }}</span>
            <span class="home_content_item_text_02">{{ item.english }}</span>
          </div>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 图片需要引入, 否则无法显示
      imgList: [
        {
          id: 0,
          idView: require("../../../assets/student/banners/banner1.png"),
        },
        {
          id: 1,
          idView: require("../../../assets/student/banners/banner1.png"),
        },
        {
          id: 2,
          idView: require("../../../assets/student/banners/banner1.png"),
        },
      ],
      menuList: [
        {
          id: 0,
          ico: require("../../../assets/student/grxx.png"),
          name: "个人中心",
          english: "Personal center",
          router: "/app/student/personal",
        },
        {
          id: 1,
          ico: require("../../../assets/student/grxx.png"),
          name: "学生成绩",
          english: "Student achievement",
          router: "",
        },
        {
          id: 2,
          ico: require("../../../assets/student/students_vacation.png"),
          name: "学生假勤",
          english: "Students' vacation",
          router: "",
        },
        {
          id: 3,
          ico: require("../../../assets/student/sqjl.png"),
          name: "实训管理",
          english: "Students' vacation",
          router: "",
        },
        {
          id: 4,
          ico: require("../../../assets/student/zzqyxx.png"),
          name: "企业学习",
          english: "Enterprise learning",
          router: "",
        },
      ],
    };
  },
    mounted(){
    this.$emit("titleChanged", null);
  },
  methods:{
    up(){
      console.log(this.Global.headerShow)
      this.Global.headerShow=false
      console.log(this.Global.headerShow)
    }
  },
};
</script>

<style>
.home{
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow-y: auto;
  align-content: center;
}
.home_banner {
  width: 94%;
  height: auto;
  margin-top: 10px;
}
.banner_img {
  height: 8rem;
  width: 100%;
  border-radius: 5px;
}
.home_content > a {
  text-decoration: none;
  -webkit-tap-highlight-color: rgba(255, 255, 255, 0);
  -webkit-user-select: none;
	-moz-user-focus: none;
  -moz-user-select: none;
}
.home_content {
  display: flex;
  flex-wrap: wrap;
  width: 94%;
  justify-content: space-between;
  margin-top: 5px;
  margin-bottom: 20px;
}
.home_content_item {
  display: flex;
  flex-direction: row;
  width: 155px;
  background-color: aliceblue;
  border-radius: 5px;
  margin-top: 10px;
  align-items: center;
  padding: 10px;
}
.home_content_item_text {
  display: flex;
  flex-direction: column;
  align-content: space-between;
  color: aliceblue;
  margin-left: 5px;
}
.home_content_item:active {
  background-color: #aed0fa;
}
.home_content_item_text_01 {
  color: #728efe;
  font-size: 15px;
  line-height: 25px;
  margin-bottom: 5px;
}
.home_content_item_text_02 {
  color: #a6a6a6;
  font-size: 10px;
  line-height: 15px;
  max-width: 105px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>