def solution(a, b):
    
    months = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days = ['THU','FRI','SAT','SUN','MON','TUE','WED']
    
    count = 0
    for i in range(a-1):
        count += months[i]
    count += b
    answer = days[count%7]
    
    return answer