#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        auto computeGain = [](int passes, int students) {
            return (double)(passes+1) / (students+1) - (double)passes / students;
        };

        priority_queue<pair<double, pair<int, int>>> heap;
        for(const auto& classInfo : classes) {
            heap.push({computeGain(classInfo[0], classInfo[1]), {classInfo[0], classInfo[1]}});
        }

        while (extraStudents--) {
            auto [gain, classInfo] = heap.top();
            heap.pop();

            int passes = classInfo.first, students = classInfo.second;
            heap.push({computeGain(passes+1, students+1), {passes+1, students+1}});
        }

        double passRatio = 0;
        while (!heap.empty()) {
            auto [_, classInfo] = heap.top();
            heap.pop();

            passRatio += (double)classInfo.first / classInfo.second;
        }

        return passRatio / classes.size();
    }
};
