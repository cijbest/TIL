library(reshape2)
data(airquality)
names(airquality) <- toupper(names(airquality))
m_air <- melt(airquality, id.vars = c("MONTH","DAY"), na.rm = T)
#m_air$value <- ifelse(is.na(m_air$value), 0, m_air$value)

names(m_air) <- toupper(names(m_air))
n_air <- dcast(m_air, MONTH ~ VARIABLE, mean)