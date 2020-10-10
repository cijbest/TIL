library(ggplot2)
motion <- gvisMotionChart(economics,
                          idvar="psavert",
                          timevar = "date")
plot(motion)