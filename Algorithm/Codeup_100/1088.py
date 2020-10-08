if __name__ == '__main__':
    a = int(input())
    
    for x in range(1,a+1):
        if x % 3 == 0:
            continue
        print(x)
    
