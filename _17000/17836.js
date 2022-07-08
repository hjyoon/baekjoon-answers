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

const bfs = (start_y, start_x, end_y, end_x) => {
  init();
  q.enqueue([start_y, start_x, 0]);
  visit[start_y][start_x] = 1;
  while (q.length) {
    const [y, x, t] = q.dequeue();
    if (y == end_y && x == end_x) {
      return t;
    }
    for (let i = 0; i < dy.length; i++) {
      if (y + dy[i] < 0 || x + dx[i] < 0 || y + dy[i] >= N || x + dx[i] >= M) {
        continue;
      }
      if (visit[y + dy[i]][x + dx[i]] == 1) {
        continue;
      }
      if (board[y + dy[i]][x + dx[i]] == 1) {
        continue;
      }
      visit[y + dy[i]][x + dx[i]] = 1;
      q.enqueue([y + dy[i], x + dx[i], t + 1]);
    }
  }
  return Infinity;
};

const find_item = () => {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (board[i][j] == 2) {
        return [i, j];
      }
    }
  }
};

const init = () => {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      visit[i][j] = 0;
    }
  }
  while (q.length) {
    q.dequeue();
  }
};

const [N, M, T] = input().split(" ").map(Number);
const board = [];
const visit = [...Array(N)].map(() => Array(M));
const q = new Queue();
const dy = [0, 1, 0, -1];
const dx = [1, 0, -1, 0];
for (let i = 0; i < N; i++) {
  board.push(input().split(" ").map(Number));
}

const [item_y, item_x] = find_item();

const ans = bfs(0, 0, N - 1, M - 1);
const ans2 = bfs(0, 0, item_y, item_x);
const ans3 = Math.abs(item_y - (N - 1)) + Math.abs(item_x - (M - 1));

const min = Math.min(ans, ans2 + ans3);
if (min <= T) {
  console.log(min);
} else {
  console.log("Fail");
}
