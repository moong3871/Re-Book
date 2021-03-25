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
      var markerPosition = new kakao.maps.LatLng(36.3457153, 127.3021023); // 마커 표시 위치
      var marker = new kakao.maps.Marker({
        // 마커 생성
        position: markerPosition,
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
