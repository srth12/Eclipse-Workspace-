package main


func getGunFactory(gunType string) iGun{
	if gunType == "ak47"{
		return newAk47()
	}else if gunType == "mk24"{
		return newAk47()
	}
	return nil
}

