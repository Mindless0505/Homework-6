public class MorseTree<T>{
    private MorseTree<String> left;
    private MorseTree<String> right;
    private String root;

    public MorseTree(){
        this.root="";
        this.left=null;
        this.right=null;
    }
    
    public MorseTree(String element){
        this.root=element;
    }

    public String getElement(){
        return root;
    }

    public MorseTree<String> getLeft(){
        return left;
    }

    public MorseTree<String> getRight(){
        return right;
    }


    public void setElement(String element){
        this.root=element;
    }

    public void setRight(MorseTree<String> right){
        this.right=right;
    }

    public void setLeft(MorseTree<String> left){
        this.left=left;
    }


    public void insertLeft(String element){
        if(this.getLeft()==null){
            this.setLeft(new MorseTree<String>(element));
        }
        else{
            System.out.println("Cannot insert left");
        }
    }

    public void insertRight(String element){
        if(this.getRight()==null){
            this.setRight(new MorseTree<String>(element));
        }
        else{
            System.out.println("Cannot insert Right");
        }
    }


    public void preorder(MorseTree<String> node){
        if (node==null){
            return;
        }
        System.out.println(node.getElement());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void postorder(MorseTree<String> node){
        if (node==null){
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getElement());
    }


    //  - | o o o o | o | - - o - | o o - | o o | - o – o | - o - | o o – o | - - - | - o o - |
    public String morseToEnglish(String morse){
        String output="";
        MorseTree roottemp=this;
        for(int i=0; i<morse.length();i++){
            // if (morse.charAt(i)==' '){
            
            // }
            if (morse.charAt(i)=='-'){
                roottemp=roottemp.getRight();
            }
            else if (morse.charAt(i)=='o'){
                roottemp=roottemp.getLeft();
            }
            else if (morse.charAt(i)=='|'){
                output= output+roottemp.getElement();
                roottemp=this;
            }

        }
        return output;
    }


    public void fillTree(){
        this.setElement("");
        this.insertLeft("e");
        this.insertRight("t");
        this.getLeft().insertLeft("i");
        this.getLeft().insertRight("a");
        this.getRight().insertLeft("n");
        this.getRight().insertRight("m");
        this.getLeft().getLeft().insertLeft("s");
        this.getLeft().getLeft().insertRight("u");
        this.getLeft().getRight().insertLeft("r");
        this.getLeft().getRight().insertRight("w");
        this.getRight().getLeft().insertLeft("d");
        this.getRight().getLeft().insertRight("k");
        this.getRight().getRight().insertLeft("g");
        this.getRight().getRight().insertRight("o");
        this.getLeft().getLeft().getLeft().insertLeft("h");
        this.getLeft().getLeft().getLeft().insertRight("v");
        this.getLeft().getLeft().getRight().insertLeft("f");
        this.getLeft().getRight().getLeft().insertLeft("l");
        this.getLeft().getRight().getRight().insertLeft("p");
        this.getLeft().getRight().getRight().insertRight("j");
        this.getRight().getLeft().getLeft().insertLeft("b");
        this.getRight().getLeft().getLeft().insertRight("x");
        this.getRight().getLeft().getRight().insertLeft("c");
        this.getRight().getLeft().getRight().insertRight("y");
        this.getRight().getRight().getLeft().insertLeft("z");
        this.getRight().getRight().getLeft().insertRight("q");
        }




    public String englishToMorse(String letter, MorseTree<T> temprootM) {

        if (this.getLeft() != null && this.getLeft().getElement().equals(letter)) {

            return " o ";

        } else if (this.getRight() != null && this.getRight().getElement().equals(letter)) {

            return " - ";

        } else {

            if (this.getLeft() != null && !(this.getLeft().englishToMorse(letter, temprootM.getLeft()).equals(""))) {

                return " o " + this.getLeft().englishToMorse(letter, temprootM.getLeft());

            } else if (this.getRight() != null && !(this.getRight().englishToMorse(letter, temprootM.getRight()).equals(""))) {

                return " - " + this.getRight().englishToMorse(letter, temprootM.getRight());

            }

            return "";
        }
    }

    public String wordRunner(String english){
        String output="";
        for(int i=0; i<english.length();i++){
            // if (morse.charAt(i)==' '){
            
            // }
            if (english.charAt(i)!=' '){
               output=""+englishToMorse((english.charAt(i) +""),this);

            }


        }
        return output;
    }


}