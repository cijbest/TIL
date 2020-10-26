from collections import deque

def dfs(v):
    print(v, end=' ')
    visited[v] = True

    for i in range(1, n+1):
        if mat[v][i] == 1 and visited[i] != True:
            dfs(i)


def bfs(v):
    q = deque([v])
    visited[v] = True
    
    while q:
        node = q.popleft()
        print(node, end =' ')
        
        for i in range(1, n+1):
            if mat[node][i] == 1 and visited[i] != True:
                q.append(i)
                visited[i] = True


# n : 정점의 개수, m : 간선의 개수, v : 시작할 정점
n, m, v = map(int,input().split())

# 데이터 저장
mat = [[0] * (n + 1) for _ in range(n + 1)]

# 방문 여부 체크
visited = [False] * (n + 1)

for i in range(m):
    # 양방향 간선이므로 다른 쪽 방향도 적용
    a, b = map(int, input().split())
    mat[a][b] = 1
    mat[b][a] = 1
    

# dfs 
dfs(v)

print()

# 초기화
visited = [False] * (n + 1)

# bfs
bfs(v)

