import sys

# 방법의 수 계산
def sol(n):
    # n이 1 ~ 3일 경우 미리 계산해둔 값을 리턴
    if n < 4:
        return data[n]
    else:
        # n이 4이상일 경우 4 ~ n까지 방법의 수를 구함 
        for c in range(4, n+1):
            data[c] = data[c-1] + data[c-2] + data[c-3]
    return data[n]


# 입력
t = int(sys.stdin.readline())
# 0 < n < 11
data = [0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0]


for i in range(t):
    n = int(sys.stdin.readline())
    
    print(sol(n))