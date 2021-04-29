def solution(numbers):
    answer = []
    n = len(numbers)
    
    # 두 수를 더한값을 리스트에 넣는다.
    for i in range(n-1):
        for j in range(i+1, n):
            answer.append(numbers[i] + numbers[j])
        
    # set 자료형으로 리스트의 중복값을 제거하고 오름차순으로 정렬
    answer = sorted(list(set(answer)))
    return answer