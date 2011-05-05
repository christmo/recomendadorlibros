-- MySQL dump 10.13  Distrib 5.1.36, for Win32 (ia32)
--
-- Host: localhost    Database: recomendador
-- ------------------------------------------------------
-- Server version	5.1.36-community-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `recomendador` 
USE `recomendador`;

--
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autores` (
  `idAutor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
INSERT INTO `autores` VALUES (1,'Antonio Machado'),(2,'Elias Rivers'),(3,'San Juan de la Cruz'),(4,'Ruben Dario'),(5,'Luis Pales Matos'),(6,'Kevin L. Hughes '),(7,'Cesar Cantt'),(8,'R.A.C. Parker'),(9,'James Johonnot'),(10,'Adam Hart-Davis'),(11,'Antonio Cruz'),(12,'Ely Chinoy '),(13,'Vilfredo Pareto'),(14,'Charles A. 1873-1946 Ellwood '),(15,'Torcuato S. Di Tella '),(16,'Warren Howard C. '),(17,'MORRIS CHARLES '),(18,'Eva Garcia'),(19,'Robert B. Cialdini'),(20,'David G. Myers'),(21,'Greg Curran'),(22,'Claudio Chiuderi'),(23,'Jose Luis Pastor Pradillo '),(24,'Trejo Candelas Luis Miguel'),(25,'Clifford C. Houk'),(26,'Alejo García Moreno '),(27,'JOHANNES ALTHUSIUS '),(28,'Sonia R. García'),(29,'Mosca, Gaetano '),(30,'Sartori Giovanni '),(31,'Jay Dubya'),(32,'Pedro Damian Jimenez'),(33,'Paulo Coelho'),(34,'Alejo Carpentier'),(35,'Miguel de Cervantes Saavedra');
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `idCategoria` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Poesía'),(2,'Historia'),(3,'Sociología'),(4,'Psicología'),(5,'Ciencias'),(6,'Política'),(7,'Novelas');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idCliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `idIdioma` int(10) unsigned NOT NULL,
  `anio` int(10) unsigned NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  PRIMARY KEY (`idCliente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Carlos Peréz',1,1980,'carlos','carlos'),(2,'María Cuenca',2,1955,'maria','maria'),(3,'Luis Cabrera',1,1989,'luis','luis'),(4,'Arturo López',2,1987,'arturo','arturo'),(5,'Roberto Suarez',1,1990,'roberto','roberto');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idiomas`
--

DROP TABLE IF EXISTS `idiomas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idiomas` (
  `idIdioma` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idioma` varchar(50) NOT NULL,
  PRIMARY KEY (`idIdioma`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idiomas`
--

LOCK TABLES `idiomas` WRITE;
/*!40000 ALTER TABLE `idiomas` DISABLE KEYS */;
INSERT INTO `idiomas` VALUES (1,'Español'),(2,'Ingles'),(3,'Alemán'),(4,'Portugués'),(5,'Italianos'),(6,'Francés'),(7,'Chino'),(8,'Coreano'),(9,'Japones');
/*!40000 ALTER TABLE `idiomas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libros` (
  `idLibro` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `resumen` varchar(1000) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  `bestseller` int(1) unsigned NOT NULL,
  `idIdioma` int(10) unsigned NOT NULL,
  `idPais` int(10) unsigned NOT NULL,
  `vistas` int(10) unsigned NOT NULL,
  `anioLanzamiento` int(10) unsigned NOT NULL,
  `idCategoria` int(10) unsigned NOT NULL,
  `idAutor` int(10) unsigned NOT NULL,
  `img` varchar(45) NOT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (1,'	Antología Poética	',15.25,'	Antonio Machado es considerado el maestro de la poesía española del siglo veinte. Su obra es introspectiva, esta bañada de melancolía, y con ella viene una veta de romanticismo que nunca habrá de abandonar. Su romanticismo está imbuido por el escepticismo y el desengaño, buscando paz y olvido. Sus fuentes de inspiración son: el amor, el dolor, la guerra, la fugacidad de la existencia y la preocupación por su querida España. En esta colección, encontrarás poemas compuestos durante la Guerra Civil Española. También podrás leer una veintena de textos anteriormente dispersos. Los poemas están organizados bajo los libros en los que fueron publicados.	','	CreateSpace 	',0,1,6,2,2011,1,1,'lib1'),(2,'	Poesia Lirica Del Siglo de Oro	',14,'	Este volumen abarca una gran epoca de la poesia espanola renacentista y barroca y en el se ofrece una amplia muestra, seleccionada por Elias Rivers, de la obra de sus principales representantes desde Garcilaso de la Vega y Herrera, pasando por Fray Luis de Leon y San Juan de la Cruz hasta los mas importantes barrocos como Lope de Vega, Gongora, Quevedo y muchos otros. La presente antologia puede servir como un primer acercamiento a obras y autores cuyas ediciones criticas y comentadas han aparecido o apareceran en esta misma coleccion Letras Hispanicas. --Los editores	','	Catedra	',1,1,10,0,2006,1,2,'lib2'),(3,'	Poesias completas (Clasicos de la literatura series)	',11.23,'	Los lectores tomarán un gran placer en descubrir los clásicos con estas bellas y económicas ediciones de las grandes obras literarias. Esta selección editorial cuenta con títulos que abarcan todos los géneros literarios, desde teatro, narrativa, poesía y el ensayo.	','	Edimat Libros	',0,1,4,0,2008,1,3,'lib3'),(4,'	Stories and Poems	',56.23,'	Nicaraguan poet and essayist Darío (the pen name of Félix Rubén García Sarmiento) is considered the high priest of the modernismo school of literature. This volume contains a rich selection of his best poems and stories from Azul (Blue), Prosas profanas (Worldly Hymns), and others. Accurate English translations appear on the facing pages.	','	Dover Publications	',0,2,7,0,2002,1,4,'lib4'),(5,'	Selected Poems	',78.45,'	\"Although today Luis Palés Matos is virtually unknown to most American readers, the eminent U.S. poet and writer William Carlos Williams once praised his younger contemporary as \"\"one of the most important poets out of Latin America.\"\"\r\nPalés Matos was a native, and lifelong resident, of Puerto Rico. Though he was not black, he became one of the Caribbeans leading advocates of poesía negra (black poetry). His landmark 1937 collection Tuntún de Pasa y Grifería: Poesía Afro-Antillana (Tom-Tom of Kinky Hair and Black Things: Afro-Caribbean Poetry) joyously celebrated the African aspects and sources of Puerto Ricos culture and influenced later generations of writers throughout the Western hemisphere.\"	','	Arte Publico Press	',1,2,3,0,2001,1,5,'lib5'),(6,'	Historia de la Iglesia: El Legado de la Fe	',56,'	Historia de la Iglesia y su evolución basada en los sucesos que han marcado historia y han dejado un legado.	','	Loyola Press	',0,1,6,0,2006,2,6,'lib6'),(7,'	Compendio de la Historia universal	',25.1,'	\"Historia es la narración encadenada de importantes acontecimientos tenidos por verdaderos. Es ciencia de primer orden entre las etnográficas y morales, y descansa en la fe que se refiere a los testimonios por que fueron trasmitidos los hechos anteriores, de los cuales deduce el porvenir probable en el desenvolvimiento de la libre actividad del hombre.\"	','	Editorial Medí	',1,1,6,0,2010,2,7,'lib7'),(8,'	Historia de la segunda guerra mundial	',20.12,'	De entre la amplia bibliografía disponible en español sobre la segunda guerra mundial, este libro destaca por su brevedad, concisión y amplitud de enfoque. La obra examina las causas del conflicto, su desarrollo y las consecuencias de largo alcance que tuvo para la humanidad. Al exponer los hechos fundamentales de la guerra en Europa y en el Pacífico, analiza las estrategias de los participantes, las economías y las sociedades en que se integraban y los rasgos más característicos de los distintos ejércitos. Además de describir el desarrollo de las batallas decisivas y de comentar sus resultados, presta atención a fenómenos como la emigración forzada, el exterminio de la población judía o el bombardeo estratégico y atómico. A diferencia de otras historias al uso, no se detiene en 1945 sino que abarca asimismo los inicios de la guerra fría y los procesos de descolonización.	','	Universidad de Zaragoza/Digitalia	',0,1,6,0,2009,2,8,'lib8'),(9,'	Ten Great Events in History	',14.05,'	Excerpts: Patriotism, or love of country, is one of the tests of nobility of character. No great man ever lived that was not a patriot in the highest and truest sense. From the earliest times, the sentiment of patriotism has been aroused in the hearts of men by the narrative of heroic deeds inspired by love of country and love of liberty. This truth furnishes the key to the arrangement and method of the present work. The ten epochs treated are those that have been potential in shaping subsequent events; and when men have struck blows for human liberty against odds and regardless of personal consequences. The simple narrative carries its own morals, and the most profitable work for the teacher will be to merely supplement the narrative so that the picture presented shall be all the more vivid. Moral reflections are wearisome and superfluous. The great events in history are those where, upon special occasions, a man or a people have made a stand against tyranny, and have preserved or ad','	IndoEuropeanPublishing.com	',0,2,9,0,2011,2,9,'lib9'),(10,'	History: The Definitive Visual Guide 	',11.2,'	\"Homo sapiens have remained the same species, largely unchanged in genetic makeup and anatomy since the Cro-Magnon era. By contrast, the cultural, social, and technological changes since then have been nothing less than extraordinary. At the core of this development is the ability of humans to store and transmit knowledge, so that each new generation stands upon the shoulders of its predecessors. This ability to use what has gone before is what sets humans apart. \r\n\r\nTelling our story, from prehistory to the present day, DKs History is a thought-provoking journey, revealing the common threads and forces that have shaped human history. Taking a broad-themed approach, acknowledging varied factors at work, from climate, ecology, disease, and geology and their roles in the human story, this visual celebration makes history accessible and relevant, putting events in their wider context and showing how they have shaped the world we live in.\"	','	DK ADULT	',1,2,2,0,2007,2,10,'lib10'),(11,'	Sociologia una desmitificacion	',10.45,'	Sometimes, in this world full of different ideas, it seems as if Christians are swimming against the current. All of the postmodern ideas we hear and see on television and in books do influence us. They also influence our loved ones. It is critical that we seek correct answers centered on the Bible. Dr. Cruz compares the philosophies of 10 well-known sociologists with the truth of Scripture.	','	CLIE	',0,1,7,0,2004,3,11,'lib11'),(12,'	Introduccion a la Sociologia	',18.26,'		','	Ediciones Paidos Iberica	',1,1,5,0,1997,3,12,'lib12'),(13,'	Trattato Di Sociologia Generale	',15,'	This is an EXACT reproduction of a book published before 1923. This IS NOT an OCRd book with strange characters, introduced typographical errors, and jumbled words. This book may have occasional imperfections such as missing or blurred pages, poor pictures, errant marks, etc. that were either part of the original artifact, or were introduced by the scanning process. We believe this work is culturally important, and despite the imperfections, have elected to bring it back into print as part of our continuing commitment to the preservation of printed works worldwide. We appreciate your understanding of the imperfections in the preservation process, and hope you enjoy this valuable book.	','	Nabu Press	',0,5,8,0,2010,3,13,'lib13'),(14,'	Sociology and modern social problems	',105,'	This is a reproduction of a book published before 1923. This book may have occasional imperfections such as missing or blurred pages, poor pictures, errant marks, etc. that were either part of the original artifact, or were introduced by the scanning process. We believe this work is culturally important, and despite the imperfections, have elected to bring it back into print as part of our continuing commitment to the preservation of printed works worldwide. We appreciate your understanding of the imperfections in the preservation process, and hope you enjoy this valuable book.	','	Nabu Press	',1,2,3,0,2010,3,14,'lib14'),(15,'	Fundamentos De Sociologia 	',25.8,'		','	Editorial Biblos	',0,1,10,0,1998,3,15,'lib15'),(16,'	Diccionario de psicología	',15.78,'	Howard C. Warren nos ofrece el vocabulario básico de la psicología, todos los términos del freudismo, las corrientes modernas, la guestalt, la psicología social. Este Diccionario es obra de 110 psicólogos y especialistas en la materia.	','	Fondo de Cultura Económica	',0,1,5,0,2007,4,16,'lib16'),(17,'	Psicología	',18.6,'	Este libro contiene todos los temas para un curso introductorio de psicologia general. Su estructura didactica ayuda a pensar de manera activa y critica. Incorpora estudios clasicos e investigaciones recientes y herramientas didacticas que permiten el pensamiento activo y critico; asi como analisis extensos relativos al genero y la cultura. Esta totalmente actualizado e incluye resumenes de investigaciones hechas en diversos paises de America Latina y Espana. Tabla de contenidos Capitulo 1. La ciencia de la psicologia Capitulo 2. Bases biologicas de la conducta Capitulo 3. Sensacion y percepcion Capitulo 4. Estados de conciencia Capitulo 5. Aprendizaje Capitulo 6. Memoria Capitulo 7. Cognicion y lenguaje Capitulo 8. Inteligencia y capacidades mentales Capitulo 9. Motivacion y emocion Capitulo 10. Desarrollo del ciclo vital Capitulo 11. Personalidad Capitulo 12. Estres y psicologia de la salud Capitulo 13. Trastornos psicologicos Capitulo 14. Terapias Capitulo 15. Psicologia social Ape','	Pearson	',1,1,7,0,2010,4,17,'lib17'),(18,'	Psicologia General, 2a.Ed	',13.6,'	An easy guide to understand psychology	','	Patria	',0,1,6,0,2005,4,18,'lib18'),(19,'	Influence: The Psychology of Persuasion 	',14.58,'	\"Arguably the best book ever on what is increasingly becoming the science of persuasion. Whether youre a mere consumer or someone weaving the web of persuasion to urge others to buy or vote for your product, this is an essential book for understanding the psychological foundations of marketing. Recommended. --This text refers to an out of print or unavailable edition of this title.\r\n\"	','	HarperPaperbacks	',1,2,3,0,2006,4,19,'lib19'),(20,'	Psychology	',36.5,'	\"There is no such thing as a light, perfunctory revision of David Myers’ Psychology. Each new edition is a fresh opportunity to communicate psychology’s enduring principles and pivotal research in terms that captivate students and connect with their lives.\r\nBut even by Myers’ standards, Psychology, Ninth Edition, is truly exceptional. This exhaustive update of the bestselling textbook for introductory psychology incorporates the largest number of new research citations of any revision to date, as well as new inquiry-based pedagogy, a reconceptualized art program, and the next generation of media and supplements. Yet, edition after edition, David Myers demonstrates an uncanny ability to communicate the science of psychology in a uniquely engaging, accessible way.\"	','	Worth Publishers	',0,2,1,0,2009,4,20,'lib20'),(21,'	Homework Helpers: Chemistry	',50.15,'	Homework Helpers: Chemistry is a user-friendly review book that will make every student--or parent trying to help their child feel like he or she has a private Chemistry tutor. Concepts are explained in clear, easy-to-understand language, and problems are worked out with step-by-step methods that are easy to follow. Each lesson comes with numerous review questions and answer keynotes that explain each correct answer and why its correct.	','	Career Press	',1,2,9,0,2011,5,21,'lib21'),(22,'	Fisica del Plasma: Fondamenti e applicazioni Astrofisiche	',40.12,'		','	Springer	',0,5,8,0,2011,5,22,'lib22'),(23,'	Fragmentos Para una Antropologia de la Actividad Fisica	',20.1,'		','	Paidotribo Editorial	',1,1,4,0,2001,5,23,'lib23'),(24,'	Química 2. Enfoque por competencias	',15.45,'	La obra se encuentra apegada a la Reforma Integral de la Educación Media Superior (RIEMS) y al programa de estudios del Bachillerato General, demuestra la relación de la Química con la tecnología y la sociedad, así como el efecto que ésta provoca en el medio ambiente, buscando generar en el estudiante una conciencia de cuidado y preservación del medio que lo rodea, al igual que un accionar ético y responsable en el manejo de los recursos naturales para la generación actual y las generaciones futuras.	','	Editorial Medí	',0,1,10,0,2008,5,24,'lib24'),(25,'	Chemistry: Concepts and Problems: A Self-Teaching Guide	',55,'	\"CHEMISTRY SECOND EDITION\r\n\r\nThe fast, easy way to master the fundamentals of chemistry\r\n\r\nHave you ever wondered about the differences between liquids, gases, and solids? Or what actually happens when something burns? What exactly is a solution? An acid? A base? This is chemistry--the composition and structure of substances composing all matter, and how they can be transformed. Whether you are studying chemistry for the first time on your own, want to refresh your memory for a test, or need a little help for a course, this concise, interactive guide gives you a fresh approach to this fascinating subject. This fully up-to-date edition of Chemistry: Concepts and Problems: \r\n* Has been tested, rewritten, and retested to ensure that you can teach yourself all about chemistry \r\n* Requires no prerequisites \r\n* Lets you work at your own pace with a helpful question-and-answer format \r\n* Lists objectives for each chapter--you can skip ahead or find extra help if you need it \r\n* Reinforces wh','	Wiley	',1,2,9,0,1996,5,25,'lib25'),(26,'	Leyes Y Tratados Internacionales	',19.25,'	Reglamentos Internacionales de los gobiernos, basado en reglamentos vigentes.	','	Nabu Press	',0,1,10,0,2010,6,26,'lib26'),(27,'	Politica	',50.1,'	Althusiuss \"Politics Methodically Set Forth and Illustrated with Sacred and Profane Examples\", known today simply as \"Politica\" or Althusiuss \"Politics\", was originally published in Germany in 1603. Professor Carneys translation, which first appeared in 1964, represents the first attempt to present the basic structure of Althusiuss political thought in English. \"Politica\" is now recognised as an extraordinary contribution to the intellectual history of the West. It combines ancient and medieval political philosophy with Reformation theory, and is considered a bridge between the political wisdom of the ancients and the moderns. Friedrich thought Althusius was the most profound political thinker between Bodin and Hobbes. Drawing deeply from Aristotle and Biblical teaching, \"Politica\" presents a unique vision of the commonwealth as a harmonious ordering of natural associations. According to Althusius, the purpose of the state is to protect and encourage social life. The family is the mos','	Liberty Fund Inc	',1,2,7,0,2010,6,27,'lib27'),(28,'	Políticas: Latina Public Officials in Texas	',20.4,'	In-depth profiles of the women who have been the first Latinas to hold key elected and appointed positions in Texas government.	','	Universidad de Texas	',0,2,7,0,2008,6,28,'lib28'),(29,'	Elementi di Scienza Politica	',11.5,'	This is a pre-1923 historical reproduction that was curated for quality. Quality assurance was conducted on each of these books in an attempt to remove books with imperfections introduced by the digitization process. Though we have made best efforts - the books may have occasional errors that do not impede the reading experience. We believe this work is culturally important and have elected to bring the book back into print as part of our continuing commitment to the preservation of printed works worldwide. This text refers to the Bibliobazaar edition.	','	BiblioBazaar	',0,5,8,0,2009,6,29,'lib29'),(30,'	La política : lógica y método en las ciencias sociales	',10.9,'	En un afán de ofrecer una metodología esencial de las ciencias sociales, Sartori diserta sobre la terminología propia de esta disciplina y sobre la contraposición de su método con el de las ciencias naturales; la diferencia entre filosofía, teoría y ciencia; la definición de política y de su carácter científico, e incluso, lo lleva a abordar campos de investigación poco desarrollados como el de la política comparada.	','	Fondo de Cultura Económica	',0,1,5,0,2002,6,30,'lib30'),(31,'	The Great Teen Fruit War	',48.26,'	The Great Teen Fruit War, A 1960 Novel\" is author Jay Dubyas eighth e-book. The story takes place in Hammonton, New Jersey, an agricultural community midway between Philadelphia and Atlantic City. The Blues wear blue denim button-down waist-length jackets and are the sons of wealthy blueberry growers. The Reds wear James Dean red zip-up jackets and are the sons of peach farmers. Bellevue Avenue in the center of town is the dividing line that separates blueberry country to the east and peach territory to the west.	','	Bookstand Publishing	',0,2,9,0,2002,7,31,'lib31'),(32,'	Novelas Ejemplares I	',23.7,'	Lope tuvo que reconocer la ejemplaridad de las novelas cervantinas, por mas a reganadientes que lo hiciese, en el sentido de que el unico modelo a seguir en Espana, el unico que el puede recordar y citar es Miguel de Cervantes. Para escribir novelas cortas habia que modelarse en las de Cervantes, que en este sentido eran ejemplares. Detras de Cervantes, en Espana, no habia nada. Y esto lo sabia muy bien el manco sano, como lo demuestra cada linea del prologo que el puso a sus novelitas.	','	Springer	',0,1,4,0,2005,7,32,'lib32'),(33,'	El Zahir : Una Novela de Obsesion 	',15.55,'	El narrador de El Zahir es un aclamado autor de renombre internacional que vive en Francia y disfruta de los privilegios que le otorgan su fama y su dinero. Esther, su esposa de hace diez años, es corresponsal de guerra y a pesar de su éxito profesional, y su relativa libertad de los confines tradicionales del matrimonio, se enfrenta a una crisis existencial que la atormenta silenciosamente. Un día, Esther desaparece con su amigo Mikhail -- quien podría o no ser su amante -- y, perplejas ante la ausencia de indicios, las autoridades deciden cuestionar al narrador. Todos se preguntan si Esther fue secuestrada o asesinada, o si fue que simplemente decidió abandonar un matrimonio que la dejaba insatisfecha. El narrador no tiene las respuestas pero poco a poco comienza a interrogarse sobre su propia existencia.	','	Rayo	',1,1,2,0,2005,7,33,'lib33'),(34,'	El reino de este mundo	',11.99,'	nspirado por la extraordinaria historia original y valido de su admirable poder narrativo, Alejo Carpentier es artífice de un relato alucinante e incomparable que recrea los acontecimientos que precedieron a la independencia haitiana en la corte real de Henri Christophe.	','	Rayo	',0,1,2,0,2009,7,34,'lib34'),(35,'	Four Stories from Cervantes	',44.66,'	Un conjunto de novelas relativas a los relatos de Miguel de Cervantes	','	European Masterpieces	',0,2,7,0,2008,7,35,'lib35');
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `idPais` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pais` varchar(50) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Alemania'),(2,'Brazil'),(3,'Canadá'),(4,'Colombia'),(5,'Ecuador'),(6,'España'),(7,'Estados Unidos'),(8,'Italia'),(9,'Reino Unido'),(10,'Venezuela');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `idVentas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idCliente` int(10) unsigned NOT NULL,
  `idLibro` int(10) unsigned NOT NULL,
  `precio` double NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idVentas`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,1,5,78.45,'2011-01-05 00:00:00'),(2,1,16,15.78,'2011-01-30 00:00:00'),(3,1,17,18.6,'2011-03-22 00:00:00'),(4,2,1,15.25,'2011-01-10 00:00:00'),(5,2,7,25.1,'2011-02-15 00:00:00'),(6,2,32,23.7,'2011-02-28 00:00:00'),(7,2,33,15.55,'2011-04-03 00:00:00'),(8,3,4,56.23,'2011-01-24 00:00:00'),(9,3,28,20.4,'2011-02-13 00:00:00'),(10,3,34,11.99,'2011-03-16 00:00:00'),(11,3,1,15.25,'2011-04-26 00:00:00'),(12,3,20,36.5,'2011-05-02 00:00:00');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-05-05  2:07:42
