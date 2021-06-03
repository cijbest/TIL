import math
def solution(n):

    sq = math.sqrt(n)
    if sq == int(sq):
        return (sq+1)**2 
    return -1
        
    
'''
# 다른 사람 풀이
def nextSqure(n):
    sqrt = n ** (1/2)

    if sqrt % 1 == 0:
        return (sqrt + 1) ** 2
    return '-1'
'''