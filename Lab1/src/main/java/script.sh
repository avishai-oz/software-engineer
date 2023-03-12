#!/usr/bin/bash

javac.exe org/example/ArithmeticApp.java

> output.txt

for i in {1..10}
do
    java.exe org.example.ArithmeticApp < Lab1-hw-inout/in$i.txt >> output.txt
done