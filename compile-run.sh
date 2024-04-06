#!/bin/bash

javac DES.java

if [ $? -eq 0 ]; then
    echo "Compilation successful. Running program..."
    java DES
else
    echo "Compilation failed."
fi
