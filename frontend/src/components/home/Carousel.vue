<template>
  <div
    id="carousel3d"
    style="width: 80vw; margin-left: 10vw; min-width: 1300px; height: 1000px"
  >
    <carousel-3d
      :perspective="0"
      :space="320"
      :display="5"
      :controls-visible="true"
      :controls-prev-html="'&#10092;'"
      :controls-next-html="'&#10093;'"
      :controls-width="60"
      :controls-height="60"
      :clickable="true"
      :autoplay="true"
      :autoplay-timeout="5000"
      style="height: 600px; min-height: 600px; max-width: 1800px !important"
    >
      <slide :index="0" style="height: 600px; border: 0px; max-width: 400px">
        <div
          style="
            height: 1500px;
            width: 100%;
            background-image: url('https://image.aladin.co.kr/product/25964/44/cover500/8933871551_3.jpg');
            background-size: contain;
            height: 100%;
            position: relative;
          "
        ></div>
      </slide>
      <slide
        :index="1"
        style="
          height: 600px;
          background-color: rgb(216, 216, 216);
          border: 0px;
          max-width: 400px;
        "
      >
      </slide>
      <slide
        :index="2"
        style="
          height: 600px;
          background-color: rgb(216, 216, 216);
          border: 0px;
          max-width: 400px;
        "
      >
      </slide>
      <slide
        :index="3"
        style="
          height: 600px;
          background-color: rgb(216, 216, 216);
          border: 0px;
          max-width: 400px;
        "
      >
      </slide>
      <slide
        :index="4"
        style="
          height: 600px;
          background-color: rgb(216, 216, 216);
          border: 0px;
          max-width: 400px;
        "
      >
      </slide>
      <slide
        :index="5"
        style="
          height: 600px;
          background-color: rgb(216, 216, 216);
          border: 0px;
          max-width: 400px;
        "
      >
      </slide>
      <slide
        :index="6"
        style="
          height: 600px;
          background-color: rgb(216, 216, 216);
          border: 0px;
          max-width: 400px;
        "
      >
      </slide>
    </carousel-3d>
  </div>
</template>
<script>
import { Carousel3d, Slide } from "vue-carousel-3d";
export default {
  data() {
    return {
      slides: 7,
      abcde: [0, 1, 2, 3, 4, 5, 6],
    };
  },
  components: {
    Carousel3d,
    Slide,
  },
};
</script>
<style scoped>
#carousel3d .carousel-3d-slide {
  display: flex;
  flex: 1;
  flex-direction: column;
  justify-content: center;
  text-align: center;
  background-color: #fff;
  /* padding: 10px; */
  transition: all 0.4s;
}
</style>
