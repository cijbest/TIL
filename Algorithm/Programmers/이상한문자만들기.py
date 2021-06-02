def solution(s):
    answer = ''
    
    i = 0
    for string in s:
        if string == ' ':
            answer += ' '
            i = 0
        elif i % 2 :
            answer += string.lower()
            i = 0
        else:
            answer += string.upper()
            i = 1
       
    return answer

'''
# 다른 사람 풀이
def solution(s):

    return " ".join(map(lambda x: "".join([a.lower() if i % 2 else a.upper() for i, a in enumerate(x)]), s.split(" ")))
'''