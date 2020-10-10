public class StateWolf 
{    
    int wolfArray[];
    
    public StateWolf(int[] wolfArray) { this.wolfArray = wolfArray; }
    
    
    public StateWolf(StateWolf state) {
    	wolfArray = new int[8];
        for(int i=0; i<8; i++) 
            this.wolfArray[i] = state.wolfArray[i];
    }
    
    public boolean equals(Object o)
    {
    	StateWolf state = (StateWolf) o;
        
        for (int i=0; i<8; i++)
            if (this.wolfArray[i] != state.wolfArray[i])
                return false;
        
        return true;
    }
    
    public int hashCode() {
        return wolfArray[0]*10000000 + wolfArray[1]*1000000 + wolfArray[2]*100000 +
               wolfArray[3]*10000 + wolfArray[4]*1000 + wolfArray[5]*100+wolfArray[6]*10+wolfArray[7];
    }    
    
    public String toString()
    {
        String ret = "";
        for (int i=0; i<8; i++)
            ret += " " + this.wolfArray[i];
        return ret;
    }
}