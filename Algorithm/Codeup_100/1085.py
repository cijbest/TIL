if __name__ == '__main__':
    a, b, c, d = input().split()
    a = int(a)
    b = int(b)
    c = int(c)
    d = int(d)

    sol = a * b * c * d / 8 /1024/1024
    print('%.1f MB' % sol)    