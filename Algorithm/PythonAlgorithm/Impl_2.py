'''
정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시간 중에서
3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시고.
'''

h = int(input())

result = 0

for h in range(h+1):
    for m in range(60):
        for s in range(60):
            s = str(h) + str(m) + str(s)
            if '3' in s:
                result += 1

print(result)