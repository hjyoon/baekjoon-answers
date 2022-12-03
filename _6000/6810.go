package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	base_value := 91

	for i := 0; i < 3; i++ {
		input, _, _ := r.ReadLine()
		tmp, _ := strconv.Atoi(string(input))
		if i%2 == 1 {
			base_value += tmp * 3
		} else {
			base_value += tmp
		}
	}

	w.WriteString("The 1-3-sum is " + strconv.Itoa(base_value))
}
