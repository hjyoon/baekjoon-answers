fn main() {
    let mut buf = String::new();
    std::io::stdin().read_line(&mut buf).unwrap();
    let res = buf
        .trim()
        .split_whitespace()
        .map(|v| v.parse::<i32>().unwrap())
        .sum::<i32>();
    print!("{}", res)
}
