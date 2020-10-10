# 1

Q1 <- "1. RTest3.java & stchart.r
- Java Application 실행되면
- 학생 별 평균을 ggplot2로 히스토그램을
- 이미지로 저장 하시오(stchart.jpg)"


draw <- function(){
  library(dplyr)
  library(reshape2)
  library(ggplot2)
  
  st <- read.csv("st.txt", header = T, fileEncoding = "utf-8")
  st <- melt(st, id.vars="NAME")
  st <- st %>% group_by(NAME) %>% summarise(AVG=mean(value))
  result <- as.data.frame(st)
  
  #jpeg(filename="stchart.jpg", width=300, height = 300, quality=120)
  ggplot(result, aes(x=NAME, y=AVG)) + geom_col(color="red")
  ggsave("sss.jpg")
  dev.off()
}

#2

Q2<- "2. RTest4.java & stavg.r
- Java Application이 동작 되면
- 학생 별 점수 합계와 평균을 구하여 출력 한다."


pr <- function(){
  library(dplyr)
  library(reshape2)
  library(ggplot2)
  
  st <- read.csv("st.txt", header = T, fileEncoding = "utf-8")
  st <- melt(st, id.vars="NAME")
  
  result2 <- st %>% group_by(NAME) %>% summarise(SUM=sum(value), AVG=mean(value))
  result2 <- as.data.frame(result2)
  
  return(result2)
}


