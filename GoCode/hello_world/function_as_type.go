package main

import "fmt"

func add(a int, b int) int {
	return a + b
}

func subtract(a int, b int) int {
	return a - b
}

// function has its own type, we can declare a variable of type function and assign it layer, like below
// var add func(int, int) int

//CalcFunc is a function type
type CalcFunc func(int, int) int

func calc(a int, b int, f CalcFunc) int {
	r := f(a, b) // calling add(a,b) or substract(a,b)
	return r
}

func main() {
	addResult := calc(5, 3, add)
	subResult := calc(5, 3, subtract)
	fmt.Println("5+3 =", addResult)
	fmt.Println("5-3 =", subResult)
}
