//Given an integer array hours representing times in hours,
// return an integer denoting the number of pairs i, j where i < j and hours[i] + hours[j] forms a complete day.

// A complete day is defined as a time duration that is an exact multiple of 24 hours.

// For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on.

//❌ https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/ ❌

public class Count_Pairs_That_Form_a_Complete_Day_II{
    //Brute Force O(n^2);
    public static int countPairs1(int arr[], int n){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((arr[i]+arr[j])%24 == 0){
                    count++;
                }
            }
        }

        return count;

    }

    // Property : (a+b)%24 = (a%24 + b%24)%24
    public static long countCompleteDayPairs(int[] hours) {
        // Making this freq array to store the counts of remainders when divided by 24.
        int freq[] = new int[24];
        long count = 0;

        // Iterating through each element in the hours array.
        for (int i = 0; i < hours.length; i++) {
            // Finding the remainder of the current number with 24.
            int rem = hours[i] % 24;

            // If the remainder is 0, then pair it with numbers whose remainder is also 0.
            if (rem == 0) {
                count += freq[0];
            }
            // If the remainder is not 0, then pair it with numbers whose remainder is (24 - rem).
            else {
                count += freq[24 - rem];
            }

            // Update the freq array to include the current remainder.
            freq[rem]++;
        }

        // Return the total count of complete day pairs.
        return count;
    }
    public static void main(String args[]){
        int a[] = {12,12,30,24,24};

        int n = 5;

        System.out.println(countPairs1(a, n));
        System.out.println("By Optimization: ");
        System.out.println(countCompleteDayPairs(a));
    }
}