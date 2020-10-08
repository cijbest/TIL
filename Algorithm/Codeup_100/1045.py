if __name__ == '__main__':
    n1, n2 = input().split()
    n1 = int(n1)
    n2 = int(n2)
    s = n1 + n2
    d = n1 - n2
    m = n1 * n2
    r = n1 // n2
    t = n1 % n2
    rr = n1 / n2
    print("%d\n%d\n%d\n%d\n%d\n%.2f" % (s,d,m,r,t,rr))