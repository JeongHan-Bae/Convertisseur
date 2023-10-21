# Readme - French (Français)

[Read in English](README.md)


## Convertisseur de Nombres en Français

Ce petit logiciel Java a été créé pour aider les étrangers à compter en français. Même si vous maîtrisez la langue française, la lecture des grands nombres peut être délicate, en particulier lorsque les nombres sont écrits en chiffres romains plutôt qu'en chiffres arabes.

Ce logiciel propose deux fonctions principales pour effectuer des conversions de chiffres :
- La conversion de chiffres arabes (entiers) en leur équivalent en français.
- La conversion de chiffres romains en chiffres arabes (entiers).

## Utilisation

Le programme est composé de deux classes principales :
- `Nums` : Cette classe contient des fonctions pour convertir des entiers en leur équivalent en français et pour convertir des chiffres romains en entiers.
- `Convertisseur` : Cette classe est la classe principale du programme, contenant la fonction `main`.

## Comment exécuter le programme

Nous fournissons un fichier JAR, `Convertisseur.jar`, pour permettre aux utilisateurs ayant l'environnement Java d'exécuter facilement le programme.

Pour lancer le programme depuis le fichier JAR, vous pouvez utiliser la commande suivante :

```shell
java -jar Convertisseur.jar
```

Double-cliquer le JAR peut aussi lancer le programme.

## Entrées acceptées

Le programme accepte deux types d'entrées :
- Chiffres romains en majuscules (les chiffres romains négatifs ne sont pas pris en charge).
- Chiffres arabes (entiers), y compris les nombres négatifs.

L'entrée peut contenir des espaces, mais ne doit pas contenir de points ni de virgules.

## Limites

- Pour les chiffres romains, le programme suit les règles de conversion, mais il ne vérifie pas la validité de l'écriture romaine. Par exemple, si vous saisissez "IIII" au lieu de "IV", le programme le lira toujours comme "Quatre". Soyez attentif à la syntaxe romaine correcte.
- Pour les chiffres arabes, la limite est celle des entiers Java, c'est-à-dire de -2 147 483 648 à 2 147 483 647. En ce qui concerne les chiffres romains, la plage prise en charge va de 0 à 3 999.

## Licence

Ce logiciel est distribué sous la [Licence MIT](LICENSE)
. Vous êtes libre de l'utiliser conformément aux termes de cette licence.

## Auteur

Ce logiciel a été développé par JeongHan-Bae.

## Contact

Vous pouvez contacter l'auteur par e-mail à l'adresse : mastropseudo@gmail.com

