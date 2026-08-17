# Number Converter (Java)

A modular, console-based Java application that converts numbers into English words, digit-by-digit text representations, and Roman numerals (supporting standard and extended vinculum notation up to 3,999,999).

---

## Features

- **English Words Conversion:** Uses recursive decomposition to convert integers up to `999,999` into readable English strings (e.g., `12485` $\rightarrow$ `Twelve Thousand Four Hundred Eighty Five`).
- **Digit-by-Digit Parsing:** Converts numerical digits to words using string traversal and array lookups (e.g., `100` $\rightarrow$ `One Zero Zero`).
- **Extended Roman Numerals:** Converts numbers up to `3,999,999` using a greedy subtraction algorithm and Unicode combining macrons for values over 3,999 (e.g., `V̅` for 5,000).
- **Input Validation:** Protects against `InputMismatchException` and 32-bit integer overflows using Scanner buffer validation.

---

## Tech Stack

- **Language:** Java (JDK 17+)
- **Concepts:** Recursion, Greedy Algorithms, Array Lookups, Input Stream Validation

---

## How to Run

1. Clone the repository:
   ```bash git clone https://github.com/MayankGome99/Number_converter.git
