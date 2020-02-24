Zadaním je vytvoriť jednoduchú aplikáciu, ktorá bude počítať poistné podľa zadaných parametrov:

     Label	                Nadobúda hodnoty	                        Povinný výber
    Variant poistenia       krátkodobé poistenie, celoročné poistenie           áno
    Začiatok poistenia                                                          áno
    Koniec poistenia                                                            áno pre krátkodobé poistenie
    Balík	                základný, rozšírený, extra                          áno
    Pripoistenia	        storno cesty, športové aktivity                     nie
    Počet osôb              1 až 3                                              áno

	                            Sadzby
	                krátkodobé poistenie	celoročné poistenie
    základný balík      1,2 € / deň                     39 €
    rozšírený balík     1,8 € / deň                     49 €
    extra balík         2,4 € / deň                     59 €
    storno cesty        50 % prirážka k sadzbe          20 % prirážka k sadzbe
    športové aktivity   30 % prirážka k sadzbe          10 % prirážka k sadzbe

Výstupom je Cena poistenia

Príklad
krátkodobé poistenie na tri kalendárne dni pre dve osoby, balík rozšírený s dojednanými športovými
aktivitami stojí 14,04 € (3 * 1,8 * 1,3 * 2)

Požiadavky na použité technológie a postupy BE:
-	Maven - pom.xml
-	Tomcat - idealne 8.5 a vyssie
-	DB - ideálne H2 DB for Java – ukladanie výpočtu + vybrané parametre (napr. Sadzby balíkov)
-	API - JSON komunikácia medzi FE – BE
-	Použitie application.properties – napr. Parametre prirážka k sadzbe
-	zadefinovanie java objektov pre API a pouzitie enumov (napr. Variant poistenia)
-	Mozne pouzit javu 8 pre datumy

Požiadavky na použité technológie a postupy FE:
-	JS framework – idealne Vue.js, je možné použiť aj iný poprípade čistý JS (ES6 výhodou)
-	HTML, CSS nie je dôležité, stačí jednoduchý layout formuláru
-	Nie je potrebné optimalizovať pre všetky prehliadače, stačí napr. Chrome


Vo výsledku očakávame:
-	Zdrojové kódy aplikácie BE a FE
-	Plusom je spustiteľné WAR-ko
