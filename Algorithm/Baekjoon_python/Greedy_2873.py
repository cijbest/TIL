# r : 행, c : 열
r, c = map(int, input().split())

data = []
for i in range(r):
    data.append(list(map(int,input().split())))

x, y = 0, 0

# D, U, R, L 순
dx = [1,-1,0,0]
dy = [0,0,1,-1]

# r이 홀수일 때 => R, D, L, D
# r이 짝수이고 c가 홀수일 때 => D, R, U, R

if r % 2 != 0:
    print('R' * c + 'D' + 'L')

        

