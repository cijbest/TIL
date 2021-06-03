def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        tmp = []
        for j in range(len(arr1[0])):
            tmp.append(arr1[i][j] + arr2[i][j])
        answer.append(tmp)
        
    return answer

'''
# 다른 사람 풀이
def solution(A,B):
    #answer = [[c + d for c, d in zip(a, b)] for a, b in zip(A,B)]
    #return answer
'''