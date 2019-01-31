package main

import "fmt"

func shorten(str string) string {
    if len(str) <= 8 {
        return str
    }
    return str[:3] + ".." + str[len(str)-3:]
}
func main() {

    fmt.Println(shorten("ajlsjdfkljadsf"))

}
