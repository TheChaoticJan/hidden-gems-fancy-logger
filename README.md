# hidden-gems-fancy-logger
Dieser Logger ist für alle, die ihren Bot in Java schreiben, und möglicherweise ihre Output Logs ein wenig schöner gestalten wollen.

## Wie sieht er denn aus?
<img width="334" height="405" alt="image" src="https://github.com/user-attachments/assets/7e1ccd1d-4912-4637-aac5-1a0b4d74c13b" />

Dies ist ein Beispiel des Loggers mit meinen Log Outputs, diese könnt ihr natürlich beliebig anpassen!

## Struktur
Der Logger ist als ein einzelnes Objekt aufgebaut.

Er sammelt in jedem Tick alle Daten in sich ein, und kann diese dann am Ende (bevor ihr euren Move macht) einfach ausspucken.

Dabei achtet der Logger auf die Höhe der Map, und priorisiert "von oben nach unten", also Logs die weiter unten stehen werden unter Umständen gar nicht ausgegeben

## Verwendung
Um den Logger zu verwenden, könnt ihr entweder den Code der Klasse einfach in euren Code einfügen, oder den Logger als Bibliothek verwenden, so wie die bereits vorhandene json.jar Bibliothek (die .jar Datei ist in dem Release zu finden)

Ihr **müsst**, damit der Logger korrekt funktioniert, jeden Tick ein neues Logger Objekt initialisieren, welches genau 1 Argument benötigt, die Höhe der Map. Dadurch weiß der Logger "wie hoch" er sein kann.

<img width="295" height="34" alt="image" src="https://github.com/user-attachments/assets/faf492a7-0a05-46fd-a4d4-ed35841a761e" />

Ich empfehle dabei, den Logger als eine private static Variable für den Bot zu definieren, und jeden Tick neu zu initialisieren. Dann könnt ihr den Logger mithilfe eines Getters von überall aufrufen und logs hinzufügen.

### Mögliche Logs
Um einen Log hinzuzufügen müsst ihr nur die entsprechende Methode aufrufen, und als Argument den String angeben, den ihr loggen wollt.

Dabei gibt es die folgenden Methoden:
```java
Logger.addMapLog("Log");
Logger.addPathLog("Log");
Logger.addSignalLog("Log");
Logger.addGenericLog("Log");
```
Diese fügen der jewailigen Log-Kategorie (wie man sie oben im Bild sieht) einen String zum loggen hinzu. Die Emojis werden dabei automatisch hinzugefügt.

### Ausgeben der Logs
Zum ausgeben der Logs müsst ihr einfach, bevor ihr euren Move auswählt die Methode Logger.sendLog() aufrufen. Diese gibt automatisch alle bis dahin gesammelten Logs in die typische Log Konsole aus


## Erweiterung
Wenn ihr Vorschläge für den Logger habt, tragt diese gern zu mir, entweder als Issue, Pull request oder als Discord Nachricht.

Gerne könnt ihr den Logger auch für eure Programmiersprache umschreiben, dafür hatte ich nur einfach nicht die Zeit 

