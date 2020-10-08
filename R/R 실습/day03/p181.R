library(KoNLP)
library(wordcloud)
library(tm)
library(RCurl)
library(RColorBrewer)
useSystemDic()
useSejongDic()
useNIADic()


add_wd <- c("코비드", "코비드19", "코로나")
buildDictionary(user_dic=data.frame(
  add_wd, rep("ncn",length(add_wd))
), replace_usr_dic=T)


wd <- readLines("wc.txt",encoding="UTF-8")
wd2 <- sapply(wd, extractNoun, USE.NAMES = F) # 단어 추출

lwd <- unlist(wd2) # 단어를 리스트에 담음

# 단어 빼기
lwd <- gsub("[0-9]","",lwd)
lwd <- gsub("[a-z]","",lwd)
lwd <- gsub("[A-Z]","",lwd)
lwd <- gsub("\\W","",lwd)
lwd <- gsub("","",lwd)
lwd <- gsub("스트레스","",lwd)


lwd2 <- Filter(function(x){
  nchar(x) >= 2 # 단어길이가 2글자 이상인 것만
}, lwd)

wc <- table(lwd2)
wc <- sort(wc, decreasing = T) # 많이 나온 단어순으로 정렬

jpeg(filename = "1p.jpg", width = 300, height = 300, quality = 120)
palate <- brewer.pal(9,"Set1")  # 몇 가지 색상, 어떤 palate 쓸건지 지정
wordcloud(names(wc),
          freq=wc,
          scale=c(5,0,5),
          rot.per=0.35,
          min.freq=1,
          random.order=F,
          random.color=T,
          colors=palate)
dev.off() # R에서의 파이프라인 끊음
