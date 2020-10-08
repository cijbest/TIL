if __name__ == '__main__':
    a, b, c = input().split()
    a = int(a)
    b = int(b)
    c = int(c)

    day = 1
    while day % a != 0 or day % b != 0 or day % c != 0:
        day += 1
    print(day)
