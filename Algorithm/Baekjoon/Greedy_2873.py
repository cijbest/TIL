# r : 행, c : 열
r, c = map(int, input().split())

data = []
for i in range(r):
    data.append(list(map(int,input().split())))

x, y = 0, 0

# D, U, R, L 순
dx = [1,-1,0,0]
dy = [0,0,1,-1]

# R, D, L, D
case1 = [2,0,3,0]
# D, R, U, R
case2 = [0,2,1,2]
# R, D, L, D
case3 = [2,0,3,0]



