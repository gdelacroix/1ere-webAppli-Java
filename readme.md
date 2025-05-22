# Développement Web Java avec VS Code

Ce guide explique comment configurer un environnement de développement web Java dans VS Code avec HTML, CSS et JavaScript, en utilisant Maven et Tomcat.

---

## ✅ Prérequis

- [VS Code](https://code.visualstudio.com/) avec l'extension **Extension Pack for Java**
- Java JDK installé (`java -version`)
- Apache Maven
- Apache Tomcat

---

## 🧰 Installation de Maven

1. Télécharger Maven : https://maven.apache.org/download.cgi  
2. Décompresser dans un dossier, par exemple `C:\dev\apache-maven-3.9.6`  
3. Définir les variables d’environnement :
   - `MAVEN_HOME = C:\dev\apache-maven-3.9.6`
   - Ajouter `%MAVEN_HOME%\bin` à la variable `Path`
4. Vérifier avec la commande :

```bash
mvn -v
```

## ⚙️ Installation de Tomcat

1. Télécharger Tomcat : https://tomcat.apache.org/download-10.cgi

2. Décompresser dans un dossier (ex: `C:\dev\tomcat`)

3. Pour démarrer Tomcat :

    - Windows : double-cliquer sur `startup.bat` dans `bin/`
    - macOS/Linux : `./startup.sh` dans `bin/`

## Structure du projet Maven Web
```bash
MyWebApp/
├── pom.xml
├── src/main/java/com/example/HelloServlet.java
├── src/main/webapp/index.html
├── src/main/webapp/WEB-INF/web.xml
```

## Exemple de `pom.xml`
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>MyWebApp</artifactId>
  <version>1.0</version>
  <packaging>war</packaging>
  <dependencies>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>
  <build>
    <finalName>MyWebApp</finalName>
  </build>
</project>
```

## 🧪 Exemple de Servlet (`HelloServlet.java`)
```java
package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h1>Hello from Java Servlet!</h1></body></html>");
  }
}
```

## 🌐 Exemple de page HTML (`index.html`)
```html
<!DOCTYPE html>
<html>
<head><title>Static Page</title></head>
<body>
  <h2>Page HTML statique</h2>
  <button onclick="alert('Salut depuis JavaScript !')">Clique moi</button>
</body>
</html>
```

## 🚀 Déploiement local
1. Compiler avec Maven :

```bash
mvn clean package
```
2. Copier le fichier `.war` depuis le dossier `target/` vers `webapps/` de Tomcat

3. Démarrer Tomcat

4. Visiter :

    - http://localhost:8080/MyWebApp/hello

    - http://localhost:8080/MyWebApp/index.html

## 🚀 Lancer l'application localement avec Maven + Jetty

### Étapes

1. Ouvrir un terminal dans le dossier racine du projet.
2. Lancer Jetty avec la commande suivante :

   ```bash
   mvn jetty:run
   ```
Une fois Jetty démarré, accéder à l'application dans votre navigateur à l'adresse suivante :

```arduino
http://localhost:8080/MyWebApp
```
Remplacez MyWebApp par le nom réel de votre projet s'il est différent.

## 🔧 Problèmes fréquents
Erreur NoClassDefFoundError: javax/servlet/http/HttpServlet
Vérifiez que la dépendance jakarta.servlet-api est bien ajoutée à votre pom.xml :

```xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>5.0.0</version>
    <scope>provided</scope>
</dependency>
```

## 📘 Licence
Ce projet est libre d'utilisation à des fins pédagogiques.