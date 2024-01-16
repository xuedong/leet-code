#include <vector>
#include <unordered_map>

using namespace std;

class RandomizedSet {
private:
    vector<int> nums;
    unordered_map<int, int> map;

public:
    RandomizedSet() {
    }
    
    bool search(int val) {
        if (map.find(val) != map.end()) {
            return true;
        }
        return false;
    }

    bool insert(int val) {
        if (search(val)) {
            return false;
        }

        nums.push_back(val);
        map[val] = nums.size() - 1;
        return true;
    }
    
    bool remove(int val) {
        if (!search(val)) {
            return false;
        }

        auto idx = map.find(val);
        nums[idx->second] = nums.back();
        nums.pop_back();
        map[nums[idx->second]] = idx->second;
        map.erase(val);

        return true;
    }
    
    int getRandom() {
        return nums[rand() % nums.size()];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */