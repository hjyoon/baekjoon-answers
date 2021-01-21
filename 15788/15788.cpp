#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <string>
#include <algorithm>
#include <tuple>
#include <set>
using namespace std;
int x, y;
long long map[501][501];
int n;
long long sum;
long long row_sum;
long long col_sum;
long long row_col_sum;
long long row_col_sum_2;
bool row_col_check;
bool row_col_check_2;
set<long long> sets;
int main() {
   freopen("../input.txt", "r", stdin);
   scanf("%d", &n);
   for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
         scanf("%lld", &map[i][j]);
         if (map[i][j] == 0) { x = i; y = j; }
      }
   }
   for (int i = 1; i <= n; i++) {
      if (x == i)continue;
      sum = 0;
      for (int j = 1; j <= n; j++) {
         sum += map[i][j];
      }
      sets.insert(sum);
   }
   for (int j = 1; j <= n; j++) {
      if (y == j)continue;
      sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += map[i][j];
      }
      sets.insert(sum);
   }
   if (x != y) {
      sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += map[i][i];
      }
      sets.insert(sum);
   }
   if (x + y != n + 1) {
      sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += map[i][n + 1 - i];
      }
      sets.insert(sum);
   }
   if (sets.size() != 1) {
      printf("-1");
      return 0;
   }
   for (int j = 1; j <= n; j++) {
      row_sum += map[x][j];
   }
   for (int i = 1; i <= n; i++) {
      col_sum += map[i][y];
   }
   if (x == y) {
      row_col_check = true;
      for (int i = 1; i <= n; i++) {
         row_col_sum += map[i][i];
      }
   }
   if (x + y == n + 1) {
      row_col_check_2 = true;
      for (int i = 1; i <= n; i++) {
         row_col_sum_2 += map[i][n + 1 - i];
      }
   }
   if (row_col_check && row_col_check_2) {
      set<long long> sets;
      long long a = sum - row_sum;
      long long b = sum - col_sum;
      long long c = sum - row_col_sum;
      long long d = sum - row_col_sum_2;
      sets.insert(a);
      sets.insert(b);
      sets.insert(c);
      sets.insert(d);
      if (sets.size() == 1 && 1 <= a && a <= 1000000000)printf("%lld", a);
      else printf("-1");
   }
   else if (row_col_check_2) {
      set<long long> sets;
      long long a = sum - row_sum;
      long long b = sum - col_sum;
      long long c = sum - row_col_sum_2;
      sets.insert(a);
      sets.insert(b);
      sets.insert(c);
      if (sets.size() == 1 && 1 <= a && a <= 1000000000)printf("%lld", a);
      else printf("-1");
   }
   else if (row_col_check) {
      set<long long> sets;
      long long a = sum - row_sum;
      long long b = sum - col_sum;
      long long c = sum - row_col_sum;
      sets.insert(a);
      sets.insert(b);
      sets.insert(c);
      if (sets.size() == 1 && 1 <= a && a <= 1000000000)printf("%lld", a);
      else printf("-1");
   }
   else {
      set<long long> sets;
      long long a = sum - row_sum;
      long long b = sum - col_sum;
      sets.insert(a);
      sets.insert(b);
      if (sets.size() == 1 && 1 <= a && a <= 1000000000)printf("%lld", a);
      else printf("-1");
   }
   return 0;
}