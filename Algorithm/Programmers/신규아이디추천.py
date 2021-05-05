def solution(new_id):
    
    # 1단계
    new_id = new_id.lower()
    
    # 2단계
    answer = ''
    for string in new_id:
        if string.isalnum() or string in '-_.':
            answer += string
    
    # 3단계
    while '..' in answer:
        answer = answer.replace('..', '.')
    
    # 4단계
    if answer[0] == '.' and len(answer) > 1:
        answer = answer[1:]
    if answer[-1] == '.':
        answer = answer[:-1]
        
    # 5단계
    if answer == '':
        answer = 'a'

    # 6단계
    if len(answer) >= 16:
        answer = answer[: 15]
        if answer[-1] == '.':
            answer = answer[:-1]
            
    # 7단계
    if len(answer) <= 3:
        answer = answer + answer[-1] * (3- len(answer))
        
        
    return answer