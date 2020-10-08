head(airquality)
dim(airquality)
str(airquality)

library(reshape2)
names(airquality) <- tolower(names(airquality))
m_air <- melt(airquality, id.vars = c("month", "day"), measure.vars = "ozone")

mean_temp <- mean(m_air$value,na.rm=T)