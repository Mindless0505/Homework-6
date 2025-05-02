public class MorseTester {
    public static void main(String[] args){
        MorseTree<String> T1 = new MorseTree<String>();
        T1.fillTree();
        T1.preorder(T1);
        T1.postorder(T1);
        System.out.println(T1.wordRunner("the quick fox"));
        System.out.println(T1.morseToEnglish(" - |  o  o  o  o |  o |  -  -  o  - |  o  o  - |  o  o |  -  o  -  o |  -  o  - |  o  o  -  o |  -  -  - |  -  o  o  - |"));
}
}
