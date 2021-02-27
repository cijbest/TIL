# Linux - war파일 배포하는 방법

### **일반적인 경우**

1. 프로젝트 war파일 생성

   

2. Tomcat 폴더`/usr/local/apache-tomcat-9.0.41/webapps`폴더에 생성된 war파일 이동

   

3. Tomcat 가동
- `/bin/startup.sh`를 실행

  
4. `http://aws주소/was파일명` 으로 접속





### **ROOT에 war파일 배포할 경우**

1. 프로젝트 war파일 생성
- war파일 생성될 위치 지정할때, 파일명은 반드시 'ROOT.war'로 입력

  
2. Tomcat 폴더/webapps/ROOT 폴더의 이름을 변경
- Tomcat을 설치하면 위 경로에 ROOT폴더가 있는데 이 폴더가 존재하면 `ROOT.war`가 압축해제되지 않음




3. Tomcat 폴더 `/usr/local/apache-tomcat-9.0.41/webapps`폴더에 생성된 war파일 이동

   

4. Tomcat 가동

- `/bin/startup.sh`를 실행

  
4. `http://aws주소/` 로 접속