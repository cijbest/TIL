# n :  사람의 수, p =  돈을 인출하는데 걸리는 시간
n = int(input())
p = list(map(int, input().split()))

p.sort()

result = 0

# 각 사람마다 인출하는데 걸리는 시간
sum = 0
for i in p:
    sum += i
    result += sum
print(result)