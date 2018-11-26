package javaparser;

/**
 * Created by xugangwen on 2018/11/27.
 */
public class Test {

    private void test(){
        int i =9;
        if(i>1){
            i++;
            getName();
        }else {
            i--;
        }
    }

    public String getName() {
        return "df";
    }
}
