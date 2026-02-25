#include <stdio.h>

int fibo(int a)								//반복문으로 피보나치 수열 만들기
{
	int sum=1;
	int arr[1000] = { 1,2, };
	if (a == 1)
		return 1;
	if (a == 2)
		return 2;
	else
	{
		for (int i = 0; i < a-2; i++)
		{
			arr[i + 2] = (arr[i + 1] + arr[i])%10007;
		}
		return arr[a - 1];
	}
}
int main()
{
	int n,result;
	scanf("%d", &n);
	result = fibo(n);
	printf("%d", result);
	return 0;
}