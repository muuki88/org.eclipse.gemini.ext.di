[![Build Status](https://travis-ci.org/muuki88/org.eclipse.gemini.ext.di.png?branch=master)](https://travis-ci.org/muuki88/org.eclipse.gemini.ext.di)

## Goal

Add the ability to inject EntityManagers for a certain
persistence unit in Eclipse 4.

## Getting Started

### Target platform - Repositories

First of all you have to get the [Gemini JPA](http://www.eclipse.org/gemini/jpa/) and [Gemini DBAccess](http://www.eclipse.org/gemini/dbaccess/) bundles to make this work. A sample target platform for Juno is available [here](https://github.com/muuki88/e4GeminiJPA/blob/master/de.mukis.gemini.sample.target/de.mukis.gemini.sample.target.target). 

The p2 repositories

* [Gemini JPA 1.1.0](http://download.eclipse.org/gemini/updates/jpa/1.1.0)
* [Gemini DBAccess 1.1.0](http://download.eclipse.org/gemini/updates/dbaccess/1.1.0)
* [Gemini Ext Di](http://p2.mukis.de/org.eclipse.gemini.ext.di/latest/)

### Inject it

You can directly inject an `EntityManager` via

```java
@Inject
@GeminiPersistenceContext(unitName="puTest")
EntityManager em;
```


or you can inject an `EntityManagerFactory` if you want to have more
control of your _EntityManagers_

```java
@Inject
@GeminiPersistenceUnit(unitName="puTest")
EntityManager em;
```

### Configuration

You can even configure your persistence units within the inject annotation.

```java
@Inject
@GeminiPersistenceContext(unitName="puTest", properties = {
 @GeminiPersistenceProperty(name=PersistenceUnitProperties.JDBC_DRIVER, value="org.gjt.mm.mysql.Driver"),
 @GeminiPersistenceProperty(name=PersistenceUnitProperties.JDBC_URL, value="jdbc:mysql://127.0.0.1/test"),
 @GeminiPersistenceProperty(name=PersistenceUnitProperties.JDBC_USER, value="test"),
 @GeminiPersistenceProperty(name=PersistenceUnitProperties.JDBC_PASSWORD, value="test"))
})
EntityManager em;
```

even with the `Preference` annotation. If you don't know them take a look [here](http://www.vogella.com/articles/Eclipse4Preferences/article.html)

```java
@Inject
@GeminiPersistenceContext(unitName = "unconfigured2", properties = {
  @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_DRIVER, valuePref = @Preference("jdbc_driver")),
  @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_URL, valuePref = @Preference("jdbc_url")) })
private EntityManager em;
```

## Sample application

A complete sample application can be found [here](https://github.com/muuki88/e4GeminiJPA).
It contains examples for

* Statically injected contexts
* Dynamically injected contextes
* Handling changing preferences with DAOs

## Note

This repository contains the work done by Filipp A. and Nepomuk Seiler.
See [Gemini Forum Post](http://www.eclipse.org/forums/index.php/t/290891/) 
for more information.

