import sys
sys.setrecursionlimit(10000)

# 입력
e, s, m = map(int, sys.stdin.readline().split())

# 카운트할 임의의 변수
t1 = t2 = t3 = cnt = 0

while(True):
    # 각각의 범위를 넘어갈 때 1로 초기화
    if t1 == 16:
        t1 = 1
    if t2 == 29:
        t2 = 1
    if t3 == 20:
        t3 = 1
    
    # e, s, m과 같은 수가 되면 루프 종료
    if t1 == e and t2 == s and t3 == m:
        break

    # 카운트
    t1 += 1
    t2 += 1
    t3 += 1
    cnt += 1
    
# 출력
print(cnt)