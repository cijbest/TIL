import math
def solution(n): 
    if n == 0:
        return 0
    
    answer = 0
    
    for i in range(1, int(math.sqrt(n))+1):
        if n % i == 0:
            if i == int(math.sqrt(n)) and math.sqrt(n) == int(math.sqrt(n)):
                answer += int(math.sqrt(n))
                continue
           
            answer += i + (n // i)
        
    return answer


print(solution(25))