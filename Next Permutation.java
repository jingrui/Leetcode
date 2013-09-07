/*
		 * 12340	->	12403
		 * 56781432	->	5678____ -> 56782___ -> 56782134
		 * 		^
		 * 		|
		 * 		begin
		 * 1657	->	1675
		 * find the last ascending number num[i] > num[i-1]
		 * find the small number s afterwards larger than num[i-1]
		 * swap
		 * reorder
		 */
public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1)    return;
		int begin = 0;
		for(int i = 1; i < num.length;i++)
			if(num[i] > num[i-1])
				begin = i;

		if(begin != 0){
			// find s
			int min = num[begin], mini = begin;
			for(int i = begin; i < num.length;i++){
    			if((min > num[i])&&(num[i] > num[begin-1])){
					mini = i;
					min = num[i];
				}
			}
			// swap
			swap(num,mini,begin-1);
		}
		Arrays.sort(num, begin, num.length);
    }
    public void swap(int num[],int a,int b){
    	int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
}
