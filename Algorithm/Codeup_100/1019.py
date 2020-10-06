if __name__ == "__main__" :
    y,m,d = input().split(".")
    y = int(y)
    m = int(m)
    d = int(d)
    print('%04d.%02d.%02d' % (y, m, d))

