import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    data = []
    for i in range(2):
        data.append(list(map(int, input().split())))
    
    # 1번째 값 초기화
    data[0][1] += data[1][0]
    data[1][1] += data[0][0]
    # 0번째 행과 1번째 행을 나눠 최대값 계산
    # 따로 dp 테이블 만들지 않고 데이터 보관한 테이블에 최대값을 갱신
    for i in range(2, n):
        data[0][i] += max(data[1][i-1], data[1][i-2])
        data[1][i] += max(data[0][i-1], data[0][i-2])

    # 0번째 행과 1번째 행에 n열의 값을 비교해서 가장 큰 값을 리턴
    print(max(data[0][n-1], data[1][n-1]))   