def solution(array, commands):
    answer = []
    
    for i, j, k in commands:
        tmp = array[i-1 : j]
        tmp.sort()
        answer.append(tmp[k-1])
    
    return answer