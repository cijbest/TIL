import sys

INF = sys.maxsize
n, m = map(int, input().split())
a = [[INF]*n for _ in range(n)]
for i in range(m):
    x, y = map(int, input().split())
    a[x-1][y-1] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            if a[i][k] + a[k][j] == 2:
                a[i][j] = 1

cnt = [0]*n
for i in range(n):
    for j in range(n):
        if a[i][j] == 1:
            cnt[i] += 1
            cnt[j] += 1
print(cnt.count(n-1))
