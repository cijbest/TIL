def solution(n):
    
    return list(map( int,reversed(list(str(n))) ))

'''
# 다른 사람 풀이 - 문자열에도 reversed를 사용할 수 있으므로 굳이 list로 변환해 줄 필요 없음
def solution(n):
    return list(map(int, reversed(str(n))))
'''