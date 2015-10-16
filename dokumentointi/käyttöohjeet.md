# TextAdventure

##Pelaajan komennot

### Liikkuminen
Pelaajalle annetaan liikkumiskomentoja kirjoittamalla "go" + haluttu liikkumissuunta ja painamalla enteriä. Pelaaja voi liikkua vain pääilmansuuntiin, joten käytössä ovat komennot go east/go west/go south/go north.

###Loot
Pelaajalle annettava käsky "loot" etsii pelaajan kyseisestä olinpaikasta tavaran ja lisää sen tavaraluetteloon (jos huoneessa on tavara).

###Esineiden käyttäminen
Esineitä käytetään tavaraluettelosta komennolla "use " + esineen nimi. 

###Taistelu
Taistelussa pelaaja voi syöttää **vain** "attack" tai "defend" komentoja, kunnes vihollinen kuolee. "attack" vähentää vihollisen hp:ta onnistuessaan, "defend" kumoaa vihollisen hyökkäyksen ja palauttaa pelaajalle 5 hp:ta onnistuessaan (onnistumisen mahdollisuus on 30%).

##Pelin kartta
katso Map.png

##Pelin loppuminen
Peli loppuu jos pelaaja kuolee tai onnistuu pääsemään ulos luolasta.
