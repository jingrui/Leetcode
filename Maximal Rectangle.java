if((matrix.length == 0)||(matrix[0].length == 0)) return 0;
		
        int max = 0;
        int[][] v = new int[matrix.length+1][matrix[0].length];
        for(int j = matrix[0].length-1; j >= 0; j--)
            for(int i = matrix.length-1; i >=0; i--){
                if(matrix[i][j] == '0')	continue;
            	v[i][j] = v[i+1][j]+1;
            }
        for(int i = 0; i <= matrix.length-1;i++){
        	for(int j = 0; j <= matrix[0].length-1; j++)
        		System.out.print(v[i][j]+" ");
        	System.out.println();
        }
        for(int i = 0; i<= matrix.length-1; i++){
        	int j = 0;
        	while(j <= matrix[0].length-1){
        		int value = v[i][j];
        		if(value == 0){
                    j++;
            		continue;
        		}
            	int next = -1, digits = 1;;

        		// single
        		max = Math.max(value,max);
            	// combo
            	int min = value;
            	while((++j <= matrix[0].length-1)&&(v[i][j]!= 0)){
            		if(v[i][j] > value)
            			next = (next == -1)?j:next;// update only for the first larger number
            		else
                		min = Math.min(min, v[i][j]);
            		digits++;
            		max = Math.max(min*digits,max);
//                	System.out.println("max = "+max+", min = "+min+",digits = "+digits);
            	}
            	if(next != -1)	j = next;
            	else	j++;
            }
        }
        return max;
