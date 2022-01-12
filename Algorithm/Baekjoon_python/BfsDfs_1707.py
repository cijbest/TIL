import sys
sys.setrecursionlimit(10000)

def dfs(n, group):

    visited[n] = group
    
    for i in data[n]:
        # 방문 안 했을 때
        if visited[i] == 0 :
            if not dfs(i, -group):
                return False
                
        # 방문 했을 때 : 인접 접점과 현재 접점이 같은 그룹인지 확인
        elif visited[i] == visited[n]:
            return False   
    return True


k = int(sys.stdin.readline())

for i in range(k):
    v, e = map(int, sys.stdin.readline().split())
    data = [[] for _ in range(v+1)]
    visited = [0] * (v + 1)
    answer = "YES"
    for j in range(e):
        a, b = map(int, sys.stdin.readline().split())
        data[a].append(b)
        data[b].append(a)
    for n in range(1, v+1):
        if visited[n] == False:
            if not dfs(n, 1):
                answer = "NO"
                break
    print(answer)
           

'''    
k = int(input())

for i in range(k):
    v, e = map(int, input().split())
    data = [0] * (v+1)
    answer = "YES"
    for j in range(e):
        a, b = map(int, input().split())
        data[a] += 1
        data[b] += 1
        if data [a] >= 3 or data[b] >= 3:
            answer = "NO"
           
    print(answer)
'''
    
    
        