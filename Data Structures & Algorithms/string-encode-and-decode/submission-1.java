class Solution {

    public String encode(List<String> strs) {
        String codedString = "";
        String seperator = "#";
        for (String str : strs){
            codedString += str.length();
            codedString += seperator;
            codedString += str;
        }


        return codedString;
    }

    public List<String> decode(String str) {
        int individualStringLength = -1;
        List<String> stringList = new ArrayList<String>();

        while (str != ""){
            individualStringLength = Integer.parseInt(str.substring(0, str.indexOf("#")));
            String decodedString = str.substring(str.indexOf("#") + 1, str.indexOf("#") + individualStringLength + 1);
            stringList.add(decodedString);
            str = str.substring(str.indexOf("#") + individualStringLength + 1, str.length());
        }

        return stringList;
    }
}