# 사진에 돋보기 추가되면 좋을까?

# img

```html
<img src={{ dummy.path }} alt="책 이미지">
```

- 아무 화면도 안뜬다. alt도 안뜸

- 붙여쓰면 컴파일 에러

- Interpolation inside attributes has been removed. Use v-bind or the colon shorthand instead

  

```html
<img :src="dummy.profileimg_path" alt="책 이미지">
```

- 이미지 및 다른 html도 잘 뜬다

# error

1. prettier/prettier delete cr

   > 해결
   >
   > ```js
   > .eslintrc.js    
   > "prettier/prettier": ["error", {
   >       "endOfLine":"auto"
   >     }]
   > ```

2. prettier/prettier delete '..'

   > 해결
   >
   > ```js
   > npm run lint --fix
   > ```
   >
   > 

# v-for에서 index is defined but never used

-------

![image-20210325073020860](vue%EC%97%90%EB%9F%AC.assets/image-20210325073020860.png)

- 정의되지 않았는데 render할 때 사용되니까 정의하고 사용하라는 뜻
- 발생이유
  - property: data(){} 내부에 정의하지 않은 경우

# 카카오 지도 api TypeError

![image-20210325093825244](vue%EC%97%90%EB%9F%AC.assets/image-20210325093825244.png)

혹은 Cannot read property 'current Style' of null

- 발생이유
  - 카카오api를 정의하는 script가 함수 실행 전에 와야 한다?
- 해결
  - current Style
    - index.html에 있던 script를 Map.vue 최상단(template 바로아래)에 정의