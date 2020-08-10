package main

import "fmt"

//  https://golangbyexample.com/abstract-factory-design-pattern-go/

func main(){
	fmt.Println("testing")
	adidasFact := getShoeFactory("adidas")
	adiShoe := adidasFact.makeShoe()
	fmt.Printf("testing %s, %d ", adiShoe.getLogo(), adiShoe.getSize())
}