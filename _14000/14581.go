package main

import (
	"bufio"
	"os"
)

func main() {
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	input, _, _ := r.ReadLine()

	w.WriteString(":fan::fan::fan:\n:fan::" + string(input) + "::fan:\n:fan::fan::fan:")
}
