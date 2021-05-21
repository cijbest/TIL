def solution(board, moves):
    answer = 0
    
    # 꺼내 온 인형 보관하는 곳
    stack = []
    # stack의 끝 위치에 있는 인형 종류값 저장
    curDoll = 0
    
    for move in moves:
        # 해당 열을 탐색하며 0이 아닌 값을 찾는다.
        for i in range(len(board)):
            # 인형이 있다면
            if board[i][move-1] != 0:
                #print(i, move)
                pickedDoll = board[i][move-1]
                
                # 현재 stack 위에 있는 인형의 종류와 같을 때
                # 빠져나온 인형 2개 증가, stack에서 인형 제거
                if curDoll == pickedDoll :
                    answer += 2
                    stack.pop()
                # 현재 stack 위에 있는 인형의 종류와 같지 않을 때
                # stack에 인형 추가, 현재 인형 종류 갱신
                else :
                    stack.append(pickedDoll)
                    curDoll = pickedDoll
                
                # 뽑은 인형 자리는 빈 자리로 갱신
                board[i][move-1] = 0
                break
    
        
    
    return answer


board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves = [1,5,3,5,1,2,1,4]

print(solution(board, moves))