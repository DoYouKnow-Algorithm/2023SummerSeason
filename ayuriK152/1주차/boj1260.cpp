#include <queue>
#include <iostream>
#include <sstream>
using namespace std;

vector<int> vertex[1000];
bool check[1000] = { false };
stringstream s;

// 재귀 함수를 사용한 DFS 구현
void DFS(int start) {
	s << start + 1 << " ";
	check[start] = true;
	for (int i = 0; i < vertex[start].size(); i++) {
		if (!check[vertex[start][i]]) {
			DFS(vertex[start][i]);
		}
	}
}

// 큐를 사용한 BFS 구현
void BFS(int start) {
	queue<int> q;
	q.push(start);
	check[start] = true;
	s << start + 1<< " ";
	while (q.size() > 0) {
		int current = q.front();
		q.pop();
		for (int i = 0; i < vertex[current].size(); i++) {
			if (!check[vertex[current][i]]) {
				q.push(vertex[current][i]);
				check[vertex[current][i]] = true;
				s << vertex[current][i] + 1 << " ";
			}
		}
	}
}

int main() {
	int n, m, v;
	int a, b;

	cin >> n >> m >> v;

	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		vertex[a - 1].push_back(b - 1);
		vertex[b - 1].push_back(a - 1);
	}

	// 리스트 정렬 과정, 정렬을 안하면 오름차순으로 정점 방문 진행이 안되기 때문
	// 정렬을 안해도 알고리즘은 맞지만 문제의 요구를 충족시키지 못함
	for (int i = 0; i < n; i++)
		sort(vertex[i].begin(), vertex[i].end());

	DFS(v - 1);
	fill_n(check, n, false);	// 정점 방문 체크용 bool 배열 초기화
	s << "\n";
	BFS(v - 1);

	cout << s.str();
	return 0;
}