def solution(lottos, win_nums):
    
    # 당첨 갯수에 따른 등수
    result = [6, 6, 5, 4, 3, 2, 1]
    
    # 맞는 번호의 갯수
    cnt = 0
    # 0인 갯수
    zeroCnt = lottos.count(0)
    for number in lottos:
        if number in win_nums:
            cnt += 1
    
    return result[cnt+zeroCnt], result[cnt]