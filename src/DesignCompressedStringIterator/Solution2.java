class StringIterator {
    int index = 0;
    int nextIndex = -1;
    String str;
    int cur = 0;
    public StringIterator(String compressedString) {
        str = compressedString;
        if(index >= str.length()) return;
        nextIndex = getNextInt(str, index + 1);
        cur = Integer.valueOf(str.substring(index+1, nextIndex));
    }

    public char next() {
        if(hasNext()){
            cur --;
            return str.charAt(index);
        }
        return ' ';
    }

    public boolean hasNext() {
        if(index >= str.length()) return false;
        while(cur == 0){
            index = nextIndex;
            if(index >= str.length()) return false;
            nextIndex = getNextInt(str, index + 1);
            cur = Integer.valueOf(str.substring(index+1, nextIndex));

        }
        return true;
    }

    private int getNextInt(String str, int index){
        while(index < str.length()){
            if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                index ++;
            }else{
                break;
            }
        }
        return index;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */