public int choose(Iterator<Integer> input){
    if(input == null || !input.hasNext()) return -1;
    Integer rst = null;
    int range = 0;
    Random r = new Random();
    while(input.hasNext()){
        range++;
        if(r.nextInt(range) == 0) rst = input.next();
    }
    return rst.intValue();
}