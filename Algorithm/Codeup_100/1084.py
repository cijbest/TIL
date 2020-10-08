if __name__ == '__main__':
    a, b, c = input().split()
    a = int(a)
    b = int(b)
    c = int(c)
    cnt = 0
    for i in range(0, a):
        for j in range(0, b):
            for k in range(0, c):
                print('%d %d %d' % (i,j,k))
                cnt += 1
    print(cnt)    