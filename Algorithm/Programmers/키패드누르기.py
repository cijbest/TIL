def solution(numbers, hand):
    answer = ''
    L = '*'
    R = '#'
    phone = [(3,1),(0,0),(0,1),(0,2),(1,0),(1,1),(1,2),(2,0),(2,1),(2,2)]
    
    for number in numbers:
        if number in [1, 4, 7]:
            answer += 'L'
            L = number
        elif number in [3, 6, 9]:
            answer += 'R'
            R = number
        else :
            Llen = abs(phone[number][0] - phone[L][0]) + abs(phone[number][1] - phone[L][1])
            Rlen = abs(phone[number][0] - phone[R][0]) + abs(phone[number][1] - phone[R][1])
            if Llen < Rlen:
                answer += 'L'
            elif Llen > Rlen:
                answer += 'R'
            else:
                if hand == 'left':
                    answer += 'L'
                else : answer += 'R'
                        
    return answer


numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = 'right'
print(solution(numbers, hand))