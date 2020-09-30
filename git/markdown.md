# 마크다운 문법

## 제목(heading)

제목은 `#` 으로 표현한다. 제목의 레벨은 `#`의 갯수로 표현되며, h1~h6까지 표현 가능하다.

### 제목3

#### 제목4

##### 제목5

###### 제목6

## 목록

목록은 순서가 있는 목록과 순서가 없는 목록으로 구분된다.

1. 순서가 있는 목록

2. 순서가 있는 목록

   1. tab을 통해서 하위 레벨로 진입
   2. 계속 작성

   enter

3. enter

* 순서가 없는 목록

* 순서가 없는 목록

  * tab
  * 계속

  enter

* enter

1. 섞어서 쓸 수도 
   * 있습니다.

## 코드 블록

```html
<h1>
    HTML 코드
</h1>
```

```sql
SELECT * FROM tables;
```

```bash
$ git init
```

다양한 프로그래밍 언어 문법의 syntax highlighting을 지원한다. 

## 링크

[구글 링크](https://google.com)

## 이미지

![images](C:\Users\user\Desktop\images.png)

* 이미지를 상대경로로 자동으로 저장하기 위해서 typora에 다음과 같은 설정을 한다.
  * 설정 > copy image to custom folder
    * 로컬 이미지
    * 온라인 이미지
    * 가능하다면 상대적 위치
    * Auto escape

![images](md-images/images-1600309456957.png)

![Screen Shot 2020-09-17 at 오전 11.23](md-images/Screen%20Shot%202020-09-17%20at%20%EC%98%A4%EC%A0%84%2011.23.png)

## 표

| 순번 | 이름   | 비고 |
| ---- | ------ | ---- |
| 1    | 홍길동 |      |
| 2    | 김철수 |      |
| 3    |        |      |

## 기타

**굵게(볼드)**

*기울임(이탤릭)*

~~취소선~~ 

---







