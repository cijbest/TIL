n, k = map(int, input().split())

coins= []
for i in range(n):
    coins.append(int(input()))

coins.sort(reverse=True)

count = 0
for coin in coins:
    count += k // coin
    k = k % coin

print(count)
