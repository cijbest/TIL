import sys
from collections import deque

# 상, 하, 좌, 우
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs():

    while q:
        now = q.popleft()

        # 만족하는 퍼즐일 경우 이동횟수 리턴
        if now == "123456789":
            return cntDict[now]
        
        # 현재 빈칸 위치 (행, 열) 
        pos = now.find("9")
        x = pos // 3
        y = pos % 3

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < 3 and 0 <= ny < 3:
                # 이동할 위치
                nPos = nx * 3 + ny
                # 이동된 상태 설정
                nextNum = list(now)
                nextNum[nPos], nextNum[pos] = nextNum[pos], nextNum[nPos]
                nextNum = "".join(nextNum)

                if not cntDict.get(nextNum):
                    # 이동된 상태 저장, 이동횟수 + 1
                    q.append(nextNum)
                    cntDict[nextNum] = cntDict[now] + 1


# 초기 퍼즐 상태
start = ""
for _ in range(3):
    # 입력 -> 123456780 형태로 변환
    temp = sys.stdin.readline().strip()
    temp = temp.replace(" ", "")
    start += temp

start = start.replace("0", "9")

# 이동된 상태 저장
q = deque()
q.append(start)

# 이동된 상태, 이동횟수 저장
cntDict = dict()
cntDict[start] = 0

# 이동이 불가하면 "-1"을 출력
result = bfs()
print(result if result != None else "-1" )
