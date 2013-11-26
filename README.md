pb162-bonus
===========
![](http://www.kent.ac.uk/careers/pics/psychologist.gif)

##Informácie:

* vypracovanie posielať buď ako:
 * pull request k tomuto repozitáru
 * alebo ako exportované jarko odovzdané do odovzávarne s názvom bonus-projektik.
* projekt sa bude zameriavať na rozširovanie vedomostí o základnom Java API a jeho konrétnom využití
* použitie niektorých návrhových vzorov, pomenej algoritmizácií.
* ide o opensource projekt, tvorcami budú samotní žiaci predmetu PB162
* každý týždeň sem pribudne riešenie, ktoré bude pochádzať z najlepšieho študenstkého riešenia

##Popis projektu:

* Ide o jednoduchú implementáciu programu ELIZA, teda akéhosi psychoterapeuta.
* V budúcnosti jej bude možné podstrčiť možné odpovede na otázky. Vytvoríme tak rôzne inštancie ELIZI: napr arogatnú, znudenú, ...

##Ako pracovať s týmto repozitárom
* Kto ešte nerobil s Githubom, tak nech si skúsi prejsť základné info na home stránke github.com
* Odporúčam sa naučiť pracovať s pull request mechanizmom a gitom samotným, je to momentálne mainstream a určite príde vhod ako dobrá referencia pri pohovore.
* [Tu]("https://confluence.atlassian.com/display/STASH/Basic+Git+commands") možete nájsť pár git príkazov.
* Pull request odporúčam hlavne pretože Vám dokážem tak dať okamžitý a presnejší feedback k Vašemu kódu.
* Projekt môžete vypracovávať aj v BlueJ. Otvoríte ho pomocou menu: *Project --> Open Non Bjuej*

##Zadania jednotlivých úloh:

### 1.

* Poskytnite implementáciu pre rozhrania: ``AutomaticPsychiatrist.java``, ``TextAnalyzer.java``.
* Viacej info v ich JAVA docs.
* Hints: ``System.currentTimeMillis`` a metódy triedy ``String`` prídu vhod.

### 2.

* Upravte triedu ``AutomaticPsychiatristImpl.java`` tak aby v jednom behu programu existovala vždy len jedna inštancia tejto triedy.
 * Ide teda o aplikáciu desing patternu *Singleton*. Inšpirujte sa napríklad [týmto](http://www.javaworld.com/javaworld/jw-04-2003/jw-0425-designpatterns.html?page=1) zdrojom. Stačia strany 1-2, nemusíte uvažovať viac-vláknové aplikácie.
 * Aplikujte *lazy inicializáciu*, vašu jedinú inštanciu sprístupnite pomocou metódy ``getInstance``.
 * Skúste si nájsť informácie o využití tohto patternu: jednoducho všade tam kde chcem zabezpečiť existenciu len jednej inštancie - jedno fotbalové ihrisko, jedno databázové pripojenie etc.
 * Zaujímavá knižka o návrhových vzoroch, príklady sú v Jave: [Head First Design Patterns](http://www.amazon.com/First-Design-Patterns-Elisabeth-Freeman/dp/0596007124).

* Predávanie parametrov programu
 * **Prví** spôsob ktorý využijete, je získavanie *System properties*. Upravte metódu ``AutomaticPsychiatristImpl#thinkSomeTime``, tak aby čas ktorý má metóda čakať získala zo systémovej premennej ``thinkingTimeoutInMilliseconds``. Hints: ``System.getProperty()``. 
   * Pre zaújimavosť si pozrite tiež ``System.getEnv()``, rozdiel medzi systémovou a premennou prostredia je pekne vysvetlený [tu]("http://stackoverflow.com/a/13112065") (platformová nezávyslosť).
   * Vytvorte checked exception: ``AutomaticPsychiatristException`` v balíku ``cz.fi.muni.exception``.
   * Tieto premenné sa predávajú ako ``String``, budete musiet preto túto hodnotu sparsovať na ``Long``. Pri akejkoľvek chybe, vyhodte ``AutomaticPsychiatristException``.
 
* **Druhý** spôsob bude parsovanie parametrov predaných metóde ``main``.
   * Naimplementujte metódu ``introduceMyself``.
   * Vytvorte spustiteľnú triedu ``Main`` v balíku ``cz.fi.muni``.
   * jej metóda ``main`` vykoná nasledovné: 
   1. Sparsuje predané parametre. Trieda je spúštaná práve s jedným parametrom. V tomto parametri je zadané meno psychiatra. Pokiaľ nie je predaný žiaden parameter, program končí s výnimkou, ktorá bude popisovať prečo program končí a informáciu o správnom spúštaní programu.
   2. Získa inštanciu ``AutomaticPsychiatrist`` (už je singleton).
   3. Predstaví psychiatra volaním ``introduceMyself``.
   4. Nechá zamyslieť psychiatra. Pokiaľ by malo myslenie končiť výnimkou tak na štandarný *chybový výstup* je vypísaný reťazec: "I am sick and tired. Come later!", zároveň však program skončí s výnimkou, ktorá popíše chybový stav.
* Vo výsledku by ste mali byť schopný spustiť program z command line napr ako: ``java -DthinkingTimeoutInMilliseconds=4000 Main "Sirius"``
* keďže sa používané triedy nachádzajú v iných balíkoch ako metóda ``main``, bude potrebné uviesť k nim cestu pomocou prepínača *-cp*.
