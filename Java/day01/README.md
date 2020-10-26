## 프로세스

> com.process.Test.java

- 실행 중인 프로그램
- 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.



## 쓰레드(Thread)

> com.thread.Test ~ Test5.java
>
> com.sus.Test.java
>
> com.sync

- 프로세스의 자원을 이용해서 시제로 작업을 수행한다.
- 모든 프로세스는 최소한 하나 이상의 쓰레드가 존재한다.
- 싱글 쓰레드 : 하나의 쓰레드를 가진 프로세스
- 멀티 쓰레드 : 둘 이상의 쓰레드를 가진 프로세스
  - 장점
    - CPU의 사용률을 향상시키나 프로세스가 여러 개 동작할 경우 그렇지 않을 수 있다.
    - 자원을 보다 효율적으로 사용할 수 있다.  쓰레드끼리는 하나의 프로세스에서 같은 자원을 공유하기 때문이다.
    - 사용자에 대한 응답성이 향상된다.
- 쓰레드를 '경량 프로세스'라고도 한다.
- 쓰레드를 쓰기 좋은 곳이 웹 서버이다.



#### 쓰레드 구현

- 쓰레드를 구현하는 방법으로는 **Thread클래스를 상속**받는 방법과 **Runnable인터페이스를 구현**하는 방법이 있다.

- Thread 클래스를 상속받으면 다른 클래스를 상속받을 수 없다.
- Runnable 인터페이스를 구현하면 재사용성이 높고 코드의 일관성을 유지할 수 있다.
- 일반적으로 Runnable을 주로 사용한다.
- main 메서드가 main 쓰레드이며 이 외의 쓰레드는 서브 쓰레드이다.



#### 쓰레드 실행

- `sleep` : 지정된 시간동안 쓰레드를 멈춘다.(1000 = 1초)
- `start()` : 쓰레드를 실행한다.
- `run()` : 쓰레드를 start()하면 run()이 호출되어 작업을 실행한다.
- `setPriority(숫자)` : 우선순위의 값(1~9)에 따라 쓰레드가 얻는 실행시간이 달라지며 숫자가 높을수록 우선순위가 높다.
- 쓰레드를 제어할 땐 보통 `flag`를 만들어 사용한다.
- `setDaemon(boolean)` : 일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료된다.
- `join()` : 지정된 쓰레드의 작업이 끝날 때까지 다른 쓰레드는 작업을 기다린다.



#### 쓰레드의 동기화(Synchronization)

- 한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것이다.
- 공유 데이터를 사용하는 코드 영역을 **'임계영역'**으로 지정해놓고 **'lock'**을 획득한 단 하나의 쓰레드만 임계영역 내의 코드를 수행할 수 있게 한다. 



## 입출력(I/O)과 스트림(Stream)

> com.io.Test1.java

- 입출력은 컴퓨터 내부 또는 외부의 장치와 프로그램, 애플리케이션 간에 데이터를 주고받는 것을 말한다.

- 스트림은 단방향통신만 가능하기 때문에 입력 스트림과 출력 스트림 총 2개의 스트림이 필요하다.

- 스트림은 바이트 단위로 데이터를 전송한다. (1byte씩 전송)

- 파일 입출력

  - `FileInputStream` : 입력 스트림

    - `read()` : 파일 읽기

  - `FileOutputStream` : 출력 스트림

    - `write()` : 파일 쓰기

      

## 보조 스트림

> com.io.Test1.java

- 스트림의 기능을 보완 또는 향상하거나 기능을 추가하기 위해 사용한다.

- Buffer를 사용하면 입출력이 향상되어 빨라진다.

- `BufferedInputStream`, : 입력 보조 스트림

- `BufferedOutputStream` : 출력 보조 스트림

- **모든 스트림 사용 시 close()를 꼭 해주어야 하는데 보조스트림만 닫아도 연결되어있는 스트림도 닫힌다.**

  ```java
  finally {
  			
  			// 반드시 close 해줄 것!!
  			// bis, bos만 close해줘도 fis, fos는 자동으로 close 된다.
  			if(bis != null) { 
  				try {
  					fis.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  			}
  			if(bos != null) {
  				try {
  					fos.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  			}
  			
  		}
  ```

  

## 문자기반 스트림

> com.io.Test2.java

- 2byte씩 자료를 전송하기 위해선 문자 기반 스트림을 사용한다.
- 바이트 기반으로 자료를 전송하면 한글파일이 깨질 수 있으므로 문자를 전송할 때는 문자 기반 스트림을 사용하는 것이 좋다.
- `FileReader` : 입력 스트림
- `FileWriter` : 출력 스트림



## 직렬화(serialization)

> com.io.Test3.java, User.java

- 객체를 데이터 스트림으로 만드는 것이다.

- 객체에 저장된 데이터를 스트림에 쓰기 위해 연속적인 데이터를 변환하는 것이다.
- `ObjectInputStream`, `ObjectOutputStream`는 보조 스트림이므로 FileInputStream과 FileOutputStream을 함께 사용한다.
- `writeObject(객체)` : 객체를 직렬화하여 쓰기
- `readObject(객체)` : 저장된 객체 읽기