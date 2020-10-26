def dfs(x, y):
    visited[x][y] = True
    cnt += 1

    for i in range(4):
        nx = x + step[i][0]
        ny = y + step[i][1]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if data[nx][ny] == 1 and visited[nx][ny] != True:
            dfs(nx, ny)


# n : 지도의 크기
n = int(input())
data = [[0]*n for _ in range(n)]
step = [(-1, 0), (1, 0), (0,-1), (0, 1)]
visited = [[False] * n for _ in range(n)]
cnt = 0

for i in range(0, n):
    data[i].append(list(map(int, input().split())))


for i in range(0, n):
    for j in range(0, n):
        if data[i][j] == 1 and visited[i][j] == True:
            dfs(i,j)
            print(cnt)
            cnt = 0
