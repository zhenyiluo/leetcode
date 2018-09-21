package findkthtolth;

import java.util.*;

public class Solution implements Iterator<Integer> {
    Iterator<List<Integer>> listIt;
    Iterator<Integer> intIt;
    public Solution(List<List<Integer>> vec2d) {
        listIt = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return intIt.next();
        }
        throw new RuntimeException();
    }

    @Override
    public boolean hasNext() {
        while((intIt == null || !intIt.hasNext()) && listIt.hasNext()){
            intIt = listIt.next().iterator();
        }
        return intIt != null && intIt.hasNext();
    }

    @Override
    public void remove(){
        if(hasNext()){
            intIt.remove();
        }
    }

    public static void main(String[] args){
        List<List<Integer>> vec2d = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(5);
        vec2d.add(list1);
        vec2d.add(list2);
        vec2d.add(list3);
        vec2d.add(list4);
        Solution sol = new Solution(vec2d);
        while(sol.hasNext()){
            System.out.println(sol.next());
        }
        sol = new Solution(vec2d);
        while(sol.hasNext()){
            if(sol.next() %2 == 0) {
                sol.remove();
            }
        }
        System.out.println("#################");
        sol = new Solution(vec2d);
        while(sol.hasNext()){
            System.out.println(sol.next());
        }
    }


}