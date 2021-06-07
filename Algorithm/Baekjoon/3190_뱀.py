import sys
input = sys.stdin.readline
from collections import deque

# 뱀의 현재위치
snake = deque()
snake.appendleft([0,0])

# 왼쪽 90도 기준 (오, 위, 왼, 아)
move = [[0, 1], [-1, 0], [0, -1], [1, 0]]

# 뱀의 현재 방향
idx = 0

# INPUT
N = int(input())
board = [[0] * N for _ in range(N)]

K = int(input())
for _ in range(K):
    x, y = map(int, input().split())
    # 사과 위치 표시
    board[x-1][y-1] = 7

# 게임 시간
sec = 0

L = int(input())
X = []
C = []
for i in range(L):
    t1, t2 = input().split()
    X.append(int(t1))
    C.append(t2)

d = ''
while True:
    # 방향 바꾸는 시간이 되었을 때
    if sec in X:
        # 방향바꾸기
        d = C[X.index(sec)]    
        
        # 왼쪽 90도
        if d == 'L':
            idx = (idx + 1) % 4
        # 오른쪽 90도
        else:
            if (idx - 1) == -1:
                idx = 3
            else:
                idx = (idx - 1) % 4

    nx = snake[0][0] + move[idx][0]
    ny = snake[0][1] + move[idx][1]

    # 벽에 부딪히거나 자기 자신을 만났을 때
    if nx < 0 or ny < 0 or nx > N-1 or ny > N-1 or ([nx, ny] in snake) :
        break
    # 사과일 때
    if board[nx][ny] == 7:
        snake.appendleft([nx, ny])
        board[nx][ny] = 0
    # 사과 아닐 때
    else:
        # 머리 위치 변경, 꼬리 줄이기
        snake.appendleft([nx, ny])
        snake.pop()

    sec += 1
        
# 뱀이 처음 시작자리에 놓이는 시간 포함  
print(sec + 1)
