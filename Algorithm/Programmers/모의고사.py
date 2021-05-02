def solution(answers):
    answer = []
    
    # 각 사람의 정답 갯수 저장
    count = [0, 0, 0]
    
    # 찍는 패턴 저장
    one = [1, 2, 3, 4, 5]
    two = [2, 1, 2, 3, 2, 4, 2, 5]
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for i in range(len(answers)):
        if answers[i] == one[(i%5)]:
            count[0] += 1
        if answers[i] == two[(i%8)]:
            count[1] += 1
        if answers[i] == three[(i%10)]:
            count[2] += 1
    

    for i in range(3):
        if count[i] == max(count):
            answer.append(i+1)
    
    return answer