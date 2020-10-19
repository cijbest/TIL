# n : 여학생의 수, m : 남학생의 수, 인턴쉽에 참여해야하는 인원 k
n, m, k = map(int, input().split())

# 팀 카운트
count = 0
while n >= 0 and m >= 0 and n + m >= k:
    n -= 2
    m -= 1
    count += 1
   
# n + m < k이 되는 시점에 팀을 하나 빼주어야 한다.
print(count - 1)
