package main

import (
    "fmt"
    "math"
    "time"
)

func isPrimef(n int64) bool {
    if n == 2 || n == 3 {
        return true
    }
    if n%6 != 1 && n%6 != 5 {
        return false
    }
    sq := int64(math.Sqrt(float64(n)))

    var i int64
    for i = 5; i <= sq; i += 6 {
        if n%i == 0 || n%(i+2) == 0 {
            return false
        }
    }
    return true
}

func main() {

    t1 := time.Now()
    fmt.Printf("start at %v\n", t1)
    var i int64
    ans := 0
    for i = 0; i < 100000000; i++ {
        if isPrimef(i) {
            ans++
        }
    }

    fmt.Printf("count primes=%d\n", ans)
    t2 := time.Now()
    fmt.Printf("end at %v\n", t2)
    fmt.Printf("use %d\n", t2.Unix()-t1.Unix())

}
