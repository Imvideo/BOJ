#include <stdio.h>

int main()
{
	int x, i, j;
	scanf("%d", &x);
	i = 0;
	while (i < x-1)
	{
		j = 0;
		while (j < x)
		{
			if (j < x-i-1)
				printf(" ");
			else 
				printf("*");
			j++;
		}
		printf("\n");
		i++;
	}
	i = 0;
	while (i < x)
	{
		printf("*");
		i++;
	}
	return 0;
}