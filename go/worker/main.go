package main

import (
    "fmt"
    "time"
)

func countPrime(n int64) int64 {
    var (
        primes         = make([]int64, n)
        index    int64 = 0
        isPrimes       = make([]int64, n)
    )

    isPrimes[0], isPrimes[1] = 1, 1
    var i int64
    for i = 2; i < n; i++ {
        if isPrimes[i] == 0 {
            primes[index] = i
            index++
        }

        var j int64
        for j = 0; j < index && i*primes[j] < n; j++ {
            isPrimes[i*primes[j]] = 1
            if i%primes[j] == 0 {
                break
            }
        }
    }

    return index
}

func main() {
    t1 := time.Now()
    fmt.Printf("start at %v\n", t1)
    fmt.Printf("count primes=%d\n", countPrime(1000))
    t2 := time.Now()
    fmt.Printf("end at %v\n", t2)
    fmt.Printf("use %d\n", t2.Unix()-t1.Unix())

}
