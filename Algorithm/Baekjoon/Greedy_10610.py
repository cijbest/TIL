# n : 입력받을 숫자
n = input()

# 숫자에 0이 없으면 30의 배수가 아니다.
if '0' not in n:
    print(-1)
else:
    sum = 0
    for i in n:
        sum += int(i)
    if sum % 3 == 0:
        # 내림차순 정렬
        print(''.join(sorted(n,reverse=True)))
    else:
        print(-1)
