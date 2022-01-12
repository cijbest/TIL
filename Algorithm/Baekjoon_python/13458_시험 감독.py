import sys
sys.stdin.readline

# INPUT
N = int(input())
data = list(map(int, input().split()))
B, C = map(int, input().split())

# 감독관 수
cnt = 0

for d in data:
    # 총감독이 감독할 수 있는 사람 빼기
    d -= B
    # 아직 감독해야할 사람이 있는 경우
    if d > 0:
        # 부감독관이 감독할 수 있는 사람이 딱 떨어지는 경우(총감독관 1명 포함)
        if (d/C) == int(d/C):
            cnt += 1 + (d/C)
        # 부감독관이 감독할 수 있는 사람보다 조금 더 있는 경우(총감독관 1명 포함)
        else:
            cnt += 1 + int(d/C) + 1
    # 총감독만으로 시험장 감독이 가능한 경우
    else:
        cnt += 1
        
print(int(cnt))