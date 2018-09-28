class StringIterator {
    String str;
    int cnt;
    int index;
    int nextIndex;
    char c;
    public StringIterator(String compressedString) {
        str = compressedString;
        if(str == null || str.length() < 2) return;
        cnt = 0;
        index = 0;
        c = str.charAt(0);
        nextIndex = findNextIndex(index, str);
        cnt = Integer.valueOf(str.substring(index+1, nextIndex));
    }

    public char next() {
        if(hasNext()){
            cnt --;
            return c;
        }
        return ' ';
    }

    public boolean hasNext() {
        if(cnt > 0) return true;
        while(cnt <= 0){
            if(nextIndex >= str.length()) return false;
            index = nextIndex;
            nextIndex = findNextIndex(index, str);
            cnt = Integer.valueOf(str.substring(index+1, nextIndex));
            c = str.charAt(index);
        }
        return cnt > 0;
    }

    private int findNextIndex(int index, String str){
        int i = index+1;
        while(i < str.length()){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                i++;
            }else{
                return i;
            }
        }
        return i;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */