package main

import "fmt"

import "regexp"
import "strings"

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// A479 codeforce
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

// A486 codeforce
func A486(n int64) int64 {
	if n%2 == 0 {
		return n / 2
	}
	return (n-1)/2 - n

}

// A208 codeforce
func A208(s string) string {
	reg1, _ := regexp.Compile(`(WUB)+`)
	s = reg1.ReplaceAllString(s, " ")
	s = strings.TrimLeft(s, " ")
	s = strings.TrimRight(s, " ")
	return s
}

func main() {
	var s string
	fmt.Scanf("%s", &s)
	fmt.Println(A208(s))
}
