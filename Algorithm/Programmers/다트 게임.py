def solution(dartResult):
    score = []
    number = ''
    for d in dartResult:
        if "0" <= d <= "9":
            number += d
            
        elif d in ("S","D", "T"):
            score.append(int(number))
            number = ''
            if d == "S":
                score[-1] **= 1
            elif d == "D":
                score[-1] **= 2
            else:
                score[-1] **= 3
        elif d in ("*", "#"):
            if d == "*":
                score[-1] *= 2
                if len(score) == 1:  
                    continue
                score[-2] *= 2
            else:
                score[-1] *= -1
    return sum(score)
