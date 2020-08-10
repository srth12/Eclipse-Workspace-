package main

import (
	"net/http"
	"fmt"
)

func main(){

	fmt.Println("Hello World")
	response, error := http.Get("https://google.com")
	if error != nil{
		panic(error)
	}
	defer response.Body.Close()
	fmt.Println( "status is " + response.Status)
}