if __name__ == '__main__':
    a, b = input().split()
    a = int(a)
    b = int(b)
    
    for i in range(1, a+1):
        for j in range(1, b+1):
            print('%d %d' % (i,j))
        