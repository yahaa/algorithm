# encoding=utf-8


def factorial(n):
    if n == 1:
        return 1
    return n * factorial(n - 1)


def fibonacci(n):
    if n <= 1:
        return 1
    return fibonacci(n - 1) + fibonacci(n - 2)


def next_permutation(arr, k, n):
    # 下一个全排列递归实现
    if k == n:
        print arr
    for i in range(k, n):
        arr[i], arr[k] = arr[k], arr[i]
        next_permutation(arr, k + 1, n)
        arr[i], arr[k] = arr[k], arr[i]


def next_permutation2(a):
    n = len(a)
    if n <= 1:
        return a

    for i in range(n, 1):
        if a[i - 1] < a[i]:
            pass

    pass


def zero_of_factorial_n(n):
    # 阶乘末尾０的个数
    res = 0
    while n > 0:
        res += n / 5
        res /= 5
    return res


def one_of_factorial_n(n):
    res = 0
    while n:
        n >>= 1
        res += n
    return res

def solve():
    n=raw_input()
    a=[]
    for i in range(n):
        t=raw_input()
        a.append(t)
    



def permutation_n(a, n):
    # 求一个序列的第n个字典排序序列,效率高但是空间复杂度高
    res = []
    l = len(a) - 1
    while n != 0:
        i = n / factorial(l)
        res.append(a[i])
        a.remove(a[i])
        n %= factorial(l)
        l -= 1
    a.sort()
    res.extend(a)
    return res


def permutation_n1(a):
    # 求一个序列的第n个字典排序序列,效率较低
    n = len(a)
    if not n:
        return
    i = n - 2
    while i >= 0 and a[i] >= a[i + 1]:
        i -= 1
    if i >= 0:
        j = n - 1
        while a[j] <= a[i]:
            j -= 1
        a[i], a[j] = a[j], a[i]
    left, right = i + 1, n - 1
    while left <= right:
        a[left], a[right] = a[right], a[left]
        left += 1
        right -= 1


def q_sort(a):
    # 快排
    def do_sort(a, left, right):
        if left >= right:
            return
        t = a[left]
        i, j = left, right
        while i != j:
            while a[j] >= t and i < j:
                j -= 1
            while a[i] <= t and i < j:
                i += 1
            if i < j:
                a[i], a[j] = a[j], a[i]
        a[left], a[i] = a[i], a[left]
        do_sort(a, left, i - 1)
        do_sort(a, i + 1, right)

    do_sort(a, 0, len(a) - 1)
    return a


def pao_sort(a):
    # 冒泡排序
    n = len(a)
    for i in range(n):
        for j in range(i, n):
            if a[i] > a[j]:
                a[i], a[j] = a[j], a[i]
    return a


def se_sort(a):
    # 选择排序
    n = len(a)
    for i in range(n):
        mi = i
        for j in range(i + 1, n):
            if a[j] < a[mi]:
                mi = j
        a[mi], a[i] = a[i], a[mi]
    return a


def binary_search(a, target, start=0, end=-1):
    """
    二分差找
    """
    if end < 0:
        end = len(a)
    left, right = start, end - 1
    while left <= right:
        mid = left + (right - left) / 2
        if target == a[mid]:
            while mid > 0 and a[mid - 1] == target:
                mid -= 1
            return mid
        elif a[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return -(mid + 1)


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


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
                self.array[index], self.array[
                    t] = self.array[t], self.array[index]
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
                    self.array[index], self.array[
                        p] = self.array[p], self.array[index]
                else:
                    break
            else:
                if self.array[index] > self.array[p]:
                    self.array[index], self.array[
                        p] = self.array[p], self.array[index]
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
    a = [1, 2, 3, 4, 5, 6, 7, 9]

    print binary_search(a, 0)
    print binary_search(a, 6)
