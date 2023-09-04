#include <stdio.h>
#include <string.h>

int main()
{
	int arr[9];
	int sum = 0, dif, tmp, count = 0,break_count=0;
	for (int i = 0; i < 9; i++)
	{
		scanf("%d", &arr[i]);
		sum += arr[i];
		if (i != 0 && arr[i] < arr[i - 1])
		{
			tmp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = tmp;
		}
	}
	for (int i = 0; i < 8; i++)
	{
		count = 0;
		for (int j = 0; j < 8; j++)
		{
			if (arr[j] < arr[j + 1])
			{
				tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
				count++;
			}
		}
		if (count == 0)
			break;
	}
	dif = sum - 100;
	for (int i = 0; i < 8; i++)
	{
		for (int j = i + 1; j < 9; j++)
		{
			if (arr[i] + arr[j] == dif)
			{
				arr[i] = 0;
				arr[j] = 0;
				break_count++;
				break;
			}
		}
		if (break_count == 1)
			break;
	}
	count = 0;
	for (int i = 8; i >= 0; i--)
	{
		if (arr[i] != 0)
		{
			printf("%d", arr[i]);
			if (count == 6)
				break;
			count++;
			printf("\n");
		}
	}
	return 0;
}