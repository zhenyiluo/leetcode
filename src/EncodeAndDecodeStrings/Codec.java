public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append(":").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 0){
            int index = sb.indexOf(":");
            int len = Integer.valueOf(sb.substring(0, index));
            ret.add(sb.substring(index+1, index+1+len));
            sb.delete(0, index+1+len);
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));}