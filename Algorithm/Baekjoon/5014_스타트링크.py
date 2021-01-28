import sys
from collections import deque

def bfs():
    # 현재 층과 누적 버튼 수 저장하는 큐
    q = deque()
    q.append((S, 0))
    visited[S] = True

    while q:
        now, cnt = q.popleft()

        # 현재 층이 G층이라면 누적 버튼 수를 리턴
        if now == G:
            return cnt
        
        # U(위)버튼 누르는 경우의 수
        if now + U <= F and not visited[now + U] :
            q.append((now + U, cnt + 1))
            visited[now + U] = True

        # D(아래)버튼 누르는 경우의 수
        if now - D >= 1 and not visited[now - D] :
            q.append((now - D, cnt + 1))
            visited[now - D] = True


# 입력
F, S, G, U, D = map(int, sys.stdin.readline().split())

# 층 방문 여부
visited = [False for _ in range(F+1)]

# 출력
result = bfs()
print(result if result != None else "use the stairs")