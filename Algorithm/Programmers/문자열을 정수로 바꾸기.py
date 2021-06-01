def solution(s):
    
    return int(s)


'''
# 다른 사람 풀이
# 배울 만한 문법이 많음
def strToInt(str):
    result = 0

    for idx, number in enumerate(str[::-1]):
        if number == '-':
            result *= -1
        else:
            result += int(number) * (10 ** idx)

    return result
'''