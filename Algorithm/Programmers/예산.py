def solution(d, budget):
    # 부서별로 신청한 금액이 들어있는 배열 : d
    # 예산 : budget
    
    # 부서의 수를 카운팅
    answer = 0
    
    # 작은 예산순으로 정렬
    d.sort()
    
    tmp = 0
    for i in d:
        tmp += i
        # 지정된 예산보다 커지면 반복문을 벗어난다.
        if tmp > budget:
            break
        # 지정된 예산보다 작으면 부서 갯수 +1 
        answer += 1
    
    return answer