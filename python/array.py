# encoding=utf-8
import bisect


def threeSum(nums):
    n = len(sums)
    for i in range(n):
        for j in range(i + 1, n):
            pass


def plus_one(digits):
    # leetcode 66
    n = len(digits)
    for i in range(n)[::-1]:
        if digits[i] < 9:
            digits[i] += 1
            return digits
        digits[i] = 0
    digits.append(1)
    digits.reverse()
    return digits


if __name__ == '__main__':
    a = [9]
    print plus_one(a)
    print [1 for i in range(10)]
