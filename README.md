# SchoolGame
My attempt at creating a simple but scalable game engine, based off of code by @MagnusSilverdal and developed as a school-project for NTI Gymnasiet Umeå

### Inledning
Syftet med projektet var att utöka min kunskap gällande pixelgrafik i Java och bygga ett lättutökat system för utveckling av spel.

### Bakgrund
Grunden till projektet är en version av @MagnusSilverdals [InteractiveGraphicsTE18](https://github.com/MagnusSilverdal/InteractiveGraphicsTE18)-projekt med modifikationer för lättare abstraktion av spelobjekt. Det använder en BufferedImage baserad canvas och förändring av individuella pixlar för rendrering, motorn har inte support för alfakanaler. För input används eventlisteners som matar in i en statisk Input.java klass, detta kan senare användas för at enkelt hämta input.

### Positiva erfarenheter
Jag har lärt mig hur input bör göras för ett bra system, samt hur bildbaserade canvas-system kan användas som ett bibliotek för lättare hantering av ritfunktioner. Jag har även lärt mig ur specifika färger kan användas som alfa för att simulera en alfakanal.

### Negativa erfarenheter
Jag lyckades tyvärr inte färdigställa spelet under tidsramen, och har istället fokuserat på abstraktionen till en sådan nivå att jag helt enkelt inte haft tid att faktiskt göra något spel.

### Sammanfattning
Projektet har varit ett roligt sätt att lära mig grafik och bildhantering. Att kunna se problemet från flera riktningar och abstrahera projektet till ett system som går att expandera är viktigt och roligt att träna på. 
