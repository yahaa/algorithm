package main

import "fmt"

func main() {
    var n, m int
    fmt.Scanf("%d/%d", &n, &m)

    t := zdgys(n, m)
    fmt.Printf("%d/%d", n/t, m/t)
}

// 最大公约数
func zdgys(n, m int) int {
    t := min(n, n)
    var res = 1

    for i := 1; i <= t; i++ {
        if n%i == 0 && m%i == 0 {
            res = i
        }
    }
    return res

}

// 求最小值
func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
