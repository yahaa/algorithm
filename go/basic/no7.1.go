package main

import (
    "fmt"
)

// 求 x 的 n 次方，这里只考虑 n>0
func pow(x float64, n int) float64 {
    for i := 1; i < n-1; i++ {
        x *= x
    }
    return x
}

func main() {
    var x float64
    var n int
    fmt.Scanf("%f %d", &x, &n)
    fmt.Println(pow(x, n))

    // fmt.Println(math.Pow(x, float64(n))) // 第二种办法，直接使用 math 包下面的Pow函数

}
