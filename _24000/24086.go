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

	input, _, _ := r.ReadLine()
	A, _ := strconv.Atoi(string(input))

	input, _, _ = r.ReadLine()
	B, _ := strconv.Atoi(string(input))

	res := B - A

	w.WriteString(strconv.Itoa(res))
}
