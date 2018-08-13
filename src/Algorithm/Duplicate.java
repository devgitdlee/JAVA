package Algorithm;

public class Duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = new int[]{1,1,3,3,0,1,1};	
        //int[] arr = new int[]{4,4,4,3,3};	
        removeDuplicates(arr);
        System.out.println("출력 되는거임="+arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]);
        //System.out.print(String.valueOf(removeDuplicates(arr)));
	}
	/*
	public static int[] removeDuplicates(int[] arr) {

	    int end = arr.length;
	    System.out.println("end 크기"+end);
	    for (int i = 0; i < end; i++) {
	        for (int j = i + 1; j < end; j++) {
	            if (arr[i] == arr[j]) {                  
	                int shiftLeft = j;
	                for (int k = j+1; k < end; k++,shiftLeft++) {
	                	//System.out.println(arr[shiftLeft]);
	                	//System.out.println(arr[k]);
	                	arr[shiftLeft] = arr[k];
	                }
	                end--;
	                j--;
	            }
	        }
	    }
	    System.out.println("재정립 arr[i] 크기"+arr);	
	    System.out.println("재정립 end 크기"+end);	
	    int[] whitelist = new int[end];
	    for(int i = 0; i < end; i++){
	        whitelist[i] = arr[i];
	    }
	    System.out.print(whitelist);
	    return whitelist;
	}
    */
	public static int[] removeDuplicates(int[] arr) {
		//int[] answer = new int[3];
		int end = arr.length;
		int last = end;
		int shiftLeft = 0;
		int i = 0;
		//for (int i = 0; i < last; i++) {
			for (int j = 1; j < last; j++) {
				if(arr[i] == arr[j]) {
					if (j+1 == last) {
					arr[shiftLeft] = arr[i];
					 //shiftLeft = shiftLeft + 1;
					 end--;
					}
				}
				else {
					arr[shiftLeft] = arr[i];
					shiftLeft = shiftLeft + 1;
					end--;
				    i = j;
				 
				}
			}
		//}
		int[] whitelist = new int[end];
	    for(int s = 0; s < end; s++){
	        whitelist[s] = arr[s];
	    }
	    //System.out.print(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+"end:"+end+","+"shift:"+shiftLeft);
	    //System.out.print(whitelist[0]);
	    return arr;
		
	}
}
