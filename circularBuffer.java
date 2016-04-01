


Class API{
    private long[] buffer;
    private int p;
    int size = 0;
    public API(){
        buffer = new long[300];
        p = 0;
    }  

    private void setNext(long time){
        buffer[p] = time;
        p++;
        p %= 300;
        if(size != 300)size++;
    }
    
    private long getOldest(){
        if(buffer == null || size == 0) return -1;
        if(size != 300) return buffer[0];
        return buffer[p];
    }
    
    public boolean withIn300(long time){
        if(!size == 300) 
            if(time - buffer[0] < 300){
                setNext(time);
                return true;
            }
            return false;
        }
        else{
            if(time - getOldest < 300){
                setNext(time);
                return true;
            }
            return false;
        }
        
    }

}
