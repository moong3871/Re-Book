<template>
  <div></div>
</template>
<script>
export default {
  data() {
    return {
      modalcheck: 0,
      countMouseOver: 0,
      opened: false,
    };
  },
  methods: {
    activarOver() {
      this.countMouseOver = 1;
      setTimeout(() => {
        this.dolt();
      }, 2000);
      setTimeout(() => {
        this.opened = true;
      }, 2500);
    },
    resetOver() {
      this.countMouseOver = 0;
    },
    dolt() {
      if (this.countMouseOver == 1) {
        console.log("진짜 성공이다");
        this.modalcheck = 1;
        // this.opened = true;
      }
    },
  },
};
</script>
<style scoped>
.cover {
  height: 500px;
  width: 400px;
  background-image: url("https://image.aladin.co.kr/product/26722/17/cover500/k712730188_1.jpg");
  background-size: 80%;
  border: 1px solid black;
}
.modal-full {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  max-height: 1350px;
  max-width: 2400px;
  min-width: 1600px;
  min-height: 900px;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.6);
  z-index: 1000;
  -webkit-backdrop-filter: saturate(180%) blur(5px);
  backdrop-filter: saturate(180%) blur(5px);
  animation: fadein 1s;
}
.modal-container {
  position: fixed;
  top: 17%;
  left: 22%;
  max-width: 1200px;
  width: 60%;
  height: 60%;
  background-color: black;
  z-index: 1002;
  /* display: flex; */
}
.book-open {
  /* align-items: center; */
  width: 45%;
  margin-left: 50%;
  height: 80%;
  margin-top: 5.6%;
}
.book-container {
  width: 100%;
  height: 100%;
  background-color: rgb(224, 224, 224);
  /* border-top-right-radius: 10px;
  border-bottom-right-radius: 10px; */

  -webkit-perspective: 800px;
  -moz-perspective: 800px;
  -o-perspective: 800px;
  perspective: 800px;
  box-shadow: 3px 3px 7px #444 inset, -4px -2px 7px #444 inset;
}
#card {
  z-index: 2000;
  width: 100%;
  height: 100%;
  position: absolute;
  -webkit-transition: -webkit-transform 1.2s;
  -moz-transition: -moz-transform 1.2s;
  -o-transition: -o-transform 1.2s;
  transition: transform 1.2s;
  -webkit-transform-style: preserve-3d;
  -moz-transform-style: preserve-3d;
  -o-transform-style: preserve-3d;
  transform-style: preserve-3d;
  -webkit-transform-origin: left center;
  -moz-transform-origin: right center;
  -o-transform-origin: right center;
  transform-origin: left center;
}
#card.flipped {
  -webkit-transform: translateY(00%) rotateY(-180deg);
  -moz-transform: translateY(00%) rotateY(-180deg);
  -ms-transform: translateY(00%) rotateY(-180deg);
  -o-transform: translateY(00%) rotateY(-180deg);
  transform: translateY(00%) rotateY(-180deg);
}
#card figure {
  display: block;
  height: 100%;
  width: 100%;
  line-height: 260px;
  color: white;
  text-align: center;
  font-weight: bold;
  font-size: 140px;
  position: absolute;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  -o-backface-visibility: hidden;
  backface-visibility: hidden;
}
#card figure {
  text-shadow: 4px 5px 7px #080808;
}
#card .front {
  background: rgb(40, 46, 65);
  margin: 0;
}

#card .back {
  background: rgb(247, 245, 179);
  -webkit-transform: rotateY(180deg);
  -moz-transform: rotateY(180deg);
  -ms-transform: rotateY(180deg);
  -o-transform: rotateY(180deg);
  transform: rotateY(180deg);
  margin: 0;
  box-shadow: 3px 3px 7px #444 inset, -4px -2px 7px #444 inset;
}
/* .wrap {
  width: 30%;
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;

  border: 3px solid #00b4cc;
  border-right: none;
  padding: 5px;
  height: 50px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9dbfaf;
}

.searchTerm:focus {
  color: #00b4cc;
}

.searchButton {
  width: 50px;
  height: 50px;
  border: 1px solid #00b4cc;
  background: #00b4cc;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
} */
@keyframes fadein {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>
