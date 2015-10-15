# TextAdventure

##HUOM!
**Klikkaa kerran tai kaksi pelin ison tekstialueen kohdalta/pohjalta ennen komentojen kirjoittamista, näin sen pitäisi päivittää alue rullaamaan automaattisesti uuden tekstin ilmestyessä (en tiedä miksi).**

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
1. [-] [-] [**H/L**] [-] [-] [-] [-]
2. [-] [-] [**V**] [**H**] [**L**] [-] [-]
3. [-] [-] [**H**] [-] [**H**] [-] [-]
4. [-] [-] [**H**] [**H**] [**H**] [**H**] [**H**]
5. [-] [-] [**H**] [-] [**V/L**] [-] [-]
6. [**L**] [**V**] [**H**] [**A**] [**H**] [-] [-]

jossa [H] = tyhjä huone, [A] = pelaajan aloituspaikka, [L] = huone jossa on loot:ia ja [V] = huone jossa on vihollinen.
Kartassa on myös yksi ovi, joka avautuu pohjois-etelä suunnassa kun "Key" esineen käyttää oikeassa kohdassa.

##Pelin loppuminen
Tekeillä...
