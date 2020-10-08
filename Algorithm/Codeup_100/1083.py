if __name__ == '__main__':
    n = int(input())
    sol = ''

    for x in range(1,n+1):
        if x % 3 == 0 :
            sol += 'X'
        else:
            sol += str(x)
        sol += ' '
    print(sol)
        