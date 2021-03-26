<template>
  <div id="map">
    <div class="map"></div>
  </div>
</template>

<script
  type="text/javascript"
  src="//dapi.kakao.com/v2/maps/sdk.js?appkey=96d25cdceea12f75a73fe83bd3348112"
></script>
<script>
export default {
  name: "Map",
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=96d25cdceea12f75a73fe83bd3348112";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(36.3457153, 127.3021026),
        level: 2,
      };

      var map = new kakao.maps.Map(container, options); // 지도 생성
      // var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커 이미지 주소
      // var imageSize = new kakao.maps.Size(64, 69), // 마커 이미지 크기
      // var imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지 옵션, 마커 좌표와 일치시킬 이미지 안에서의 좌표 설정

      // var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption), // 마커 이미지 생성
      var markerPosition = new kakao.maps.LatLng(36.3457153, 127.3021023); // 마커 표시 위치
      var marker = new kakao.maps.Marker({
        // 마커 생성
        position: markerPosition,
        // image: markerImage // 마커이미지 설정
      });
      marker.setMap(map); // 마커가 지도 위에 표시
      map.setMapTypeId(kakao.maps.MapTypeId.STANDARD); // 이거 안하면 is defined but not used
    },
  },
};
</script>

<style scoped>
.map {
  width: 500px;
  height: 400px;
}
</style>
