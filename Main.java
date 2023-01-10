
   import java.util.Scanner;

    public class Main {
        public static void main(String[] arg){
            Scanner scanner = new Scanner(System.in);
            String inPut = scanner.nextLine();
            String[] symbol = inPut.split(" ");

            if (isDigitArabicRoma(symbol[0]) == true & isDigitArabicRoma(symbol[2]) == true){
                int firstNumbArabic = parseInt(symbol[0]);
                int secondNumbArabic = parseInt(symbol[2]);
                if (firstNumbArabic  < 1 || secondNumbArabic < 1 ||
                        firstNumbArabic  > 10 || secondNumbArabic > 10){
                    System.out.println("Исключение");

                }
                int res = result(firstNumbArabic , secondNumbArabic, symbol[1]);
                System.out.println(res);
            }
            else if (isDigitArabicRoma(symbol[0]) == false & isDigitArabicRoma(symbol[2]) == false){
                int firstNumbRoman = romanConvertArabian(symbol[0]);
                int secondNumbRoman = romanConvertArabian(symbol[2]);
                if ( firstNumbRoman == -1 || secondNumbRoman == -1){
                    System.out.println("Исключение");

                }
                int containsRoma = result(firstNumbRoman, secondNumbRoman, symbol[1]);
                if (containsRoma < 1) {
                    System.out.println("Исключение");

                }
                StringBuilder res_roman = arabiaConvertRoman(containsRoma);
                System.out.println(res_roman);
            }
            else {
                System.out.println("Исключение");
            }

        }
        private static int result (int firstSymbol, int secondSymbol, String operatores){
            char operator = operatores.charAt(0);
            int result = 0;
            switch (operator) {
                case '+':
                    return result = firstSymbol + secondSymbol;
                case '-':
                    return result = firstSymbol - secondSymbol;
                case '*':
                    return result = firstSymbol * secondSymbol;
                case '/':
                    return result = firstSymbol/ secondSymbol;
                default:
                    throw new IllegalArgumentException("Исключение, такой операции не существует");

            }

        }

        private static int parseInt(String a) {
            int numb = Integer.parseInt(a);
            return numb;
        }
        private static boolean isDigitArabicRoma(String word) {
            try {
                int firstNumber = Integer.parseInt(word);
                return true;
            }
            catch (Exception a) {
                return false;
            }
        }
        private static int romanConvertArabian(String romanNumber){
            switch (romanNumber) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                default:
                    return -1;

            }
        }
        private static StringBuilder arabiaConvertRoman(int numb){
            StringBuilder roman = new StringBuilder();
            while (numb > 0){
                if (numb / 50 > 0) {
                    roman = roman.append("L");
                    numb = numb - 50;
                }
                else if (numb / 10 > 0) {
                    int ten = 0;
                    for (int i = 0; i < (numb / 10); i++) {
                        roman = roman.append("X");
                        ten = i + 1;
                    }
                    numb = numb - (ten * 10);
                }
                else if (numb / 5 > 0){
                    numb = numb - 5;
                    roman = roman.append("V");
                }
                else if (numb == 4) {
                    roman = roman.append("IV");
                    numb = numb - 4;
                }
                else {
                    while (numb > 0 & numb < 4) {
                        roman = roman.append("I");
                        numb--;
                    }
                }
            }

            return roman;
        }

    }

