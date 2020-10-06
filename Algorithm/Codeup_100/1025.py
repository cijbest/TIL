if __name__ == '__main__':
    n = input()
    le = len(n)
    for x in str(n):
        tmp = int(x) * 10**(le-1)
        print("[%d]" % tmp)
        le -= 1