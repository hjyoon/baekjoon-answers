package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	// var err error
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	input, _, _ := r.ReadLine()
	ans, _ := strconv.Atoi(string(input))
	ans = ans * ans * ans
	w.WriteString(strconv.Itoa(ans))
}
