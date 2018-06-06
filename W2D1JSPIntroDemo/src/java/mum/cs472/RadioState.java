/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

/**
 *
 * @author sunling
 */
public class RadioState {
    private String yesCheck ;
    private String noCheck ;

    public void setNoCheck(String noCheck) {
        this.noCheck = noCheck;
    }

    public void setYesCheck(String yesCheck) {
        this.yesCheck = yesCheck;
    }

    public String getNoCheck() {
        return noCheck;
    }

    public String getYesCheck() {
        return yesCheck;
    }
    public void checked(String option){
        if(option.equals("1")){
            setYesCheck("checked");
            setNoCheck("");
        }else{
            setYesCheck("");
            setNoCheck("checked");
        }
    }
}
