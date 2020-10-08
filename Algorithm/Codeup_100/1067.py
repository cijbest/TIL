if __name__ == '__main__':
    x = input()
    x = int(x)

    if(x % 2) == 0:
        if(x > 0):
             print("plus\neven")
        else:
            print("minus\neven")
    else:
        if(x > 0):
            print("plus\nodd")
        else:
            print("minus\nodd")

    