if __name__ == '__main__':

    h = input()
    
    for i in range(1, 16):
        result = '{:x}'.format(int(h, 16) * i)
        print(h + '*' + '{:x}'.format(i,16).upper() + '=' + result.upper())


