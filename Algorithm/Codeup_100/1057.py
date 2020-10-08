if __name__ == '__main__':
    a,b = input().split()
    a = bool(int(a))
    b = bool(int(b))
    s = int(a == b)
    print(s)
    