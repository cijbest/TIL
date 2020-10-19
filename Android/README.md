# Android

> 책 -  Do it! 안드로이드 앱 프로그래밍(이지스 퍼블리싱) 참고

- 프로젝트 명은 책의 페이지를 나타냅니다.



---

## 안드로이드 구성

- Gradle Scripts/build.gradle(Module:xxx.app)  : 라이브러리 추가/삭제, 자동으로 자원관리 
- app/manifests/AndroidManifest.xml :  안드로이드 환경 설정 파일
- app/java/com.emxample.myapplication(제일 상단)/MainActivity.java : 실질적으로 안드로이드를 실행할 기능들이 들어있는 곳, 코드 작성하는 곳
- app/res/layout/activity_main.xml : 화면 구현 하는 곳

- MainActivity.java 
  - `R` : 안드로이드에서 모든 걸 관장함
  - res/values/strings.xml : 문자열 리소스 관리
  - `minmap` 폴더 : icon 관리
  - `drawabel` 폴더 : 이미지 관리