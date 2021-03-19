import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

const vuetify = new Vuetify({
  theme: {
    themes: {
      light: {
        deepgreen: '#345656',
        green: '#4C7162',
      },
    },
  },
});
export default vuetify;

