package main

import (
    "fmt"
    "github.com/reiver/go-telnet"
    "regexp"
)

func main() {

    conn, err := telnet.DialTo("115.231.110.37:9011")
    if err != nil {
        fmt.Println(err)
    }

    conn.Close()


    if ok, _ := regexp.MatchString("^[0-9a-zA-Z-]+$", "0hello-"); ok {
        fmt.Println("ok")
    }

}
