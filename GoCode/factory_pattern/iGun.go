package main

type iGun interface{
	getName() string
	getPower() int
	setName(name string)
	setPower(power int)
}