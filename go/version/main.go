package main

import (
	"errors"
	"fmt"
	"reflect"
)

var (
	Version = "1.0.0"
	Build   = ""
	Tag     = 1
	Err1    = errors.New("error1")
	Err2    = errors.New("error2")
)

type T1 struct{ name string }
type T2 struct{ name string }

type AErr struct {
	Err string
	Msg string
}

func (a AErr) Error() string {
	return fmt.Sprintf("%s %s", a.Msg, a.Err)
}

func NewAErr(a, b string) *AErr {
	return &AErr{a, b}
}

type BErr struct {
	Err error
	Msg string
}

func (a BErr) Error() string {
	return fmt.Sprintf("%s %s", a.Msg, a.Err.Error())
}

func main() {
	e := errors.New("A")
	e1 := errors.New("A")
	aa := &T1{"a"}
	fmt.Printf("%p,%p,%p\n", e, e1, aa)

	fmt.Println(reflect.TypeOf(e))

	a := NewAErr("A", "SSSS")
	b := NewAErr("A", "SSSS")

	fmt.Println(*a == *b)

}

func Terr(e error) {

	switch e.(type) {
	case AErr:
		fmt.Println(reflect.TypeOf(e), "this is a")
	case BErr:
		fmt.Println(reflect.TypeOf(e), "this is b")
	default:
		fmt.Println(reflect.TypeOf(e), "this is default")
	}
}
