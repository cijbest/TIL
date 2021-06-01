def solution(s):
    
    if s.lower().count('p') == s.lower().count('y'):
        return True

    return False


'''
# 다른 사람 풀이
def solution(s):
    
    return s.lower().count('p') == s.lower().count('y'):
'''