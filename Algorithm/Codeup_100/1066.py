if __name__ == '__main__':
    a,b,c = input().split()
    a = int(a)
    b = int(b)
    c = int(c)
    l = [a,b,c]
    for x in l:
        if(x % 2) == 0:
            print("even")
        else:
            print("odd")

    