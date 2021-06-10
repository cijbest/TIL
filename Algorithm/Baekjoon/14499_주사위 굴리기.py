import sys
input = sys.stdin.readline

# 동, 서, 북, 남
direct = [(0, 1), (0, -1), (-1, 0), (1, 0)]

#INPUT
n, m, x, y, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
move = list(map(int, input().split()))

# 주사위에 적힌 수 보관 (전개도)
dice = [0] * 6

def changeDiceState(i):
    if i == 1:
        dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
    elif i == 2:
        dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
    elif i == 3:
        dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
    else:
        dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]

for i in move:
    nx = x + direct[i-1][0]
    ny = y + direct[i-1][1]
    
    # 범위 밖에 있으면 명령 건너뛰기
    if nx < 0 or ny < 0 or nx > n - 1 or ny > m - 1:
        continue

    # 주사위 전개도 배치 바꾸기
    changeDiceState(i)

    # 지도 칸의 숫자가 0일 때
    if board[nx][ny] == 0:
        board[nx][ny] = dice[5]
    # 지도 칸의 숫자가 0이 아닐 때
    else:
        dice[5] = board[nx][ny]
        board[nx][ny] = 0
    
    x = nx
    y = ny

    # 주사위 윗면 출력
    print(dice[0])

