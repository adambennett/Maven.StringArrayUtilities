package com.zipcodewilmington;

import java.util.ArrayList;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
       for (String s : array) {
           if (s == value) { return true; }
       }
       return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        ArrayList<String> listy = new ArrayList<>();
        for (int i = array.length - 1; i > -1; i--) {
            listy.add(array[i]);
        }

       String[] toRet = listy.toArray(new String[listy.size()]);
        return toRet;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] revCopy = reverse(array);
        for (int i = 0; i < revCopy.length; i++) {
            if (revCopy[i] != array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        ArrayList<Character> alphabet = new ArrayList<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        ArrayList<char[]> charArra = new ArrayList<>();
        for (String s : array) {
            charArra.add(s.toCharArray());
        }

        for (char[] c : charArra) {
            for (char ca : c) {
                if (alphabet.contains(ca)) {
                    int index = alphabet.lastIndexOf((char)ca);
                    alphabet.remove(index);
                }
                else if (alphabet.contains(Character.toLowerCase(ca))) {
                    int index = alphabet.lastIndexOf((char)Character.toLowerCase(ca));
                    alphabet.remove(index);
                }
            }
        }
        return alphabet.size() < 1;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int amt = 0;
        for (String s : array) {
            if (s == value) {
                amt++;
            }
        }
        return amt;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        ArrayList<String> toRet = new ArrayList<>();
        for (String s : array) {
            if (s != valueToRemove) {
                toRet.add(s);
            }
        }
        String[] returna = toRet.toArray(new String[toRet.size()]);
        return returna;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArr = new ArrayList<>();
        String lastCheck = "";
        for (String s : array) {
            if (s != lastCheck) {
                newArr.add(s);
                lastCheck = s;
            }
        }
        String[] returna = newArr.toArray(new String[newArr.size()]);
        return returna;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArr = new ArrayList<>();
        String lastCheck = "";
        String lastMatch = "";
        for (String s : array) {
            newArr.add(s);
        }
        for (int i = 0; i < newArr.size(); i++) {
            boolean toSet = false;
            if ((newArr.get(i) == lastCheck || newArr.get(i) == lastMatch) && i - 1 >= 0) {
                toSet = true;
                lastMatch = newArr.get(i);
            }
            lastCheck = newArr.get(i);
            if (toSet) {
                newArr.set(i - 1, newArr.get(i - 1) + newArr.get(i));
                toSet = false;
                newArr.remove(i);
                i = 0;
            }
        }
        String[] abbb = newArr.toArray(new String[newArr.size()]);
        return abbb;
    }


}
