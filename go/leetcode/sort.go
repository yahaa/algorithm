package main

import (
    "fmt"
    "math"
    "sort"
)

// intersect 求量个slice的交集
func intersect(nums1 []int, nums2 []int) []int {
    res := make([]int, 0)
    sort.Ints(nums1)
    sort.Ints(nums2)

    n1, n2 := len(nums1), len(nums2)

    for i, j := 0, 0; i < n1 && j < n2; {
        if nums1[i] == nums2[j] {
            res = append(res, nums1[i])
            i++
            j++
        } else if nums1[i] < nums2[j] {
            i++
        } else {
            j++
        }
    }
    return res
}

// intersect 法2
func intersect2(num1, num2 []int) []int {
    m := make(map[int]int)
    for _, v := range num1 {
        _, ok := m[v]
        if ok {
            m[v]++
        } else {
            m[v] = 1
        }
    }
    res := make([]int, 0)
    for _, v := range num2 {
        t, ok := m[v]
        if ok && t > 0 {
            res = append(res, v)
            t--
            m[v] = t
        }
    }
    return res
}

type Strings []string

func (s Strings) Len() int {
    return len(s)
}

func (s Strings) Less(i, j int) bool {
    if len(s[i]) < len(s[j]) {
        return false
    } else if len(s[i]) > len(s[j]) {
        return true
    } else {
        return s[i] < s[j]
    }

}

func (s Strings) Swap(i, j int) {
    s[i], s[j] = s[j], s[i]
}

func findLongestWord(s string, d []string) string {
    ss := Strings(d)
    sort.Sort(ss)
    for _, v := range ss {
        n := len(v)
        i := 0
        for _, c := range s {
            if i < n && string(c) == string(v[i]) {
                i++
            }
        }
        if i == n {
            return v
        }
    }
    return ""
}

func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    m := make(map[int32]int)
    for _, v := range s {
        m[v]++
    }
    for _, v := range t {
        _, ok := m[v]
        if ok {
            m[v]--
            if m[v] == 0 {
                delete(m, v)
            }
        } else {
            return false
        }
    }

    return len(m) == 0
}

type IntHeap []int

func (h IntHeap) Swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h IntHeap) Less(i, j int) bool {
    return h[i] < h[j]
}

func (h IntHeap) Len() int {
    return len(h)
}

func (h *IntHeap) Pop() interface{} {
    old := *h
    n := old.Len()
    x := old[n-1]
    *h = old[:n-1]
    return x
}

func (h *IntHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

type Two struct {
    W int
    H int
}

func (t1 Two) less(t2 Two) bool {
    if t1.W < t2.W && t1.H < t2.H || t1.W < t2.W || t1.W == t2.W && t1.H < t2.H {
        return true
    }
    return false
}

type TwoList []Two

func (t TwoList) Len() int {
    return len(t)
}

func (t TwoList) Less(i, j int) bool {
    return t[i].less(t[j])
}

func (t TwoList) Swap(i, j int) {
    t[i].W, t[i].H, t[j].W, t[j].H = t[j].W, t[j].H, t[i].W, t[i].H
}

func maxEnvelopes(envelopes [][]int) int {
    n := len(envelopes)
    tw := make(TwoList, 0)

    for _, v := range envelopes {
        t := Two{W: v[0], H: v[1]}
        tw = append(tw, t)
    }

    //fmt.Printf("%v 1\n", tw)

    sort.Sort(tw)

    //fmt.Printf("%v 2\n", tw)

    dp := make([]int, n)

    res := 0
    for i := 1; i < n; i++ {
        for j := i - 1; j >= 0; j-- {
            if tw[j].W < tw[i].W && tw[j].H < tw[i].H {
                dp[i] = max(dp[j]+1, dp[i])
                res = max(res, dp[i])
            }
        }
    }
    if n == 0 {
        return 0
    }
    return res + 1
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}

func threeSumClosest(nums []int, target int) int {
    n := len(nums)
    if n <= 3 {
        t := 0
        for _, v := range nums {
            t += v
        }
        return t
    }
    sort.Ints(nums)

    left, right, sum, diff, res := 0, 0, 0, math.MaxInt32, 0
    for i := 0; i < n-2; i++ {
        left = i + 1
        right = n - 1
        for left < right {
            sum = nums[i] + nums[left] + nums[right]

            switch {
            case sum == target:
                return sum
            case sum < target:
                left++
            case sum > target:
                right--
            }

            if abs(target-sum) < diff {
                diff = abs(target - sum)
                res = sum
            }
        }
    }
    return res

}

func jump(nums []int) int {
    left, right, n := 0, 0, len(nums)
    ans := make([]int, n)
    for left < n && right < n {
        for right < left+nums[left] {
            right++
            if right >= n {
                break
            }
            ans[right] = ans[left] + 1
        }
        left++
    }
    return ans[n-1]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func findCheapestPrice(n int, flights [][]int, src int, dst int, K int) int {
    dis := make([]int, n)
    for i := 0; i < n; i++ {
        dis[i] = math.MaxInt32
    }
    dis[src] = 0
    for i := 0; i <= K; i++ {
        t := make([]int, n)
        copy(t, dis)
        for _, v := range flights {
            t[v[1]] = min(t[v[1]], dis[v[0]]+v[2])
        }
        dis = t
    }
    if dis[dst] == math.MaxInt32 {
        return -1
    }
    return dis[dst]

}

var (
    m = map[string][]string{
        "2": {"a", "b", "c"},
        "3": {"d", "e", "f"},
        "4": {"g", "h", "i"},
        "5": {"j", "k", "l"},
        "6": {"m", "n", "o"},
        "7": {"p", "q", "r", "s"},
        "8": {"t", "u", "v"},
        "9": {"w", "x", "y", "z"},
    }
)

func solve(s, res string, ans *[]string) {
    if len(s) <= 0 {
        if len(res) != 0 {
            *ans = append(*ans, res)
        }

        return
    }

    p := m[s[0:1]]
    for _, v := range p {
        solve(s[1:], res+v, ans)
    }

}

func letterCombinations(digits string) []string {
    ans := make([]string, 0)
    solve(digits, "", &ans)
    return ans
}

func tt(s []string) {
    s = append(s, "bbb")
    fmt.Printf("%p,%v\n", s, s)
    s[0] = "aaa"
    fmt.Printf("%p,%v\n", s, s)

}

func firstMissingPositive(nums []int) int {
    n := len(nums)
    if n == 0 {
        return 1
    }
    for i := 0; i < n; i++ {
        for nums[i] > 0 && nums[i] != i+1 {
            if nums[i] > n {
                nums[i] = -1
                break
            }

            if nums[i] == nums[nums[i]-1] {
                break
            }
            nums[i], nums[nums[i]-1] = nums[nums[i]-1], nums[i]

        }
    }

    ans := 1
    for i, v := range nums {
        if v != i+1 {
            return i + 1
        }
        ans = i + 1

    }
    return ans + 1
}

func findDuplicate(nums []int) int {
    i := nums[0]
    for i != nums[i] {
        nums[i], i = i, nums[i]
        fmt.Printf("%v \n", nums)
    }
    return i

}

func romanToInt(s string) int {
    m := map[string]int{
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000,
    }
    res := 0

    n := len(s)
    for i := 0; i < n; i++ {
        var k1 string
        var k2 string
        k1 = s[i : i+1]
        if i+2 <= n {
            k2 = s[i+1 : i+2]
        }

        if m[k1] < m[k2] && i+2 <= n {
            res += m[k2] - m[k1]
            i++
        } else {
            res += m[k1]
        }

    }
    return res

}


func main() {
    fmt.Println(romanToInt(""))
}
