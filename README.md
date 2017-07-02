# Bottoms Up

Ceci est l'application java qui sert de support à la présentation Kotlin.
Il s'agit d'une petite API Rest qui tient le compte des consommations de 
bière de la tablée. (Oui au FinistJUG, les exemples tournent souvent autour 
de la bière)

## Explications

L'application propose 6 endpoints :

* /table donne la composition actuelle de la tablée.
* /beers donne la liste des bières disponibles.
* /invite permet d'inviter (ou renvoyer) un membre à table.
* /leader permet d'inviter un leader à table (ils boivent différemment).
* /bottomsup À la vôtre !
* /oneround un des convives paie une tournée.


Il y a un DAO, une classe business principale (BeerHandler), des beans 
simples et d'autres un peu plus riches qui implémentent de la logique 
fonctionnelle. Une suite de tests unitaires est également présente pour valider 
les 
modifications apportées au code.

Au cours de la présentation, nous modifierons cette application pour 
principalement en simplifier le code et réimplémenter différents design 
patterns en kotlin. Ces modifications sont visibles sur la 
branche "kotlin".
 
### Pré requis

le wrapper gradle inclus télechargera ce qu'il faut.

```
./gradlew build
```

## Déploiement

Le war devrait fonctionner avec n'importe quel serveur Java EE 7 qui supporte
 JAX-RS.

## Outils

* [Java EE](https://jcp.org/en/jsr/detail?id=342) - The web framework used
* [Gradle](https://gradle.org/) - Build Tool/Dependecy Management
* [Wildfly Swarm](https://wildfly-swarm.io) - Application server (optional)

## License

Ce projet est sous licence MIT - [LICENSE.txt](LICENSE.txt) pour plus de détails copiés-collés.

## Remerciements

* **Lovis Möller** - [lmller](https://github.com/lmller) pour le GoF Kotlin
* **Mario Fusco** - [mariofusco](https://github.com/mariofusco/from-gof-to-lambda) pour l'insipiration originale
* **Svetlana Isakova** - [SVTK](https://github.com/svtk) pour les Kotlins Koans
