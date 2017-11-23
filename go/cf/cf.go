package main

import "fmt"

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// codeforce 479A
func A479(a, b, c int) int {
	res := 0
	res = max(res, a+b+c)
	res = max(res, a*b*c)
	res = max(res, a+b*c)
	res = max(res, a*b+c)
	res = max(res, (a+b)*c)
	res = max(res, a*(b+c))
	return res
}

func main() {
	var a, b, c int
	fmt.Scanf("%d\n%d\n%d\n", &a, &b, &c)
	fmt.Println(A479(a, b, c))
}
