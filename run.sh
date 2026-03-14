#!/usr/bin/env bash
set -e

# Compile all Java files
javac -d bin $(find src -name "*.java")

# Run Main
java -cp bin com.sabih.Main
