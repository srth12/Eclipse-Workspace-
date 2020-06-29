package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
)

func main(){
	// deferExample()
	panicExample()
}

func panicExample(){
	// Case 1
	// a, b := 1, 0
	// ans := a/b
	// fmt.Println(ans)

	// Case 2 : manual panic
	// panic("Something bad happened")

	// Case 3 :
	// http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request){
	// 	w.Write([]byte("hello world!"))
	// })

	// err := http.ListenAndServe(":8080", nil)
	// if err != nil{
	// 	panic(err.Error())
	// }

	// Case 4: Panic happends after defer execution

	// Case 5: Panic happends after defer anonymous fn;
	// Recover helps to recover after panic.
	defer func(){
		if err := recover(); err != nil{
			log.Println("Error in defer", err)
			panic(err)  // rethrow in needed
		}
	}()
	panic("Something bad happened")
}

func deferExample(){

	defer fmt.Println("Hello World")  // will execute at the end before this main() return
	fmt.Println("Sarath Babu")
	defer fmt.Println("Drishya")  // Defer prints in the order 	LIFO ; used for closing resources

	resp, error := http.Get("https://www.google.com/robots.txt")
	defer resp.Body.Close()  //close will be called at the end: open and close the resources side by side
	//NB: not good to close using defer if millions of http calls
	if error != nil{
		log.Fatal(error)
	}

	robots, err := ioutil.ReadAll(resp.Body)

	if err != nil {
		log.Fatal(err)
	}

	fmt.Printf("%s", robots)

	// eagerly using the original passed value in derer
	a := "test"
	defer fmt.Println(a)
	a = "new valuue"

}
