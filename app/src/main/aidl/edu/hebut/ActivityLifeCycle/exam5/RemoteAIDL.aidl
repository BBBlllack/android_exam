// RemoteAIDL.aidl
package edu.hebut.ActivityLifeCycle.exam5;

// Declare any non-default types here with import statements

interface RemoteAIDL {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}