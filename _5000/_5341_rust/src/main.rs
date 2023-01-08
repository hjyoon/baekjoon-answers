use std::fmt::Write;
use std::io::Read;

fn sum(n: i32) -> i32 {
    (n * (1 + n)) / 2
}

fn main() {
    let mut output = String::new();
    let mut buf = String::new();
    std::io::stdin().read_to_string(&mut buf).unwrap();
    let tokens: Vec<i32> = buf
        .trim()
        .split_ascii_whitespace()
        .map(|x| x.parse::<i32>().unwrap())
        .collect();

    for i in 0..tokens.len() - 1 {
        writeln!(output, "{}", sum(tokens[i])).unwrap();
    }

    println!("{}", output);
}
