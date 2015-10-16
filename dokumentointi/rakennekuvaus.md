#Yleinen toiminta

Ohjelma rakentaa ensin tyhjän kartan HashMapiin AreaBuilder luokassa, 
jonka jälkeen huoneiden tiedot asetetaan tyhjiin (Room) huoneisiin RoomDataReader luokan avustuksella, sekä lisätään niihin
 mahdolliset esineet sekä viholliset.
 
Tämän jälkeen pelaaja asetetaan valittuun aloitushuoneeseen ja annetaan sen viite InputReaderille sekä UserInterfacelle
(komentojen käsittelyä varten) ja graafinen käyttöliittymä käynnistetään.

Lopuksi käyttöliittymästä annetaan viitteet tarvittaviin komponentteihin niitä tarvitseville luokille.

Peliä pelatessa annetaan komento joko näppäimen tai komentokentän kautta, joka menee pelitilanteesta riippuen käsiteltäväksi 
InputReader tai CombatEvent luokkaan.

Pelin loppuessa pelaajan elämänpisteet lasketaan nollaan, jolloin uusia komentoja ei ole enää mahdollista käsitellä.

#Yksityiskohtaisemmat tiedot

##GameMain
Käsittelee pelin aloituksen

##InputReader
Käsittelee käyttäjän antamat yleiset komennot (ei taistelukomentoja)

##RoomDataReader
Käsittelee huoneiden tietojen lukemisen tekstitiedostoista

##AreaBuilder
Käsittelee pelin kartan rakentamisen

##Room
Sisältää huoneen ominaisuudet

##CombatEvent
Käsittelee taistelutilanteet ja siihen liittyvät komennot

#Player
Sisältää pelaajan ominaisuudet

#Inventory
Sisältää tavaraluettelon toiminnallisuuden

#UserInterface
Luo graafisen käyttöliittymän

#components-luokat
Sisältävät käyttöliittymän komponenttien ominaisuudet

#item-luokat
Sisältää tavaroiden ominaisuudet

#enemies-luokat
Sisältää vihollisten ominaisuudet
