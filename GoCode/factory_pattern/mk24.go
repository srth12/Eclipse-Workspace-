package main

type mk24 struct{
	gun
}

func (mk *mk24) newMk24() iGun{
	return &mk24{
		gun: gun{
			name: "MK 24",
			power: 5,
		},
	}
}