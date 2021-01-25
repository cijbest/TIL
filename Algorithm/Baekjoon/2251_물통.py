import sys
from collections import deque

# x, y의 경우의 수 저장
def pour(x, y):
    if not visited[x][y]:
        visited[x][y] = True
        q.append((x, y))

def bfs():

    while q:
        # x : a물통의 물의 양, y : b물통의 물의 양, z : c물통의 물의 양
        x, y = q.popleft()
        z = c - x - y

        # a 물통이 비어있는 경우 c 물통에 남아있는 양 저장
        if x == 0:
            answer.append(z)
        
        # x -> y
        water = min(x, b-y)
        pour(x - water, y + water)
        # x -> z
        water = min(x, c-z)
        pour(x - water, y)
        # y -> x
        water = min(y, a-x)
        pour(x + water, y - water)
        # y -> z
        water = min(y, c-z)
        pour(x, y - water)
        # z -> x
        water = min(z, a-x)
        pour(x + water, y)
        # z -> y
        water = min(z, b-y)
        pour(x, y + water)


# 입력(리터 범위)
a, b, c = map(int, sys.stdin.readline().split())

# 경우의 수를 담을 큐
q = deque()
q.append((0, 0))

# 방문 여부(visited[x][y])
visited = [[False] * (b+1) for _ in range(a+1)]
visited[0][0] = True

# 답을 저장할 배열
answer = []

bfs()

# 출력
answer.sort()
for i in answer:
    print(i, end=" ")