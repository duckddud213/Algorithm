#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
using namespace std;
#define MAX 10001

int cnt, N, M, a, b, maxVal;
bool visited[MAX];
vector<int> result;
vector<int> graph[MAX];

void dfs(int i)
{
    for (int val : graph[i])
    {
        if (!visited[val])
        {
            visited[val] = true;
            cnt++;
            dfs(val);
        }
    }
}

int main()
{
    cin >> N >> M;

    for (int i = 0; i < M; i++)
    {
        cin >> a >> b;
        graph[b].push_back(a);
    }

    for (int i = 1; i <= N; i++)
    {
        memset(visited, false, sizeof(bool) * MAX);
        cnt = 1;
        visited[i] = true;
        dfs(i);
        if (cnt > maxVal)
        {
            maxVal = cnt;
            result.clear();
            result.push_back(i);
        }
        else if (cnt == maxVal)
        {
            result.push_back(i);
        }
    }

    for (int i : result)
    {
        cout << i << " ";
    }
}