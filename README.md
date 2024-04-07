# DES Encryption Implementation in Java

This repository contains a Java implementation of the Data Encryption Standard (DES), a symmetric-key algorithm for the encryption of digital data. Although DES has been succeeded by more secure encryption methods, this implementation serves educational purposes, demonstrating the algorithm's inner workings.

## Overview

The DES algorithm is a block cipher that encrypts data in 64-bit blocks using a 56-bit key. This implementation provides a detailed example of the encryption process, including key scheduling, initial and final permutations, and the complex Feistel structure.

## Repository Contents

- `DES.java` - The main Java file that implements the DES encryption algorithm.
- `compile-run.sh` - A bash script to compile and run the `DES.java` file.

## Prerequisites

To run this project, you will need:
- Java Development Kit (JDK) - Version 8 or above.
- A Unix-like environment (Linux, macOS, or WSL on Windows) for executing the bash script.

## Usage

1. **Clone the Repository**

   Clone this repository to your local machine using git:
  ```git clone <repository-url>```
2. **Compile and Run**

Navigate to the repository directory and run the `compile-run.sh` script:
```
cd path/to/repository
chmod +x compile-run.sh
./compile-run.sh
```

The script will compile the `DES.java` file and, if successful, run the program to encrypt a predefined plaintext using a specified key.

## Implementation Details

The `DES.java` file contains the implementation of the DES encryption algorithm, including the initial permutation (IP), final permutation (IP-1), expansion permutation (E), permutation (P), and the substitution boxes (S-boxes).

The encryption process is demonstrated with a hardcoded plaintext and key, but these can be modified within the `main` method to experiment with different inputs.

## Contributing

Contributions are welcome! If you have suggestions for improvements or bug fixes, please feel free to open an issue or create a pull request.

## Disclaimer

This implementation is provided for educational purposes only. DES is considered to be insecure for many applications. It is recommended to use more secure encryption standards like AES for practical cryptographic needs.
