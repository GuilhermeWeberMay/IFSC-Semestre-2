 drop database if exists Parte2;
 create database Parte2;
 use Parte2;
 set foreign_key_checks = 0;
 drop table if exists bolo;
 drop table if exists confeiteiro;
 set foreign_key_checks = 1;
 
 CREATE TABLE GRAVADORA (
 idGravadora INT AUTO_INCREMENT PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 pais VARCHAR(50) NOT NULL
 ) Engine InnoDB;
 CREATE TABLE ARTISTA (
 idArtista INT AUTO_INCREMENT PRIMARY KEY,
 nomeArtista VARCHAR(100) NOT NULL,
 nacionalidade VARCHAR(50) NOT NULL
 ) Engine InnoDB;
 CREATE TABLE ALBUM (
 idAlbum INT AUTO_INCREMENT PRIMARY KEY,
 titulo VARCHAR(100) NOT NULL,
 ano INT NOT NULL,
 idArtista INT NOT NULL,
 idGravadora INT NOT NULL,
 FOREIGN KEY (idArtista) REFERENCES ARTISTA(idArtista),
 FOREIGN KEY (idGravadora) REFERENCES GRAVADORA(idGravadora)
 ) Engine InnoDB;
 CREATE TABLE MUSICA (
 idMusica INT AUTO_INCREMENT primary KEY,
 titulo VARCHAR(100) NOT NULL,
 duracao DECIMAL(3,1) NOT NULL,
 idAlbum INT NOT NULL,
 FOREIGN KEY (idAlbum) REFERENCES ALBUM(idAlbum)
 )Engine InnoDB;
 
 -- Gravadoras
 INSERT INTO GRAVADORA(nome,pais)VALUES
 ('UniversalMusic', 'EUA'),
 ('SonyMusic', 'EUA'),
 ('WarnerMusic', 'EUA');
 -- Artistas
 INSERT INTO ARTISTA(nomeArtista,nacionalidade)VALUES
 ('TaylorSwift', 'EUA'),
 ('TheBeatles', 'ReinoUnido'),
 ('IU', 'CoreiadoSul'),
 ('TomJobim', 'Brasil');
 -- Albuns
 INSERT INTO ALBUM(titulo,ano,idArtista, idGravadora)VALUES
 ('1989',2014,1,1),
 ('Evermore',2020,1,2),
 ('AbbeyRoad',1969,2, 1),
 ('Lovelight',2015,3,2),
 ('Wave',1967,4,3);
 -- Musicas
 INSERT INTO MUSICA(titulo,duracao, idAlbum)VALUES
 ('BlankSpace',3.5,1),
 ('Style',3.7,1),
 ('Willow',3.4,2),
 ('Something',3.0,3),
 ('ComeTogether',4.2,3),
 ('Palette',3.5,4),
 ('Chegade Saudade',2.5,5),
 ('Wave',4.0,5);
 
-- 5. (10pontos) Liste todos os artistas cujo nome contém Tom.
select * from ARTISTA where nomeArtista like '%Tom%'; -- feito

-- 6. (10pontos) Liste os artistas que possuem mais de um álbum cadastrado no banco de dados.
 select idArtista, count(idArtista) as qtd 
	from album group by idArtista having count(idArtista) > 1; -- feito
    
-- 7. (10pontos) Conte quantos álbuns cada gravadora possui.
 select idGravadora, count(idGravadora) from album group by idGravadora; -- feito
 
-- 8. (10pontos) Liste todos os álbuns com o nome do artista e da gravadora a que pertencem.
 select album.titulo as NomeAlbum, ARTISTA.nomeArtista, GRAVADORA.nome as NomeGravadora from album natural join artista natural join gravadora; -- feito

-- 9. (10pontos) Mostre todas as músicas de Taylor Swift, juntamente com o título do álbum em que estão.
select artista.nomeArtista, album.titulo from artista natural join album where artista.nomeArtista = 'TaylorSwift'; -- feito

-- 10. (10pontos) Liste todas as músicas lançadas a partir de 2015, mostrando: Título da música,Álbum,Artista e Gravadora. Com esses exatos nomes das colunas
    
	select MUSICA.titulo as tituloMusica, album.titulo as Album, artista.nomeArtista as Artista, GRAVADORA.nome as gravadora from musica 
		inner join album on album.idAlbum = MUSICA.idAlbum inner join artista on album.idArtista = ARTISTA.idArtista inner join gravadora on album.idGravadora = GRAVADORA.idGravadora 
			where ALBUM.ano > 2015;
    










