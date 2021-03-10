import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * 1001

# 초기값 지정
dp[1] = 1
dp[2] = 2

# 점화식에 따른 경우의 수 계산
for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[n]%10007)
