a1 <- function(){
  result <- c(3,3,3,3,3)
  return (result)
}
a2 <- function(){
  result <- read.csv("test.txt", header=T)
  return (result)
}
a3 <- function(){
  result <- c(7,8,9,4,5)
  return (result)
}

# 한글
func1 <- function(x){
  if(x == 10){
    return(a1())
  }else if(x == 20){
    return(a2())
  }else if(x == 30){
    return(a3())
  }else{
    
  }
}

result <- func1(20)