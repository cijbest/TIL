#1
library(dplyr)
mid_exam <- as.data.frame(read_excel("mid_exam.xlsx"))
mid_exam <- rename(mid_exam,MATH_MID=MATH,ENG_MID=ENG)

#2
final_exam <- as.data.frame(read_excel("final_exam.xlsx"))
final_exam <- rename(final_exam, MATH_FINAL=MATH, ENG_FINAL=ENG)


#3
total_exam <- full_join(mid_exam,final_exam, by="ID")

#4
total_exam$MATH_AVG <- rowMeans(total_exam %>% select(MATH_MID,MATH_FINAL), na.rm=T)
total_exam$ENG_AVG <- rowMeans(total_exam %>% select(ENG_MID,ENG_FINAL), na.rm=T)

#5
total_exam <- total_exam %>% filter(MATH_MID != "NA" & MATH_FINAL != "NA" & ENG_MID != "NA" & ENG_FINAL != "NA")
total_exam$TOTAL_AVG <- rowMeans(total_exam %>% select(MATH_AVG, ENG_AVG), na.rm=T)

#6
smr <- total_exam %>% summarise(CLASS_MATH_AVG=mean(MATH_AVG), CLASS_ENG_AVG=mean(ENG_AVG))

#7
smr2 <- total_exam %>% filter(MATH_MID >= 80 & ENG_MID >= 90)
smr2 %>% select("ID")

#8
boxplot(total_exam$MATH_AVG, total_exam$ENG_AVG)