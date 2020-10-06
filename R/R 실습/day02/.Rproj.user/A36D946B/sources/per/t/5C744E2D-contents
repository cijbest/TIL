library(readxl)
y16 <- as.data.frame(read_excel("y16.xlsx"))
y17 <- as.data.frame(read_excel("y17.xlsx"))


r1 <- left_join(y16,y17, by="ID")
r2 <- left_join(y17,y16, by="ID")
r3 <- inner_join(y16,y17, by="ID")
r4 <- full_join(y17,y16,by="ID")

r5 <- r3

# 16,17년 결재 금액의 합과 건수의 합을 테이블에 추가하시오.
#SUM_AMT, SUM_CNT
# 위의 데이터를 기준으로 지역별 사용량의 평균을 구하시오.

r4$SUM_AMT <- rowSums(r4 %>% select(AMT17,AMT16), na.rm=T)
r4$SUM_CNT <- rowSums(r4 %>% select(Y17_CNT,Y16_CNT), na.rm=T)

r4 <- as.data.frame(r4 %>% group_by(AREA) %>% summarise(AVG_AMT = mean(SUM_AMT), AVG_CNT = mean(SUM_CNT)))

r4$AREA <- ifelse(is.na(r4$AREA), 'NONE', r4$AREA)
r4 <- r4 %>% arrange(desc(AVG_AMT))

library(psych)
describe(r4)

library(descr)
fq <- freq(r5$AREA,plot=T)

hist(r5$AGE)

boxplot(r5$AGE)


