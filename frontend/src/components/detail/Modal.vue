<template>
  <div class="overlay" @click.self="$emit('close-modal')">
    <div class="modal-card">
      <p class="c-title">{{ dummy.title }}</p>
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  props: {
    dummy: Object,
  },
};
</script>

<style scoped>
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  background: rgba(0, 0, 0, 0.5);
  z-index: 5;
}
.modal-card {
  position: relative;
  max-width: 40%;
  margin: auto;
  margin-top: 80px;
  padding: 40px;
  background-color: #345656;
  min-height: 500px;
  z-index: 6;
  color: white;
  text-align: center;
}
.c-title {
  font-size: 2rem;
}
</style>
