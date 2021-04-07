# n <= 10만
import sys
input = sys.stdin.readline


n = int(input())


cnt = 0
i = n - 1
while n:
    if n == 1:
        cnt += 1
        break
    if n >= i ** 2:
        cnt += 1
        n -= i ** 2
    else:
        i -= 1


print(cnt)