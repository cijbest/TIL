n = int(input())

sum = 0
minus = []
plus = []
for i in range(n):
    num = int(input())
    if num < 0:
        minus.append(num)
    elif num > 1:
        plus.append(num)
    else:
        sum += num
        continue

plus.sort(reverse=True)
minus.sort(reverse=True)

for i in range(0, len(plus), 2):
    if i+1 < len(plus):
        sum += (plus[i] * plus[i+1])
    else:
        sum += plus[i]

for i in range(0, len(minus), 2):
    if i+1 < len(minus):
        sum += (minus[i] * minus[i+1])
        print(minus[i] , minus[i+1])
    else:
        sum += minus[i]
print(sum)
    




