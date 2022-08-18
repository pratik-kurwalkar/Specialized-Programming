class GenerateParenthesis:

    def generateParenthesis(self, A) -> list:
        # Create an empty array to store the list of created patterns using parenthesis.
        pattern_list = []
        # Calling generate element method with the following arguments.
        # A - providing value of A
        # opening - A (denotes the number of opening brackets available. Which will be equal to A at the start)
        # closing - A (denotes the number of closing brackets available. Which will be equal to A at the start)
        # string - "" (empty string. Will be used to generate pattern and add to list. Will be useful in recursive call)
        # pattern_list - pattern_list passing the list to the method.
        self.generateElement(A, A, A, "", pattern_list)
        return pattern_list

    def generateElement(self, A, opening, closing, string, pattern_list):
        # Condition to check if the no. of opening and closing brackets are less than 0. If satisfied,
        # will exit the method.
        if opening < 0 or closing < 0:
            return None
        # Condition to check if the opening is greater than closing brackets. If so, parenthesis cannot be balanced.
        if opening > closing:
            return None
        # If there are no opening and closing brackets, it means that opening and closing brackets are already
        # utilized to create the string. So, the string will be appended to the pattern_list
        if opening == 0 and closing == 0:
            pattern_list.append(string)
        # First element that needs to be appended to string is opening bracket.
        # Will recursively call itself to create a tree structure from top to bottom.
        self.generateElement(A, opening - 1, closing, string + "(", pattern_list)
        self.generateElement(A, opening, closing - 1, string + ")", pattern_list)


if __name__ == '__main__':
    temp_object = GenerateParenthesis()
    print(temp_object.generateParenthesis(5))
