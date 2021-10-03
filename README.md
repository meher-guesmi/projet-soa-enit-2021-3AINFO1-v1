# projet-soa-ecommerce-enit-v1


# Liste des microservices
- catalog: responsable des produits exposés et de leurs caractéristiques + prix de référence
- pricing: responsable de déterminer le prix d'un produit ou d'un panier entier
    - produit -> prix
    - panier-> prix unitaire de chaque produit + total
    - gère les promotions
        - % réduction sur un produit pendant une période
        - % réduction sur une catégorie de produits pendant une période
- inventory : responsable de 
    - la gestion des quantités de produits dans le stock
    - la réservation de produits d'une commande en attente de paiement.
    - la libération de commandes annulées
    - la préparation des commandes payées pour livraison.
- search : recherche d'un produit via texte libre
- cart : gestion du panier
- order : gère le processus de commande de la validation du panier, à la reservation, au paiement jusqu'au déclenchement de la livraison.
- shipping :  responsable de la livraison d'une commande confirmée (livraison en attente, livraison en cours, livraison effectuée)
- review : responsable des avis (texte ou note) sur les produits:
    - donner un avbis
    - donner une note
    - note moyenne d'un produit
- recommendation:
    - propose pour un utilisateur les produits similaires à ceux qu'il a bien noté (similaires textuellement).
- payment: responsable de l'exécution du processus de paiement d'une commande par un utilisateur auprès de la banque.
système externe
- bank : responsable des virements entre les comptes (compte débité et compte crédité).

# ports
vérifier les ports de chaque microservice
système externe
- bank : 8091
microservices
- cart : 8081
- catalog : 8082
- inventory : 8083
- order : 8084
- payment : 8085
- pricing : 8086
- recommendation: 8087
- review : 8088
- search : 8089
- shipping : 8090


# Technologies

- données transactionnelles : postgresql (utiliser un schéma différent par microservice)
- index externe pour le texte (solr)
- base de données en mémoire : postgresql en v1 et une bd en mémoire en v2

# Prérequis:
- java 11 ou plus.
- il faut avoir JAVA_HOME configurée
- maven récent avec MAVEN_HOME configurée
- installer docker (avec WSL sur windows)
- VS code avec les extensions java quarkus docker redhat gitlens
- démarrer dans le terminal (interne à vscode) en mode developpement avec la commande mvn clean compile quarkus:dev
- la configuration est dans le fichier application.properties
- par defaut l'application tourne sur localhost:8080 (l'interface qui s'affiche contient un lien vers dev-ui qui liste les extensions/modules installés
- dev-ui donne l'accès à swagger pour tester les APIs
- pour lancer l'infra sur docker click droit dans le fichier docker-compose et faire docker compose up

si besoin de voir la BD avec pgadmin faire:
- pg admin est configuré sur docker et se trouve sur le port 5050
- première utilisation de pgadmin il faut configurer un nouveau serveur avec les paramètres par defaut et dont l'adresse est db

pour voir d'autres exemples avec la doc alkler sur https://quarkus.io/guides/
