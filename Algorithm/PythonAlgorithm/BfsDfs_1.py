'''
문제 : 음료수 얼려 먹기
첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어집니다.(1 <= N, M <= 1,000)
두 번째 줄부터 N + 1번째 줄까지 얼음 틀의 형태가 주어집니다.
이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1입니다.

한번에 만들 수 있는 아이스크림의 개수를 출력하시오.
'''

# 나의 풀이 : 해당 좌표가 0값인지 먼저 확인하고 dfs로 좌표를 넘김, 이동할 방향 step도 미리 지정 
'''
def dfs(x, y):
    data[x][y] = 1
    for i in range(4):
        nx = x + step[i][0]
        ny = y + step[i][1]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if data[nx][ny] == 0:
            dfs(nx, ny)


n, m = map(int, input().split())

data = []
result = 0

step = [(1,0), (-1,0), (0,1), (0,-1)]

for i in range(n):    
    data.append(list(map(int, input())))

for i in range(n):
    for j in range(m):
        if data[i][j] == 0:
            result += 1
            dfs(i, j)       

print(result)
'''

# 모범답안 : 좌표만 넘겨주고 dfs에 모든 것을 다 처리, 따로 이동 리스트 생성 X
def dfs(x, y):
    if x < 0 or y < 0 or x >= n or y >= m:
        return False
    if data[x][y] == 0:
        data[x][y] = 1
        
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y + 1)
        dfs(x, y - 1)
        return True
    return False


n, m = map(int, input().split())

data = []
result = 0

for i in range(n):    
    data.append(list(map(int, input())))

for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1 

print(result)