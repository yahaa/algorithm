package main

import (
    "fmt"
    "time"
)

var (
    ak         = ""
    sk         = ""
    bucketName = "zihuaa"
)

func main() {

    //client, err := oss.New("oss-cn-beijing.aliyuncs.com", ak, sk)
    //if err != nil {
    //    fmt.Println("something error")
    //}
    ////bucket,err:=client.Bucket(bucketName)
    //res, err := client.ListBuckets()
    //fmt.Println(res.Buckets)
    //
    //bucket, err := client.Bucket(bucketName)
    //
    //err = bucket.PutObjectFromFile("zihuatest", "/Users/zihua/Desktop/hyd.png")
    //if err != nil {
    //    fmt.Println(err)
    //}

    //m := make(map[string]string)
    //m["111"] = "111"
    //m["112"] = "111"
    //
    //layout := "2006-01-02 15:04:05"
    //fmt.Println(len(m))
    //t := "2018-09-05 10:22:15"
    //tn, err := time.Parse(layout, t)
    //if err != nil {
    //    fmt.Println(err)
    //}
    //fmt.Println(tn)
    //
    //res := []string{"as", "at", "ataman", "baa", "aster", "ab", "a", "abb", "aaa", "aaaab", "attack", "astrolabe", "astrophysics"}
    //fmt.Println(res)
    //sort.Strings(res)
    //fmt.Println(res)

    ticker1 := time.NewTicker(time.Second * 100)
    ticker2 := time.NewTicker(time.Second * 20)

    for {
        select {
        case <-ticker1.C:
            fmt.Println("hello i am 100 second report")
        case <-ticker2.C:
            fmt.Println("hello i am 20 second report")
        }
    }

}
