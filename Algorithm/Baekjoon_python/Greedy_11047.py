# n : 동전의 종류 수, k : 만들려는 가치의 합
n, k = map(int, input().split())

# 동전의 종류를 담을 배열
coins= []
for i in range(n):
    coins.append(int(input()))

# 내림차순으로 정렬
coins.sort(reverse=True)

count = 0
for coin in coins:
    # 해당 동전의 최대 개수 계산
    count += k // coin
    k = k % coin

print(count)
