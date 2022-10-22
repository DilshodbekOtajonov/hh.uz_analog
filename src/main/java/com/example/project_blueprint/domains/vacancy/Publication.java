package com.example.project_blueprint.domains.vacancy;

import java.time.LocalDateTime;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 5:00 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
public class Publication {

    //    private PublicationType publicationType;
    private LocalDateTime publicationTime;

    public static void main(String[] args) {

        System.out.println(addBinary("11001", "10"));
    }

    public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int checker = 1;
        byte remained = 0;
        byte alfa = 0;
        byte beta = 0;
        byte addition = 0;
        boolean firstCase = aLength >= checker;
        boolean secondCase = bLength >= checker;
        StringBuffer result = new StringBuffer("");
        while (firstCase || secondCase) {

            if (firstCase && a.charAt(aLength - checker) == '1') alfa = 1;
            else alfa = 0;

            if (secondCase && b.charAt(bLength - checker) == '1') beta = 1;
            else beta = 0;

            addition = (byte) (alfa + beta + remained);

            switch (addition) {
                case 1: {
                    result.insert(0, '1');
                    remained = 0;
                }
                break;
                case 2: {
                    result.insert(0, '0');
                    remained = 1;
                }
                break;

                case 3: {
                    result.insert(0, '1');
                    remained = 1;
                }
                break;
                default: {
                    result.insert(0, '0');
                    remained = 0;
                }
            }
            checker++;
            firstCase = aLength >= checker;
            secondCase = bLength >= checker;
        }
        return result.toString();
    }

}
