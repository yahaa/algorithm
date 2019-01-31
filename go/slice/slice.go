package main

import "fmt"

func AB(a []int) {
    fmt.Printf("%p\n", &a)
    for i := 0; i < len(a); i++ {
        a[i] += 1
    }
}

func TT(a [10]int) {
    for i := 0; i < len(a); i++ {
        a[i] += 1
    }

}

func main() {

    a := []int{1, 2, 3, 4, 5, 6, 7}
    fmt.Printf("%p\n", &a)
    AB(a)
    fmt.Println(a)
    fmt.Printf("%p\n", &a)

    v := [10]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    TT(v)
    fmt.Println(v)

}
