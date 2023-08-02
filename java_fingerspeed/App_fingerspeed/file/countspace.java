package App_fingerspeed.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class countspace {
    String Para;
    StringTokenizer word;
    ArrayList<String> wordList;
    ArrayList<Integer> spaceatpos;
    HashMap<Integer, Integer> spacepos;

    int countSpace = 1;

    public countspace(String para) {
        this.Para = para;
        this.word = new StringTokenizer(Para);
        this.wordList = new ArrayList<String>();
        this.spaceatpos = new ArrayList<Integer>();
        this.spacepos = new HashMap<Integer, Integer>();
        while (this.word.hasMoreTokens()) {
            this.wordList.add(word.nextToken());
        }
        String fiwo = this.wordList.get(0);
        int lefiwo = fiwo.length();
        this.spacepos.put(1, lefiwo);
        this.spaceatpos.add(1);
        for (int i = 1; i < this.Para.length(); i++) {
            Character charat = this.Para.charAt(i);
            if (charat == ' ') {
                String wordat = this.wordList.get(this.countSpace);
                int length = wordat.length();
                this.spaceatpos.add(i + 2);
                this.spacepos.put(i + 2, i + length + 1);
                countSpace += 1;
            }
        }
    }

    public void printwordlist() {
        for (int i = 0; i < this.wordList.size(); i++) {
            // this.spaceatpos.get(i);
            System.out.print(this.wordList.get(i) + " " + this.spaceatpos.get(i) + " "
                    + this.spacepos.get(this.spaceatpos.get(i)) + "\n");
        }
    }

    public ArrayList<String> WList() {
        return this.wordList;
    }

    public ArrayList<Integer> SAPos() {
        return this.spaceatpos;
    }

    public HashMap<Integer, Integer> SPos() {
        return this.spacepos;
    }

    public void getWord(int pos, String word, int chudau, int chucuoi) {
        word = this.wordList.get(pos);
        chudau = this.spaceatpos.get(pos);
        chucuoi = this.spacepos.get(chudau);
    }

    public String getw(int pos) {
        return this.wordList.get(pos);
    }

    public int getchudau(int pos) {
        return this.spaceatpos.get(pos);
    }

    public int getchucuoi(int chudau) {
        return this.spacepos.get(chudau);
    }
}
