use std::io::BufReader;
use std::io::Read;

fn main() {
    let mut inp = Vec::<u8>::new();
    BufReader::new(std::io::stdin())
        .read_to_end(&mut inp)
        .unwrap();
    let mut a: Vec<i32> = std::str::from_utf8(&mut inp)
        .unwrap()
        .split_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();
    a.sort();
    print!("{}", a[1])
}
