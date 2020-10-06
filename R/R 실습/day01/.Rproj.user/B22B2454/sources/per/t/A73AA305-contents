library(readxl)
grade <- read.table(file="data_w.csv", 
                  encoding="utf-8",
                  header=T,
                  sep=",",
                  stringsAsFactors = F)
sum <-rowSums(grade[3:5],)
mean <-rowMeans(grade[3:5],)
df <- data.frame(grade, sum, mean)
df


