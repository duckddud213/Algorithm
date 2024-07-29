#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n, i, j;
	unsigned long long **arr;
	unsigned long long sum;

	scanf("%d", &n);

	arr = (unsigned long long **)malloc(sizeof(unsigned long long *) * (n + 1));

	for (i = 1; i <= n; i++)
	{
		arr[i] = (unsigned long long *)malloc(sizeof(unsigned long long) * 10);
	}

	arr[1][0] = 0;
	for (i = 1; i < 10; i++)
	{
		arr[1][i] = 1;
	}

	if (n == 1)
	{
		printf("%d", 9);
	}
	else
	{
		for (i = 2; i <= n; i++)
		{
			for (j = 0; j < 10; j++)
			{
				if (j == 0)
				{
					arr[i][j] = arr[i - 1][j + 1];
				}
				else if (j == 9)
				{
					arr[i][j] = arr[i - 1][j - 1];
				}
				else
				{
					arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
				}
			}
		}
		sum = 0;
		for (j = 0; j < 10; j++)
		{
			sum += arr[n][j];
		}
		printf("%llu", sum % 1000000000);
	}
}