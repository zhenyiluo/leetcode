class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<>();
        if(accounts == null || accounts.size() == 0){
            return ret;
        }
        int countName = 0;
        int countEmail = 0;
        HashMap<String, String> nameMapping = new HashMap<>();
        HashMap<String, Integer> emailMapping = new HashMap<>();
        UF uf = new UF(10000);
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                String email = account.get(i);
                if(!emailMapping.containsKey(email)){
                    emailMapping.put(email, countEmail++);
                    nameMapping.put(email, name);
                }
                if(i != 1){
                    int a = emailMapping.get(account.get(1));
                    int b = emailMapping.get(account.get(i));
                    uf.union(a, b);
                }
            }
        }

        HashMap<Integer, List<String>> hm = new HashMap<>();
        for(String email: emailMapping.keySet()){
            int a = emailMapping.get(email);
            int num = uf.find(a);
            if(!hm.containsKey(num)){
                hm.put(num, new LinkedList<>());
            }
            hm.get(num).add(email);
        }

        for(int key: hm.keySet()){
            List<String> list = hm.get(key);
            String name = nameMapping.get(list.get(0));
            Collections.sort(list);
            list.add(0, name);
            ret.add(list);
        }
        return ret;
    }
}

class UF{
    int[] id;
    int[] size;
    public UF(int n){
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return;
        if(size[p] < size[q]){
            id[p] = q;
            size[q] += size[p];
        }else{
            id[q] = p;
            size[p] += size[q];
        }
    }
}