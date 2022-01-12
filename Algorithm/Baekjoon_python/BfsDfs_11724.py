import sys
sys.setrecursionlimit(10000)

# n : 정점의 수, m : 간선의 수
n, m = map(int, sys.stdin.readline().split())

data = [[] for i in range(n + 1)]
visited = [False] * (n + 1)

# 각 노드와 연결된 노드들끼리 묶기
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    data[a].append(b)
    data[b].append(a)

def dfs(node):
    visited[node] = True
    for i in data[node]:
        if visited[i] != True:
            dfs(i)

cnt = 0

# 차례대로 방문하지 않은 노드들에 대해서 dfs 실행
for i in range(1, n+1):
    if visited[i] != True:
        cnt += 1
        dfs(i)
        
print(cnt)
