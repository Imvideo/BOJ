#include <stdio.h>

int main(void)
{
	int x;
	scanf("%d", &x);
	x % 4 == 0 && x % 100 != 0||x % 400 == 0  ? printf("1") : printf("0");
	return 0;
}