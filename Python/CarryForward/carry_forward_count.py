
def numberOfCarryOperations(first_no, second_no):
    carry_count=0
    current_carry = 0
    while(first_no!=0 or second_no != 0):

        first_dig=first_no % 10
        second_dig=second_no % 10
        if(first_dig + second_dig + current_carry > 9):
            carry_count=carry_count + 1
            current_carry = (first_dig + second_dig + current_carry) // 10
        else:
            current_carry = 0

        first_no = first_no // 10
        second_no = second_no // 10

    print(carry_count)


def main():
    numberOfCarryOperations(123, 456) # // 0
    numberOfCarryOperations(555, 555) #// 3
    numberOfCarryOperations(900, 11) #// 0
    numberOfCarryOperations(145, 55) #// 2
    numberOfCarryOperations(0, 0) #// 0
    numberOfCarryOperations(1, 99999) #// 5
    numberOfCarryOperations(999045, 1055) #// 5
    numberOfCarryOperations(101, 809) #// 1
    numberOfCarryOperations(189, 209) #// 1


if __name__ == "__main__":
    main()
