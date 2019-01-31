package main

import (
    "fmt"
    "math"
)

func main() {
    var a, b, c int
    fmt.Scanf("%d %d %d", &a, &b, &c)
    if isSanjiaox(a, b, c) {
        fmt.Printf("%.5f\n", mj(float64(a), float64(b), float64(c)))
    } else {
        fmt.Printf("不是三角形")
    }
}

// 判断三条边能不能构成三角形
func isSanjiaox(a, b, c int) bool {
    if a+b > c && a+c > b && b+c > a { // 任意两边之和都大于第三边，那么a,b，c能构成三角形
        return true
    }
    return false

}

// 根据三角形三边长求出三角形面积
func mj(a, b, c float64) float64 {
    t := (a + b + c) / 2
    res := t * (t - a) * (t - b) * (t - c)
    result := math.Sqrt(res) // math.Sqrt() 函数能求开方数
    return result

}
