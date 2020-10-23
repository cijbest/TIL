## 프로젝트 기획내용

영화관의 정보를 제공하는 안드로이드 어플리케이션입니다. 상영 영화 정보와 상영관의 위치를 확인합니다.



## 시스템 구성도

![구성도](https://user-images.githubusercontent.com/24764210/97004348-e871dd80-1577-11eb-9443-4c45489e2eae.png) 

## 구현기술

- Android 7.0 (Nougat)

- Java 8

## 구현내용

#### 인트로

Handler를 이용하여 약 3초간의 인트로 화면을 띄운 후 로그인 화면으로 이동합니다.

#### 로그인

서버와 통신하여 로그인하려는 ID와 비밀번호의 일치 여부를 알아내고 로그인이 성공하면 메인 화면으로 이동합니다.

#### 메인

- 화면 제일 상단에는 푸시 알람의 내용을 표시합니다. 웹서버의 요청으로 구글의 FCM(Firebase Cloud Management)을 이용하여 등록한 단말기에 푸시알람을 보내 사용자가 화면에서도 확인할 수 있습니다. 푸시알람은 앱이 꺼져 있거나 켜져 있는 상태에서도 Notification을 통해 받습니다.

- 영화관의 고객센터와 연결할 수 있는 전화 걸기 기능이 있습니다.

- 하단에는 두 개의 Fragmanet를 배치하여 상영 중인 영화의 정보를 랭킹순으로 볼 수 있고 상영관의 위치 정보를 제공합니다. 영화의 상세정보는 해당 리스트를 클릭하면 AlerDialog를 통해 확인합니다. 위치 정보는 구글의 맵으로 화면에 마커로 표시됩니다.

## 구현결과

#### 인트로

 ![1](https://user-images.githubusercontent.com/24764210/97007946-2291ae00-157d-11eb-9267-daffef0776ce.jpg) 



#### 로그인

![2](https://user-images.githubusercontent.com/24764210/97018350-047e7a80-158a-11eb-8061-1b4da6621dc8.jpg) 



#### 로그인 중

![3](https://user-images.githubusercontent.com/24764210/97018360-06483e00-158a-11eb-9dcb-be136b790ab4.jpg) 



#### 데이터를 불러오는 중

![4](https://user-images.githubusercontent.com/24764210/97018368-06e0d480-158a-11eb-9b0f-9d0af0484b2e.jpg) 



#### 메인

![5](https://user-images.githubusercontent.com/24764210/97018376-08aa9800-158a-11eb-9e6b-51f17d5abdfe.jpg) 



#### 리스트 클릭 시 상세정보 표시

![6](https://user-images.githubusercontent.com/24764210/97018403-13652d00-158a-11eb-9cc1-e857874a1f5a.jpg) 



#### 영화관 위치확인

![7](https://user-images.githubusercontent.com/24764210/97018511-3099fb80-158a-11eb-8d52-6057b898dbd9.jpg) 



#### 앱 실행상태에서의 푸시알람

![8](https://user-images.githubusercontent.com/24764210/97018733-75be2d80-158a-11eb-8f07-86f4bf4f9656.jpg) 



#### 푸시알람의 내용을 앱 화면 상단에 표시

![9](https://user-images.githubusercontent.com/24764210/97018740-76ef5a80-158a-11eb-8f2c-8e7e3e104f7b.jpg) 



#### 앱이 실행되고 있지 않을 때의 푸시 알람

![10](https://user-images.githubusercontent.com/24764210/97018741-7787f100-158a-11eb-9ab3-fe34943608fa.jpg) 