def solution(x):
    s = 0

    xl = list(str(x))
    for i in xl:
        s += int(i)
    
    if x % s:
        return False
    return True

    '''
    # 다른 사람 풀이
    return x % sum([int(c) for c in str(x)]) == 0
    '''