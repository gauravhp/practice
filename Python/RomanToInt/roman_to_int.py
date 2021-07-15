def roman_to_int(s: str) -> int:
    dict1 = {"I": 1,
             "V": 5,
             "X": 10,
             "L": 50,
             "C": 100,
             "D": 500,
             "M": 1000}
    val = 0
    for i, c in enumerate(s):
        if i == len(s) - 1:
            val = val + dict1[c]
            break;
        if dict1.get(s[i]) < dict1.get(s[i + 1]):
            val = val - dict1[c]
        else:
            val = val + dict1[c]
    return val


def main():
    assert (roman_to_int("III") == 3)
    assert (roman_to_int("IV") == 4)
    assert (roman_to_int("IX") == 9)
    assert (roman_to_int("LVIII") == 58)
    assert (roman_to_int("MCMXCIV") == 1994)


if __name__ == "__main__":
    main()
