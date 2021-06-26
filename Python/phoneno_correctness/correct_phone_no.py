import re

def solution(S):
    digits=re.sub('\D','',S)
    chunks = [digits[i:i + 3] for i in range(0, len(digits), 3)]
    if(len(chunks[len(chunks)-1])==1):
        chunks[len(chunks)-1]=chunks[len(chunks)-2][-1]+chunks[len(chunks)-1]
        chunks[len(chunks)-2]=chunks[len(chunks)-2][:-1]
    separator="-"
    return separator.join(chunks)

def main():
    S="0  -  22 1985--324"
    print(solution(S))

if __name__ == "__main__":
    main()