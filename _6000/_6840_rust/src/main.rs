use std::io::Read;

fn main() {
    // let mut inp = Vec::<u8>::new();
    // BufReader::new(std::io::stdin())
    //     .read_to_end(&mut inp)
    //     .unwrap();
    // let mut a: Vec<i32> = std::str::from_utf8(&mut inp)
    //     .unwrap()
    //     .split_whitespace()
    //     .map(|x| x.parse().unwrap())
    //     .collect();
    // a.sort();
    // print!("{}", a[1])

    // let mut buf = Vec::<u8>::new();
    let mut buf = String::new();
    let mut stdin = std::io::stdin();
    //stdin.lock().read_to_string();
    // stdin.lock().read_to_end(&mut buf).unwrap();
    stdin.read_to_string(&mut buf).unwrap();
    let res: Vec<&str> = buf.split_whitespace().collect();

    print!("{:?}", res)

    // for v in inp {
    //     print!("{}\n", v)
    // }

    // for v in a {
    //     print!("{}\n", v.unwrap())
    // }
    // stdin.bytes()
}
