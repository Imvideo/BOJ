#include<stdio.h>
#define SIZE 7

int main()
{
	int a, min = 100, sum = 0,count=0;
	int arr[SIZE] = { 0, };
	for (int i = 0; i < 7; i++)
	{
		scanf("%d", &a);
		arr[i] = a;
		if (a % 2 == 1)
		{
			count++;
			sum += arr[i];
			if (min > arr[i]) min = arr[i];
		}
	}
	if (count != 0)
		printf("%d\n%d", sum, min);
	else
		printf("%d", -1);
	return 0;
}