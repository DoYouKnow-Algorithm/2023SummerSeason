#include <iostream>
#include <sstream>

using namespace std;

class Deque {		// 앞뒤 삭제를 위한 자체 덱 클래스
public:
	string arr[100000];
	int count, first, last;
	bool isReverse;			// 반전여부
	bool isError;			// 에러 여부
	Deque(int size) {
		count = size;
		first = 0;
		last = size - 1;
		isReverse = false;
		isError = false;
	}

	void Reverse() {		// 반전 함수
		isReverse = !isReverse;
	}

	void Delete() {			// 삭제 함수
		if (first > last || count == 0 || isError) { // 더이상 삭제할 요소가 없거나 이미 에러가 난 경우 에러 처리
			isError = true;
			return;
		}
		if (!isReverse) {	// 반전 여부가 거짓이면 앞의 인덱스 늘리기
			first++;
			count--;
		}
		else {			// 반전 여부가 참이면 뒤의 인덱스 줄이기
			last--;
			count--;
		}
	}
	
	string ShowAll() {		// 최종 결과 출력
		string result;
		if (isError)		// 에러가 났으면 error 출력
			result = "error";
		else if (count == 0)	// 남은 요소가 0개면 [] 출력
			result = "[]";
		else if (!isReverse) {		// 리버스 여부에 따라 출력 형식에 맞춰 출력
			result += "[";
			for (int i = first; i <= last; i++) {
				result += arr[i] + ",";
			}
			result[result.length() - 1] = ']';
		}
		else {
			result += "[";
			for (int i = last; i >= first; i--) {
				result += arr[i] + ",";
			}
			result[result.length() - 1] = ']';
		}
		return result;
	}
};

int main() {
	int t;
	cin >> t;

	for (int i = 0; i < t; i++) {
		string p;
		cin >> p;

		int n;
		cin >> n;
		Deque deque(n);

		string input;
		cin >> input;
		input = input.substr(1, input.length() - 2);	// 입력받은 형식을 숫자만 잘라내기 위한 과정 (77~81행까지)
		istringstream iss(input);

		for (int j = 0; j < n; j++)
			getline(iss, deque.arr[j], ',');
		for (int j = 0; j < p.length(); j++) {		// 입력받은 커멘드에 따라 함수 실행
			switch (p[j]) {
			case 'R':
				deque.Reverse();
				break;
			case 'D':
				deque.Delete();
				break;
			}
		}
		cout << deque.ShowAll() << endl;
	}
	return 0;
}