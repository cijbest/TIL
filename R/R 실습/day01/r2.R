library(readxl)

ex2 <- read.table(file="data.csv", 
                  encoding="utf-8",
                  header=T,
                  sep=",",
                  stringsAsFactors = F)
str(ex2)


