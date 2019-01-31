package main

import (
    "fmt"
    "math"
)

func main() {
    var x1, y1, x2, y2 float64
    fmt.Scanf("%f %f %f %f", &x1, &y1, &x2, &y2)
    t1 := math.Abs(y1 - y2)
    t2 := math.Abs(x1 - x2)
    result := math.Sqrt(t1*t1 + t2*t2)
    fmt.Printf("%.3f", result)
}
