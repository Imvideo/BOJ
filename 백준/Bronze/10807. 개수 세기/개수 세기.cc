#include <iostream>

int main()
{
	int a, b,count=0;
	std::cin >> a;
	int* arr = new int[a];
	for (int i = 0; i < a; i++)
	{
		std::cin >> arr[i];
	}
	std::cin >> b;
	for (int i = 0; i < a; i++)
	{
		if (arr[i] == b)
		{
			count++;
		}
	}
	std::cout << count;
	return 0;
}