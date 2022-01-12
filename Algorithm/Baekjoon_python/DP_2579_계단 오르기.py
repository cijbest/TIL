import sys
input = sys.stdin.readline

n = int(input())
score = [0] * 300
for i in range(n):
    score[i] = int(input())

# 초기값 설정
dp = [0] * 300
dp[0] = score[0]
dp[1] = score[0] + score[1]
dp[2] = max(score[0] + score[2], score[1] + score[2])

# 마지막 계단을 포함하면서 나올 수 있는 경우의 수를 찾는다
for i in range(3, n):
    dp[i] = max(score[i-1] + dp[i-3] + score[i], dp[i-2] + score[i])


print(dp[n-1])