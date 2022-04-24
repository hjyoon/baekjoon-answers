#include <iostream>

using namespace std;

//
bool t1[1][4] = {
    {1, 1, 1, 1}
};

bool t2[4][1] = {
    {1},
    {1},
    {1},
    {1}
};

//
bool t3[2][2] = {
    {1, 1},
    {1, 1}
};

//
bool t4[3][2] = {
    {1, 0},
    {1, 0},
    {1, 1}
};

bool t5[3][2] = {
    {1, 1},
    {0, 1},
    {0, 1}
};

bool t6[2][3] = {
    {0, 0, 1},
    {1, 1, 1}
};

bool t7[2][3] = {
    {1, 1, 1},
    {1, 0, 0}
};

//
bool t8[3][2] = {
    {0, 1},
    {0, 1},
    {1, 1}
};

bool t9[3][2] = {
    {1, 1},
    {1, 0},
    {1, 0}
};

bool t10[2][3] = {
    {1, 1, 1},
    {0, 0, 1}
};

bool t11[2][3] = {
    {1, 0, 0},
    {1, 1, 1}
};

//
bool t12[3][2] = {
    {1, 0},
    {1, 1},
    {0, 1}
};

bool t13[2][3] = {
    {0, 1, 1},
    {1, 1, 0}
};

//
bool t14[3][2] = {
    {0, 1},
    {1, 1},
    {1, 0}
};

bool t15[2][3] = {
    {1, 1, 0},
    {0, 1, 1}
};

//
bool t16[3][2] = {
    {1, 0},
    {1, 1},
    {1, 0}
};

bool t17[2][3] = {
    {0, 1, 0},
    {1, 1, 1}
};

bool t18[3][2] = {
    {0, 1},
    {1, 1},
    {0, 1}
};

bool t19[2][3] = {
    {1, 1, 1},
    {0, 1, 0}
};

int N, M;
int a[500][500];

int check_1(int y, int x) {
    if(x + 4 > M) {
        return 0;
    }

    int res = 0;
    for(int i=0; i<1; i++) {
        for(int j=0; j<4; j++) {
            if(t1[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_2(int y, int x) {
    if(y + 4 > N) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<4; i++) {
        for(int j=0; j<1; j++) {
            if(t2[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_3(int y, int x) {
    if(y + 2 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
            if(t3[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_4(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t4[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_5(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t5[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_6(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t6[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_7(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t7[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_8(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t8[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_9(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t9[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_10(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t10[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_11(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t11[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_12(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t12[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_13(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t13[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_14(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t14[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_15(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t15[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_16(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t16[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_17(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t17[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_18(int y, int x) {
    if(y + 3 > N || x + 2 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++) {
            if(t18[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int check_19(int y, int x) {
    if(y + 2 > N || x + 3 > M) {
        return 0;
    }
    
    int res = 0;
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++) {
            if(t19[i][j] == true) {
                res += a[i+y][j+x];
            }
        }
    }
    return res;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(0);
    freopen("input.txt", "r", stdin);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cin >> a[i][j];
        }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_1(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_2(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_3(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_4(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_5(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_6(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_7(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_8(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_9(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_10(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_11(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_12(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_13(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_14(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_15(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_16(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_17(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_18(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int tmp = check_19(i, j);
            if(tmp > max) {
                max = tmp;
            }
        }
    }

    cout << max;

    return 0;
}