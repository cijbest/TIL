def solution(n, arr1, arr2):
    answer = []
    print(zip(arr1,arr2))
    for i in range(len(arr1)):
        a1 = str(bin(arr1[i]))[2:]
        a1 = '0' * (n-len(a1)) + a1
        
        a2 = str(bin(arr2[i]))[2:]
        a2 = '0' * (n-len(a2)) + a2
        
        tmp = ''
        for j in range(len(a1)):
            if a1[j] != a2[j]:
               tmp += '#'
            else :
                if a1[j] == '0':
                    tmp += ' '
                else:
                    tmp += '#'
        answer.append(tmp)
        
    
    return answer