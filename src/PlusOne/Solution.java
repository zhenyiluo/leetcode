class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int carryOver = 1;
        for(int i = digits.length -1; i >= 0; i--){
            int sum = carryOver + digits[i];
            digits[i] = sum % 10;
            carryOver = sum / 10;
        }
        int[] arr = digits;
        if(carryOver > 0){
            arr = new int[digits.length + 1];
            arr[0] = carryOver;
            for(int i = 0; i < digits.length; i++){
                arr[i+1] = digits[i];
            }
        }

        return arr;
    }
}