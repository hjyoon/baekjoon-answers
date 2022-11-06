package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	var input []byte
	// var err error
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	for i := 1; ; i++ {
		input, _, _ = r.ReadLine()
		if string(input) == "0" {
			break
		}
		w.WriteString("Case " + strconv.Itoa(i) + ": Sorting... done!\n")
	}
}
