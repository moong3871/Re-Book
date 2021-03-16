(function(window, undefined) {
  var dictionary = {
    "40febade-723d-4bd5-a4bc-8850f9f2c729": "로그인",
    "69934c01-e0dc-403d-80ec-9f3382f60ae0": "책 상세페이지",
    "7d3d56b8-2f78-4fd5-a612-1e2373b56ad0": "도서관 정보",
    "d018c8d0-606b-4c7c-8999-d1c1fdae16d3": "회원가입",
    "03f56d18-402b-452c-a7e7-c2e45e859f23": "리스트",
    "f332cef7-095d-4823-ab74-996cbed2ad39": "장터",
    "09e08aab-e480-4d58-b33d-fbcfd7047fb0": "메인",
    "c96765dd-336f-438b-9db8-a54b526cb95c": "채팅",
    "d12245cc-1680-458d-89dd-4f0d7fb22724": "나의 책장",
    "8f1aff96-b24d-477c-8ad8-eea95bbbe756": "마이페이지",
    "f37e3f72-0337-419a-afdf-61155468ed9f": "비로그인_사이트 소개",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);