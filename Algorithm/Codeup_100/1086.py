if __name__ == '__main__':
    a, b, c= input().split()
    a = int(a)
    b = int(b)
    c = int(c)

    sol = a * b * c / 8 /1024/1024
    print('%.2f MB' % sol)    