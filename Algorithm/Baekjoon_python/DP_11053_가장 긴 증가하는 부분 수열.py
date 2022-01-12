import sys
input = sys.stdin.readline


n = int(input())
data = list(map(int, input().split()))

# dp 초기화
# maxValue : 현재 최대값 저장
dp = [0] * n
dp[0] = 1

for i in range(1, n):
    maxValue = data[i]
    tmp = 0
    for j in range(i, -1, -1):
        if data[i] < maxValue :
            tmp += 1
            maxValue = data[i]
    dp[i] = max(tmp, dp[i-1])
print(dp[n-1])
    
