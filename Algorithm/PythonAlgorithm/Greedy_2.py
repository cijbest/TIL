'''
��� �� N�� 1�� �� ������ ������ �� ���� �� �ϳ��� �ݺ������� �����Ͽ� ������ ���� �ּ� Ƚ����?
��, �ι�° ������ N�� K�� ������ ������ ���� ������ �� �ִ�.
1. N���� 1�� ���ϴ�.
2. N�� K�� �����ϴ�.
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