"strict mode";
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const decomp = (alphabets, sentence) => {
  for (let i = 0; i < sentence.length; i++) {
    const idx = sentence.charCodeAt(i) - "A".charCodeAt(0);
    alphabets[idx]++;
  }
};

const subset = (n) => {
  for (let i = 1; i < 2 ** n; i++) {
    const tmp = [];
    for (let j = 0; j < n; j++) {
      if (i & (1 << j)) {
        tmp.push(j);
      }
    }
    if (check(origin, tmp)) {
      ans = Math.min(ans, prices_sum(tmp));
    }
  }
};

const prices_sum = (tmp) => {
  let res = 0;
  for (const v of tmp) {
    res += prices[v];
  }
  return res;
};

const check = (origin, tmp) => {
  const tmp_sum = Array(26).fill(0);
  for (const v of tmp) {
    for (let i = 0; i < 26; i++) {
      tmp_sum[i] += alphabets[v][i];
    }
  }

  for (let i = 0; i < 26; i++) {
    if (origin[i] > tmp_sum[i]) {
      return false;
    }
  }
  return true;
};

const S = input();
const N = Number(input());
const prices = Array(N);
const alphabets = [...Array(N)].map(() => Array(26).fill(0));
const origin = Array(26).fill(0);
let ans = Infinity;

decomp(origin, S);

for (let i = 0; i < N; i++) {
  const tmp = input().split(" ");
  const [price, sentence] = [Number(tmp[0]), tmp[1]];
  prices[i] = price;
  decomp(alphabets[i], sentence);
}

subset(N);
console.log(ans == Infinity ? -1 : ans);
