import sys, itertools

# 입력
n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))

# 순열
permu = itertools.permutations(data, n)

# 차이가 최대인 값을 넣을 변수
answer = 0

for p in list(permu):
    # 차이의 합을 저장하는 임시 변수
    sumNum = 0
    
    # 차이의 합 계산
    for i in range(n-1):
        sumNum += abs(p[i]- p[i+1])
    
    # 차이의 합 최대값 비교
    if sumNum > answer:   # answer = max(sumNum, answer) - 실행시간이 더 걸림
        answer = sumNum
    
print(answer)
