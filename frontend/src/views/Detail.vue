<template>
  <div>
    <Info :dummy="dummy" />
    <Comment :dummy="dummy" />
  </div>
</template>

<script>
import Info from "@/components/detail/Info.vue";
import Comment from "@/components/detail/Comment.vue";
export default {
  name: "Detal",
  components: {
    Info,
    Comment,
  },
  data() {
    return {
      dummy: {
        user_id: 1,
        book_id: 1,
        title: "관계를 정리하는 중입니다.",
        author: "이 평",
        company: "SBS 컴퍼니",
        price: "13,500",
        desc:
          "나의 머릿속을 복잡하게 만드는 원인인 '관계'를 속 시원하게 정리해주고, 나아가 나를 돌아보게 만드는 문장들로 많은 독자들에게 공감과 애정을 이끌어낸 책 <관계를 정리하는 중입니다>. 이번 한정판에서는 기존판에서는 볼 수 없는 새롭게 추가된 글들로 독자들에게 한발 더 다가선다. 총 214P였던 기존 판보다 무려 40P가 늘어난 이번 리미티드 에디션을 통해 작가 이평은 특유의 사이다성 문구들로 사람 문제로 속앓이하는 독자들에게 더 구체적인 방법을 제시할 예정이다. 우리는 살아가면서 무수히 많은 사람을 만난다. 개중에는 좋은 사람도 나쁜 사람도, 그리고 이상한 사람도 존재한다. 물론 우리는 그들을 모두 이해할 수도, 정의내릴 수도 없다. 사람에 대한 평가는 모두 상대적이고, 우리는 우리 스스로조차도 온전히 이해할 수 없기 때문이다. '넌 도대체 왜 이렇게 무례하게 구니?' '너는 왜 나를 이렇게 힘들게 하니?' 결국 마음속엔 무수한 질문만이 쌓여간다.",
        profileimg_path:
          "http://image.yes24.com/momo/TopCate3247/MidCate002/305041342.jpg",
        grade: 9.8,
        point: "?",
        regtime: "regtime?",
        comments: [
          {
            id: 1,
            nickname: "북유럽",
            rating: 3.5,
            review:
              "시기적으로 나에게 필요한 책이었다 논리가 때로 조금 어설프고 다듬어지지 않은 느낌도 들엇으나 한번씩 와닿는 문장들에 충분히 위로 받았다.",
          },
          {
            id: 2,
            nickname: "오마이걸",
            rating: 3.5,
            review:
              "처음에 인스타를 통해 감정적인 소모로 인한 저의 마음을 잘 정리된 피드로 위로를 많이 받았어요",
          },
        ],
      },
    };
  },
};
</script>
<style></style>
