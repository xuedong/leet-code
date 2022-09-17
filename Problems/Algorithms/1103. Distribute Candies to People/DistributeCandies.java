class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int turns = (int) Math.sqrt(2*candies);
        if (turns * (turns + 1) / 2 > candies) {
            turns--;
        }
        int rest = candies - (turns*(turns+1))/2;

        int[] result = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            int turn = turns/num_people;
            result[i] = (i+1)*turn + (turn*(turn-1)*num_people)/2;
            if (turns%num_people > i) {
                result[i] += i+1 + turn*num_people;
            }
        }
        result[turns%num_people] += rest;
        return result;
    }
}
