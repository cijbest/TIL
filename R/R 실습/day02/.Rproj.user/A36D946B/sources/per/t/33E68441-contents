library(dplyr)
sh <- read.csv("shop3.txt",
               header = T,
               stringsAsFactors=F,
               fileEncoding="UTF-8"
)
sh <- rename(sh,ID=TX_ID,NAME=TX_NM, AGE=TX_A, TEMP=TX_T, PRICE=TX_P,QT=TX_Q)
sh$AGE_HL <- ifelse(sh$AGE >= 30,"H",
                    ifelse(sh$AGE >= 25,"M",
                           ifelse(sh$AGE >= 20,"L","F")
                    )
)

# 총 구매 금액이 (PRICE*QT)
# 10000 이하면 "B"
# 30000 이하면 "S"
# 100000 이하면 "G"
#를 GRADE 컴럼으로 만드시오.

sh$GRADE <- ifelse(sh$PRICE*sh$QT <= 10000,"B",
                   ifelse(sh$PRICE*sh$QT <= 30000,"S",
                          ifelse(sh$PRICE*sh$QT <= 300000,"G","F")))

sh2 <- sh %>% select(-ID,-AGE,-GRADE)
sh3 <- sh %>% filter(GRADE == 'G' & AGE_HL == 'M' & TEMP != 'NA')

mean(sh3$PRICE * sh3$QT)

sh4 <- sh %>% arrange(AGE)
sh4 <- sh %>% arrange(desc(AGE),MM)

smr <- sh %>% summarise(TOT = sum(PRICE), AGES = mean(AGE))

smr2 <- sh %>% group_by(NAME) %>% summarise(TOTAVG = mean(PRICE*QT))

smr3 <- as.data.frame(smr2)
