a <- factor("A", c("A", "B", "C"))
a
is.factor(a)


v1 <- c(1,2,3,4,5)
sum(v1)

v1 <- c(1,2,3)
names(v1) <- c("d1","d2","d3")
v1
v1[1:2]
v1[1]

v1 <- c(1,2,3)
names(v1) <- c("d1","d2","d3")
v1[c(1,3)]

v1 <- c(1,2,3)
names(v1) <- c("d1","d2","d3")
v1[-2]

v1 <- c(1,2,3)
names(v1) <- c("d1","d2","d3")
v1["d1"]
v1[c("d1", "d3")]
length(v1)
names(v1)
names(v1)[2]
names(v1)[c(2,3)]
NROW(v1)

v3 <- seq(1,10,2)
v3
7:3

rep(1:2, each=5, time=2)

list1 <- list(v1 = "data1", v2="data2")
list1$v1
list1[1]

(m1 <- matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), ncol=3, byrow=T))
m1
colnames(m1) <- c("C1","C2","C3")
rownames(m1) <- c("R1","R2","R3")
m1[1,2]
m1[1:2,]
m1[,-1]
m1[c(1,3),]

nrow(m1)
ncol(m1)
d <- dim(m1)
d
m1[,"C1"]

rowSums(m1)
rowMeans(m1[c(1,2),])

d1 <- data.frame(name=c("kim","lee","seo"),
                 ko=c(90,80,98),
                 en=c(100,78,92),
                 ma=c(99,68,88))
d1
str(d1)
dname <- d1$name
dname
dko <- d1$ko
dko
mean(dko)
d1$ko <- c(100, 90, 99)
d1
d1$si <- c(90,80,88)
d1
d1$ko[c(1,2)]
d1[1,1]
d1[-1, c(-1,-3)]
d1[-1, c("ko", "en", "ma")]
result <- d1[,c("ko")]
result
sum(result)
d1[,c("ko"), drop=F]

head(d1,2)
View(d1)
result <- d1[,c("ko"), drop=F]
is.data.frame((result))

str(d1)

typeof(d1)
