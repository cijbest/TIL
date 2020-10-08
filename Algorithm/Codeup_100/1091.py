if __name__ == '__main__':
    a, m, d, n = input().split()
    a = int(a)
    m = int(m)
    d = int(d)
    n = int(n)
    
    sol = a
    for x in range(1, n):
        sol = sol * m + d
    print(sol)
