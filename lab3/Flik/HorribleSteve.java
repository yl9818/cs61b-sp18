public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }// break when i = 128 and j = 128;
        }
        System.out.println("i is " + i);
    }
}
// refactor/refactoring: means changing the syntax
// without changing the functionality

// Autoboxing: is the automatic conversion that the Java
// compiler makes between the primitive types and their
// corresponding object wrapper classes.
// Unboxing: conversion goes the other way

// Integer a = 127; Integer b = 127; a == b => true
// direct assignment of an int literal to an Integer reference
// is an example of auto-boxing concept where the literal value
// to object conversion code is handled by the compiler,
// so during compilation phase compiler converts
// Integer a = 127;
// to
// Integer a = Integer.valueOf(127);
// The Integer class maintains an internal IntegerCache for
// integers, which by default ranges from -128 to 127, and
// Integer.valueOf() method returns objects of mentioned
// range from that cache. So a == b returns true because
// a and b are pointing to the same object.

// if we pass in an integer literal i, which is greater than
// IntegerCache.low and less than IntegerCache.high, then
// the method returns Integer objects from IntegerCache.
// Default value for IntegerCache.low and IntegerCache.high
// are -128 and 127 respectively.

// Integer a = 128; Integer b = 128; a == b => false

