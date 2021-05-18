def solution(phone_book):
    
    phone = dict()
    
    for p in phone_book:
        phone[p] = 1
    
    for p in phone_book:
        tmp = ''
        for i in p:
            tmp += i
            if tmp in phone.keys() and tmp != p:
                return False
    
    return True