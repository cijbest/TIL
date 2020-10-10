library(ggplot2)

#jpeg(filename="gg1.jpg", width=300, height = 300, quality=120)
ggplot(airquality,aes(x=Day, y=Temp))+geom_point(size=3, color="red") + geom_line()
#dev.off()

ggplot(mtcars,aes(x=cyl)) + geom_bar(width = 0.5)

# fator : 데이터의 범주를 표시
# 가지고 있는 데이터만 그래프로 표시
ggplot(mtcars,aes(x=factor(cyl))) + geom_bar(width=0.5)

ggplot(mtcars,aes(x=factor(cyl))) + geom_bar(aes(fill=factor(gear)))

ggplot(mtcars,aes(x=factor(cyl))) + geom_bar(aes(fill=factor(gear))) + coord_polar()

ggplot(mtcars,aes(x=factor(cyl))) + geom_bar(aes(fill=factor(gear))) + labs(x="실런더", y="기어", title="차량정보")