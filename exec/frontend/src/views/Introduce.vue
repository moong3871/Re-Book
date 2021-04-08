<template>
  <body>
    <div class="wrapper">
      <ul class="team">
        <li class="team-item">
          <div class="profile profile_red">
            <img src="../assets/images/SJ.jpeg" />
            <div class="profile-contents">
              <h2>Joon<span>CEO</span></h2>
              <p>정말 성준해~</p>
            </div>
          </div>
        </li>
        <li class="team-item">
          <div class="profile profile_beige">
            <img src="../assets/images/Dony.jpg" />
            <div class="profile-contents">
              <h2>Dony<span>베스킨나이31</span></h2>
              <p>만 30세, 무직</p>
            </div>
          </div>
        </li>
        <li class="team-item">
          <div class="profile profile_green">
            <img src="../assets/images/Dony.jpg" />
            <div class="profile-contents">
              <h2>SBS<span>Back-end</span></h2>
              <p>신체나이 31세</p>
            </div>
          </div>
        </li>
        <li class="team-item">
          <div class="profile profile_pink">
            <img src="../assets/images/Dony.jpg" />
            <div class="profile-contents">
              <h2>주녁<span>Back-end</span></h2>
              <p>리듬타</p>
            </div>
          </div>
        </li>
        <li class="team-item">
          <div class="profile profile_purple">
            <img src="../assets/images/Dony.jpg" />
            <div class="profile-contents">
              <h2>Moon<span>Front-end</span></h2>
              <p>Moonrise</p>
            </div>
          </div>
        </li>
        <li class="team-item">
          <div class="profile profile_pink">
            <img src="../assets/images/Dony.jpg" />
            <div class="profile-contents">
              <h2>SumJean<span>Back-end</span></h2>
              <p>막내온탑, 합성수지</p>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </body>
</template>

<script>
export default {
  name: "Introduce",
};
</script>

<style scoped>
body,
ul,
h2,
p {
  margin: 0;
  padding: 0;
}

li {
  list-style-type: none;
}

body {
  /* background-color:white; */
  color: #999;
}

.wrapper {
  display: flex;
  height: 100vh;
  justify-content: center;
  align-items: center;
}

.team {
  display: flex;
  justify-content: center;
  align-items: center;
}

.team-item {
  flex-basis: 150px;
  flex-shrink: 0;
  margin: 0 4px;
  opacity: 0.8;
  transition: all 0.4s;
}

.team-item:hover {
  opacity: 1;
  flex-basis: 300px;
  margin: 0 20px;
}

.team-item img {
  width: 100%;
}

.profile {
  background-color: #222;
  position: relative;
  overflow: hidden;
}

.profile:before {
  content: " ";
  /* Permalink - use to edit and share this gradient: https://colorzilla.com/gradient-editor/#000000+0,000000+100&0+0,0.95+100 */
  background: -moz-linear-gradient(
    top,
    rgba(0, 0, 0, 0) 0%,
    rgba(0, 0, 0, 0.95) 100%
  ); /* FF3.6-15 */
  background: -webkit-linear-gradient(
    top,
    rgba(0, 0, 0, 0) 0%,
    rgba(0, 0, 0, 0.95) 100%
  ); /* Chrome10-25,Safari5.1-6 */
  background: linear-gradient(
    to bottom,
    rgba(0, 0, 0, 0) 0%,
    rgba(0, 0, 0, 0.95) 100%
  ); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00000000', endColorstr='#f2000000',GradientType=0 ); /* IE6-9 */
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
  height: 200px;
}

.profile_red {
  color: #ff4949;
}

.profile_beige {
  color: beige;
}

.profile_green {
  color: darkseagreen;
}

.profile_pink {
  color: pink;
}

.profile_purple {
  color: violet;
}

.profile-contents {
  position: absolute;
  left: 0;
  bottom: 0;
  padding: 10px;
}

.profile-contents h2 {
  font-size: 17px;
}

.profile-contents h2 span {
  display: block;
  font-size: 10px;
}

.profile-contents p {
  color: white;
  font-size: 10px;
  min-width: 140px;
  max-height: 0;
  overflow: hidden;
  line-height: 1.2;
  transition: all 1s;
  opacity: 0;
}

.team-item:hover .profile-contents p {
  opacity: 1;
  transition-delay: 0.4s;
  max-height: 6em;
  margin-top: 0.4em;
}
</style>
