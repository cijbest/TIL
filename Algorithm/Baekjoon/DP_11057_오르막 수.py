import sys
input = sys.stdin.readline

n = int(input())

dp = [[0] * 10 for _ in range(n + 1)]
# 1 자리수는 1로 초기화(앞에 0 올 수 있음)
for i in range(10):
    dp[1][i] = 1

for i in range(2, n+1): # 자리 수
    for j in range(10): # 뒤에 있는 숫자
        for k in range(j+1): # 앞에 올 숫자
            dp[i][j] += dp[i-1][k]

print(sum(dp[n]) % 10007)
