<template>
  <div class="home">
    <div class="home_banner">
      <el-carousel :interval="5000" arrow="always" class="d_jump" height="8rem" with="90%">
        <el-carousel-item v-for="item in imgList" :key="item.id">
          <el-row>
            <el-col :span="10"
              ><img :src="item.idView" class="banner_img"
            /></el-col>
          </el-row>
        </el-carousel-item>
      </el-carousel>
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
    };
  },
};
</script>

<style>
html,
body,
#app {
  height: 100%;
  width: 100%;
  margin: 0px;
  padding: 0px;
}
.home {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  background-image: linear-gradient(
    to bottom right,
    rgba(75, 152, 245, 1),
    rgba(1, 32, 79, 1)
  );
  align-items: center;
}
.home_banner {
  width: 23rem;
  height: auto;
  margin-top: 10px;
}
.banner_img{
  height: 8rem;
  width: 23rem;
  border-radius: 5px;
}

</style>