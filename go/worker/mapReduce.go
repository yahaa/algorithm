package main

import (
	"fmt"
	"math"
	"sync"
	"time"
)

var ch = make(chan int64, 10000000)

func isPrime(n int64) bool {
	if n == 1 {
		return false
	}
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

func worker(index int64, wg *sync.WaitGroup) {
	var i int64
	for i = index * 100000; i < (index+1)*100000; i++ {
		if isPrime(i) {
			ch <- i
		}
	}
	wg.Done()
}

func main() {

	//ta := time.Now()
	//fmt.Printf("start as loop %v\n", ta)
	//c1 := 0
	//for i := 0; i < 100000000; i++ {
	//	if isPrime(int64(i)) {
	//		c1++
	//	}
	//}
	//tb := time.Now()
	//fmt.Printf("end loop primes=%v,at %v\n", c1, tb)
	//fmt.Printf("loop use %d s\n", tb.Unix()-ta.Unix())




	t1 := time.Now()
	fmt.Printf("start at goroutine %v\n", t1)

	wg := &sync.WaitGroup{}
	var i int64
	for i = 0; i < 1000; i++ {
		wg.Add(1)
		go worker(i, wg)
	}

	wg.Wait()

	fmt.Printf("wait at %v\n", time.Now())
	close(ch)
	ans := 0

	for _ = range ch {
		ans++
	}

	fmt.Printf("count primes=%d\n", ans)
	t2 := time.Now()
	fmt.Printf("end at %v\n", t2)
	fmt.Printf("goroutine use %d s\n", t2.Unix()-t1.Unix())

}
