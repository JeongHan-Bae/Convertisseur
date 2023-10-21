# Readme - English

[Lire en Français](README.fr.md)

## French Number Converter

This small Java software was created to assist foreigners in counting in French. Even if you are fluent in the French language, reading large numbers can be challenging, especially when numbers are written in Roman numerals instead of Arabic numerals.

This software provides two main functions for performing number conversions:
- Converting Arabic numbers (integers) into their French equivalents.
- Converting Roman numerals into Arabic numbers (integers).

## Usage

The program consists of two main classes:
- `Nums`: This class contains functions to convert integers into their French equivalents and to convert Roman numerals into integers.
- `Convertisseur`: This is the main class of the program, containing the `main` function.

## How to Run the Program

We provide a JAR file, `Convertisseur.jar`, to allow users with the Java environment to easily run the program.

To run the program from the JAR file, you can use the following command:

```shell
java -jar Convertisseur.jar
```

or you can double-clic the JAR file to run the program.

## Accepted Inputs

The program accepts two types of inputs:
- Uppercase Roman numerals (negative Roman numerals are not supported).
- Arabic numbers (integers), including negative numbers.

The input can contain spaces but should not contain periods or commas.

## Limits

- For Roman numerals, the program follows the conversion rules but does not check the validity of the Roman numeral writing. For example, if you enter "IIII" instead of "IV," the program will still read it as "Four." Pay attention to correct Roman numeral syntax.
- For Arabic numbers, the limit is the range of Java integers, from -2,147,483,648 to 2,147,483,647. Regarding Roman numerals, the supported range is from 0 to 3,999.

## License

This software is distributed under the [MIT Licence](LICENSE)
. You are free to use it in accordance with the terms of this license.

## Author

This software was developed by JeongHan-Bae.

## Contact

You can contact the author via email at: mastropseudo@gmail.com
