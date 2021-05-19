def solution(n, lost, reserve):
    # 전체 학생의 수 : n
    # 체육복을 도난당한 학생들의 번호가 담긴 배열 : lost
    # 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 : reserve
    
    zeroClothe = [l for l in lost if l not in reserve]
    twoClothe = [r for r in reserve if r not in lost]
    
    for i in twoClothe:
        forward = i - 1
        backward = i + 1
        
        if forward in zeroClothe:
            zeroClothe.remove(forward)
        elif backward in zeroClothe:
            zeroClothe.remove(backward)

    return n - len(zeroClothe)
    
    '''
    students = [1] * n
    
    # students 테이블에 lost, reserve 상태를 반영
    for i in range(n):
        if i+1 in lost:
            students[i] -= 1
        if i+1 in reserve:
            students[i] += 1
    
    for i in range(n):
        # 도난 당한 학생일 경우
        if students[i] == 0:
            # 첫번째 학생 : 바로 뒤에 있는 학생의 여벌 여부만을 확인
            if i == 0:
                if students[i+1] > 1:
                    students[i] += 1
                    students[i+1] -= 1
            # 마지막 학생 : 바로 앞에 있는 학생의 여벌 여부만을 확인
            elif i == n-1:
                if students[i-1] > 1:
                    students[i] += 1
                    students[i-1] -= 1
            # 그 외
            else:
                # 바로 앞에 있는 학생이 여벌을 가지고 있는 것부터 체크하고 없으면 뒤에 있는 학생의 여벌 여부를 체크
                if students[i-1] > 1:
                    students[i] += 1
                    students[i-1] -= 1
                elif students[i+1] > 1:
                    students[i] += 1
                    students[i+1] -= 1
    
    # 옷 갯수가 0이 아닌 학생의 수를 카운트                
    answer = 0
    for student in students:
        if student > 0:
            answer += 1
    
    return answer
    '''