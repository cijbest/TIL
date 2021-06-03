def solution(n, m):
    mul = n * m
    if n < m:
        n, m = m, n
        
    while m != 0:
        tmp = n % m
        n = m
        m = tmp
    
    return [n, mul // n]