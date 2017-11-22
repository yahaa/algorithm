package main

import (
	"fmt"
)

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	var n int
	fmt.Scanf("%d", &n)
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scanf("%d", &arr[i])
	}

	cur, res := 1, 0
	for i := 1; i < n; i++ {
		if arr[i] >= arr[i-1] {
			cur++
		} else {
			cur = 1
		}
		res = max(res, cur)
	}
	fmt.Println(res)

}
