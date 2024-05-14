package com.rsakin.practise.playground;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakVsSoftReferences {

    public static void weakReferenceUsage() {
        // Create an object
        String myObject = new String("Hello, weak reference!");

        // Create a weak reference to the object
        WeakReference<String> weakReference = new WeakReference<>(myObject);

        // Dereference the strong reference to make it eligeable to collect by GC
        myObject = null;

        // Access the object through the weak reference
        System.out.println("Object through weak reference: " + weakReference.get());

        // Trigger garbage collector to potentially reclaim the object
        System.gc();

        // Access the object through the weak reference after garbage collection
        System.out.println("Object through weak reference after GC: " + weakReference.get());
    }

    public static void softReferenceUsage() {
        // Create a strong reference to the object
        String myObject = new String("Hello, soft reference!");

        SoftReference<String> softReference = new SoftReference<>(myObject);
        // Dereference the strong reference
        myObject = null;

        // Access the object through the strong reference (will still be accessible)
        System.out.println("Object through soft reference: " + softReference.get());

        // Trigger garbage collector to see what ll happen
        System.gc();

        // Access the object through the strong reference after garbage collection
        System.out.println("Object through soft reference after GC: " + softReference.get());
    }

    public static void main(String[] args) {

        weakReferenceUsage();
        System.out.println("-------------------------------------------");
        softReferenceUsage();

    }

}
