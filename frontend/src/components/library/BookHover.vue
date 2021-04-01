<template>
  <div class="card" :style="elStyle">
    <div class="content">
      <h2 class="title">{{ book.title }}</h2>
      <p class="rate">★ 5.0</p>
      <p class="copy">
        이 책에서 ‘회복탄력성’ 이란 원래 제자리로 되돌아오는 힘을 일컫는 말로
        회복력 혹은 높이 되튀어오르는 탄력성을 뜻한다고 한다. 또한 회복탄력성은
        성공에 대한 강한 집념에서 나오는 것이 아닌 실패에 대한 두려움 없음에서
        나온다. 그리고 이 책에서 다양한 사례에서 계속 강조하듯이 회복탄력성에서
        제일 중요한 것은 ‘긍정성’ 이다. 삶에서 일어나는 모든 사건들을 보다 더
        긍정적으로 받아들이는 뇌가 회복탄력성을 높이는 것처럼. 긍정적인 뇌,
        긍정적인 습관을 키울 수 있는 것이 중요하다. 이 책의 PART 2 에서는
        회복탄력성의 지수를 알아볼 수 있는 KRQ-53 테스트가 있다. 테스트를 하기
        전 부터 사실 걱정이 좀 되었지만, 내 예상대로 자기조절능력, 대인관계능력,
        긍정성 까지 평균보다 낮아버렸다. (이 세가지 점수의 총합이 회복탄력성
        지수인데, 나는 160점대가 나왔다.) 즉 나는 깨지기 쉬운 유리 같은
        존재라고. 사실 최근들어 힘든 일이 너무 많아서 멘탈이 무너지고 있었다.
        무슨 일을 하기 전부터 부정적인 생각이 나를 더 강하게 지배하고 있었다.
        짧은 시간 안에 바꾸기는 힘들겠지만 조금 더 나은 나의 삶을 위해서
        긍정적인 힘을 믿어보기로 했다. 3주가량 노력하면 의식하지 않아도 습관이
        들기 시작하고, 3개월 정도 지나면 완전히 내 것으로 만들 수 있다니까!
        회복탄력성을 내 것으로 만들어보자.
      </p>
      <BookModal />
    </div>
  </div>
</template>

<script>
import BookModal from "./BookModal.vue";

export default {
  name: "BookHover",
  props: {
    book: {
      type: Object,
    },
  },
  components: {
    BookModal,
  },
  computed: {
    elStyle() {
      return {
        "background-image": `url(${this.book.src})`,
      };
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Cardo:400i|Rubik:400,700&display=swap");
:root {
  --d: 700ms;
  --e: cubic-bezier(0.19, 1, 0.22, 1);
  --font-sans: "Rubik", sans-serif;
  --font-serif: "Cardo", serif;
}

* {
  box-sizing: border-box;
}

html,
body {
  height: 100%;
}

body {
  display: grid;
  place-items: center;
}

.card {
  position: relative;
  display: flex;
  align-items: flex-end;
  overflow: hidden;
  /* padding: 1rem; */
  width: 220px;
  text-align: center;
  color: whitesmoke;
  background-color: whitesmoke;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1),
    0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1),
    0 16px 16px rgba(0, 0, 0, 0.1);
  background-size: cover;
  background-position: center;
}
@media (min-width: 600px) {
  .card {
    height: 300px;
  }
}
.card:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  background-position: 0 0;
  transition: transform calc(700ms * 1.5) var;
  pointer-events: none;
}
.card:after {
  content: "";
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 200%;
  pointer-events: none;
  background-image: linear-gradient(
    to bottom,
    rgba(0, 0, 0, 0) 0%,
    rgba(0, 0, 0, 0.009) 11.7%,
    rgba(0, 0, 0, 0.034) 22.1%,
    rgba(0, 0, 0, 0.072) 31.2%,
    rgba(0, 0, 0, 0.123) 39.4%,
    rgba(0, 0, 0, 0.182) 46.6%,
    rgba(0, 0, 0, 0.249) 53.1%,
    rgba(0, 0, 0, 0.32) 58.9%,
    rgba(0, 0, 0, 0.394) 64.3%,
    rgba(0, 0, 0, 0.468) 69.3%,
    rgba(0, 0, 0, 0.54) 74.1%,
    rgba(0, 0, 0, 0.607) 78.8%,
    rgba(0, 0, 0, 0.668) 83.6%,
    rgba(0, 0, 0, 0.721) 88.7%,
    rgba(0, 0, 0, 0.762) 94.1%,
    rgba(0, 0, 0, 0.79) 100%
  );
  transform: translateY(-50%);
  transition: transform calc(700ms * 2) cubic-bezier(0.19, 1, 0.22, 1);
}

.content {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 250px;
  padding: 1rem;
  transition: transform 700ms cubic-bezier(0.19, 1, 0.22, 1);
  z-index: 1;
  background-color: #345656;
}
.content > * + * {
  margin-top: 1rem;
}

.title {
  font-size: 1.3rem;
  font-weight: bold;
  line-height: 1;
  text-shadow: 2px 2px 2px gray;
  margin-bottom: 0;
}

.rate {
  color: yellow;
  margin: 0;
}

.copy {
  font-family: var(--font-serif);
  font-size: 1.125rem;
  font-style: italic;
  line-height: 1.35;
  /* 자르기 */
  max-height: 8em;
  white-space: normal;
  text-align: left;
  word-wrap: break-word;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 5;
  -webkit-box-orient: vertical;
}

@media (hover: hover) and (min-width: 600px) {
  .card:after {
    transform: translateY(0);
  }

  .content {
    /* content Y축 이동 */
    transform: translateY(calc(100% - 4.5rem));
  }
  .content > *:not(.title):not(.rate) {
    opacity: 0;
    transform: translateY(1rem);
    transition: transform 700ms cubic-bezier(0.19, 1, 0.22, 1),
      opacity 700ms cubic-bezier(0.19, 1, 0.22, 1);
  }

  .card:hover,
  .card:focus-within {
    align-items: center;
  }
  .card:hover:before,
  .card:focus-within:before {
    transform: translateY(-4%);
  }
  .card:hover:after,
  .card:focus-within:after {
    transform: translateY(-50%);
  }
  .card:hover .content,
  .card:focus-within .content {
    transform: translateY(12%);
  }
  .card:hover .content > *:not(.title),
  .card:focus-within .content > *:not(.title) {
    opacity: 1;
    transform: translateY(0);
    transition-delay: calc(700ms / 8);
  }

  .card:focus-within:before,
  .card:focus-within:after,
  .card:focus-within .content,
  .card:focus-within .content > *:not(.title) {
    transition-duration: 0s;
  }
}
</style>
