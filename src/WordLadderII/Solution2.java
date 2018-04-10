class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(String word: wordList){
            hs.add(word);
        }
        if(!hs.contains(endWord)){
            return ret;
        }

        Queue<Element> q = new LinkedList<>();
        q.add(new Element(beginWord, null));
        hs.remove(beginWord);
        boolean endFlag = false;
        while(!q.isEmpty() && !endFlag){
            int size = q.size();
            HashSet<String> usedString = new HashSet<>();
            for(int i = 0; i < size; i++){
                Element e = q.poll();
                if(e.val.equals(endWord)){
                    helper(ret, e);
                    endFlag = true;
                }
                char[] curArr = e.val.toCharArray();
                for(int j= 0; j < curArr.length; j++){
                    char c = curArr[j];
                    for(char tmp = 'a'; tmp <= 'z'; tmp++){
                        if(tmp == c) continue;
                        curArr[j] = tmp;
                        String newWord = new String(curArr);
                        if(hs.contains(newWord)){
                            q.add(new Element(newWord, e));
                            usedString.add(newWord);
                        }
                    }
                    curArr[j] = c;
                }
            }
            for(String s: usedString){
                hs.remove(s);
            }
        }
        return ret;
    }

    private void helper(List<List<String>> ret, Element e){
        List<String> curResult = new ArrayList<>();
        while(true){
            curResult.add(0, e.val);
            if(e.parent != null){
                e = e.parent;
            }else{
                break;
            }
        }
        ret.add(curResult);
    }
}

class Element{
    Element parent;
    String val;
    public Element(String val, Element parent){
        this.val = val;
        this.parent = parent;
    }
}