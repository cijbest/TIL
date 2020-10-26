##  기획내용

임의의 자동차 IoT 장비로부터 들어오는 로그 데이터를 분석해 차트로 시각화 합니다.



## 시스템 구성도

![1](https://user-images.githubusercontent.com/24764210/97151791-581fdc80-17b3-11eb-9d40-10cb594689d1.jpg) 



##  구현기술

- JAVA(JDK - 8버전)
- Apache-Tomcat 9
- MariaDB
- Hadoop
- Hive



## 구현내용

- IoT 장비를 통해 들어오는 자동차의 빅데이터를 로그 데이터로 저장하고 Hadoop의 데이터 웨어하우스인 Hive를 이용해 로그 데이터를 분석합니다.

- 데이터를 일자별로 처리하며 일별 데이터의 평균 값을 추출한 후 차트로 결과 화면을 구현합니다. 

#### 기능 코드

1. 로그데이터 환경 설정

   ```
   log4j.logger.car = DEBUG, console, car
   
   # car
   log4j.appender.car.Threadhold=DEBUG
   log4j.appender.car = org.apache.log4j.DailyRollingFileAppender 
   log4j.appender.car.DatePattern = '.'yyyy-MM-dd
   log4j.appender.car.layout = org.apache.log4j.PatternLayout 
   log4j.appender.car.layout.ConversionPattern = %d{yyyy:MM},%m%n
   log4j.appender.car.File = /root/logs/car.log
   ```

2. 로그데이터 저장 설정

   ```java
   public class Loggers {
   	
       private Logger car_log = Logger.getLogger("car"); 
   
       // before
       @Before("execution(* com.biz.CarBiz.*(..))")
       public void logging3(JoinPoint jp) {
           Object[] args = jp.getArgs();
           CarStatus cstatus = (CarStatus) args[0];
           car_log.debug(jp.getSignature().getName() + "," + cstatus.getId() + "," + 
                         cstatus.getSpeed() + "," + cstatus.getTemp() + "," +         
                         cstatus.getOiltemp() + "," + cstatus.getRpm());
       }
   }
   ```

3. HIVE 계정 환경 설정

   ```java
   // HIVE 계정
   String url = "jdbc:hive2://192.168.111.130:10000/default";
   String userid = "root";
   String password = "111111";
   
   public ChartController() {
   	try {
   		Class.forName("org.apache.hive.jdbc.HiveDriver");
   	} catch (ClassNotFoundException e) {
   		e.printStackTrace();
   	}
   }
   ```

4. HIVE에 테이블 구조 생성

   ```sql
   CREATE TABLE cardata(
   	date STRING,
   	fn STRING, 
   	id STRING,
   	speed FLOAT,
   	temp FLOAT,
   	oiltemp FLOAT,
   	rpm INT
   )
   PARTITIONED BY (logdate STRING)
   ROW FORMAT DELIMITED
   FIELDS TERMINATED BY ','
   LINES TERMINATED BY '\n'
   STORED AS TEXTFILE;
   ```

5. 로그 데이터 로드

   ```sql
   LOAD DATA LOCAL INPATH '/root/logs/$fileName' OVERWRITE INTO TABLE cardata PARTITION (logdate="$fileName");
   ```

   

## 구현결과

![2](https://user-images.githubusercontent.com/24764210/97151882-7980c880-17b3-11eb-9beb-f75fffb21436.png) 
![3](https://user-images.githubusercontent.com/24764210/97151884-7a195f00-17b3-11eb-9713-8d9d4135f779.png)