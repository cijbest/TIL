# 학생 별 과목 별 성적 평균을 구하시오.
library(reshape2)

test <- read.csv("test.txt",
               header = T,
               stringsAsFactors=F,
               fileEncoding="UTF-8"
)

names(test) <- toupper(names(test))
test <- melt(test, id.vars = "NAME", na.rm = T)
names(test) <- toupper(names(test))
r_test <- dcast(test, NAME ~ VARIABLE, mean) 