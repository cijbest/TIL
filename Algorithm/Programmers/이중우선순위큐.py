import heapq
def solution(operations):
    heap = []
    
    for operation in operations:
        op, num = operation.split()
        if op == "I":
            heapq.heappush(heap, int(num))
        else:
            if len(heap) > 0:
                if num == "1":
                    heap.pop(heap.index(heapq.nlargest(1, heap)[0]))
                if num == "-1":
                    heapq.heappop(heap)
            else:
                pass
            
    if len(heap) == 0:
        return [0, 0]
    else:
        return [max(heap), min(heap)]