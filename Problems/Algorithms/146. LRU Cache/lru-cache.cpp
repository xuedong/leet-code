#include <unordered_map>

using namespace std;

class LRUCache {
public:
    class Node {
        public:
            int key;
            int val;
            Node* prev;
            Node* next;

            Node(int key, int val) {
                this->key = key;
                this->val = val;
            }
    };

    Node* head = new Node(-1, -1);
    Node* tail = new Node(-1, -1);

    int capacity;
    unordered_map<int, Node*> map;

    LRUCache(int capacity) {
        this->capacity = capacity;
        head->next = tail;
        tail->prev = head;
    }

    void add(Node* node) {
        Node* temp = head->next;

        node->next = temp;
        node->prev = head;

        head->next = node;
        temp->prev = node;
    }

    void remove(Node* node) {
        Node* tempPrev = node->prev;
        Node* tempNext = node->next;

        tempPrev->next = tempNext;
        tempNext->prev = tempPrev;
    }
    
    int get(int key) {
        if (map.find(key) != map.end()) {
            Node* result = map[key];
            int ans = result->val;

            map.erase(key);
            remove(result);
            add(result);

            map[key] = head->next;
            return ans;
        }

        return -1;
    }
    
    void put(int key, int value) {
        if (map.find(key) != map.end()) {
            Node* curr = map[key];
            map.erase(key);
            remove(curr);
        }

        if (map.size() == capacity) {
            map.erase(tail->prev->key);
            remove(tail->prev);
        }

        add(new Node(key, value));
        map[key] = head->next;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */