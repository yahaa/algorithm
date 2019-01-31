package main

import (
    "fmt"
    "github.com/jlaffaye/ftp"
    "log"
    "net/textproto"
    "path/filepath"
    "strings"
    "time"
)


func main() {
    c, err := ftp.DialTimeout("127.0.0.1:21", 5*time.Second)
    if err != nil {
        log.Fatal(err, "tcp dial error")
    }

    err = c.Login("test", "test")
    if err != nil {
        log.Fatal(err, "login error")
    }

    fmt.Println(makeDirR(c, "/a/b/c/c/d/j/hha/bb/cc", true))

    c.Logout()

}
