library(KoNLP)
library(wordcloud)
library(tm)
library(RCurl)
library(RColorBrewer)

# Dictionary Setting
useSystemDic()
useSejongDic()
useNIADic()

# Dictionary에 내가 원하는 명사 추가
add_wd <- c("코비드", "코비드19", "코로나")
buildDictionary(user_dic=data.frame(
  add_wd, rep("ncn",length(add_wd))
), replace_usr_dic=T)

# 텍스트 가져오기
wd <- readLines("https://www.nongmin.com/news/NEWS/POL/ETC/327549/view",encoding="UTF-8")

# 단어 추출
wd2 <- sapply(wd, extractNoun, USE.NAMES = F) 

# 단어를 리스트에 담음
lwd <- unlist(wd2) 

# 특정 문자 빼기
lwd <- gsub("[0-9]","",lwd)
lwd <- gsub("[a-z]","",lwd)
lwd <- gsub("[A-Z]","",lwd)
lwd <- gsub("\\W","",lwd) #특수문자
lwd <- gsub("","",lwd) # 공백
lwd <- gsub("_","",lwd)
lwd <- gsub("__","",lwd)
lwd <- gsub("___","",lwd)

# 단어길이가 2글자 이상인 것만 추출
lwd2 <- Filter(function(x){
  nchar(x) >= 2
}, lwd)

# 테이블에 담음
wc <- table(lwd2)

# 많이 나온 단어순으로 정렬
# head() : sort된 것 중에 100개만
wc <- head(sort(wc, decreasing = T), 100) 

# palate에 표시
jpeg(filename = "2p.jpg", width = 300, height = 300, quality = 120)
palate <- brewer.pal(9,"Set1")  # 몇 가지 색상, 어떤 palate 쓸건지 지정
wordcloud(names(wc),
          freq=wc,
          scale=c(5,0,5),
          rot.per=0.35,
          min.freq=1,
          random.order=F,
          random.color=T,
          colors=palate)

# R에서의 파이프라인 끊음. plot에 표시 안 되게 함.
dev.off() 
