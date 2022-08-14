"strict mode";
const assert = require("node:assert/strict");
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const nextComb = (flag, n, r) => {
  let i = r - 1;
  while (flag[i] >= n - (r - i)) {
    i--;
    if (i < 0) return false;
  }

  flag[i]++;
  while (i < r - 1) {
    flag[i + 1] = flag[i] + 1;
    i++;
  }
  return true;
};

// 원페어: 동일한 숫자의 카드가 2개 있을 때.
const isType2 = (flag) => {
  for (const v of flag) {
    if (v.reduce((v, ac) => ac + v, 0) === 2) return true;
  }
  return false;
};

// 투페어: 동일한 숫자의 카드가 2개 있는 게 두 쌍이 있을 때.
const isType3 = (flag) => {
  let cnt = 0;
  for (const v of flag) {
    if (v.reduce((v, ac) => ac + v, 0) === 2) cnt++;
    if (cnt >= 2) return true;
  }
  return false;
};

// 트리플: 동일한 숫자의 카드가 3개 있을 때.
const isType4 = (flag) => {
  for (const v of flag) {
    const cnt = v.reduce((v, ac) => ac + v, 0);
    if (cnt === 3) return true;
  }
  return false;
};

// 스트레이트: 5개의 연속된 숫자가 있을 때.
const isType5 = (flag) => {
  for (let i = 0; i < 9; i++) {
    if (
      flag[i].some((e) => e) &&
      flag[i + 1].some((e) => e) &&
      flag[i + 2].some((e) => e) &&
      flag[i + 3].some((e) => e) &&
      flag[i + 4].some((e) => e)
    )
      return true;
  }
  return false;
};

// 빽스트레이트: A,2,3,4,5인 스트레이트.
const isType6 = (flag) => {
  if (
    flag[0].some((e) => e) &&
    flag[1].some((e) => e) &&
    flag[2].some((e) => e) &&
    flag[3].some((e) => e) &&
    flag[4].some((e) => e)
  )
    return true;
  return false;
};

// 마운틴: A,K,Q,J,10인 스트레이트.
const isType7 = (flag) => {
  if (
    flag[0].some((e) => e) &&
    flag[9].some((e) => e) &&
    flag[10].some((e) => e) &&
    flag[11].some((e) => e) &&
    flag[12].some((e) => e)
  )
    return true;
  return false;
};

// 플러쉬: 같은 문양의 카드가 5장 있을 때.
const isType8 = (flag) => {
  for (const v of flag) {
    const cnt = v.reduce((v, ac) => ac + v, 0);
    if (cnt >= 5) return true;
  }
  return false;
};

// 풀하우스: 트리플 + 원페어(서로 다른 카드로)
const isType9 = (flag) => {
  let pair = 0;
  let triple = 0;
  for (const v of flag) {
    const cnt = v.reduce((v, ac) => ac + v, 0);
    if (cnt === 2) pair++;
    else if (cnt === 3) triple++;
    if ((pair >= 1 && triple >= 1) || triple >= 2) return true;
  }
  return false;
};

// 포카드: 같은 숫자의 카드가 4장 있을 때.
const isType10 = (flag) => {
  for (const v of flag) {
    if (v.every((e) => e)) return true;
  }
  return false;
};

// 스트레이트 플러쉬: 같은 문양인 숫자가 연속된 5장의 카드.
const isType11 = (flag) => {
  for (const v of flag) {
    for (let i = 0; i < 9; i++) {
      if (v.slice(i, i + 5).every((e) => e)) return true;
    }
  }
  return false;
};

// 로얄 스트레이트 플러쉬: A,2,3,4,5인 스트레이트 플러쉬.
const isType12 = (flag) => {
  for (const v of flag) {
    if (v.slice(0, 5).every((e) => e)) return true;
  }
  return false;
};

const getHandType = (hand) => {
  const flag_1 = [
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
  ];
  const flag_2 = [
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
  ];
  for (const [rank, suit] of hand) {
    const i = suits_mapping.get(suit);
    const j = ranks_mapping.get(rank);
    flag_1[i][j]++;
    flag_2[j][i]++;
  }
  if (isType12(flag_1)) return 11;
  else if (isType11(flag_1)) return 10;
  else if (isType10(flag_2)) return 9;
  else if (isType9(flag_2)) return 8;
  else if (isType8(flag_1)) return 7;
  else if (isType7(flag_2)) return 6;
  else if (isType6(flag_2)) return 5;
  else if (isType5(flag_2)) return 4;
  else if (isType4(flag_2)) return 3;
  else if (isType3(flag_2)) return 2;
  else if (isType2(flag_2)) return 1;
  else return 0;
};

const gcd = (x, y) => {
  while (y) [x, y] = [y, x % y];
  return x;
};

const flag = [0, 1, 2, 3, 4, 5];
const handCnts = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
const deck = [];
const suits = ["♣", "♥", "♠", "◆"];
const ranks = [
  "A",
  "2",
  "3",
  "4",
  "5",
  "6",
  "7",
  "8",
  "9",
  "10",
  "J",
  "Q",
  "K",
];
const suits_mapping = new Map(suits.map((v, i) => [v, i]));
const ranks_mapping = new Map(ranks.map((v, i) => [v, i]));

// for (const suit of suits) {
//   for (const rank of ranks) {
//     deck.push([rank, suit]);
//   }
// }
// let cnt = 0;
// while (1) {
//   const hand = flag.map((i) => deck[i]);
//   handCnts[getHandType(hand)]++;
//   cnt++;
//   if (!nextComb(flag, 52, 6)) break;
// }

// handCnts.forEach((v) => {
//   const tmp = gcd(v, cnt);
//   console.log(`${v / tmp}/${cnt / tmp}`);
//   // console.log(`${v}/${cnt}`);
// });

const ans = `1005/3094
486537/1017926
24354/195755
1408/39151
14103/1017926
9/4606
9/4606
25747/2544815
228/27965
3/4165
184/2544815
1/108290`;

console.log(ans);
