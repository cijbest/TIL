def solution(strings, n):
    
    answer = sorted(strings)
    answer.sort(key=lambda x : x[n])
    return answer