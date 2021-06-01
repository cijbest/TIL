def solution(arr, divisor):
    answer = []
    for a in arr:
        if a % divisor == 0:
            answer.append(a)
            
    if len(answer) == 0:
        answer.append(-1)
    answer.sort()

    return answer

'''
def solution(arr, divisor): 
    # 빈 배열이면 False로 인식하기 때문에 or 다음 부분으로 넘어간다.
    return sorted([n for n in arr if n % divisor == 0]) or [-1]
'''