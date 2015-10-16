Ohjelman testaus suoritettiin aika pitkälti käsin, koska se tuntui luontevalta pelin testauksessa.

#Käsin testattua

Käsin ohjelmasta on testattu
- Pelaajan liikkumiskomennot (mahdollista jos liikuttavassa suunnassa on naapurihuone)
- Pelaajan taistelukomennot (*attack* ja *defend* toimivat)
- Esineiden etsintä (*loot* komento) (lisää esineen luetteloon jos se on huoneessa, muuten kertoo että huoneessa ei ole esinettä)
- Esineiden käyttäminen (toimivat oikein tietyissä tilanteissa)
- virheellisten komentojen syöttäminen (jos komento ei ole validi, se sivuutetaan. Taistelukomentoja ei voi käyttää ilman taistelun ulkopuolella ja muita komentoja ei voi käyttää taistelun aikana)

#Bugeista
Ainoa suurempi huomattu ongelma on tekstien näkyminen eri tavalla eri alustojen välillä. Ohjelma on kehitetty pääasiassa Windows 10:n sisältävällä koneella ja testauksessa Ubuntulla tekstien fontti oli eri kokoa, mikä muutti ohjelman ulkonäköä. Muuten ohjelma toimi kuten aiemminkin.
