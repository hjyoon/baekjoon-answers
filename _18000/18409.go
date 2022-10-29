package main

import "fmt"

func main() {
	var n, cnt int;
	var s string;
	
	fmt.Scanln(&n);
	fmt.Scanln(&s);

	for _, v := range s {
		if v == 'a' {
			cnt++;
		} else if v == 'i' {
			cnt++;
		} else if v == 'u' {
			cnt++;
		} else if v == 'e' {
			cnt++;
		} else if v == 'o' {
			cnt++;
		}
	}

	fmt.Println(cnt);
}