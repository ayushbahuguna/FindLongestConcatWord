import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class FindLongestConcatWord {
  private static class LenghtComparator implements Comparator<String> {
    @Override
    public int compare(String word1, String word2) {
      return Integer.compare(word2.length(), word1.length());
    }
  }

  public String printLongestWord(String arr[]) {
    HashMap<String, Boolean> map = new HashMap<>();
    for (String newWord : arr) {
      map.put(newWord, true);
    }
    Arrays.sort(arr, new LenghtComparator());
    for (String word : arr) {
      if (canBuildWord(word, true, map)) {
        System.out.println(word);
        return word;
      }
    }
    return "";
  }

  private boolean canBuildWord(String wordPart, boolean isOriginalWord, HashMap<String, Boolean> map) {
    if (map.containsKey(wordPart) && !isOriginalWord) {
      return map.get(wordPart);
    }

    for (int i = 0; i < wordPart.length(); i++) {
      String left = wordPart.substring(0, i);
      String right = wordPart.substring(i);

      if (map.containsKey(left) && map.get(left) && canBuildWord(right, false, map)) {
        return true;
      }
    }

    map.put(wordPart, false);
    return false;
  }

}

public class FindLongestWord {
  public static void main(String[] args) throws Exception {
    String[] words = new String[] { "cats", "dog", "rat", "catsdog", "catsratdog", "catxdogsabsdjaasdfhsj",
        "hippopotamuses", "catxratdog" };
    FindLongestConcatWord lcw = new FindLongestConcatWord();
    lcw.printLongestWord(words);
  }

}