//https://code.google.com/codejam/contest/2418487/dashboard#s=p1
//tip: think about how adding a new value influences previously calculated results
//moral: squeeze time for important events to maximize gain

#include <iostream>
using namespace std;
const int maxn = 10000 + 5;

int main() {

	freopen("b-large", "r", stdin);
	int numCase;
	cin >> numCase;

	for (int i = 1; i <= numCase; i++) {
		int N;
		long long E, R;
		cin >> E >> R >> N;
		if (R > E) {
			R = E;
		}

		long long v[maxn], consume[maxn];

		long long leftover = E;

		for (int j = 0; j < N; j++) {
			cin >> v[j];
			//B 11
			//C 9

			//if C < B, consume everything B left

			//A 6
			//B 8
			//C 20

			// if C > B and C > A, make A and B pass down as close to E as possible

			//B 8
			//C 8
			//D 11

			// C = B can be a part of either C > B or C < B

			if (j == 0) {
				consume[j] = leftover;
				leftover = 0 + R;
			} else {
				int k = 1;
				while (leftover < E and v[j] >= v[j - k]) {
					long long squeeze = E - leftover;
					if (consume[j - k] > squeeze) {
						consume[j - k] = consume[j - k] - squeeze;
						leftover = E;
					} else {
						leftover = leftover + consume[j - k];
						consume[j - k] = 0;
					}
					k = k + 1;
				}
				consume[j] = leftover;
				leftover = 0 + R;
			}
		}

		long long sum = 0;
		for (int j = 0; j < N; j++) {
			sum = sum + v[j] * consume[j];
		}

		cout << "Case #" << i << ": " << sum << endl;
	}

	return 0;
}
