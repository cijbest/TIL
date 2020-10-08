if __name__ == '__main__':
    n = int(input())
    s = 0
    for x in range(1, n+1):
        if(x % 2 == 0):
            s += x
    print(s)

    