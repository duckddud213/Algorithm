#include <stdio.h>
#include <stdlib.h>

typedef struct Location
{
    int i, j;
} Loc;

void bfs(char **sect1, char **sect2, int N)
{
    int cnt, cnt_bli, i, j, ind1, ind2, q1, q2;
    int a, b;
    char a1, a2;
    Loc *que1;
    Loc *que2;

    que1 = (Loc *)malloc(sizeof(Loc) * N * N);
    que2 = (Loc *)malloc(sizeof(Loc) * N * N);

    for (i = 0; i < N * N; i++)
    {
        que1[i].i = -1;
        que1[i].j = -1;
        que2[i].i = -1;
        que2[i].j = -1;
    }

    cnt = 0;
    cnt_bli = 0;
    ind1 = 0;
    ind2 = 0;
    q1 = 0;
    q2 = 0;
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < N; j++)
        {
            if (sect1[i][j] != 'X') //구역의 값이 X가 아닐 경우 : 방문하지 않은 구역일 경우(적녹색맹이 아닌 경우)
            {
                que1[ind1].i = i;
                que1[ind1].j = j;
                ind1++;
                a1 = sect1[i][j];
                while ((que1[q1].i >= 0) && (que1[q1].i < N))
                {
                    a = que1[q1].i;
                    b = que1[q1].j;

                    if (a - 1 >= 0)
                    {
                        if (a1 == sect1[a - 1][b])
                        {
                            sect1[a - 1][b] = 'X';
                            que1[ind1].i = a - 1;
                            que1[ind1].j = b;
                            ind1++;
                        }
                    }
                    if (a + 1 < N)
                    {
                        if (a1 == sect1[a + 1][b])
                        {
                            sect1[a + 1][b] = 'X';
                            que1[ind1].i = a + 1;
                            que1[ind1].j = b;
                            ind1++;
                        }
                    }
                    if (b - 1 >= 0)
                    {
                        if (a1 == sect1[a][b - 1])
                        {
                            sect1[a][b - 1] = 'X';
                            que1[ind1].i = a;
                            que1[ind1].j = b - 1;
                            ind1++;
                        }
                    }
                    if (b + 1 < N)
                    {
                        if (a1 == sect1[a][b + 1])
                        {
                            sect1[a][b + 1] = 'X';
                            que1[ind1].i = a;
                            que1[ind1].j = b + 1;
                            ind1++;
                        }
                    }
                    sect1[a][b] = 'X';
                    q1++;
                }
                cnt++;
            }

            if (sect2[i][j] != 'X') //구역의 값이 X가 아닐 경우 : 방문하지 않은 구역일 경우(적녹색맹일 경우)
            {
                que2[ind2].i = i;
                que2[ind2].j = j;
                ind2++;
                a2 = sect2[i][j];
                while ((que2[q2].i >= 0) && (que2[q2].i < N))
                {
                    a = que2[q2].i;
                    b = que2[q2].j;

                    if (a - 1 >= 0)
                    {
                        if ((a2 == 'R') || (a2 == 'G'))
                        {
                            if ((sect2[a - 1][b] == 'R') || (sect2[a - 1][b] == 'G'))
                            {
                                sect2[a - 1][b] = 'X';
                                que2[ind2].i = a - 1;
                                que2[ind2].j = b;
                                ind2++;
                            }
                        }
                        else
                        {
                            if (a2 == sect2[a - 1][b])
                            {
                                sect2[a - 1][b] = 'X';
                                que2[ind2].i = a - 1;
                                que2[ind2].j = b;
                                ind2++;
                            }
                        }
                    }
                    if (a + 1 < N)
                    {
                        if ((a2 == 'R') || (a2 == 'G'))
                        {
                            if ((sect2[a + 1][b] == 'R') || (sect2[a + 1][b] == 'G'))
                            {
                                sect2[a + 1][b] = 'X';
                                que2[ind2].i = a + 1;
                                que2[ind2].j = b;
                                ind2++;
                            }
                        }
                        else
                        {
                            if (a2 == sect2[a + 1][b])
                            {
                                sect2[a + 1][b] = 'X';
                                que2[ind2].i = a + 1;
                                que2[ind2].j = b;
                                ind2++;
                            }
                        }
                    }
                    if (b - 1 >= 0)
                    {
                        if ((a2 == 'R') || (a2 == 'G'))
                        {
                            if ((sect2[a][b - 1] == 'R') || (sect2[a][b - 1] == 'G'))
                            {
                                sect2[a][b - 1] = 'X';
                                que2[ind2].i = a;
                                que2[ind2].j = b - 1;
                                ind2++;
                            }
                        }
                        else
                        {
                            if (a2 == sect2[a][b - 1])
                            {
                                sect2[a][b - 1] = 'X';
                                que2[ind2].i = a;
                                que2[ind2].j = b - 1;
                                ind2++;
                            }
                        }
                    }
                    if (b + 1 < N)
                    {
                        if ((a2 == 'R') || (a2 == 'G'))
                        {
                            if ((sect2[a][b + 1] == 'R') || (sect2[a][b + 1] == 'G'))
                            {
                                sect2[a][b + 1] = 'X';
                                que2[ind2].i = a;
                                que2[ind2].j = b + 1;
                                ind2++;
                            }
                        }
                        else
                        {
                            if (a2 == sect2[a][b + 1])
                            {
                                sect2[a][b + 1] = 'X';
                                que2[ind2].i = a;
                                que2[ind2].j = b + 1;
                                ind2++;
                            }
                        }
                    }
                    sect2[a][b] = 'X';
                    q2++;
                }
                cnt_bli++;
            }
        }
    }

    printf("%d %d", cnt, cnt_bli);
}

int main()
{
    int N, i, j;
    char **sect1;
    char **sect2;

    scanf("%d", &N);
    getchar();

    sect1 = (char **)malloc(sizeof(char *) * N);
    sect2 = (char **)malloc(sizeof(char *) * N);

    for (i = 0; i < N; i++)
    {
        sect1[i] = (char *)malloc(sizeof(char) * N);
        sect2[i] = (char *)malloc(sizeof(char) * N);
        for (j = 0; j < N; j++)
        {
            scanf("%c", &sect1[i][j]);
            sect2[i][j] = sect1[i][j];
        }
        getchar();
    }

    bfs(sect1, sect2, N);
}