package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	T, _, _ := r.ReadLine()
	T2, _ := strconv.Atoi(string(T))

	for i := 0; i < T2; i++ {
		line, _, _ := r.ReadLine()
		line2 := string(line)

		slice := strings.Split(line2, " ")
		lt, _ := strconv.Atoi(slice[0])
		wt, _ := strconv.Atoi(slice[1])
		le, _ := strconv.Atoi(slice[2])
		we, _ := strconv.Atoi(slice[3])

		s1 := lt * wt
		s2 := le * we

		var ans string
		if s1 == s2 {
			ans = "Tie"
		} else if s1 <= s2 {
			ans = "Eurecom"
		} else {
			ans = "TelecomParisTech"
		}
		w.WriteString(ans + "\n")
	}
}
