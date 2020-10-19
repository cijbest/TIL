'''
알파벳 대문자와 숫자(0 ~ 9)로만 구성된 문자열이 입력으로 주어진다.
모든 알파베을 오름차순으로 전렬하여 이어서 출력한 뒤에
그 뒤에 모든 숫자를 더한 값을 이어서 출력하시오.
'''

data = input()

alpha = []
num = 0

for d in data:
    if d.isalpha():
        alpha.append(d)
    else:
        num += int(d)

alpha.sort()

if num != 0:
    alpha.append(str(num));

print(''.join(alpha))