import java.util.*;

class Solution {
    class HTML implements Comparable<HTML>
    {
        String content;
        List<String> links;
        int index;
        int count;
        double totalPoint = -1.0;
        
        public HTML(String content, List<String> links, int index, int count)
        {
            this.content = content;
            this.links = links;
            this.index = index;
            this.count = count;
            this.totalPoint = (double)count;
        }
        
        @Override
        public int compareTo(HTML o)
        {
            if(o.totalPoint - this.totalPoint > 0) return 1;
            else if(o.totalPoint - this.totalPoint < 0) return -1;
            else
            {
                if(this.index - o.index > 0) return 1;
                else if(this.index - o.index < 0) return -1;
                return 0;
            }
        }
    }
    HashMap<String, HTML> pageMap;
    
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        pageMap = new HashMap<>();
        int len = pages.length;
        List<String> contentList = new ArrayList<>();
        for(int i=0; i<len; i++)
        {
            pages[i] = pages[i].toLowerCase();
            if(!pages[i].contains("meta")) continue;
            String[] contents = pages[i].split("[\\n]+");
            if(contents.length == 1 && !contents[0].contains("https://")) continue;
            String content = "";
            List<String> links = new ArrayList<>();
            for(int j=0; j<contents.length; j++)
            {
                if(contents[j].contains("meta"))
                {
                    String[] a = contents[j].split("\"");
                    for(int k=0; k<a.length; k++)
                    {
                        if(a[k].startsWith("https://")) content = a[k];
                    }
                }
                if(contents[j].contains("<a href"))
                {
                    String[] a = contents[j].split("\"");
                    if(a.length==0 || a== null) continue;
                     for(int k=0; k<a.length; k++)
                     {
                          if(a[k].contains("https://")) links.add(a[k]);
                     }
                }
            }
            if(content.equals("")) continue;
            contentList.add(content);
            String[] str = pages[i].split("[^a-zA-Z]+");
            int count=0;

            for(int j=0; j<str.length; j++)
            {
                if(str[j].equals(word)) count += 1;
            }
            HTML input = new HTML(content, links, i, count);
            pageMap.put(content, input);
        }
        for(int i=0; i<contentList.size(); i++)
        {
            HTML entry = pageMap.get(contentList.get(i));
            List<String> linkList = entry.links;
            for(int j=0; j<linkList.size(); j++)
            {
                String a = linkList.get(j);
                HTML linkEntry = pageMap.get(a);
                if(linkEntry == null) continue;
                linkEntry.totalPoint += (double)entry.count / (double)linkList.size();
                pageMap.put(a, linkEntry);
            }
        }
        List<HTML> arr = new ArrayList(pageMap.values());
        Collections.sort(arr);
        return arr.get(0).index;
    }
}