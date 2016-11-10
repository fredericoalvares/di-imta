# Tutoriel : Injection de dépendances 


## Exemple : Messagerie twitter

![alt text](http://yuml.me/6e1b047d.svg)

```java
public void post(String msg){
   if (msg.length > 140){
       msg = shortener.shorten(msg);
   }

   if (msg.length <= 140){
       tweeter.send(msg);
   }
}
```

## Dépendances dans le constructeur
![alt text](http://yuml.me/3d7e40fe.svg)

* Implémentez les classes indiquées dans le diagramme
* Implémentez une classe de teste pour tester votre implémentation  
* Quels sont les inconvénients de l'approche par composition?

![alt text](http://yuml.me/25618f3f.svg)

* Changement d'implémentation -> un changement dans la classe dépendante 
* Manque de flexibilité 
* Par exemple : pas très pratique pour les testes ! 


## Dépendance via des fabriques statiques

![alt text](http://yuml.me/e6e738cd.svg)

* Implémentez les classes indiquées dans le diagramme
* Implémentez une classe de teste pour tester votre implémentation  
* Quels sont les avantages par rapport à l'approche par composition?
* Quels sont les inconvénients de cette approche?



![alt text](http://yuml.me/5f9d31b9.svg)

* On augmente le niveau d'abstraction mais le problème de dépendance reste le même.
* Testes. 


# Injection de dépendances

## "Don't call us, we call you!"

---

## Injection de dépendances par agrégation


<img src="http://yuml.me/afcafff9.svg" width="350px"/>

* Implémentez les classes indiquées dans le diagramme
* Implémentez une classe de teste pour tester votre implémentation  
* Quels sont les avantages par rapport aux approches précédentes?


# Injection de dépendances par agrégation + fabriques


<img src="http://yuml.me/b7bf6870.svg" width="400px"/>

* Implémentez les classes indiquées dans le diagramme
* Implémentez une classe de teste pour tester votre implémentation  
* Quels sont les avantages par rapport aux approches précédentes?
* Quels sont les inconvénients de cette approche?

# Coder les fabriques ? 

# Injection de dépendances avec Guice

<img src="http://yuml.me/456f0a36.svg" width="450px"/>

* `Module` : mapping interfaces -> classes implémentation
* `Injector` : joue le rôle d'une fabrique
 * Fournie par Guice 
 * .alert[on ne doit pas la coder/maintenir]  

# Injection de dépendances avec Guice

* Module
  
```java
import com.google.inject.AbstractModule;

public class TweetModule extends AbstractModule {
   @Override
   protected void configure() {
   	bind(Twitter.class).to(SmsTwitter.class);
   	bind(Shortener.class).to(TinyUrlShortener.class);
   }
}
```
--
* Injector

```java
Injector injector = Guice.createInjector(new TweetModule());
TweetClient client = injector.getInstance(TweetClient.class);
```

---

# Injection de dépendances avec Guice

* Classe dépendante   

```java
import com.google.inject.Inject;

public class TweetClient {
    ...		
	@Inject
	public TwitterClient(Shortener shortener, Tweet twitter) {
		this.shortener = shortener;
		this.twitter = twitter;
	}
    ...
}
```


# A retenir : injection de dépendances et Guice

* Les objets viennent à vous
  * Au lieu de `new` et `Factory`
  * *Inversion of control (IoC)*
* Architecture plus modulaire / Modules réutilisables
* Fabriques déjà implémentées par Guice 
* Moins de code inutile (factorisation)
