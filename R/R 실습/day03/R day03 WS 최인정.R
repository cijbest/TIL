library(readxl)
library(reshape2)
library(dplyr)

# 1
middle_mid_exam <- read_excel("middle_mid_exam.xlsx")

# 2
MATHEMATICS <- middle_mid_exam %>% select(ID, CLASS, MATHEMATICS)
MATHEMATICS <- dcast(MATHEMATICS, ID ~ CLASS)

ENGLISH <- middle_mid_exam %>% select(ID, CLASS, ENGLISH)
ENGLISH <- dcast(ENGLISH, ID ~ CLASS)

# 3
middle_mid_exam %>% group_by(CLASS) %>% summarise(ENG_MEAN=mean(ENGLISH), ENG_SUM=sum(ENGLISH))
middle_mid_exam %>% group_by(CLASS) %>% summarise(MATH_MEAN=mean(MATHEMATICS), MATH_SUM=sum(MATHEMATICS))

# 4
MATHEMATICS %>% filter(class1 >= 80) %>% summarise(n())

# 5
middle_mid_exam %>% arrange(desc(MATHEMATICS), ENGLISH)

# 6
middle_mid_exam %>% filter(MATHEMATICS >= 80 & ENGLISH >= 85) %>% summarise(n())