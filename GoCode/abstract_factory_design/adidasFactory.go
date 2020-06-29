package main

type adidasFactory struct{

}

func  (a *adidasFactory) makeShoe() iShoe{
	return &adidasShoe{
		shoe: shoe{
		logo: "adidas",
		size: 10,
		},
	}
}