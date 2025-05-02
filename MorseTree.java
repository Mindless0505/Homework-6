public class MorseTree<T>{
    private String element;
    private MorseTree<String> left;
    private MorseTree<String> right;
    private MorseTree<String> root;

    public MorseTree(){
        this.element="empty";
        this.root.setElement("element");;
    }

    public MorseTree(String element){
        this.element=element;
    }

    public String getElement(){
        return element;
    }

    public MorseTree<String> getLeft(){
        return left;
    }

    public MorseTree<String> getRight(){
        return right;
    }

    public MorseTree<String> getRoot(){
        return root;
    }

    public void setElement(String element){
        this.element=element;
    }

    public void setRight(MorseTree<String> right){
        this.right=right;
    }

    public void setLeft(MorseTree<String> left){
        this.left=left;
    }



    // public void inorder(MorseTree<String> node){
    //     if (node==null){
    //         return;
    //     }
    //     inorder(node.getLeft());
    //     System.out.println(node.getElement());
    //     inorder(node.getRight());
    // }

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


    //  - | o o o o | o | - - o - | o o - | o o | - o – o | - o - | o o – o | - - - | - o o - |
    public String morseToEnglish(String morse){
        String output="";
        MorseTree<String> roottemp=root;
        for(int i=0; i<morse.length();i++){
            // if (morse.charAt(i)==' '){
            
            // }
            if (morse.charAt(i)=='-'){
                roottemp=root.getRight();
            }
            else if (morse.charAt(i)=='o'){
                roottemp=root.getLeft();
            }
            else if (morse.charAt(i)=='|'){
                output= output+roottemp.getElement();
                roottemp=root;
            }

        }
        return output;
    }


    public void fillTree(){
        root.setElement("");
        root.insertLeft("e");
        root.insertRight("t");
        root.getLeft().insertLeft("i");
        root.getLeft().insertRight("a");
        root.getRight().insertLeft("n");
        root.getRight().insertRight("m");
        root.getLeft().getLeft().insertLeft("s");
        root.getLeft().getLeft().insertRight("u");
        root.getLeft().getRight().insertLeft("r");
        root.getLeft().getRight().insertRight("w");
        root.getRight().getLeft().insertLeft("d");
        root.getRight().getLeft().insertRight("k");
        root.getRight().getRight().insertLeft("g");
        root.getRight().getRight().insertRight("o");
        root.getLeft().getLeft().getLeft().insertLeft("h");
        root.getLeft().getLeft().getLeft().insertRight("v");
        root.getLeft().getLeft().getRight().insertLeft("f");
        root.getLeft().getRight().getLeft().insertLeft("l");
        root.getLeft().getRight().getRight().insertLeft("p");
        root.getLeft().getRight().getRight().insertRight("j");
        root.getRight().getLeft().getLeft().insertLeft("b");
        root.getRight().getLeft().getLeft().insertRight("x");
        root.getRight().getLeft().getRight().insertLeft("c");
        root.getRight().getLeft().getRight().insertRight("y");
        root.getRight().getRight().getLeft().insertLeft("z");
        root.getRight().getRight().getLeft().insertRight("q");
        }




    public String englishToMorse(String letter, MorseTree<String> temprootM) {

        if (this.getLeft() != null && this.getLeft().getRoot().equals(letter)) {

            return " o ";

        } else if (this.getRight() != null && this.getRight().getRoot().equals(letter)) {

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
               output=""+englishToMorse((english.charAt(i) +""),root);

            }


        }
        return output;
    }


}