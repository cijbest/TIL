if __name__ == '__main__':
    a,b = input().split()
    a = bool(int(a))
    b = bool(int(b))
    if a == False and b == False:
        print(1)
    else:
        print(0)    

    