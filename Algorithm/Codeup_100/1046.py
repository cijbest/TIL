if __name__ == '__main__':
    n1, n2, n3 = input().split()
    n1 = int(n1)
    n2 = int(n2)
    n3 = int(n3)
    s = n1 + n2 + n3
    v = s / 3
    print("%d\n%.1f" % (s,v))