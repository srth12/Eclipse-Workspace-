package main

type nikeFactory struct{

}

func (n *nikeFactory) makeShoe() iShoe{
	return &nikeShoe{
		shoe: shoe{
			logo: "nike",
			size: 11,
		},

	}
}