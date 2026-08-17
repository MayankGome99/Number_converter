package mayank_number_converter_prj;

import java.util.Scanner;

public class Number_converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\n--- NUMBER CONVERTER ---");
            System.out.println("A. English Words");
            System.out.println("B. Digit by Digit (e.g., 100 -> One Zero Zero)");
            System.out.println("C. Roman Numerals");
            System.out.println("D. Exit Program");
            System.out.print("Choose an option (A-D): ");

            String choice = sc.next().toUpperCase();

            // 1. Check for Exit
            if (choice.equals("D")) {
                System.out.println("Exiting Program. Good work!");
                keepGoing = false;
                break;
            }

            // 2. Validate Choice before asking for input
            if (!choice.equals("A") && !choice.equals("B") && !choice.equals("C")) {
                System.out.println("Invalid choice! Please choose A, B, C, or D.");
                continue;
            }

            // 3. Ask for the number safely
            System.out.print("Enter a number: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: Input is too large or not a valid integer!");
                sc.next(); // Clear the invalid token from scanner buffer
                continue;
            }
            int number = sc.nextInt();

            // 4. Process the conversion
            switch (choice) {
                case "A":
                    if (number < 0 || number >= 1000000) {
                        System.out.println("Error: Limit is 0 to 999,999!");
                    } else {
                        System.out.print("English Words: ");
                        englishWords(number);
                        System.out.println();
                    }
                    break;
                case "B":
                    System.out.print("Digit by Digit: ");
                    digitByDigit(number);
                    break;
                case "C":
                    if (number <= 0 || number > 3999999) {
                        System.out.println("Error: Limit is 1 to 3,999,999!");
                    } else {
                        romanNumerals(number);
                    }
                    break;
            }

            System.out.println("\n--------------------------------");
            System.out.print("Press 'D' to Close, or type literally anything else to continue: ");

            String continueChoice = sc.next().toUpperCase();

            if (continueChoice.equals("D")) {
                System.out.println("[System] Task complete. Shutting down.");
                keepGoing = false;
                break;
            }

            // --- THE COOLDOWN TIMER ---
            System.out.println("\n[System] Reloading menu in 5 seconds...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Timer error.");
            }
        }

        sc.close();
    }

    public static void digitByDigit(int number) {
        String numStr = Integer.toString(number);
        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            System.out.print(words[digit] + " ");
        }
        System.out.println();
    }

    public static void romanNumerals(int number) {
        int[] values = {
                1000000, 900000, 500000, 400000, 100000, 90000, 50000, 40000, 10000, 9000, 5000, 4000,
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        String[] roman = {
                "M\u0305", "C\u0305M\u0305", "D\u0305", "C\u0305D\u0305", "C\u0305", "X\u0305C\u0305", "L\u0305", "X\u0305L\u0305",
                "X\u0305", "I\u0305X\u0305", "V\u0305", "I\u0305V\u0305",
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        System.out.print("Roman Numerals: ");
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                System.out.print(roman[i]);
            }
        }
        System.out.println();
    }

    public static void englishWords(int number) {
        String[] units = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        if (number < 20) {
            System.out.print(units[number]);
        } else if (number < 100) {
            int tensDigit = number / 10;
            int onesDigit = number % 10;

            if (onesDigit == 0) {
                System.out.print(tens[tensDigit]);
            } else {
                System.out.print(tens[tensDigit] + " " + units[onesDigit]);
            }
        } else if (number < 1000) {
            int hundredsDigit = number / 100;
            int leftover = number % 100;

            System.out.print(units[hundredsDigit] + " Hundred ");

            if (leftover > 0) {
                englishWords(leftover);
            }
        } else if (number < 1000000) {
            int thousandsDigit = number / 1000;
            int leftover = number % 1000;

            englishWords(thousandsDigit);
            System.out.print(" Thousand ");

            if (leftover > 0) {
                englishWords(leftover);
            }
        }
    }
}