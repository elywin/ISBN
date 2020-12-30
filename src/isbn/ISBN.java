/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isbn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Elywin
 */
public final class ISBN {

    private String firstValue;
    private String secondValue;
    private String thirdValue;
    private String fourthValue;

    //ISBN constractor
    public ISBN(String fvalue, String svalue, String tvalue, String ffvalue) {
        setFirstValue(fvalue);
        setSecondValue(svalue);
        setThirdValue(tvalue);
        setFourthValue(ffvalue);
    }

    //SETTERS
    public void setFirstValue(String fvalue) {
        this.firstValue = fvalue;
    }

    public void setSecondValue(String svalue) {
        this.secondValue = svalue;
    }

    public void setThirdValue(String tvalue) {
        this.thirdValue = tvalue;
    }

    public void setFourthValue(String ffvalue) {
        this.fourthValue = ffvalue;
    }

    //Getters
    public String getFirstValue() {
        return firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public String getThirdValue() {
        return thirdValue;
    }

    public String getFourthValue() {
        return fourthValue;
    }

    //method to compute isbn
    public static void isbnCompute(String st) {
        if (st.length() == 10) {

            int dNumber, d, t;
            int s = 0;
            for (int i = 0; i < st.length(); i++) {
                d = Integer.parseInt(st.substring(i, i + 1));
                dNumber = i + 1;
                t = dNumber * d;
                s += t;
            }

            // check the number s is divisible by 11 or not
            if ((s % 11) != 0) {
                System.out.println("Invalid ISBN");
            } else {
                System.out.println("Valid ISBN");
            }
        } else {
            System.out.println("Invalid Input");
        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String value;
        String ffirstvalue;
        String ssecondvalue;
        String tthirdvalue;
        String ffourthvalue;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ISBN is made up of 10 values");
        do {
            System.out.println("ENTER FIRST VALUE (one value to be entered)");
            ffirstvalue = br.readLine();
            if (ffirstvalue.length() == 1) {
                do {
                    System.out.println("ENTER SECOND VALUE (six values to be entered)");
                    ssecondvalue = br.readLine();
                    if (ssecondvalue.length() == 6) {
                        do {
                            System.out.println("ENTER THIRD VALUE (two values to be entered)");
                            tthirdvalue = br.readLine();
                            if (tthirdvalue.length() == 2) {
                                do {
                                    System.out.println("ENTER FOURTH VALUE (one value to be entered)");
                                    ffourthvalue = br.readLine();
                                    if (ffourthvalue.length() == 1) {
                                        System.out.println("-----------------------------------------------");

                                        ISBN isbn = new ISBN(ffirstvalue, ssecondvalue, tthirdvalue, ffourthvalue);
                                        System.out.println("First value: " + isbn.getFirstValue());
                                        System.out.println("Second value: " + isbn.getSecondValue());
                                        System.out.println("Third value: " + isbn.getThirdValue());
                                        System.out.println("Fourth value: " + isbn.getFourthValue());

                                        value = isbn.getFirstValue() + isbn.getSecondValue() + isbn.getThirdValue() + isbn.getFourthValue();
                                        System.out.println("value entered:" + " " + value);
                                        isbnCompute(value);
                                    } else {
                                        System.out.println("fourth value wrong");
                                    }
                                } while (ffourthvalue.length() > 1 || ffourthvalue.length() < 0);
                            } else {
                                System.out.println("third value wrong");
                            }
                        } while (tthirdvalue.length() > 2 || tthirdvalue.length() < 2);
                    } else {
                        System.out.println("second value wrong");
                    }
                } while (ssecondvalue.length() > 6 || ssecondvalue.length() < 6);
            } else {
                System.out.println("first value wrong");
            }
        } while (ffirstvalue.length() > 1 || ffirstvalue.length() < 0);

    }

}
