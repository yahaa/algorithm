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


class Heap(object):
    """
    基于list实现的堆,
    初始化时若指定 minm=True ,为最小堆，反之为最大堆
    """

    def __init__(self, array=[], size=0, minm=True):
        self.array = array
        self.minm = minm
        if size != 0:
            self.size = size
        else:
            self.size = len(array)
        self.__create()

    def __create(self):
        for i in range(0, self.size / 2)[::-1]:
            self.__siftdown(i)

    def __siftdown(self, index=0):
        while index * 2 + 1 < self.size:
            t = index
            if self.minm:
                if self.array[index * 2 + 1] < self.array[index]:
                    t = index * 2 + 1
                if index * 2 + 2 < self.size and self.array[index * 2 + 2] < self.array[t]:
                    t = index * 2 + 2
            else:
                if self.array[index * 2 + 1] > self.array[index]:
                    t = index * 2 + 1
                if index * 2 + 2 < self.size and self.array[index * 2 + 2] > self.array[t]:
                    t = index * 2 + 2

            if t != index:
                self.array[index], self.array[t] = self.array[t], self.array[index]
                index = t
            else:
                break

    def __siftup(self, index=-1):
        if index == -1:
            index = self.size - 1
        while index > 0:
            p = (index - 1) / 2
            if self.minm:
                if self.array[index] < self.array[p]:
                    self.array[index], self.array[p] = self.array[p], self.array[index]
                else:
                    break
            else:
                if self.array[index] > self.array[p]:
                    self.array[index], self.array[p] = self.array[p], self.array[index]
                else:
                    break

    def pop(self):
        res = self.top
        if self.size > 0:
            self.array[0], self.array[self.size -
                                      1] = self.array[self.size - 1], self.array[0]

            self.size -= 1
            self.__siftdown()
        return res

    @property
    def top(self):
        if self.size > 0:
            return self.array[0]
        return None

    def setSize(self, val):
        self.size + val

    def insert(self, val):
        self.array.append(val)
        self.size += 1
        self.__siftup(self.size - 1)

    @staticmethod
    def heapSort(a, esc=False):
        heap = Heap(a, minm=esc)
        while heap.size > 0:
            heap.pop()
        return a


if __name__ == '__main__':
    a = [9]
    print plus_one(a)
    print [1 for i in range(10)]
    c = [99, 5, 36, 2, 19, 1, 46, 12, 7, 22, 25, 28, 17, 92]
    bb = Heap(c)
    print bb.top
    bb.pop()
    bb.insert(45)

    t = [3, 4, 2, 5, 6, 2]

    print Heap.heapSort(t)
    y = Heap()

    print y.pop()
    print y.top
