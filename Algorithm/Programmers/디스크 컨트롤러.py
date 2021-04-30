import heapq
def solution(jobs):
    last=-1
    now=0
    answer=0
    wait=[]
    n=len(jobs)
    count=0
    while(count<n):
        for job in jobs:
            if last <job[0]<=now:
                answer+=(now-job[0])
                heapq.heappush(wait,job[1])
        if len(wait)>0:
            answer+=len(wait)*wait[0]
            last=now
            now+=heapq.heappop(wait)
            count+=1
        else:
            now+=1
    return answer//n