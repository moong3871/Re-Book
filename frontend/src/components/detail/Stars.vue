<template>
  <v-rating
    color="green"
    dense
    empty-icon="$mdiStarOutline"
    full-icon="$mdiStar"
    half-icon="$mdiStarHalfFull"
    half-increments
    hover
    length="5"
    size="38"
  >
  </v-rating>
</template>

<script>
export default {
  data: () => ({
    rating: 1,
  }),
};
</script>

<style></style>
