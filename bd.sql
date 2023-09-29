CREATE DATABASE cruddavid IF NOT EXISTS;
use cruddavid;

CREATE TABLE artistas(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  genero VARCHAR (100) NOT NULL,
  descripcion text
);

INSERT INTO `artistas` ( `nombre`, `genero`, `descripcion`) VALUES ('NEFFEX', 'Hip hop, Rap', 'Proyecto musical estadounidense de Bryce Savage ​que originalmente incluía a Cameron Wales. Produjeron remixes y canciones originales caracterizadas por una mezcla de géneros de música electrónica y rap.') 