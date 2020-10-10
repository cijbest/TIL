if __name__ == '__main__':
    n = input()
    ran = input().split()
    ran = list(map(int, ran))

    result = [0 for i in range(24)]

    for x in ran:
        result[x] += 1

    for x in range(1, len(result)):
        print(result[x], end=' ')
