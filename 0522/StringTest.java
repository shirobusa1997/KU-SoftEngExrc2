public class StringTest{
    //StringTestクラスのメインメソッドです。
    public static void main (String argv[]){
        //処理対象となる文字列を定義します。
        String msg = "The quick brown fox jumps over the lazy dog.";
        //変数の定義と処理結果のパラメータによる初期化を行います。
        int lastindex_e = msg.lastIndexOf('e');
        int beginindex = 11;
        int endindex = 21;
        
        //最後に'e'が現れる位置を出力します。
        System.out.printf("文字 'e' が最後に現れるのは、 %d 文字目です。\n", lastindex_e);
        //文字列 msg の11文字目から20文字目までの部分文字列を取り出し、出力します。
        System.out.printf("文字列msgの11文字目から20文字目までの部分文字列は以下の内容です。\n==>");
        System.out.printf(msg.substring(beginindex, endindex) + "\n");
    }
}