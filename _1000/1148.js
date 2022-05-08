const stdin = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const words = [];

while (true) {
  const tmp = input();
  if (tmp === "-") {
    break;
  }
  words.push([...tmp]);
}

const boards = [];

while (true) {
  const tmp = input();
  if (tmp === "#") {
    break;
  }
  boards.push([...tmp].sort());
}

const toMap = (ac, v) => {
  if (ac.has(v)) {
    ac.set(v, ac.get(v) + 1);
  } else {
    ac.set(v, 1);
  }
  return ac;
};

boards.forEach((e) => {
  const filtered = words
    .map((v) => v.reduce(toMap, new Map()))
    .filter((wm) =>
      [...wm.keys()].every(
        (c) => e.reduce(toMap, new Map()).get(c) >= wm.get(c)
      )
    );

  const cntArr = [...new Set(e)].reduce((ac, c) => {
    ac.set(c, filtered.filter((v) => v.has(c)).length);
    return ac;
  }, new Map());

  const [smallest, largest] = [...cntArr.values()].reduce(
    (ac, v) => {
      if (v < ac[0]) {
        ac[0] = v;
      }

      if (v > ac[1]) {
        ac[1] = v;
      }
      return ac;
    },
    [200000, 0]
  );

  const [smCh, larCh] = [...cntArr.entries()].reduce(
    (ac, [k, v]) => {
      if (v == smallest) {
        ac[0] += k;
      }
      if (v == largest) {
        ac[1] += k;
      }
      return ac;
    },
    ["", ""]
  );

  console.log(smCh, smallest, larCh, largest);
});
