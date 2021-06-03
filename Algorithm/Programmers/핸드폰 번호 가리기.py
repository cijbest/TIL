def solution(phone_number):
    
    answer = ''
    answer = answer.rjust(len(phone_number)-4, '*') + phone_number[-4:]
    
    return answer

'''
def solution(s):
    return "*"*(len(s)-4) + s[-4:]
'''