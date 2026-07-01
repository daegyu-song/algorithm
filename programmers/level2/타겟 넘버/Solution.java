class Solution {

    int target;
    int[] numbers;

    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;

        return process(0, 0);
    }

    int process(int idx, int sum) {
        if (idx == numbers.length) {
            return sum == target ? 1 : 0;
        }

        return process(idx + 1, sum + numbers[idx]) + process(idx + 1, sum - numbers[idx]);
    }
}