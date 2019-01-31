package main

import (
    "bufio"
    "os"
    "strings"
    "fmt"
)

// 自定义 ReadLine 函数，该函数能从键盘读入包含空格的字符串，
func ReadLine(s *string) {
    reader := bufio.NewReader(os.Stdin)
    data, _, _ := reader.ReadLine()
    *s = string(data)
}

func main() {
    var s string
    ReadLine(&s) // 读入整行

    str := strings.Split(s, " ") // 用空格 " " 分割字符串 s。strings.Split（）函数返回字符串切片
    //fmt.Println(str)             // 把str 字符串切片输出

    for i := len(str) - 1; i >= 0; i-- {
        fmt.Printf("%s ", str[i])
    }

}
