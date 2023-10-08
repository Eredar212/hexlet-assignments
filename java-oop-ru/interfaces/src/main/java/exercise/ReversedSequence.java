package exercise;

// BEGIN
public class ReversedSequence  implements CharSequence {
    private String charSeq;

    public ReversedSequence(String charSeq) {
        this.charSeq = new StringBuilder(charSeq).reverse().toString();
    }

    @Override
    public int length() {
        return charSeq.length();
    }

    @Override
    public char charAt(int index) {
        return charSeq.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return charSeq.subSequence(start, end);
    }
    @Override
    public String toString() {
        return charSeq;
    }
}
// END
