def solution(N, stages):
    answer = []
    total = len(stages)
    
    # stages를 하나씩 돌면서 계산
    for i in range(1, N+1):
        if total != 0:
            count = stages.count(i)
            calc = count/total
            answer.append([calc, i])
            total -= count
        else:
            answer.append([0, i])
        
    # 실패율이 높은 순이면서 인덱스가 작은 순으로 정렬
    answer.sort(key=lambda x: (-x[0], x[1]))
    # 정렬해놓은 배열에서 1번째 요소들만 뽑는다.
    answer = list(map(list, zip(*answer)))[1]

    
    return answer