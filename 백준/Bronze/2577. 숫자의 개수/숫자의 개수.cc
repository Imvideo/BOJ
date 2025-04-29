#include<stdio.h>
#define SIZE 10

int main()
{
	int a, b, c, result,i;
	scanf("%d %d %d", &a, &b, &c);
	result = a * b * c;
	int arr[SIZE] = { 0, };
	int count[10] = { 0, };
	while (result > 0)
	{
		
		for (int i = 0; i < 10; i++)
		{
			if (result % 10 == i) count[i]++;
		}
		result /= 10;
	}
	for (int j = 0; j < 10; j++)
		printf("%d\n", count[j]);
	return 0;
}