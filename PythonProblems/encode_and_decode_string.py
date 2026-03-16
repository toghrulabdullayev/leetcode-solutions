from ast import List


# ! NOTE: in problem you are asked to write the stateless code (without any additional data structures for lengths and etc)
# O(n)
def encode(strs):
    res = ""
    # putting each word's length in front of special char (here, #) and then the word itself
    for s in strs:
        res += str(len(s)) + "#" + s
    return res


# O(n)
def decode(encoded):
    res, i = [], 0

    # i points to the length of word
    while i < len(encoded):
        j = i  # i serves as a left, j - as a right pointer
        while encoded[j] != "#":
            j += 1
        length = int(encoded[i:j])  # takes the length
        res.append(encoded[j + 1: j + 1 + length])  # takes the word using its length
        i = j + 1 + length  # sets i to the num right after the word
    return res


# Overall time complexity: O(n) n = total length of characters
arr = ["leet", "code", "love", "you"]
string = encode(arr)
print(string)
print(decode(string))
