<template>
  <star-rating @rating-selected="setRating" />
</template>

<script>
import StarRating from "vue-star-rating";
export default {
  components: {
    StarRating,
  },
  data() {
    return {
      rating: 0,
    };
  },
  methods: {
    setRating: function (rating) {
      this.rating = rating;
    },
  },
};
</script>

<style scoped></style>
