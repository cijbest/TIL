def solution(s, n):
    answer = ''
    
    Halpa = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    Lalpa = 'abcdefghijklmnopqrstuvwxyz'
    
    for string in s:
        if string == ' ':
            answer += string
        elif 'A' <= string <= 'Z':
            answer += Halpa[(Halpa.index(string) + n) % 26]
        else:
            answer += Lalpa[(Lalpa.index(string) + n) % 26]
        
    
    return answer

'''
# 다른 사람 풀이
def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i]=chr((ord(s[i])-ord('A')+ n)%26+ord('A'))
        elif s[i].islower():
            s[i]=chr((ord(s[i])-ord('a')+ n)%26+ord('a'))

    return "".join(s)
'''