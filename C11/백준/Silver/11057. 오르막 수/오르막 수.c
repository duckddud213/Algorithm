#pragma warning(disable:4996)
#include<stdio.h>
#include<stdlib.h>

int main() {
	int N, i, j, k, sum;
	int **arr;

	scanf("%d", &N);

	arr = (int **)malloc(sizeof(int *) * (N + 1));
	for (i = 1; i < N + 1; i++) {
		arr[i] = (int *)malloc(sizeof(int) * 10);
	}

	if (N == 1) {
		printf("%d", 10);
		return 0;
	}

	for (i = 0; i < 10; i++) arr[1][i] = 1;

	for (i = 2; i <= N; i++) {
		for (j = 0; j < 10; j++) {
			sum = 0;
			for (k = j; k < 10; k++) {
				sum += arr[i - 1][k];
				sum %= 10007;
			}
			arr[i][j] = sum;
		}
	}

	sum = 0;
	for (i = 0; i < 10; i++) {
		sum += arr[N][i];
		sum %= 10007;
	}
	printf("%d", sum);
}