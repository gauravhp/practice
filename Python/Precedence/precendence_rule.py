def findWord(args):
    dict1 = {k: v for k, v in (a.split(">") for a in args)}
    for k in dict1.keys():
        if k not in dict1.values():
            start=k
    i=len(args)
    curr=start
    word=start
    while(i>0):
        word=word+str(dict1.get(curr))
        curr=dict1.get(curr)
        i-=1

    print(word)


def main():
    findWord(["P>E", "E>R", "R>U"])  # PERU
    findWord(["I>N", "A>I", "P>A", "S>P"])  # SPAIN
    findWord(["U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"])  # HUNGARY
    findWord(["I>F", "W>I", "S>W", "F>T"])  # SWIFT
    findWord(["R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"])  # PORTUGAL
    findWord(["W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"])  # SWITZERLAND


if __name__ == "__main__":
    main()
