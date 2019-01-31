package main

import "fmt"

func main() {
    //var n int
    //fmt.Scanf("%d", &n) // 输入正整数 n
    //
    //if n%2 == 1 { // 判断 n 是奇数还是偶数
    //    fmt.Println("odd")
    //} else {
    //    fmt.Println("even")
    //}

    s := "abzABZ09"
    a := []int{1, 2, 3,}
    for _, v := range s {
        fmt.Printf("%d ", v)

    }

    a[0] = 100
    fmt.Printf(s)
}

func isDx(s string) bool {
    if len(s) > 1 {
        return false
    }
}
