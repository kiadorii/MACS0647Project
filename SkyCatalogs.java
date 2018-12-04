public class SkyCatalogs{
    private char[] numCheck;
    private String[] Header;
    private String[] Data;
    private String[] newCatalog;
    
//    public int arrayLength(int count){
//    }
    
    public String[] headerInit(String s){
        
    }
    
    
    //Reads the input from SubSupCam and checks when to stop
    public boolean HeaderEnd(){
        for(int i=0; i<char.length; i++){
            if(strRead == char[i])
                return true;
        }
        return false;
    }
    
    //used to check if user wants header or not
    //also will read in whether or not the user would like to confirm new header
    public boolean HandledKeyTyped(char keyPressed){
        if(keyPressed == 'Y'||keyPressed =='y'){
            return true;
        }
        return false;
    }
}