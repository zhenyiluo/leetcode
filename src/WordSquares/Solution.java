class Solution {

    public List<List<String>> wordSquares(String[] words) {
        int len = words[0].length();
        List<List<String>> ret = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Trie trie = new Trie(words);
        for(String word: words){
            list.add(word);
            dfs(ret, list, len, trie);
            list.remove(list.size() -1);
        }
        return ret;
    }

    private void dfs(List<List<String>> ret, List<String> list, int len, Trie trie){
        if(list.size() == len){
            ret.add(new ArrayList<>(list));
            return;
        }

        int idx = list.size();

        StringBuilder prefix = new StringBuilder();
        for(String s: list){
            prefix.append(s.charAt(idx));
        }

        List<String> possibleWords = trie.getPrefixWords(prefix.toString());
        for(String word : possibleWords){
            list.add(word);
            dfs(ret, list, len, trie);
            list.remove(list.size() -1);
        }

        return;
    }
}

class Trie{
    TrieNode root;
    public Trie(String[] words){
        root = new TrieNode();
        for(String word: words){
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                int idx = c - 'a';
                if(cur.children[idx] == null){
                    cur.children[idx] = new TrieNode();
                }
                cur.startsWith.add(word);
                cur = cur.children[idx];
            }
        }
    }

    List<String> getPrefixWords(String prefix){
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int idx = c - 'a';
            cur = cur.children[idx];
            if(cur == null){
                return new ArrayList<>();
            }
        }
        return cur.startsWith;
    }
}

class TrieNode{
    List<String> startsWith;
    TrieNode[] children;

    public TrieNode(){
        startsWith = new ArrayList<>();
        children = new TrieNode[26];
    }

}