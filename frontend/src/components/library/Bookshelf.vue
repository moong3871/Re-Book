<template>
  <v-container>
    <div class="bookshelf">
      <div class="book-grid">
        <ul>
          <li v-for="book in books" :key="book.id">
            <BookHover :book="book" />
          </li>
        </ul>
      </div>
      <div class="shelf-shadows"></div>
      <div class="shelf"></div>
    </div>
  </v-container>
</template>

<script>
import BookHover from "@/components/library/BookHover.vue";

export default {
  name: "Bookshelf",
  props: {
    books: Array,
  },
  components: {
    BookHover,
  },
};
</script>

<style scoped>
.bookshelf {
  width: 100%;
  margin: 50px 0;
  text-align: center;
  position: relative;
}

.book-grid {
  z-index: 2;
  position: relative;
  transform: translateY(-15px);
}
.book-grid ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
}
.book-grid ul li {
  justify-self: center;
}
.book-grid ul img {
  display: block;
  box-shadow: 0px -5px 20px 2px rgba(0, 0, 0, 0.3);
  width: 24vh;
  height: 36vh;
  -o-object-fit: cover;
  object-fit: cover;
}

.shelf-shadows {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 1rem;
  border-radius: 2px;
  z-index: 1;
  box-shadow: 0px -5px 3px 0px rgba(170, 170, 170, 0.2),
    0px 15px 20px 0px rgba(170, 170, 170, 0.7),
    0px 5px 5px 0px rgba(119, 119, 119, 0.3);
}

.shelf {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 1rem;
  background-color: #f9f9f9;
  border-radius: 2px;
  z-index: 3;
}
</style>
