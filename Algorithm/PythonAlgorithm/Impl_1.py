'''
���డ A�� N x N ũ���� ���簢�� ���� ���� �ְ�
������ǥ�� (1, 1)�̴�.
�ϳ��� �ٿ� ���⸦ �������� 
L(����), R(������), U(��), D(�Ʒ�) �� �ϳ��� ���ڰ� �ݺ������� �Էµ� ��
���� �������� ���Ͻÿ�.
'''

n = int(input())
x, y = 1, 1
plans = input().split()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

for p in plans:
    for i in range(len(move_types)):
        if p == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
            if(nx < 1 or ny > n or nx < 1 or ny > n):
                continue
            x, y = nx, ny

print(x, y)