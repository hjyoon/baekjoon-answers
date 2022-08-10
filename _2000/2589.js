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

class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null; // 제일 앞 노드
    this.rear = null; // 제일 뒤 노드
    this.length = 0; // 노드의 길이
  }

  enqueue(data) {
    // 노드 추가.
    const node = new Node(data); // data를 가진 node를 만들어준다.
    if (!this.head) {
      // 헤드가 없을 경우 head를 해당 노드로
      this.head = node;
    } else {
      this.rear.next = node; // 아닐 경우 마지막의 다음 노드로
    }
    this.rear = node; // 마지막을 해당 노드로 한다.
    this.length++;
  }

  dequeue() {
    // 노드 삭제.
    if (!this.head) {
      // 헤드가 없으면 한 개도 없는 것이므로 false를 반환.
      return false;
    }
    const data = this.head.data; // head를 head의 다음 것으로 바꿔주고 뺀 data를 return
    this.head = this.head.next;
    this.length--;

    return data;
  }

  // head를 반환하는 함수
  front() {
    // head가 있을 경우 head의 data를 반환.
    return this.head && this.head.data;
  }

  //큐의 모든 원소를 반환하는 함수
  getQueue() {
    if (!this.head) return false;
    let node = this.head;
    const array = [];
    while (node) {
      // node가 없을 때까지 array에 추가한 후 반환해준다.
      array.push(node.data);
      node = node.next;
    }
    return array;
  }
}

const bfs = (start_y, start_x) => {
  const q = new Queue();
  const visited = [...Array(R)].map(() => Array(C).fill(0));

  q.enqueue([start_y, start_x, 0]);
  while (q.length) {
    const [now_y, now_x, step] = q.dequeue();

    if (now_y < 0 || now_y >= R || now_x < 0 || now_x >= C) {
      continue;
    }

    if (board[now_y][now_x] == "W") {
      continue;
    }

    // 방문 체크
    if (visited[now_y][now_x] == 1) {
      continue;
    }
    visited[now_y][now_x] = 1;
    ans = Math.max(ans, step);

    for (const [dy, dx] of [
      [0, 1],
      [1, 0],
      [0, -1],
      [-1, 0],
    ]) {
      q.enqueue([now_y + dy, now_x + dx, step + 1]);
    }
  }
};

const [R, C] = input().split(" ").map(Number);
const board = [];
for (let i = 0; i < R; i++) {
  board.push(input());
}

let ans = 0;
for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    bfs(i, j);
  }
}

console.log(ans);
