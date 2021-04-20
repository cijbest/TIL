def solution(s):
    answer = ''
    
    length = len(s)
    # 길이가 홀수일 때
    if length % 2:
        return s[length//2]
    else:
        return s[length//2 - 1] + s[length//2]