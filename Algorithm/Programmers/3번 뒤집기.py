def solution(n):
    answer = ''
    
    while n:
        answer += str(n % 3)
        n = n // 3
    
    answer = int(answer, 3)
    
    return answer