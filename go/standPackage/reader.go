package main

import (
	"fmt"
	"io"
	"log"
	"os"
)

func ReadFrom(reader io.Reader, num int) ([]byte, error) {
	var b []byte
	n, err := reader.Read(b)
	if err != nil {
		log.Println(err)
		return b[:n], nil
	}
	return b, err
}

func main() {
	f, err := os.Open("/Users/zihua/Documents/Repo/algorithm/go/standPackage/test.txt")
	info, err := f.Readdir(0)
	fmt.Println(info)
	fmt.Println(f.Name())
	if err != nil {
		fmt.Println(err)
	}

	data, err := ReadFrom(f, 10)
	if err != nil {
		log.Println(err)
	}
	fmt.Println(data)

}
