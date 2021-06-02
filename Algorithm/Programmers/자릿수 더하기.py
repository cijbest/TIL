def solution(n):
    
    return sum(map(int,list(str(n))))
    

'''
# 다른 사람 풀이
def solution(n):
    if n < 10:
        return n;
    return (n % 10) + solution(n // 10) 
'''