
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Reads data form text file
class ReadFromTextFile {

  public void getTextFile() throws Exception {
    File file = new File("./words.txt");

    BufferedReader br = new BufferedReader(new FileReader(file));

    String fileWord;
    TrieDS trie = new TrieDS();
    DataQueue dataQueue = new DataQueue();
    while ((fileWord = br.readLine()) != null) {
      trie.insertDataInTrie(fileWord);
      dataQueue.addDataInQueue(fileWord);
    }

    trie.searchWordFromTrie("ratcatdogcat");
    // dataQueue.showQueue();

  }

}

// Create a Trie data structure to store data
class TrieDS {
  private class TrieNode {
    Map<Character, TrieNode> children;
    boolean leafNode;

    public TrieNode() {
      children = new HashMap<>();
      leafNode = false;
    }
  }

  private final TrieNode root;

  public TrieDS() {
    root = new TrieNode();
  }

  // Insert data in nodes

  public void insertDataInTrie(String word) {
    TrieNode currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = currentNode.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        currentNode.children.put(ch, node);
      }
      currentNode = node;
      System.out.println("Inserted");
    }
    currentNode.leafNode = true;

  }

  // Search a word in TrieNode
  public boolean searchWordFromTrie(String word) {
    TrieNode currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = currentNode.children.get(ch);
      if (node == null) {
        return false;
      }
      currentNode = node;
    }
    System.out.println(currentNode.leafNode);
    return currentNode.leafNode;
  }

}

// Also add data in Queue
class DataQueue {
  Queue<String> wordQueue = new LinkedList<>();

  public void addDataInQueue(String word) {
    wordQueue.add(word);
  }

  // public void showQueue() {
  // System.out.println(wordQueue);
  // }

}

public class Main {
  public static void main(String[] args) throws Exception {
    ReadFromTextFile rd = new ReadFromTextFile();
    rd.getTextFile();

  }

}