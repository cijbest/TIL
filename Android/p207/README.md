# p207 실습

1. 앱이 생성될 때, 앱이 실행될 때, 앱이 멈출 때, 앱이 꺼질 때의 상태를 확인
2. 스마트폰을 가로로 두었을 때, 가로용 화면이 나타남

## 실행화면

< 1 >

- onCreate도 정상으로 뜨고 있지만 순식간에 지나가서 보이지 않음. logcat으로 확인 가능.
- onStart

![캡처](https://user-images.githubusercontent.com/24764210/95820647-64437d00-0d63-11eb-9d4e-8005736f102f.PNG) 

- onStop

![캡처](https://user-images.githubusercontent.com/24764210/95820773-b2588080-0d63-11eb-8937-08806201d833.PNG) 

- onDestroy

![캡처](https://user-images.githubusercontent.com/24764210/95820875-e338b580-0d63-11eb-9130-94e385d36b40.PNG) 

< 2 >

- 가로 화면

![캡처](https://user-images.githubusercontent.com/24764210/95821202-770a8180-0d64-11eb-882b-d2464590e7c7.PNG) 

- 가로 화면 설정할 땐, android:configChanges="orientation|screenSize|keyboardHidden"
- 가로 화면으로 고정할 땐, android:screenOrientation="landscape" 추가

![캡처](https://user-images.githubusercontent.com/24764210/95825628-2008aa80-0d6c-11eb-9eac-7078c5219fce.PNG) 