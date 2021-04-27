import heapq
def solution(scoville, K):
    
    h = []
    # heapq.heapify(scoville)는 아래 for문과 같다. h가 필요없어진다.
    for value in scoville:
        heapq.heappush(h, value)
    
    count = 0
    while h:
        # 스코빌 점수가 없거나 스코빌 점수가 1개만 있거나 남아있을 때 K 이하 이면 목표에 도달X
        if (len(h) == 1 and h[0] < K) or len(h) == 0:
            return -1
        
        tmpS1 = heapq.heappop(h)
        # 첫번째로 작은 수가 K보다 크면 다른 수들은 K이상이므로 횟수 리턴
        if tmpS1 >= K:
            return count
        tmpS2 = heapq.heappop(h) * 2
        count += 1
        heapq.heappush(h, tmpS1+tmpS2)