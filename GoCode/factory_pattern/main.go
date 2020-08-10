package main

import "fmt"


func main(){
	akFact := getGunFactory("ak47")
	fmt.Printf("Gut is %s, %s ", akFact.getName(), akFact.getPower())
}