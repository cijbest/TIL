'''
문제 : 모험가 길드
모험가가 N명의 공포도를 조사
공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여
여행을 떠날 수 있는 그룹 수의 최댓값을 구하시오.
'''

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

result = 0
count = 0
for i in range(0, len(arr)):
    count += 1
    if count >= arr[i]:
        result += 1
        count = 0

print(result)
    
