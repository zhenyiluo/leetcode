class StringIterator {
    int index = -1;
    int newIndex = 0;
    int cur = 0;
    int curTotal = 0;
    String str;
    public StringIterator(String compressedString) {
        str = compressedString;
    }

    public char next() {
        if(hasNext()){
            cur ++;
            return str.charAt(index);
        }
        return ' ';
    }

    public boolean hasNext() {
        while(cur >= curTotal){
            index = newIndex;
            if(index >= str.length()) return false;
            newIndex = getNextChar(str, index);
            curTotal = Integer.valueOf(str.substring(index+1, newIndex));
            cur = 0;
        }
        return true;
    }

    private int getNextChar(String str, int start){
        start ++;
        while(start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            start ++;
        }
        return start;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */