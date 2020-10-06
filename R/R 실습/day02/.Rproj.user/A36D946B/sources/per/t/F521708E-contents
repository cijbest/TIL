library(dplyr)
sh <- read.csv("shop2.txt",
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
                          ifelse(sh$PRICE*sh$QT <= 100000,"G","F")))