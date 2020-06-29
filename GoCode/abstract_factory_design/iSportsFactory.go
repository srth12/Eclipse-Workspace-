package main

type iSportsFactory interface{
	makeShoe() iShoe
}

func getShoeFactory(brand string) iSportsFactory{
	if brand == "adidas"{
		return &adidasFactory{}
	}else if brand == "nike"{
		return &nikeFactory{}
	} else {
		return nil
	}

}