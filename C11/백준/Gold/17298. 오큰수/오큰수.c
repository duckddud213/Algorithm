#include <stdio.h>
#include <stdlib.h>

int top = 1;

void push(int *stack, int num)
{
    stack[top] = num;
}

void pop(int *stack)
{
    stack[top] = -1;
}

int main()
{
    int N, i, j, num;
    int *arr, *NGE, *stack;

    scanf("%d", &N);

    arr = (int *)malloc(sizeof(int) * (N + 1));
    NGE = (int *)malloc(sizeof(int) * (N + 1));
    stack = (int *)malloc(sizeof(int) * (N + 1));

    for (i = 0; i <= N; i++)
    {
        NGE[i] = -1;
        stack[i] = -1;
    }

    for (i = 1; i <= N; i++)
    {
        scanf("%d", arr + i);
        if (i == 1)
        {
            push(stack, 1);
        }
        else
        {
            if (arr[i] > arr[stack[top]])
            {
                while ((arr[i] > arr[stack[top]]) && (top >= 1))
                {
                    NGE[stack[top]] = arr[i];
                    pop(stack);
                    top--;
                }
                top++;
                push(stack, i);
            }
            else
            {
                top++;
                push(stack, i);
            }
        }
    }

    for (i = 1; i <= N; i++)
    {
        printf("%d ", NGE[i]);
    }
}