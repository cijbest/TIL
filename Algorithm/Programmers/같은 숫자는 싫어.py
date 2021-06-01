def solution(arr):
    answer = []
    
    # 위치 포인터
    p = 0
    answer.append(arr[0])

    i = 1
    while i < len(arr):
        # 포인터가 위치한 값과 같을 때
        if arr[p] == arr[i]:
            i += 1
            continue

        # 포인터가 위치한 값과 다를 때 : 포인터 이동
        answer.append(arr[i])
        p = i
        i = p + 1       
    
    return answer


'''
# 다른 사람 풀이
def no_continuous(s):
    a = []
    for i in s:
        if a[-1:] == [i]: continue
        a.append(i)
    return a
'''