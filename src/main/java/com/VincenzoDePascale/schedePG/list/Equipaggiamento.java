package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Equipaggiamento {
	
	//NOME("nome", TipiEquip.BASE, "descrizione nome", 0, Moneta.ZZ, 0),

	//BASE
    ABACO("abaco", TipiEquip.BASE, "descrizione abaco", 2, Moneta.MO, 1),
    ABITO_CF("abito, clima freddo", TipiEquip.BASE, "descrizione abito, clima freddo", 10, Moneta.MO, 2.2),
    ABITO_CM("abito, comune", TipiEquip.BASE, "descrizione abito ,comune", 5, Moneta.MA, 1.5),
    ABITO_CS("abito, costume", TipiEquip.BASE, "descrizione abito, costume", 5, Moneta.MO, 2),
    ABITO_DV("abito, da viaggio", TipiEquip.BASE, "descrizione ", 2, Moneta.MO, 1.0),
    ABITO_PR("abito, pregiato", TipiEquip.BASE, "descrizione abito, da viaggio", 15, Moneta.MO, 1.0),
	ACCIARINO_E_PIETRA_FOCAIA("acciarino e pietra focaia", TipiEquip.BASE, "Un piccolo contenitore usato per accendere il fuoco, che contiene acciarino, pietra focaia e materiale combustibile (solitamente stracci essiccati e bagnati d'olio). Per accendere una torcia (o qualsiasi altra cosa che faccia uso di abbondante combustibile scoperto) usando acciarino e pietra focaia è richiesta un'azione. Per accendere un fuoco di qualsiasi altro tipo è richiesto 1 minuto.", 5, Moneta.MA, 0.5),
	ACIDO("acido (fiala)", TipiEquip.BASE, "Con un'azione, il personaggio può spruzzare il contenuto di questa fiala su una creatura situata entro 1,5 metri da lui o lanciarla fino a 6 metri di distanza (la fiala si frantumerà all'impatto). In ogni caso, il personaggio effettua un attacco a distanza contro una creatura o un oggetto, considerando l'acido come un'arma improvvisata. Se la fiala d'acido colpisce il bersaglio, quest'ultimo subisce 2d6 danni da acido.", 25, Moneta.MO, 0.5),
	ACQUA_SANTA("acqua santa (ampolla)",TipiEquip.BASE, "Con un'azione, il personaggio può spruzzare il contenuto di questa ampolla su una creatura situata entro 1,5 metri da lui o lanciarla fino a 6 metri di distanza (l'ampolla si frantumerà all'impatto). In ogni caso, il personaggio effettua un attacco a distanza contro la creatura bersaglio, considerando l'acqua santa come un'arma improvvisata. Se il bersaglio è un immondo o un non morto, subisce 2d6 danni radiosi. Un chierico o un paladino può creare l'acqua santa celebrando un rituale speciale. Per celebrare questo rituale è richiesta 1 ora di tempo e polvere d'argento per un valore di 25 mo; l'incantatore deve inoltre spendere uno slot incantesimo di 1° livello.", 25, Moneta.MO, 0.5),
	AMPOLLA("ampolla",TipiEquip.BASE, "capienza: 0,5 litri liquidi", 2, Moneta.MR, 0.5),
	BOCCALE("boccale",TipiEquip.BASE, "descrizione boccale", 2, Moneta.MR, 0.5),
	ANELLO_CON_SIGILLO("anello con sigillo",TipiEquip.BASE, "descrizione anello con sigillo", 2, Moneta.MO, 0),
	ANTITOSSINA("antitossina (fiala)", TipiEquip.BASE, "Una creatura che beve questa fiala di liquido dispone di vantaggio ai tiri salvezza contro veleno per 1 ora. Non conferisce alcun beneficio ai costrutti o ai non morti.", 50, Moneta.MO, 0),
	ARIETE_PORTATILE("ariete portatile",TipiEquip.BASE, "Un ariete portatile può essere usato per sfondare le porte e conferisce un bonus di +4 alla prova di Forza del personaggio. Un altro personaggio può aiutare il primo a usare l'ariete, nel qual caso il primo personaggio dispone di vantaggio a questa prova.", 4, Moneta.MO, 17.5),
	ASTA("asta (3 metri)",TipiEquip.BASE, "descrizione asta (3 metri)", 5, Moneta.MR, 3.5),
	ATTREZZI_DA_SCASSINATORE("attrezzi da scassinatore",TipiEquip.BASE, "Gli attrezzi da scalatore includono dei chiodi da rocciatore speciali, punte per stivali, quanti e un'imbragatura. Un personaggio può usare gli attrezzi da scalatore con un'azione per ancorarsi; quando lo fa, non può cadere per più di 7,5 metri dal punti in cui si è ancorato e non può arrampicarsi per più di 7,5 metri da quel punto senza disfare l'ancora.", 25, Moneta.MO, 6),
	BARILE("barile",TipiEquip.BASE, "capienza: 160 litri liquidi, 4 cubi con spigolo di 30 cm", 2, Moneta.MO, 35),
	BILANCIA_DA_MERCANTE("bilancia da mercante",TipiEquip.BASE, "Una bilancia è composta da un piccolo braccio, due piatti e un assortimento di pesi di varie misure fino a un massimo di 1 kg. Grazie a questa bilancia, un personaggio può misurare il peso esatto degli oggetti più piccoli, come per esempio i metalli preziosi allo stato grezzo o le merci, per determinare il valore esatto.", 5, Moneta.MO, 1.5),
	BORSA("borsa",TipiEquip.BASE, " Una borsa di stoffa o di cuoio può contenere fino a 20 proiettili da fionda o 50 aghi da cerbottana, tra le altre cose, Una borsa suddivisa in scomparti per contenere le componenti per incantesimi è chiamata una borsa per componenti (descritta di seguito). Capienza: 1 cubo con spigolo di 3 cm/3 kg di equipaggiamento", 5, Moneta.MA, 0.5),
	BORSA_DEL_GUARITORE("borsa del guaritore",TipiEquip.BASE, "Questa borsa in pelle contiene bende, unguenti e stecche di legno. Prevede dieci utilizzi. Con un'azione, un personaggio può spendere un utilizzo per stabilizzare una creatura scesa a 0 punti ferita senza dover effettuare una prova di Saggezza (Medicina).", 5, Moneta.MO, 1.5),
	BORSA_PER_COMPONENTI("borsa per componenti",TipiEquip.BASE, "Una borsa per componenti è una piccola borsa di cuoio impermeabile da legare alla cintura, dotata di scomparti dove custodire tutte le componenti materiali e gli altri oggetti speciali di cui il personaggio ha bisogno per lanciare incantesimi, fatta eccezione per quelle componenti che prevedono un costo specifico (come indicato nella descrizione dell'incantesimo).", 25, Moneta.MO, 1),
	BOTTIGLIA_DI_VETRO("bottiglia di vetro",TipiEquip.BASE, "capienza: 0,75 litri liquidi", 2, Moneta.MO, 1),
	BROCCA("brocca",TipiEquip.BASE, "capienza: 4 litri liquidi", 2, Moneta.MR, 2),
	CARAFFA("caraffa",TipiEquip.BASE, "capienza: 4 litri liquidi", 2, Moneta.MR, 2),
	CAMPANELLA("campanella",TipiEquip.BASE, "descrizione campanella", 1, Moneta.MO, 0),
	CANDELA("candela",TipiEquip.BASE, "Per 1 ora, una candela proietta luce intensa entro un raggio di 1,5 metri e luce fioca per altri 1,5 metri.", 1, Moneta.MR, 0),
	CANESTRO("canestro",TipiEquip.BASE, "capienza: 2 cubi con spigolo di 30 cm/20 kg di equipaggiamento", 4, Moneta.MR, 1),
	CANNA_DA_PESCA("canna da pesca",TipiEquip.BASE, "Questo oggetto include un'asta di legno, un filo di seta, un galleggiante di sughero, ami in acciaio, mosche da usare come esche e una reticella.", 1, Moneta.MO, 2),
	CANNOCCHIALE("cannocchiale",TipiEquip.BASE, "Gli oggetti osservati attraverso un cannocchiale appaiono grandi il doppio della loro taglia.", 1000, Moneta.MO, 0.5),
	CARRUCOLA_E_PARANCO("carrucola e paranco",TipiEquip.BASE, "Questa serie di carrucole è dotata di un cavo che le attraversa e che si collega a un uncino da agganciare a un oggetto. Consente a un personaggio di sollevare fino al quadruplo del peso che normalmente potrebbe sollevare.", 1, Moneta.MO, 2.5),
	CARTA("carta (un foglio)",TipiEquip.BASE, "descrizione carta (un foglio)", 2, Moneta.MA, 0),
	CASSETTA_PER_LE_OFFERTE("cassetta per le offerte", TipiEquip.BASE, "descrizione cassetta per le offerte", 0, Moneta.ZZ, 0),
	CATENA("catena (3 metri)",TipiEquip.BASE, "Una catena ha 10 punti ferita. Può essere spezzata superando una prova di Forza con CD 20. Lunghezza: 3 metri", 5, Moneta.MO, 5),
	CERA_PER_SIGILLO("cera per sigillo", TipiEquip.BASE, "descrizione cera per sigillo", 0, Moneta.ZZ, 0),
	CHIODO_DA_ROCCIATORE("chiodo da rocciatore",TipiEquip.BASE, "descrizione chiodo da rocciatore", 5, Moneta.MR, 0.125),
	CLESSIDRA("clessidra",TipiEquip.BASE, "descrizione clessidra", 25, Moneta.MO, 0.5),
	COLTELLINO("coltellino", TipiEquip.BASE, "descrizione coltellino", 0, Moneta.ZZ, 0),
	COPERTA("coperta",TipiEquip.BASE, "descrizione coperta", 5, Moneta.MA, 1.5),
	CORDA_DI_CANAPA("corda di canapa (15 metri)",TipiEquip.BASE, "Una corda, che sia di canapa o di seta, possiede 2 punti ferita e può essere spezzata superando una prova di Forza con CD 17. Lunghezza: 15 metri", 1, Moneta.MO, 5),
	CORDA_DI_SETA("corda di seta (15 metri)",TipiEquip.BASE, "Una corda, che sia di canapa o di seta, possiede 2 punti ferita e può essere spezzata superando una prova di Forza con CD 17. Lunghezza: 15 metri", 10, Moneta.MO, 2.5),
	COTE_PER_AFFILARE("cote per affilare",TipiEquip.BASE, "descrizione cote per affilare", 1, Moneta.MR, 0.5),
	CUSTODIA_PER_MAPPE_O_PERGAMENE("custodia per mappe o pergamene",TipiEquip.BASE, "Questa custodia cilindrica in cuoio può contenere fino a dieci fogli di carta arrotolati o fino a cinque fogli di pergamena arrotolati.", 1, Moneta.MO, 0.5),
	CUSTODIA_PER_QUADRELLI("custodia per quadrelli da balestra",TipiEquip.BASE, "Questa custodia di legno può contenere fino a 20 quadrelli da balestra.", 1, Moneta.MO, 0.5),
	FARETRA("faretra",TipiEquip.BASE, "Una faretra può contenere fino a 20 frecce.", 1, Moneta.MO, 0.5),
	FIALA("fiala (vuota)",TipiEquip.BASE, "capienza: 120 grammi liquidi", 1, Moneta.MO, 0),
	FISCHIETTO_DA_RICHIAMO("fischietto da richiamo",TipiEquip.BASE, "descrizione fischietto da richiamo", 5, Moneta.MR, 0),
	FORZIERE("forziere",TipiEquip.BASE, "capienza: 12 cubi con spigolo di 30 cm/150 kg di equipaggiamento", 5, Moneta.MO, 12.5),
	FUOCO_DELL_ALCHIMISTA("fuoco dell'alchimista (ampolla)",TipiEquip.BASE, "Questo fluido adesivo e gommoso si infiamma quando è esposto all'aria. Con un'azione, il personaggio può lanciare questa ampolla fino 6 metri di distanza (l'ampolla si frantumerà all'impatto). Il personaggio effettua un attacco a distanza contro una creatura o un oggetto, considerando il fuoco dell'alchimista come arma improvvisata. Se colpisce il bersaglio, esso subisce 1d4 danni da fuoco all'inizio di ogni suo turno. Una creatura può terminare questi danni usando un'azione per effettuare una prova di Destrezza con CD 10 al fine di estinguere le fiamme.", 50, Moneta.MO, 0.5),
	GAVETTA("gavetta",TipiEquip.BASE, "Questa scatola di stagno contiene una scodella e delle semplici posate. Le due metà della scatola, una volta aperte, possono essere usate come padella e come piatto o scodella.", 2, Moneta.MA, 0.5),
	GESSETTO("gessetto (1 pezzo)",TipiEquip.BASE, "descrizione gessetto (1 pezzo)", 1, Moneta.MR, 0),
	GIACIGLIO("giaciglio",TipiEquip.BASE, "descrizione giaciglio", 1, Moneta.MO, 3.5),
	INCENSO("incenso",TipiEquip.BASE, "descrizione incenso", 0, Moneta.ZZ, 0),
	INCENSIERE("incensiere",TipiEquip.BASE, "descrizione incensiere", 0, Moneta.ZZ, 0),
	INCHIOSTRO("inchiostro (boccetta da 30 grammi)",TipiEquip.BASE, "descrizione inchiostro (boccetta da 30 grammi)", 10, Moneta.MO, 0),
	LAMPADA("lampada",TipiEquip.BASE, "Una lampada proietta luce intensa in un raggio di 4,5 metri e luce fioca per ulteriori 9 metri. Una volta accesa, arde per 6 ore consumando 1 ampolla (0,5 litri) di olio.", 5, Moneta.MA, 0.5),
	LANTERNA_A_LENTE_SPORGENTE("lanterna a lente sporgente",TipiEquip.BASE, "Una lanterna a lente sporgente proietta luce intensa in un cono di 18 metri e luce fioca per ulteriori 18 metri. Una volta accesa, arde per 6 ore consumando 1 ampolla (0,5 litri) di olio.", 10, Moneta.MO, 1),
	LANTERNA_SCHERMABILE("lanterna schermabile",TipiEquip.BASE, "Una lanterna schermabile proietta luce intensa in un raggio di 9 metri e luce fioca per ulteriori 9 metri. Una volta accesa, arde per 6 ore consumando 1 ampolla (0,5 litri) di olio. Con un'azione, un personaggio può abbassare il cappuccio della lanterna, riducendo la luce proiettata a luce fioca in un raggio di 1,5 metri.", 5, Moneta.MO, 1),
	LENTE_INGRANDIMENTO("lente d'ingrandimento",TipiEquip.BASE, "Questa lente consente di esaminare più da vicino gli oggetti più piccoli. Può anche tornare utile come alternativa alla pietra focaia e all'acciarino per accendere un fuoco. Per accendere un fuoco con una lente d'ingrandimento è necessaria una luce da concentrare intensa quando la luce del sole, dei rametti da accendere e circa 5 minuti affinché il fuoco attecchisca. Una lente d'ingrandimento conferisce vantaggio a ogni prova di caratteristica effettuata per valutare o ispezionare un oggetto di piccola taglia o estremamente dettagliato.", 100, Moneta.MO, 0),
	LIBRO("libro",TipiEquip.BASE, "Un libro può contenere poesie, resoconti storici, informazioni in un campo specifico di conoscenze, diagrammi e appunti su un marchingegno gnomesco o pressoché ogni informazione che sia possibile trasmettere tramite testi e immagini. Se contiene incantesimi, si tratta di un libro degli incantesimi (descritto di seguito).", 25, Moneta.MO, 2.5),
	LIBRO_DEGLI_INCANTESIMI("libro degli incantesimi",TipiEquip.BASE, "Un libro degli incantesimi, essenziale per i maghi, è un tomo rilegato in cuoio e composto da 100 pagine pergamenate vuote su cui annotare gli incantesimi.", 50, Moneta.MO, 1.5),
	MANETTE("manette",TipiEquip.BASE, "Queste costrizioni di metallo possono bloccare una creatura di taglia Media o Piccola. Per sfuggire alle manette è necessario superare una prova di Destrezza con CD 20. A ogni coppia di manette è abbinata una chiave. Senza la chiave, una creatura competente negli arnesi da scasso può scassinare la serratura superando una prova di Destrezza con CD 15. Le manette hanno 15 punti ferita.", 2, Moneta.MO, 3),
	MARTELLO("martello",TipiEquip.BASE, "descrizione martello", 1, Moneta.MO, 1.5),
	MARTELLO_DA_DEMOLIZIONE("martello da demolizione",TipiEquip.BASE, "descrizione martello da demolizione", 2, Moneta.MO, 5),
	OLIO("olio (ampolla)",TipiEquip.BASE, "L'olio solitamente viene venduto in ampolle di argilla da 0,5 litri. Con un'azione, il personaggio può spruzzare l'olio dell'ampolla su una creatura situata entro 1,5 metri da lui o lanciarla fino a 6 metri di distanza (l'ampolla si frantumerà all'impatto). Il personaggio effettua un attacco a distanza contro una creatura o un oggetto, considerando l'olio come un'arma improvvisata. Se colpisce il bersaglio, lo ricopre di olio. Se il bersaglio subisce danni da fuoco prima che l'olio si asciughi (dopo 1 minuto), esso subisce 5 danni da fuoco aggiuntivi a causa dell'olio incendiato. Un personaggio può anche versare un'ampolla di olio sul terreno per coprire un'area quadrata con lato di 1,5 metri, purché la superficie sia piana. Una volta incendiato, l'olio brucia per 2 round e infligge 5 danni da fuoco a qualsiasi creatura che entri nell'area o vi termini il proprio turno. Una creatura può subire questi danni solo una volta per turno.", 1, Moneta.MA, 0.5),
	OTRE("otre",TipiEquip.BASE, "capienza: 2 litri liquidi", 2, Moneta.MA, 3.5),
	PENNINO("pennino",TipiEquip.BASE, "descrizione pennino", 2, Moneta.MR, 0),
	PERGAMENA("pergamena (un foglio)",TipiEquip.BASE, "descrizione pergamena (un foglio)", 1, Moneta.MA, 0),
	PICCONE_DA_MINATORE("piccopne da minatore",TipiEquip.BASE, "descrizione piccopne da minatore", 2, Moneta.MO, 5),
	PIEDE_DI_PORCO("piede di porco",TipiEquip.BASE, "L'utilizzo di un piede di porco conferisce vantaggio alle prove di Forza in cui è possibile usare il piede di porco per fare leva.", 2, Moneta.MO, 2.5),
	POZIONE_DI_GUARIGIONE("pozione di guarigione",TipiEquip.POZIONE, "Quando un personaggio beve il fluido magico rosso contenuto in questa fiala recupera 2d4 + 2 punti ferita. Per bere o somministrare una pozione è richiesta un'azione.", 50, Moneta.MO, 0.25),
	PROFUMO("profumo (fiala)",TipiEquip.BASE, "descrizione profumo (fiala)", 5, Moneta.MO, 0),
	RAMPONE("rampone",TipiEquip.BASE, "Un rampone è una piastra di metallo con punte che è legata alla suola di uno stivale. Una creatura che indossa i ramponi non può cadere prona mentre si muove sul ghiaccio scivoloso.", 2, Moneta.MO, 2),
	RAZIONE("razione",TipiEquip.BASE, "Le razioni consistono in cibo essiccato adatto a essere trasportato nei lunghi viaggi: carne secca, frutta secca, gallette e noci.", 5, Moneta.MA, 1),
	SACCHETTO_DI_SABBIA("sacchetto di sabbia", TipiEquip.BASE, "descrizione sacchetto di sabbia", 0, Moneta.ZZ, 0),
	SACCO("sacco",TipiEquip.BASE, "capienza: 1 cubo con spigolo di 30 cm/15 kg di equipaggiamento", 1, Moneta.MR, 0.25),
	SAPONE("sapone",TipiEquip.BASE, "descrizione sapone", 2, Moneta.MR, 0),
	SCALA_A_PIOLI("scala a pioli (3 metri)",TipiEquip.BASE, "descrizione scala a pioli (3 metri)", 1, Moneta.MA, 12.5),
	SECCHIO("secchio",TipiEquip.BASE, "capienza: 12 litri liquidi, 1 cubo con spigolo di 15 cm", 5, Moneta.MR, 1),
	SERRATURA("serratura",TipiEquip.BASE, "Assieme alla serratura viene fornita una chiave. Senza la chiave, una creatura competente negli arnesi da scasso può scassinare la serratura superando una prova di Destrezza con CD 15. Il DM può permettere che siano disponibili serrature migliori a prezzi più alti.", 10, Moneta.MO, 0.5),
	SFERE_METALLICHE("sfere metalliche",TipiEquip.BASE, "Con un'azione, un personaggio può versare queste minuscole sfere di metallo fuori dal sacchetto per coprire un'area quadrata regolare e pianeggiante con lato di 3 metri. Quando una creatura si muove attraverso l'area coperta dalle sfere, deve superare un tiro salvezza su Destrezza con CD 10, altrimenti cade a terra prona. Se una creatura si muove attraverso l'area a velocità dimezzata, non deve effettuare il tiro salvezza.", 1, Moneta.MO, 1),
	SPECCHIO_PICCOLO_DI_METALLO("specchio piccolo di metallo",TipiEquip.BASE, "descrizione specchio piccolo di metallo", 5, Moneta.MO, 0.25),
	SPUNTONI("spuntoni, ferro 10",TipiEquip.BASE, "descrizione spuntoni, ferro 10", 1, Moneta.MO, 2.5),
	TAGLIOLA("tagliola",TipiEquip.BASE, "Quando il personaggio usa la sua azione per predisporre questa trappola, colloca a terra un cerchio di metallo dentato che si chiude con uno scatto quando una creatura preme una leva d'aggancio situata al centro. La trappola viene fissata a una pesante catena o a un oggetto immobile come un albero o un palo piantato a terra. Quando una creatura mette un piede sulla leva, deve superare un tiro salvezza su Destrezza con CD 13, altrimenti subisce 1d4 danni perforanti e smette di muoversi. Da allora in poi, finché la creatura non si libera dalla trappola, il suo movimento è limitato dalla lunghezza della catena (solitamente 90 cm). Una creatura può usare la sua azione per effettuare una prova di Forza con CD 13 per liberare sé stessa o un'altra creatura entro portata in caso di successo. Ogni prova fallita infligge 1 danno perforante alla creatura intrappolata.", 5, Moneta.MO, 12.5),
	TENDA("tenda per due persone",TipiEquip.BASE, "Un semplice riparo portatile in tela, che può ospitare due persone.", 2, Moneta.MO, 10),
	TORCIA("torcia",TipiEquip.BASE, "Una torcia arde per 1 ora e proietta luce intensa in un raggio di 6 metri e luce fioca per ulteriori 6 metri. Se un personaggio effettua un attacco in mischia con una torcia accesa e colpisce, infligge 1 danno da fuoco.", 1, Moneta.MR, 0.5),
	TRIBOLI("triboli (sacchetto da 20)",TipiEquip.BASE, "Con un'azione, un personaggio può spargere il contenuto di un sacchetto di triboli per coprire un'area quadrata con lato di 1,5 metri. Ogni creatura che entra in quell'area deve superare un tiro salvezza su Destrezza con CD 15, altrimenti dovrà smettere di muoversi per questo turno e subire 1 danno perforante. Se subisce questo danno, la sua velocità base sul terreno è ridotta di 3 metri finché non recupera almeno 1 punto ferita. Se una creatura si muove attraverso l'area a velocità dimezzata, non deve effettuare il tiro salvezza. Quantità: 20.", 1, Moneta.MO, 1),
	VANGA("vanga",TipiEquip.BASE, "descrizione vanga", 2, Moneta.MO, 2.5),
	BADILE("badile",TipiEquip.BASE, "descrizione badile", 2, Moneta.MO, 2.5),
	VASO_DI_FERRO("vaso di ferro",TipiEquip.BASE, "capienza: 4 litri liquidi", 2, Moneta.MO, 5),
	VELENO("veleno di base",TipiEquip.BASE, "Un personaggio può usare il veleno contenuto in questa fiala per rivestire un'arma tagliente o perforante o un massimo di tre munizioni. Per applicare il veleno è richiesta un'azione. Una creatura colpita dall'arma o dalle munizioni avvelenate deve superare un tiro salvezza su Costituzione con CD 10, altrimenti subirà 1d4 danni da veleno. Una volta applicato, il veleno mantiene la sua potenza per 1 minuto prima di essiccarsi.", 100, Moneta.MO, 0),
	VESTE("veste",TipiEquip.BASE, "descrizione veste", 1, Moneta.MO, 2),
	ZAINO("zaino",TipiEquip.BASE, "capienza: 1 cubo con spigolo di 30 cm/15 kg di equipaggiamento; un personaggio può anche legare alcuni oggetti come un giaciglio o un rotolo di corda all'esterno dello zaino.", 2, Moneta.MO, 2.5),
	ZAINO_DA_SPELEOLOGO("zaino da speleologo",TipiEquip.BASE, "descrizione zaino da speleologo", 0, Moneta.ZZ, 2.5),
	ZAINO_DA_ESPLORATORE("zaino da esploratore",TipiEquip.BASE, "descrizione zaino da esploratore", 2, Moneta.ZZ, 2.5),
	ZAINO_DA_SACERDOTE("zaino da sacerdote",TipiEquip.BASE, "descrizione zaino da sacerdote", 2, Moneta.ZZ, 2.5),
	
	//focus arcano
	BACCHETTA("bacchetta",TipiEquip.FOCUS_ARCANO, "descrizione bacchetta", 10, Moneta.MO, 0.5),
	BASTONE("bastone",TipiEquip.FOCUS_ARCANO, "descrizione bastone", 5, Moneta.MO, 2),
	CRISTALLO("cristallo",TipiEquip.FOCUS_ARCANO, "descrizione cristallo", 10, Moneta.MO, 0.5),
	GLOBO("globo",TipiEquip.FOCUS_ARCANO, "descrizione globo", 20, Moneta.MO, 1.5),
	VERGA("verga",TipiEquip.FOCUS_ARCANO, "descrizione verga", 10, Moneta.MO, 1),
	
	//focus druidico
	BACCHETTA_IN_LEGNO_DI_TASSO("bacchetta in legno di tasso",TipiEquip.FOCUS_DRUIDICO, "descrizione bacchetta in legno di tasso", 10, Moneta.MO, 0.5),
	BASTONE_DI_LEGNO("bastone di legno",TipiEquip.FOCUS_DRUIDICO, "descrizione bastone di legno", 5, Moneta.MO, 2),
	RAMETTO_DI_VISCHIO("rametto di vischio",TipiEquip.FOCUS_DRUIDICO, "descrizione rametto di vischio", 1, Moneta.MO, 0),
	TOTEM("totem",TipiEquip.FOCUS_DRUIDICO, "descrizione totem", 1, Moneta.MO, 0),
	
	//simboli sacri
	AMULETO("amuleto",TipiEquip.SIMBOLO_SACRO, "descrizione amuleto", 5, Moneta.MO, 0.5),
	EMBLEMA("emblema",TipiEquip.SIMBOLO_SACRO, "descrizione emblema", 5, Moneta.MO, 0),
	RELIQUIARIO("reliquiario",TipiEquip.SIMBOLO_SACRO, "descrizione reliquiario", 5, Moneta.MO, 1),
	
	//strumenti
	ARNESI_DA_FALSARIO("arnesi da falsario", TipiEquip.STRUMENTO, "descrizione arnesi da falsario", 15, Moneta.MO, 2.5),
	ARNESI_DA_SCASSO("arnesi da scasso", TipiEquip.STRUMENTO, "descrizione arnesi da scasso", 25, Moneta.MO, 0.5),
	BORSA_DELL_ERBORISTA("borsa dell'erborista", TipiEquip.STRUMENTO, "descrizione borsa dell'erborista", 5, Moneta.MO, 1.5),
	DADI("dadi", TipiEquip.GIOCO, "descrizione dadi", 1, Moneta.MA, 0),
	MAZZO_DI_CARTE("mazzo di carte", TipiEquip.GIOCO, "descrizione mazzo di carte", 5, Moneta.MA, 0),
	SCACCHI_DEI_DRAGHI("scacchi dei draghi", TipiEquip.GIOCO, "descrizione scacchi dei draghi", 1, Moneta.MO, 0.25),
	TRE_DRAGHI_AL_BUIO("tre draghi al buio", TipiEquip.GIOCO, "descrizione tre draghi al buio", 1, Moneta.MO, 0),
	SOSTANZE_DA_AVVELENATORE("sostanze da avvelenetatore", TipiEquip.STRUMENTO, "descrizione sostanze da avvelenetatore", 50, Moneta.MO, 1),
	SCORTE_DA_ALCHIMISTA("scorte da alchimista", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione scorte da alchimista", 50, Moneta.MO, 4),
	SCORTE_DA_CALLIGRAFO("scorte da calligrafo", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione scorte da calligrafo", 10, Moneta.MO, 2.5),
	SCORTE_DA_MESCITORE("scorte da mechitore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione scorte da mechitore", 20, Moneta.MO, 4.5),
	STRUMENTI_DA_CALZOLAIO("strumenti da calzolaio", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da calzolaio", 5, Moneta.MO, 2.5),
	STRUMENTI_DA_CARTOGRAFO("strumenti da cartografo", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da cartografo", 15, Moneta.MO, 3),
	STRUMENTI_DA_CONCIATORE("strumenti da conciatore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da conciatore", 5, Moneta.MO, 2.5),
	STRUMENTI_DA_COSTRUTTORE("strumenti da costruttore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da costruttore", 10, Moneta.MO, 4),
	STRUMENTI_DA_FABBRO("strumenti da fabbro", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da fabbro", 20, Moneta.MO, 4),
	STRUMENTI_DA_FALEGNAME("strumenti da falegname", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da falegname", 8, Moneta.MO, 3),
	STRUMENTI_DA_GIOIELLIERE("strumenti da gioielliere", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da gioielliere", 25, Moneta.MO, 1),
	STRUMENTI_DA_INTAGLIATORE("strumenti da intagliatore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da intagliatore", 1, Moneta.MO, 2.5),
	STRUMENTI_DA_PITTORE("strumenti da pittore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da pittore", 10, Moneta.MO, 2.5),
	STRUMENTI_DA_SOFFIATORE("strumenti da soffiatore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da soffiatore", 30, Moneta.MO, 2.5),
	STRUMENTI_DA_TESSITORE("strumenti da tessitore", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da tessitore", 1, Moneta.MO, 2.5),
	STRUMENTI_DA_VASAIO("strumenti da vasaio", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione strumenti da vasaio", 10, Moneta.MO, 1.5),
	UTENSILI_DA_CUOCO("utensili da cuoco", TipiEquip.STRUMENTO_DA_ARTIGIANO, "descrizione utensili da cuoco", 1, Moneta.MO, 4),
	STRUMENTI_DA_NAVIGATORE("strumenti da navigatore", TipiEquip.STRUMENTO, "descrizione strumenti da navigatore", 25, Moneta.MO, 1),
	CIARAMELLA("ciaramella", TipiEquip.STRUMENTO_MUSICALE, "descrizione ciaramella", 2, Moneta.MO, 0.5),
	CORNAMUSA("cornamusa", TipiEquip.STRUMENTO_MUSICALE, "descrizione cornamusa", 30, Moneta.MO, 3),
	CORNO("corno", TipiEquip.STRUMENTO_MUSICALE, "descrizione corno", 3, Moneta.MO, 1),
	DULCIMER("dulcimer", TipiEquip.STRUMENTO_MUSICALE, "descrizione dulcimer", 25, Moneta.MO, 5),
	FLAUTO("flauto", TipiEquip.STRUMENTO_MUSICALE, "descrizione flauto", 2, Moneta.MO, 0.5),
	FLAUTO_DI_PAN("flauto di pan", TipiEquip.STRUMENTO_MUSICALE, "descrizione flauto di pan", 12, Moneta.MO, 1),
	LIRA("lira", TipiEquip.STRUMENTO_MUSICALE, "descrizione lira", 30, Moneta.MO, 1),
	LIUTO("liuto", TipiEquip.STRUMENTO_MUSICALE, "descrizione liuto", 35, Moneta.MO, 1),
	TAMBURO("tamburo", TipiEquip.STRUMENTO_MUSICALE, "descrizione tamburo", 6, Moneta.MO, 1.5),
	VIOLA("viola", TipiEquip.STRUMENTO_MUSICALE, "descrizione viola", 30, Moneta.MO, 0.5),
	TRUCCHI_PER_IL_CAMUFFAMENTO("trucchi per il camuffamento", TipiEquip.STRUMENTO, "descrizione trucchi per il camuffamento", 25, Moneta.MO, 1.5),;
	
	private String nome;
    private TipiEquip tipo;
    private String descrizione;
    private double costo;
    private Moneta moneta;
    private double peso;

    Equipaggiamento(String nome, TipiEquip tipo, String descrizione, double costo, Moneta moneta, double peso) {
        this.nome = nome;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.costo = costo;
        this.moneta = moneta;
        this.peso = peso;
    }
    
    public String getNome() {
        return nome;
    }

    public TipiEquip getTipo() {
        return tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getCosto() {
        return costo;
    }

    public Moneta getMoneta() {
        return moneta;
    }

    public double getPeso() {
        return peso;
    }

    @JsonValue
    public Map<String, Object> getEquipaggiamento() {
        Map<String, Object> result = new HashMap<>();
        result.put("nome", nome);
        result.put("tipo", tipo);
        result.put("descrizione", descrizione);
        result.put("costo", costo);
        result.put("moneta", moneta);
        result.put("peso", peso);
        return result;
    }
    
    public static Equipaggiamento getEnumByNome(String tipo) {
        for (Equipaggiamento data : Equipaggiamento.values()) {
            if (data.getNome().equalsIgnoreCase(tipo)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessun eqipaggiamento trovato con questo nome: " + tipo);
    }
}
