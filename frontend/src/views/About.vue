<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div class="cover"><div>abcdefg</div></div>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
.wrap {
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
}
.cover {
  height: 500px;
  width: 200px;
  background-image: url("https://image.aladin.co.kr/product/26722/17/cover500/k712730188_1.jpg");
  background-size: 100%;
  border: 1px solid black;
}

/*Resize the wrap to see the search bar change!*/
</style>
