import sys, math
from collections import deque

def findPrime():
    # 에라토스테네스의 체(제곱근 범위까지 조사)
    for i in range(2, 100):
        # 소수인 상태에서 소수의 배수를 체크해줘야 함
        if prime[i] == True:
            # 소수의 배수 체크
            for j in range(2*i, 10000, i):
                prime[j] = False

def bfs():
    q = deque()
    q.append([start, 0])

    # 방문여부
    visited = [0 for i in range(10000)]
    visited[start] = 1

    while q:
        now, cnt = q.popleft()
        # now를 숫자에서 문자로 변환
        strNow = str(now)

        # 빼낸 값이 end면 cnt 리턴 
        if now == end:
            return cnt
        
        for i in range(4):
            # 각 자리에 0 ~ 9를 넣어가며 소수인지 확인
            for j in range(10):
                temp = int(strNow[:i] + str(j) + strNow[i+1:])

                # 방문 X, 소수 O, 1000이상인 숫자
                if visited[temp] == 0 and prime[temp] and temp >= 1000:
                    visited[temp] = 1
                    q.append([temp, cnt + 1])
         

# 테스트 케이스 횟수
t = int(sys.stdin.readline())
# 소수 판별 배열
prime = [True for _ in range(10000)]
# 소수 판별
findPrime()

for _ in range(t):
    # 입력
    start, end = map(int, sys.stdin.readline().split())
    
    # start ~ end의 단계 카운트
    result = bfs()
    print(result if result != None else "Impossible" )
