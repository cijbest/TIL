# 세로(행) : n, 가로(열) : m
n, m = map(int, input().split())

# 각 행의 크기별로 조건을 푼다.
if n == 1:
    print(1)
elif n == 2:
    print(min(4, (m + 1) // 2))
else:
    if m <= 6:
        print(min(4, m))
    else:
        print(m - 2)