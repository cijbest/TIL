'''
문제 : 미로 탈출
첫째 줄에 두 정수 N, M(4 <= N, M <= 200)이 주어집니다.
다음 N개의 줄에는 각각 M개의 중에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어집니다.
시작 칸과 마지막 칸은 항상 1입니다.
시작지점은 (1, 1), 탈출지점은 (N, M)
탈출지점까지 갈 수 있는 최소한의 거리를 구하세요.
'''
from collections import deque

def bfs(x, y):
    q = deque()
    q.append((x, y))
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + step[i][0]
            ny = y + step[i][1]
            if nx < 0 or ny < 0 or nx >= n or ny >= m :
                continue
            if data[nx][ny] == 0:
                continue
            if data[nx][ny] == 1:
                data[nx][ny] = data[x][y] + 1
                q.append((nx, ny))
        
        return data[n-1][m-1]


n, m = map(int, input().split())

data = []
for i in range(n):
    data.append(list(map(int, input())))

step = [(1,0), (-1,0), (0,1), (0,-1)]

print(bfs(0, 0))
