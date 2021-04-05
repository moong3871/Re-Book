<template>
  <v-dialog max-width="500" max-height="700" transition="dialog-top-transition">
    <template v-slot:activator="{ on, attrs }">
      <v-avatar
        v-bind="attrs"
        v-on="on"
        class="my-profile"
        color="green"
        size="50px"
      >
        <v-icon dark size="48px"> mdi-account-circle </v-icon>
      </v-avatar>
    </template>
    <LoginModal></LoginModal>
  </v-dialog>
</template>

<script>
import LoginModal from "./LoginModal.vue";
export default {
  name: "Member",
  components: {
    LoginModal,
  },
};
</script>

<style scoped>
.content {
  width: 400px;
  position: absolute;
  top: 0;
  right: 0;
}
</style>
