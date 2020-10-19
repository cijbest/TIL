'''
어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행할 때의 최소 횟수는?
단, 두번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다.
1. N에서 1을 뺍니다.
2. N을 K로 나눕니다.
'''

n = 17
k = 4

result = 0

while True:
    target = (n // k) * k
    result += n - target
    n = target
    if n < k:
        break
    n = n // k
    result += 1

result -= 1
print(result)