<template>
  <div>
    <li v-for="(comment, index) in dummy[comments]" v-bind:key="index">
      {{ comment.nickname }}
      {{ comment.rating }}
      {{ comment.review }}
    </li>
  </div>
  <!-- <v-card class="mx-auto" max-width="1610">
    <v-card-title>Card title</v-card-title>
    <v-card-text>
      Phasellus magna. Quisque rutrum. Nunc egestas, augue at pellentesque
      laoreet, felis eros vehicula leo, at malesuada velit leo quis pede.
      Aliquam lobortis. Quisque libero metus, condimentum nec, tempor a, commodo
      mollis, magna. In turpis. In dui magna, posuere eget, vestibulum et,
      tempor auctor, justo. In turpis. Pellentesque dapibus hendrerit tortor. Ut
      varius tincidunt libero.
    </v-card-text>
  </v-card> -->
</template>

<script>
export default {
  name: "CommentItem",
  props: {
    dummy: Object,
  },
};
</script>

<style scoped></style>
