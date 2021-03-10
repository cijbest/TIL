import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * 1000001

for i in range(2, n+1):
    # 1을 빼는 연산
    dp[i] = dp[i-1] + 1
    
    # 2로 나누어 떨어질 때 2로 나누어 연산하고 기존의 dp[i]의 값 중 작은 것을 최적의 횟수로 저장
    # 자연스레 -1한 연산과 min 비교를 하게됨
    if i % 2 == 0 :
        dp[i] = min(dp[i], dp[i//2] + 1)

    # 3로 나누어 떨어질 때 3으로 나누어 연산하고 기존의 dp[i]의 값 중 작은 것을 최적의 횟수로 저장
    # 자연스레 /2한 연산과 min 비교를 하게됨
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3] + 1)

print(dp[n])
