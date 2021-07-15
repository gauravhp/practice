open_parenthesis = ["[", "{", "("]
close_parenthesis = ["]", "}", ")"]


def get_matching_open_parenthesis(paren):
    return open_parenthesis[close_parenthesis.index(paren)]


def get_matching_close_parenthesis(paren):
    return close_parenthesis[open_parenthesis.index(paren)]


def proper_nesting(str):
    print("############")
    if not str.strip():
        return str

    stack = []
    final_str = str
    for i in str:

        if i in open_parenthesis:
            stack.append(i)
        elif i in close_parenthesis:
            if stack and i == get_matching_close_parenthesis(stack[len(stack) - 1]):
                stack.pop()
                continue
            elif stack and i != get_matching_close_parenthesis(stack[len(stack) - 1]):
                raise ValueError('Cannot create a proper nesting with given substring in in')
            elif not stack:
                final_str = get_matching_open_parenthesis(i) + final_str
                continue
    while stack:
        i = stack.pop(0)
        if i in close_parenthesis:
            raise ValueError('Cannot create a proper nesting with given substring in in')
        final_str = final_str + get_matching_close_parenthesis(i)
    return final_str


def main():
    proper_nesting("()[]")  #
    proper_nesting("]-(")  #
    proper_nesting("}{[()](()v())}])")  #
    proper_nesting("")  # empty string
    proper_nesting("([]]}")  # error


if __name__ == "__main__":
    main()
