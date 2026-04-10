#pragma warning(disable:4996)
#include<stdio.h>
#include<math.h>

int main() {
	unsigned long long a, t, x, y, n1, n2, i, j;

	scanf("%llu", &t);

	for (a = 0; a < t; a++) {
		scanf("%llu %llu", &x, &y);

		n1 = sqrt(y - x);
		
		if (n1 * n1 == y - x) {
			printf("%llu\n", 2 * n1 - 1);
		}
		else {
			n2 = n1 + 1;

			i = n1 * n1;
			j = n2 * n2;

			if (((i + j) / 2) >= (y - x)) {
				printf("%llu\n", 2 * n1);
			}
			else {
				printf("%llu\n", 2 * n1 + 1);
			}
		}
	}
}