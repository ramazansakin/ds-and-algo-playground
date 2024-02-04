package com.rsakin.practise.playground;

import java.lang.ref.WeakReference;

public class WeakStrongReferences {

    public static void weakReferenceUsage() {
        // Create an object
        String myObject = new String("Hello, weak reference!");

        // Create a weak reference to the object
        WeakReference<String> weakReference = new WeakReference<>(myObject);

        // Dereference the strong reference
        myObject = null;

        // Access the object through the weak reference
        System.out.println("Object through weak reference: " + weakReference.get());

        // Trigger garbage collection to potentially reclaim the object
        System.gc();

        // Access the object through the weak reference after garbage collection
        System.out.println("Object through weak reference after GC: " + weakReference.get());
    }

    public static void strongreferenceUsage() {
        // Create a strong reference to the object
        String myObject = new String("Hello, strong reference!");

        String anotherRef = myObject;
        // Dereference the strong reference
        myObject = null;

        // Access the object through the strong reference (will still be accessible)
        System.out.println("Object through strong reference: " + anotherRef);

        // Trigger garbage collection (may not necessarily collect the object)
        System.gc();

        // Access the object through the strong reference after garbage collection
        System.out.println("Object through strong reference after GC: " + anotherRef);
    }

    public static void main(String[] args) {

//        weakReferenceUsage();
        strongreferenceUsage();

    }

}
