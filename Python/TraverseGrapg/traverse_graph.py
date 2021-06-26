

def solution(N, A, B):
    for i in range(1,N+1):
        print(i)
        indices = [index for index, val in enumerate(A) if val == i]
        print(indices)
        found=False
        for index in indices:
            print(B[index])
            if(B[index]==index+1):
                found=True
        if(not found):
            continue
        else:
            return False
    return True

def main():
    N = 4
    A=[1,2,4,4,3]
    B=[2,3,1,3,1]
    print(solution(N,A,B))

if __name__ == "__main__":
    main()