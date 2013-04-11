public class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> ret = new ArrayList<String>();
        String [] a = path.split("/");
        for(int i = 1; i < a.length; i++)
            ret.add(a[i]);
        int i = 0;
        while( i < ret.size()){                
            if((ret.get(i).equals("."))||(ret.get(i).equals(""))){
                ret.remove(i);
                continue;
            }
            if(ret.get(i).equals("..")){
                ret.remove(i);
                if (i>0)
                    ret.remove(i---1);
                continue;
            }
            i++;
        }
        String s = "";
        int j = 0;
        for( j = 0; j < ret.size(); j++)
            s = s+"/"+ret.get(j);
        if (j == 0) s = "/";
        return s;
    }
}
