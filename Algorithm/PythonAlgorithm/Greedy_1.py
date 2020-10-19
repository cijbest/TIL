'''
500원, 100원, 50원, 10원짜리 동전으로 거스름을 거슬러 줄 때
사용할 동전의 최소 개수는?
'''

#  n : 거스름돈
n = 1260
count = 0

coins = [500, 100, 50, 10]

for coin in coins:
    count += n // coin
    n = n % coin

print(count)