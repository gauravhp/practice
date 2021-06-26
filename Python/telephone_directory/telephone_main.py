def solution(A, B, P):
    arr=[]
    for index, value in enumerate(B):
        if str(P) in value:
            arr.append(A[index])

    if(len(arr)==0):
        return "NO CONTACT"
    arr.sort()
    return arr[0]



def main():
    A=["pim","pom","abc"]
    B=["999999999","777888999","9923988999"]
    P=889991
    print(solution(A,B,P))

if __name__ == "__main__":
    main()