public class StatePancake
{    
    int pancakeArray[];
    int N;
    
    public StatePancake(int[] pancakeArray) {
    	
    	this.pancakeArray = pancakeArray;
        this.N=	pancakeArray.length;
    }
    
    
    public StatePancake(StatePancake state) {
    	N=state.N;
    	pancakeArray = new int[N];
        for(int i=0; i<N; i++) 
            this.pancakeArray[i] = state.pancakeArray[i];
    }
    
    public boolean equals(Object o)
    {
    	StatePancake state = (StatePancake) o;
        
        for (int i=0; i<state.N; i++)
            if (this.pancakeArray[i] != state.pancakeArray[i])
                return false;
        
        return true;
    }
    
    public int hashCode() {
    	return java.util.Arrays.hashCode( pancakeArray );
    }
    
    public String toString()
    {
        String ret = "";
        for (int i=0; i<pancakeArray.length; i++)
            ret += " " + this.pancakeArray[i];
        return ret;
    }
}