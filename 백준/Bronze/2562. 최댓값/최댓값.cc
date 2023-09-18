#include <stdio.h>

int main()
{
	int max = 0, a, num;
	for (int i = 0; i < 9; i++)
	{
		scanf("%d", &a);
		if (a > max)
		{
			max = a;
			num = i + 1;
		}
	}
	printf("%d\n%d", max, num);
	return 0;
}