'''
여행가 A는 N x N 크기의 정사각형 공간 위에 있고
시작좌표는 (1, 1)이다.
하나의 줄에 띄어쓰기를 기준으로 
L(왼쪽), R(오른쪽), U(위), D(아래) 중 하나의 문자가 반복적으로 입력될 때
최종 도착지를 구하시오.
'''

n = int(input())
x, y = 1, 1
plans = input().split()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

for p in plans:
    for i in range(len(move_types)):
        if p == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
            if(nx < 1 or ny > n or nx < 1 or ny > n):
                continue
            x, y = nx, ny

print(x, y)