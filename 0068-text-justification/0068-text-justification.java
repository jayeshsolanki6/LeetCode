class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        int i = 0;
        int len = 0;
        for(int j = 0; j<=n; j++){
            int strlen = (j == n)? 0 : words[j].length();
            if(j == n || len + strlen > maxWidth){
                list.add(buildStr(words, i, j-1, maxWidth));
                len = strlen+1;
                i = j;
            } else{
                len += strlen+1;
            }
        }
        return list;
    }
    String buildStr(String[] words, int i, int j, int maxWidth){
        if(i == j) return words[i] + space(maxWidth-words[i].length());
        boolean isLastLine = j == words.length-1;
        int gap = j-i;
    
        int totalSpace = maxWidth;
        for(int x = i; x<=j; x++){
            totalSpace -= words[x].length();
        }

        int evenSpace = (isLastLine) ? 1 : totalSpace / gap;
        int extra = (isLastLine)? 0 : totalSpace % gap;
        int last = totalSpace - gap;

        StringBuilder sb = new StringBuilder();
        sb.append(words[i]);

        for(int x = i+1; x <= j; x++){
            sb.append(space(evenSpace));
            if(!isLastLine && extra-- > 0){
                sb.append(" ");
            }
            sb.append(words[x]);
        }
        if(isLastLine){
            sb.append(space(last));
        }
        return sb.toString();
    }

    String space(int len){
        return new String(new char[len]).replace('\0', ' ');
    }
}