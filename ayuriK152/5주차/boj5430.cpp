#include <iostream>
#include <sstream>

using namespace std;

class Deque {		// �յ� ������ ���� ��ü �� Ŭ����
public:
	string arr[100000];
	int count, first, last;
	bool isReverse;			// ��������
	bool isError;			// ���� ����
	Deque(int size) {
		count = size;
		first = 0;
		last = size - 1;
		isReverse = false;
		isError = false;
	}

	void Reverse() {		// ���� �Լ�
		isReverse = !isReverse;
	}

	void Delete() {			// ���� �Լ�
		if (first > last || count == 0 || isError) { // ���̻� ������ ��Ұ� ���ų� �̹� ������ �� ��� ���� ó��
			isError = true;
			return;
		}
		if (!isReverse) {	// ���� ���ΰ� �����̸� ���� �ε��� �ø���
			first++;
			count--;
		}
		else {			// ���� ���ΰ� ���̸� ���� �ε��� ���̱�
			last--;
			count--;
		}
	}
	
	string ShowAll() {		// ���� ��� ���
		string result;
		if (isError)		// ������ ������ error ���
			result = "error";
		else if (count == 0)	// ���� ��Ұ� 0���� [] ���
			result = "[]";
		else if (!isReverse) {		// ������ ���ο� ���� ��� ���Ŀ� ���� ���
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
		input = input.substr(1, input.length() - 2);	// �Է¹��� ������ ���ڸ� �߶󳻱� ���� ���� (77~81�����)
		istringstream iss(input);

		for (int j = 0; j < n; j++)
			getline(iss, deque.arr[j], ',');
		for (int j = 0; j < p.length(); j++) {		// �Է¹��� Ŀ��忡 ���� �Լ� ����
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