//For original code you may go to below link.
//https://github.com/tahtaciburak/turkish-id-validator/blob/master/src/main/java/TurkishIdNumber.java
package credit.application.util;

public final class TurkishIdNumber {


    public static boolean isValid(String strNumber){
        if(strNumber.length()!=11 || strNumber.charAt(0)=='0'){
            return false;
        }
        int oddSum=0,evenSum=0,controlDigit=0;
        for(int i=0;i<=8;i++){
            if(i%2==0){
                oddSum+=Character.getNumericValue(strNumber.charAt(i));

            }else{
                evenSum+=Character.getNumericValue(strNumber.charAt(i));
            }
        }
        controlDigit = (oddSum*7-evenSum)%10;
        if(Character.getNumericValue(strNumber.charAt(9))!=controlDigit){
            return false;
        }
        if(Character.getNumericValue(strNumber.charAt(10))!=(controlDigit+evenSum+oddSum)%10){
            return false;
        }
        return true;
    }
}
